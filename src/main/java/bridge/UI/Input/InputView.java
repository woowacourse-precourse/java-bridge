package bridge.UI.Input; //패키지 변경 가능


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
     *
     * 메서드의 인자와 이름 그리고 반환 타입을 변경할 수 있다.
     */
    public String readMoving() {
        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     *
     * 메서드의 인자와 이름 그리고 반환 타입을 변경할 수 있다.
     */
    public String readGameCommand() {
        return null;
    }
}

//필요한 메서드 추가할 수 있다.