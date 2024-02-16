import java.io.*;
import java.util.*;

class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

class Expense {
    private Date date;
    private String category;
    private double amount;

    public Expense(Date date, String category, double amount) {
        this.date = date;
        this.category = category;
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public String getCategory() {
        return category;
    }

    public double getAmount() {
        return amount;
    }
}

public class ExpenseTracker {
    private List<User> users;
    private List<Expense> expenses;

    public ExpenseTracker() {
        users = new ArrayList<>();
        expenses = new ArrayList<>();
    }

    public void registerUser(String username, String password) {
        users.add(new User(username, password));
    }

    public boolean loginUser(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public void addExpense(Date date, String category, double amount) {
        expenses.add(new Expense(date, category, amount));
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public double getTotalExpenseForCategory(String category) {
        double total = 0;
        for (Expense expense : expenses) {
            if (expense.getCategory().equals(category)) {
                total += expense.getAmount();
            }
        }
        return total;
    }

    public void saveExpensesToFile(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(expenses);
            System.out.println("Expenses saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public void loadExpensesFromFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            expenses = (List<Expense>) ois.readObject();
            System.out.println("Expenses loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExpenseTracker tracker = new ExpenseTracker();
        tracker.registerUser("user1", "password1");

        // Sample usage
        if (tracker.loginUser("user1", "password1")) {
            tracker.addExpense(new Date(), "Food", 50.0);
            tracker.addExpense(new Date(), "Transportation", 30.0);
            tracker.addExpense(new Date(), "Food", 20.0);

            System.out.println("Total expenses for Food: $" + tracker.getTotalExpenseForCategory("Food"));

            tracker.saveExpensesToFile("expenses.dat");
            tracker.loadExpensesFromFile("expenses.dat");
        } else {
            System.out.println("Invalid username or password.");
        }
    }
}
