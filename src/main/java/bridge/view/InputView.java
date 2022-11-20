package bridge.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    public String readBridgeSize() {
        System.out.println("\n다리의 길이를 입력해주세요.");
        return readLine();
    }

    public String readMoving() {
        System.out.println("\n이동할 칸을 선택해주세요. (위: U, 아래: D)");
        return readLine();
    }

    public String readGameCommand() {
        System.out.println("\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        return readLine();
    }
}
