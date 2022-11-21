package bridge.view;

/*
 * camp.nextstep.edu.missionutils.Console 의 readLine() 메서드를 이용
 * 제공된 InputView 클래스를 활용해 구현해야 한다.
 * InputView의 패키지는 변경할 수 있다.
 * InputView의 메서드의 시그니처(인자, 이름)와 반환 타입은 변경할 수 있다.
 * 사용자 값 입력을 위해 필요한 메서드를 추가할 수 있다.
 */

import bridge.validation.BridgeSizeValidation;
import bridge.validation.GameCommandValidation;
import bridge.validation.MovingValidation;

import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private final String INPUT_BRIDGE_SIZE_MSG = "다리의 길이를 입력해주세요.";
    private final String INPUT_MOVING_MSG = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private final String INPUT_GAME_COMMAND = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        BridgeSizeValidation bridgeSizeValidation = new BridgeSizeValidation();
        String bridgeSize;

        System.out.println(INPUT_BRIDGE_SIZE_MSG);
        bridgeSize = readLine();
        bridgeSizeValidation.validate(bridgeSize);

        return Integer.parseInt(bridgeSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        MovingValidation movingValidation = new MovingValidation();
        String moving;

        System.out.println(INPUT_MOVING_MSG);
        moving = readLine();
        movingValidation.validate(moving);

        return moving;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        GameCommandValidation gameCommandValidation = new GameCommandValidation();
        String gameCommand;

        System.out.println(INPUT_GAME_COMMAND);
        gameCommand = readLine();
        gameCommandValidation.validate(gameCommand);

        return gameCommand;
    }
}
