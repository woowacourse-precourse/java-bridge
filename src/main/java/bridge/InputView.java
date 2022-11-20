package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        return 0;
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

    /**
     * 안내 문구를 출력하고 사용자로부터 입력받은 문자열을 반환한다.
     *
     * @param guide 출력해줄 안내 문구
     * @return 사용자가 입력한 문자열 반환
     */
    public String getInput(String guide) {
        System.out.println(guide);
        String input = Console.readLine();
        System.out.println();
        return input;
    }
}
