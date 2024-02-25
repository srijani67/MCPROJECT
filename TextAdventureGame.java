import java.util.Scanner;

public class TextAdventureGame {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the Text Adventure Game!");

        // Initialize player stats or any other necessary variables

        // Start the game
        startGame();
    }

    private static void startGame() {
        System.out.println("You wake up in a mysterious room. What do you do?");
        System.out.println("1. Look around");
        System.out.println("2. Try to open the door");
        System.out.print("Enter your choice: ");

        int choice = getUserChoice(2); // Ensure user input is within range (1-2)

        switch (choice) {
            case 1:
                lookAround();
                break;
            case 2:
                tryOpenDoor();
                break;
        }
    }

    private static void lookAround() {
        System.out.println("You see a key on the table and a window with bars. What do you do?");
        System.out.println("1. Take the key");
        System.out.println("2. Try to break the bars");
        System.out.println("3. Go back");
        System.out.print("Enter your choice: ");

        int choice = getUserChoice(3);

        switch (choice) {
            case 1:
                takeKey();
                break;
            case 2:
                tryBreakBars();
                break;
            case 3:
                startGame(); // Go back to the previous decision point
                break;
        }
    }

    private static void tryOpenDoor() {
        System.out.println("The door is locked. What do you do?");
        System.out.println("1. Look around");
        System.out.println("2. Use the key");
        System.out.println("3. Kick the door");
        System.out.println("4. Go back");
        System.out.print("Enter your choice: ");

        int choice = getUserChoice(4);

        switch (choice) {
            case 1:
                lookAround();
                break;
            case 2:
                useKey();
                break;
            case 3:
                kickDoor();
                break;
            case 4:
                startGame();
                break;
        }
    }

    // Define more methods for other decision points and outcomes...

    // Utility method to get user choice with error handling
    private static int getUserChoice(int maxChoice) {
        int choice = 0;
        boolean validInput = false;

        while (!validInput) {
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice >= 1 && choice <= maxChoice) {
                    validInput = true;
                } else {
                    System.out.println("Invalid input. Please enter a number between 1 and " + maxChoice + ".");
                }
            } else {
                scanner.next(); // Consume invalid input
                System.out.println("Invalid input. Please enter a number.");
            }
        }

        return choice;
    }

    // Define other methods for different outcomes

    private static void takeKey() {
        System.out.println("You take the key. It might be useful later.");
        // Update player inventory or status
        // Proceed to the next part of the story
    }

    private static void tryBreakBars() {
        System.out.println("You try to break the bars, but they seem too sturdy.");
        // Proceed to the next part of the story
    }

    private static void useKey() {
        System.out.println("You use the key and unlock the door.");
        // Proceed to the next part of the story
    }

    private static void kickDoor() {
        System.out.println("You kick the door, but it doesn't budge.");
        // Proceed to the next part of the story
    }
}
