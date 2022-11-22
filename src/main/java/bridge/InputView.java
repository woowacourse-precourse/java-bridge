package bridge;

import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public String readBridgeSize() {
        System.out.print("다리 건너기 게임을 시작합니다.\n\n");
        System.out.print("다리의 길이를 입력하세요.\n");
        return readLine();
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.print("\n이동할 칸을 입력해 주세요. (위: U, 아래: D)\n");
        return readLine();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.print("게임을 다시 시도할 지 여부를 입력해 주세요.(재시도: R, 종료: Q) : ");
        return readLine();
    }
}
