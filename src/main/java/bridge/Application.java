package bridge;

public class Application {
    private static OutputView outputView = new OutputView();

    public static void main(String[] args) {
        outputView.printStartMessage();

        Controller controller = new Controller();

        controller.startGame();

    }
}
