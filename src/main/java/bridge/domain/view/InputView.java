package bridge.domain.view;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */

import camp.nextstep.edu.missionutils.Console;

/**
 * 패키지 변경 가능
 * 메서드 이름 변경 가능
 * 메서드 인자, 반환 타입 변경 가능
 * 사용자 값 입력을 위해 필요한 메소드 추가 가능
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String bridgeSizeInput = Console.readLine();

        int bridgeSize = Integer.parseInt(bridgeSizeInput);

        return bridgeSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String movingInput = Console.readLine();

        return movingInput;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
