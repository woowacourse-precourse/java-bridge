package bridge.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 * <p>
 * 1. 제공된 InputView 클래스를 활용해 구현해야 한다.
 * 2. InputView의 패키지는 변경할 수 있다.
 * 3. InputView의 메서드의 시그니처(인자, 이름)와 반환 타입은 변경할 수 있다.
 * 4. 사용자 값 입력을 위해 필요한 메서드를 추가할 수 있다.
 */
public class InputView {
    public static final String INPUT_BRIDGE_LENGTH = "다리의 길이를 입력해주세요.";
    public static final String INPUT_MOVE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(INPUT_BRIDGE_LENGTH);
        int bridgeLength = Integer.parseInt(Console.readLine());
        return bridgeLength;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(INPUT_MOVE);
        return Console.readLine();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
