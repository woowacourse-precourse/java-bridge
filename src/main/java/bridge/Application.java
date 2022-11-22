package bridge;

public class Application {

    public static void main(String[] args) {
        Controller controller = new Controller();
        try {
            controller.run();
        }catch(IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }
}
