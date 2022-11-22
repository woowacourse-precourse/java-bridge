package bridge.View;

import bridge.Utils.Verification;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static int readBridgeSize() {
        while (true) {
            String size = Console.readLine();
            if (Verification.isBridgeNum(size)) {
                return Integer.parseInt(size);
            }
        }
    }

    public String readMoving() {
        return null;
    }

    public String readGameCommand() {
        return null;
    }
}
