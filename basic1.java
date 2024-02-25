import java.util.ArrayList;
import java.util.Scanner;

public class basic1 {
    public static void main(String[] args) {
        Tasklist tasklist = new Tasklist();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter the task name: ");
                    String taskName = scanner.next();
                    tasklist.addTask(taskName);
                    break;

                case 2:
                    if (!tasklist.isEmpty()) {
                        tasklist.listTasks();
                        System.out.println("Enter the task number to be removed: ");
                        int taskNumber = scanner.nextInt();

                        if (tasklist.isValidTaskNumber(taskNumber)) {
                            tasklist.removeTask(taskNumber);
                        }

                        else {
                            System.out.println("Invalid Task Number Entered.");
                        }
                    }

                    else {
                        System.out.println("No Tasks To Remove.");
                    }

                    break;

                case 3:
                    if (!tasklist.isEmpty()) {
                        tasklist.listTasks();
                    }

                    else {
                        System.out.println("No Tasks To List.");
                    }

                    break;

                case 4:
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid Option. Please try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("List Of Tasks");
        System.out.println("1. Add Task");
        System.out.println("2. Remove Task");
        System.out.println("3. List Tasks");
        System.out.println("4. Quit");
        System.out.println("Select An Option: ");
    }

}

class Tasklist {
    private ArrayList<String> tasks = new ArrayList<>();

    public void addTask(String name) {
        tasks.add(name);
        System.out.println("Task Added.");
    }

    public void removeTask(int taskNumber) {
        tasks.remove(taskNumber - 1);
        System.out.println("Task Removed.");
    }

    public void listTasks() {
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    public boolean isEmpty() {
        return tasks.isEmpty();
    }

    public boolean isValidTaskNumber(int taskNumber) {
        return taskNumber >= 1 && taskNumber <= tasks.size();
    }
}