package bridge.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        // 다리 길이를 입력받고 숫자인지 확인한다.
        String input = Console.readLine();
        validateBridgeSizeType(input);

        // 다리 길이가 지정 범위이내인지 확인하고 반환한다.
        int bridgeSize = Integer.parseInt(input);
        validateBridgeSizeRange(bridgeSize);
        return bridgeSize;
    }

    private void validateBridgeSizeType(String input) {
    }

    private void validateBridgeSizeRange(int bridgeSize) {
    }

    private void convertToInteger() {
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }


    private void printInputBridgeSizeMessage() {
        System.out.println("다리의 길이를 입력해주세요.");
    }

    private void printInputMovingMessage() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    private void printInputGameCommandMessage() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }
}
