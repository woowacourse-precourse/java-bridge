package bridge.view;

import static bridge.constants.GuideMessage.*;

public class GuideOutputView {

    public static void printStart() {
        System.out.println(START_MESSAGE+"\n");
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
