package system;

import utils.EnumStrings;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println(EnumStrings.PRINT_START.getValue());
        new BridgeGame().game();
    }
}
