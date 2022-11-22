package bridge.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    public String readBridgeSize() {
        return inputWithMessage("다리의 길이를 입력해 주세요.");
    }

    public String readMoving() {
        return inputWithMessage("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    public String readRetry() {
        return inputWithMessage("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }

    public String inputWithMessage(final String message) {
        System.out.println(message);
        return inputBasicString();
    }

    public String inputBasicString() {
        return readLine();
    }
}
