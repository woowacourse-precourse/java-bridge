package bridge;

import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    Validation inputCheck;

    InputView() {
        inputCheck = new Validation();
    }
    /**
     * 다리의 길이를 입력받는다.
     */
    public String readBridgeSize() {
        try {
            System.out.print("다리 건너기 게임을 시작합니다.\n\n");
            System.out.print("다리의 길이를 입력하세요.\n");
            return inputCheck.readBridgeSizeCheck(readLine());
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readBridgeSize();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        try {
            System.out.print("\n이동할 칸을 입력해 주세요. (위: U, 아래: D)\n");
            return inputCheck.readMovingCheck(readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readBridgeSize();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        try {
            System.out.print("게임을 다시 시도할 지 여부를 입력해 주세요.(재시도: R, 종료: Q) : ");
            return inputCheck.readCommandCheck(readLine());
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readGameCommand();
        }
    }
}
