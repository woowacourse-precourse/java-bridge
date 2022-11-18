package bridge;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 *  InputView 클래스에서만 camp.nextstep.edu.missionutils.Console 의 readLine()을
    이용해 사용자의 입력을 받을 수 있다.
 *  InputView의 패키지는 변경할 수 있다.
 *  InputView의 메서드의 시그니처(인자, 이름)와 반환 타입은 변경할 수 있다.
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
}
