package bridge;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            Controller controller = new Controller();
            controller.startGame();

        } catch (IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
