package bridge.view;

import static bridge.domain.util.Message.BRIDGE_SIZE_ERROR_MESSAGE;
import static bridge.domain.util.Message.MOVE_ERROR_MESSAGE;
import static bridge.domain.util.Message.RETRY_ERROR_MESSAGE;

public class ErrorOutputView extends ErrorOutput {

    public void printBridSizeError() {
        super.printError();
        System.out.println(BRIDGE_SIZE_ERROR_MESSAGE);
    }

    public void printMoveError() {
        super.printError();
        System.out.println(MOVE_ERROR_MESSAGE);
    }

    public void printRetryError() {
        super.printError();
        System.out.println(RETRY_ERROR_MESSAGE);
    }
}
