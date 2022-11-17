package bridge.view;

import bridge.util.ValidationUtil;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println("다리의 길이를 입력해주세요.");
        int bridgeSize = -1;
        while (bridgeSize < 0) {
            bridgeSize = getValidBridgeLength();
        }
        return bridgeSize;
    }

    private static int getValidBridgeLength() {
        String input;
        try {
            input = Console.readLine();
            ValidationUtil.isValidBridgeLength(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            input = "-1";
        }
        return Integer.parseInt(input);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String inputKey = "";
        while (inputKey.isBlank()) {
            inputKey = getValidMovingKey();
        }
        return inputKey;
    }

    private static String getValidMovingKey() {
        String inputKey;
        try {
            inputKey = Console.readLine();
            ValidationUtil.isUpOrDown(inputKey);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            inputKey = "";
        }
        return inputKey;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String inputKey = "";
        while (inputKey.isBlank()) {
            inputKey = getValidREadGameCommand();
        }
        return inputKey;
    }

    private static String getValidREadGameCommand() {
        String inputKey;
        try {
            inputKey = Console.readLine();
            ValidationUtil.isRetryOrQuit(inputKey);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            inputKey = "";
        }
        return inputKey;
    }
}
