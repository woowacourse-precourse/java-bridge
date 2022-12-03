package bridge.view;

import bridge.message.Message;

public class ViewMessage {
    public static void printGameStartMessage() {
        System.out.println(Message.START_GAME.getMessage());
    }

    public static void printBridgeSizeInputRequest() {
        System.out.println(Message.INPUT_BRIDGE_SIZE.getMessage());
    }

    public static void printMovingInputRequest() {
        System.out.println(Message.INPUT_MOVING.getMessage());
    }

    public static void printGameCommandInputRequest() {
        System.out.println(Message.INPUT_GAME_COMMAND.getMessage());
    }

    public static void printEndGameMessage() {
        System.out.println(Message.RESULT.getMessage());
    }
}
