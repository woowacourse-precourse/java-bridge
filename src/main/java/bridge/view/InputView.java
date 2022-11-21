package bridge.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public String readBridgeSize() {
        return inputWithMessage("다리의 길이를 입력해 주세요.");
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        return inputWithMessage("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    public String readRetry() {
        return inputWithMessage("\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }

    public String inputWithMessage(final String message) {
        System.out.println(message);
        return inputBasicString();
    }

    public String inputBasicString() {
        return readLine();
    }

}
