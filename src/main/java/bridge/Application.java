package bridge;

import exception.UserInputException;
import game.Controller;
import view.InputView;
import view.OutputView;

public class Application {

    public static void main(String[] args) {
        Controller controller = new Controller();
        try {
            OutputView.printStartMsg();
            controller.run(InputView.readBridgeSize());
        } catch (UserInputException e) {
            e.printStackTrace();
            InputView.readBridgeSize();
        }
    }
}
