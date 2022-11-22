package bridge.view;

import bridge.view.enums.GuideMessage;

public class PrintGuideMessage {
    public static void printStartGuide() {
        System.out.println(GuideMessage.START_MESSAGE.getMessage());
    }

    public static void printBridgeSizeGuide() {
        System.out.println(GuideMessage.BRIDGE_SIZE_INPUT_MESSAGE.getMessage());
    }

    public static void printMovingGuide() {
        System.out.println(GuideMessage.MOVING_INPUT_MESSAGE.getMessage());
    }

    public static void printCommandGuide() {
        System.out.println(GuideMessage.COMMAND_INPUT_MESSAGE.getMessage());
    }

    public static void printResultGuide() {
        System.out.println(GuideMessage.RESULT_MESSAGE.getMessage());
    }
}