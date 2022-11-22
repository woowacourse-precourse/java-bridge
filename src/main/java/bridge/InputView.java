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
        while(true) {
            System.out.println("다리의 길이를 입력해주세요.");
            String inputBridgeLength = Console.readLine();
            // 만약 올바른 값이라면 그 값 리턴
            // 올바르지 않은 값이라면 에러 Exception 발생 후 에러 메시지 출력 후 반복
            return 0;
        }
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
