package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        inputView.readBridgeSize();
    }
    /**
     * 다리의 길이를 입력받는다.
     */
    // 일단 여기서 데이터 검증 로직 추가.
    // 추후 DTO 같은 곳에서 검증 할 수 도 있음.
    public int readBridgeSize() {
        String inputSize = Console.readLine();
        for (int i = 0; i < inputSize.length(); i++) {
            if (!Character.isDigit(inputSize.charAt(i))) {
                throw new IllegalArgumentException("다리 길이는 양의숫자 여야 합니다.");
            }
        }
        return Integer.parseInt(inputSize);
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
}
