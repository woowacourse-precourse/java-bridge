package bridge;

import bridge.controller.GameController;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        try {
            GameController.run();
        } catch (IllegalArgumentException e) {
            OutputView.printExceptionMessageForInvalidInput(e);
        } catch (Exception e) {
            Logger.log(e);
        }
    }
}
