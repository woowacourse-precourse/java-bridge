package bridge.View;

import bridge.Enum.BridgeGameInfo;
import bridge.Validator.Integarated.BridgeSizeValidator;
import bridge.Validator.Integarated.PlayerMoveValidator;
import bridge.Validator.Integarated.RestartDecisionValidator;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public InputView() {}
    BridgeSizeValidator bridgeSizeValidator = new BridgeSizeValidator();
    PlayerMoveValidator playerMoveValidator = new PlayerMoveValidator();
    RestartDecisionValidator restartDecisionValidator = new RestartDecisionValidator();

    public int readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        String input = getInput();
        bridgeSizeValidator.validate(input);
        return Integer.parseInt(input);
    }

    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: "+ BridgeGameInfo.UP.getWord() +", 아래: "+BridgeGameInfo.DOWN.getWord()+")");
        String input = getInput();
        playerMoveValidator.validate(input);
        return input;
    }

    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요 (재시도: "+BridgeGameInfo.RESTART.getWord()+", 종료: "+BridgeGameInfo.QUIT.getWord()+")");
        String input = getInput();
        restartDecisionValidator.validate(input);
        return input;
    }

    public String getInput() {
        return Console.readLine();
    }

}

