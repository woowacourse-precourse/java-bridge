package bridge.view;

import bridge.constants.GuideMessage;

import static bridge.constants.GuideMessage.*;

public class OutputView {

    public static void printStart() {
        System.out.println(START_MESSAGE);
    }

    public static void printBridgeLength() {
        System.out.println(ENTER_BRIDGE_LENGTH);
    }

    public static void printUpAndDown() {
        System.out.println(ENTER_UP_DOWN);
    }

    public static void printRetry() {
        System.out.println(ENTER_RETRY);
    }
}
