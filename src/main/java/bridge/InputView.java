package bridge;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public String readBridgeSize() {
        return getInput("\n다리의 길이를 입력해주세요.");
    }

    public String readMoving() {
        return getInput("\n이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    public String readGameCommand() {
        return getInput("\n게임을 다시 시도할지 여부를 입력햐주세요. (재시도: R, 종료: Q)");
    }

    private String getInput(String prompt) {
        System.out.println(prompt);
        return readLine();
    }

}
