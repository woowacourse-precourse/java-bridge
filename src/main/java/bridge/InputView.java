package bridge;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 * 1. InputView의 패키지는 변경할 수 🌴있다.🌴
 * 2. InputView의 메소드 시그니처 (인자, 이름)와 반환 타입은 변경할 수 🌴있다.🌴
 * 3. 사용자 값 입력을 위해 필요한 메소드를 추가할 수 🌴있다.🌴
 * 4. InputView 클래스에서만 Console.readLine() 메소드를 이용해 사용자의 입력을 받을 수 🌴있다.🌴
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
