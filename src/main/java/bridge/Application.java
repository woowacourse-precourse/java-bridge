package bridge;

import bridge.controller.BridgeGame;
import bridge.utils.EnumStrings;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println(EnumStrings.PRINT_START.getValue());
        new BridgeGame().runGame();
    }
}
