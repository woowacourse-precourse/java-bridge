package bridge;

import bridge.resource.message.ErrorMessage;
import bridge.resource.message.FixedMessage;

public class Application {

    public static void main(String[] args) {
        try {
            InputView inputView = new InputView();
            System.out.println(FixedMessage.GAME_START.getMessage() + "\n");
            inputView.readBridgeSize();
        } catch (IllegalArgumentException exception) {
            System.out.println(ErrorMessage.EXIT.getMessage());
        }
    }
}
