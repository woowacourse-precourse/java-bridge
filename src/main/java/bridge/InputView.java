package bridge;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        int bridgeSize = strToInt(readLine());

        validateBridgeSize(bridgeSize);
        return bridgeSize;
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
        String line = readLine();

        validateMovingCommand(line);
        return line;
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
        String line = readLine();

        validateGameCommand(line);
        return line;
    }

    private static void validateGameCommand(String line) {
        if (line.equals(BridgeGame.CMD_RETRY) || line.equals(BridgeGame.CMD_QUIT)) {
            return;
        }
        throw new IllegalArgumentException(ErrorMessageGenerator.generate("잘못된 게임 명령어 입니다."));
    }

    private static String readLine() {
        try {
            return (Console.readLine());
        } catch (NoSuchElementException ex) {
            throw new IllegalArgumentException(ErrorMessageGenerator.generate("[ERROR] 잘못된 입력 값 입니다."));
        }
    }

    private static int strToInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(ErrorMessageGenerator.generate("변환할 수 없는 문자열입니다."));
        }
    }
}
