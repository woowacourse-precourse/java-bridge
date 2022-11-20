package bridge.view;

import bridge.MoveCommand;
import bridge.RetryCommand;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
        System.out.println("다리의 길이를 입력해주세요.");

        int bridgeLen = validateBridgeInputIsNumber(Console.readLine());
        validateBridgeLen(bridgeLen);

        return bridgeLen;
    }

    private int validateBridgeInputIsNumber(String input) {
        int bridgeLen;
        try {
            bridgeLen = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("다리 길이는 숫자로만 입력 가능합니다.");
        }
        return bridgeLen;
    }

    private void validateBridgeLen(int bridgeLen) {
        if (!(3 <= bridgeLen && bridgeLen <= 20))
            throw new IllegalArgumentException("다리 길이는 3 이상 20 이하의 숫자를 입력할 수 있습니다.");
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public char readMoveCommand() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");

        String alphabeticInput = Console.readLine();
        validateAlphabeticInputLen(alphabeticInput);

        char moveCommand = alphabeticInput.charAt(0);
        validateMoveCommandFormat(moveCommand);

        return moveCommand;
    }

    private void validateMoveCommandFormat(char moving) {
        if (moving != MoveCommand.UP.getValue() && moving != MoveCommand.DOWN.getValue())
            throw new IllegalArgumentException("이동할 칸은 U 혹은 D를 입력하여야 합니다.");
    }

    private void validateAlphabeticInputLen(String input) {
        if (input.length() != 1)
            throw new IllegalArgumentException("길이가 2 이상인 문자열은 입력할 수 없습니다.");
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public char readRetryCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");

        String alphabeticInput = Console.readLine();
        validateAlphabeticInputLen(alphabeticInput);

        char restartCommand = alphabeticInput.charAt(0);
        validateRetryCommandFormat(restartCommand);

        return restartCommand;
    }

    private void validateRetryCommandFormat(char retryCommand) {
        if (retryCommand != RetryCommand.RETRY.getValue() && retryCommand != RetryCommand.QUIT.getValue())
            throw new IllegalArgumentException("게임 재시도 여부는 R 혹은 Q를 입력하여야 합니다.");
    }
}
