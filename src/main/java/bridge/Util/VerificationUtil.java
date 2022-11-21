package bridge.Util;

import camp.nextstep.edu.missionutils.Console;

public class VerificationUtil {

    private VerificationUtil() {}

    public static int verifyBridgeSize(String size) {

        int bridgeSize;
        try {
            bridgeSize = Integer.parseInt(size);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 숫자여야 합니다.");
        }

        if (bridgeSize < 3 || bridgeSize > 20)
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");

        return bridgeSize;
    }

    public static void verifyMoving(String moving) {

        if (!moving.equals("U") && !moving.equals("D"))
            throw new IllegalArgumentException("[ERROR] 이동할 칸은 U 또는 D로 입력할 수 있습니다.");
    }

    public static void verifyGameCommand(String command) {

        if (!command.equals("R") && !command.equals("Q"))
            throw new IllegalArgumentException("[ERROR] 재시작 여부는 R 또는 Q로 입력할 수 있습니다.");

    }
}
