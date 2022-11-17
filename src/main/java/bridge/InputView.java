package bridge;

/*
 * camp.nextstep.edu.missionutils.Console 의 readLine() 메서드를 이용
 * 제공된 InputView 클래스를 활용해 구현해야 한다.
 * InputView의 패키지는 변경할 수 있다.
 * InputView의 메서드의 시그니처(인자, 이름)와 반환 타입은 변경할 수 있다.
 * 사용자 값 입력을 위해 필요한 메서드를 추가할 수 있다.
 */

import bridge.dto.UserDto;
import bridge.validation.BridgeSizeValidation;

import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private final String INPUT_BRIDGE_SIZE_MSG ="다리의 길이를 입력해주세요.";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        BridgeSizeValidation bridgeSizeValidation = new BridgeSizeValidation();

        System.out.println(INPUT_BRIDGE_SIZE_MSG);
        String bridgeSize = readLine();
        bridgeSizeValidation.validate(bridgeSize);

        return Integer.parseInt(bridgeSize);
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
