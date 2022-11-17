package bridge;

public class Application {

    public static void main(String[] args) {
        Controller controller = new Controller();
        try {
            controller.run();
        } catch (Exception e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }
}
