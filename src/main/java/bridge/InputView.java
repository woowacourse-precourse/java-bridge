package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String ASK_BRIDGE_SIZE_MESSAGE = "다리의 길이를 입력해주세요.";
    private static final String ASK_RETRY_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private static final String ASK_MOVING_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        while (true) {
            System.out.println(ASK_BRIDGE_SIZE_MESSAGE);
            try {
                int bridgeSize = strToInt(Console.readLine());
                validateBridgeSize(bridgeSize);
                return bridgeSize;
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    private static int strToInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(ErrorMessageGenerator.generate("변환할 수 없는 문자열입니다."));
        }
    }

    private static void validateBridgeSize(int bridgeSize) {
        if (bridgeSize < 3 || bridgeSize > 20) {
            throw new IllegalArgumentException(ErrorMessageGenerator.generate("브릿지 크기가 범위 밖입니다."));
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        while (true) {
            System.out.println(ASK_MOVING_MESSAGE);
            try {
                String line = Console.readLine();
                validateMovingCommand(line);
                return line;
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    private static void validateMovingCommand(String line) {
        if (line.equals(BridgeGame.CMD_UP) || line.equals(BridgeGame.CMD_DOWN)) {
            return;
        }
        throw new IllegalArgumentException(ErrorMessageGenerator.generate("잘못된 이동 명령어 입니다."));
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        while (true) {
            System.out.println(ASK_RETRY_MESSAGE);
            try {
                String line = Console.readLine();
                validateGameCommand(line);
                return line;
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    private static void validateGameCommand(String line) {
        if (line.equals(BridgeGame.CMD_RETRY) || line.equals(BridgeGame.CMD_QUIT)) {
            return;
        }
        throw new IllegalArgumentException(ErrorMessageGenerator.generate("잘못된 게임 명령어 입니다."));
    }
}
