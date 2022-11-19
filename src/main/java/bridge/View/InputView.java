package bridge.View;

import bridge.Validator.Integarated.BridgeSizeValidator;
import bridge.Validator.Integarated.PlayerMoveValidator;
import bridge.Validator.Integarated.RestartDecisionValidator;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    public InputView() {}
    BridgeSizeValidator bridgeSizeValidator = new BridgeSizeValidator();
    PlayerMoveValidator playerMoveValidator = new PlayerMoveValidator();
    RestartDecisionValidator restartDecisionValidator = new RestartDecisionValidator();
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        String input = getInput();
        bridgeSizeValidator.validate(input);
        return Integer.parseInt(input);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String input = getInput();
        playerMoveValidator.validate(input);
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요 (재시도: R, 종료: Q)");
        String input = getInput();
        restartDecisionValidator.validate(input);
        return input;
    }


    public String getInput() {
        return Console.readLine();
    }

}

