package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private final String BRIDGE_SIZE_NOTICE = "다리의 길이를 입력해주세요.";
    private final String BRIDGE_SIZE_RANGE_ERROR_NOTICE = "[ERROR] 가능한 범위를 벗어났습니다.";
    private final String BRIDGE_SIZE_NOT_LETTER_ERROR_NOTICE = "[ERROR] 문자 입력이 감지되었습니다..";
    private final String MOVING_NOTICE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private final String MOVING_NOT_NUMBER_ERROR_NOTICE = "[ERROR] 제한된 입력 방식과 다릅니다.";
    private final String GAME_COMMAND_NOTICE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private final String GAME_COMMAND_NOT_NUMBER_ERROR_NOTICE = "[ERROR] 제한된 입력 방식과 다릅니다.";
    int bridgeSize_in = 0;
    String upAndDown_in = "";
    String retryAndQuit_in = "";

    public void readBridgeSize() {
        System.out.println(BRIDGE_SIZE_NOTICE);
        String bridgeSizeLetter_in = Console.readLine();
        bridgeSizeNotLetterValidation(bridgeSizeLetter_in);
        bridgeSizeRangeValidation(bridgeSize_in);
    }

    public void readMoving() {
        System.out.println(MOVING_NOTICE);
        upAndDown_in = Console.readLine();
        movingNotNumberValidation(upAndDown_in);
    }

    public void readGameCommand() {
        System.out.println(GAME_COMMAND_NOTICE);
        retryAndQuit_in = Console.readLine();
        gameCommandNumberValidation(retryAndQuit_in);
    }

    private void bridgeSizeRangeValidation(int bridgeSize_in) {
        if (20 < bridgeSize_in || bridgeSize_in < 3)
            try {
                throw new IllegalArgumentException();
            } catch (IllegalArgumentException e) {
                System.out.println(BRIDGE_SIZE_RANGE_ERROR_NOTICE);
                readBridgeSize();
            }
    }

    private void bridgeSizeNotLetterValidation(String bridgeSizeLetter_in) {
        String filter = "^[0-9]+";
        try {
            if (String.valueOf(bridgeSizeLetter_in).matches(filter)) {
                bridgeSize_in = Integer.parseInt(String.valueOf(bridgeSizeLetter_in));
                return;
            }
            throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            System.out.println(BRIDGE_SIZE_NOT_LETTER_ERROR_NOTICE);
            readBridgeSize();
        }
    }
}
