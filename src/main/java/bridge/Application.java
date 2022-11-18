package bridge;

import bridge.resource.message.FixedMessage;

public class Application {

    public static void main(String[] args) {
        System.out.println(FixedMessage.GAME_START.getMessage() + "\n");
    }
}
