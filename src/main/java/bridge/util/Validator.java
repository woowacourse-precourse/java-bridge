package bridge.util;

import bridge.constant.BridgeMove;
import bridge.constant.BridgeRange;
import bridge.constant.GameCommand;

public class Validator {

    public static void validateNumberInBridgeRange(int number) {
        int minRange = BridgeRange.MIN.getValue();
        int maxRange = BridgeRange.MAX.getValue();

        if (!(minRange <= number && number <= maxRange)) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    public static void validateMovableInput(String input) {
        BridgeMove bridgeMove = BridgeMove.findByInput(input);

        if (bridgeMove.isMiss()) {
            throw new IllegalArgumentException("[ERROR] 이동할 칸은 U 또는 D를 입력해야 합니다.");
        }
    }

    public static void validateIfStringIsGameCommand(String string) {
        GameCommand gameCommand = GameCommand.findByString(string);

        if (gameCommand.isMiss()) {
            throw new IllegalArgumentException("[ERROR] R 또는 Q를 입력해주세요.");
        }
    }
}
