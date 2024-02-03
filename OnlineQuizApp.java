import java.util.ArrayList;
import java.util.Scanner;

class Question {
    private String question;
    private String[] options;
    private int correctOption;

    public Question(String question, String[] options, int correctOption) {
        this.question = question;
        this.options = options;
        this.correctOption = correctOption;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getOptions() {
        return options;
    }

    public int getCorrectOption() {
        return correctOption;
    }
}

class Quiz {
    private ArrayList<Question> questions;
    private int score;

    public Quiz() {
        questions = new ArrayList<>();
        score = 0;
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public void takeQuiz() {
        Scanner scanner = new Scanner(System.in);

        for (Question question : questions) {
            System.out.println(question.getQuestion());

            String[] options = question.getOptions();
            for (int i = 0; i < options.length; i++) {
                System.out.println((i + 1) + ". " + options[i]);
            }

            int userAnswer = getUserInput(options.length);
            checkAnswer(question, userAnswer);
        }

        System.out.println("Quiz completed. Your score: " + score + "/" + questions.size());
    }

    private int getUserInput(int maxOption) {
        Scanner scanner = new Scanner(System.in);
        int userAnswer = -1;

        while (userAnswer < 1 || userAnswer > maxOption) {
            System.out.print("Enter your choice (1-" + maxOption + "): ");
            try {
                userAnswer = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }

        return userAnswer;
    }

    private void checkAnswer(Question question, int userAnswer) {
        if (userAnswer == question.getCorrectOption()) {
            System.out.println("Correct!\n");
            score++;
        } else {
            System.out.println("Incorrect. The correct answer is: " +
                    question.getOptions()[question.getCorrectOption() - 1] + "\n");
        }
    }
}

public class OnlineQuizApp {
    public static void main(String[] args) {
        // Create questions
        Question question1 = new Question("What is the capital of France?",
                new String[]{"Paris", "Berlin", "Madrid", "Rome"}, 1);

        Question question2 = new Question("Which planet is known as the Red Planet?",
                new String[]{"Earth", "Mars", "Venus", "Jupiter"}, 2);

        Question question3 = new Question("What is the largest mammal?",
                new String[]{"Elephant", "Blue Whale", "Giraffe", "Hippopotamus"}, 2);
        Question question4 = new Question("What is the extension of java code files?",
                new String[] {" .txt", " .pdf", " .sql", " .java"},4);
        Question question5 = new Question("Who invented Java Programming? ", 
                new String[]{"Guido van Rossum", "James Gosling", "Dennis Ritchie", "Bjarne Stroustrup"},2);
        Question question6 = new Question(" Which statement is true about Java?", 
                new String[]{" Java is a sequence-dependent programming language ", " Java is a code dependent programming language ", " Java is a platform-dependent programming language ", " Java is a platform-independent programming language "},4);
        
        Question question7 = new Question("Which one of the following is not a Java feature?", 
                new String[]{" Object-oriented", "Use of pointers", "Portable", "Dynamic and Extensible"},2);
        Question question8 = new Question("Which of these cannot be used for a variable name in Java?", 
                new String[]{" identifier & keyword", "identifier", " Keyword", "none of the mentioned"},3);
        
        // Create quiz and add questions
        Quiz quiz = new Quiz();
        quiz.addQuestion(question1);
        quiz.addQuestion(question2);
        quiz.addQuestion(question3);
        quiz.addQuestion(question4);
        quiz.addQuestion(question5);
        quiz.addQuestion(question6);
        quiz.addQuestion(question7);
        quiz.addQuestion(question8);
        // Take the quiz
        quiz.takeQuiz();
    }
}
