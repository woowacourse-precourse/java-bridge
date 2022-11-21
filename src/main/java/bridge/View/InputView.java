package bridge.View;

import bridge.Utils.Verification;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static int readBridgeSize() {
        while(true) {
            String size = Console.readLine();
            if(Verification.isBridgeNum(size)) {
                return Integer.parseInt(size);
            }
        }
    }

    public static String readMoving() {
        while(true) {
            String key = Console.readLine();
            if(Verification.isMoveKey(key)) {
                return key;
            }
        }
    }

    public static String readGameCommand() {

    }
}
