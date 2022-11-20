package bridge.view;

import bridge.view.enums.GuideMessage;

public class PrintGuideMessage {
    public static void printStartGuide() {
        System.out.println(GuideMessage.START_MESSAGE.getMessage());
    }

    public static void printBridgeSizeGuide() {
        System.out.println(GuideMessage.BRIDGE_SIZE_INPUT_MESSAGE.getMessage());
    }
}