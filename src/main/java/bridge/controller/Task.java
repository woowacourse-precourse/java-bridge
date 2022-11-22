package bridge.controller;

public interface Task {
    void run();
    static void retryTask(Task task) {
        while (true) {
            try {
                task.run();
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
