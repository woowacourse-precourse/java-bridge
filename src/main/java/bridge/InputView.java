package bridge;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private static final String INPUT_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    private static final String SELECT_BLOCK = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String INPUT_COMMAND = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    public static String readBridgeSize() {
        System.out.println(INPUT_BRIDGE_SIZE);
        return readLine();
    }

    public static String readMoving() {
        System.out.println(SELECT_BLOCK);
        return readLine();
    }

    public static String readGameCommand() {
        System.out.println(INPUT_COMMAND);
        return readLine();
    }
}