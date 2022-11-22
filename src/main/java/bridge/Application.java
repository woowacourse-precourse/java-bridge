package bridge;

public class Application {

    public static void main(String[] args) {
        try {
            Controller controller = new Controller();
            controller.run();
        } catch (Exception e) {
            System.out.print("[ERROR] ");
            System.out.println(e.getMessage());
        }

    }
}
