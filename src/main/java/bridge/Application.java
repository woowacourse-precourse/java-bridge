package bridge;

public class Application {

    public static void main(String[] args) {
        BridgeGameService service = new BridgeGameService();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Controller controller = new Controller(service, inputView, outputView);
        try {
            controller.start();
            controller.move();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
