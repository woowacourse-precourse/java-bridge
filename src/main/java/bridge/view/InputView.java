package bridge.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() throws NumberFormatException {
        System.out.println("\n다리의 길이를 입력해주세요.");
        int size;
        try {
            size = Integer.parseInt(readLine().trim());
        } catch (NumberFormatException error) {
            System.out.println("[ERROR] 올바른 형식의 입력값이 아닙니다. 다시 입력해 주십시오.");
            return readBridgeSize();
        }
        return size;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("\n이동할 칸을 선택해주세요. (위: U, 아래: D)");
        return readLine().trim();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        return readLine().trim();
    }
}