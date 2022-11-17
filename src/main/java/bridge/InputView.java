package bridge;

import camp.nextstep.edu.missionutils.Console;
import exception.ExceptionHandler;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private ExceptionHandler eh;
    /**
     * 다리의 길이를 입력받는다.
     */
    public Integer readBridgeSize() {
        try {
            this.eh = new ExceptionHandler(Integer.parseInt(Console.readLine()));
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 3 ~ 20 사이의 정수만 입력 가능합니다.");
            this.readBridgeSize();
        }
        return eh.getSize();
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
        try {
            this.eh = new ExceptionHandler(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 재시도: R, 종료: Q");
            this.readGameCommand();
        }
        return eh.getGameCommand();
    }
}
