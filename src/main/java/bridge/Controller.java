package bridge;

public class Controller {
    BridgeGame model = new BridgeGame();
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void init() {
        outputView.printInitMsg();
        while (true) {
            try {
                model.init(inputView.readBridgeSize());
                break;
            } catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void move() {
        outputView.printMoveMsg();
        while (true) {
            try {
                model.move(inputView.readMoving());
                break;
            } catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
