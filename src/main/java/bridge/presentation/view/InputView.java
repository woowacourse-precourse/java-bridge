package bridge.presentation.view;

import bridge.domain.GameCommand;
import bridge.domain.Move;
import bridge.presentation.converter.Converter;
import bridge.presentation.validator.InputValidator;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private final static String READ_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    private final static String READ_MOVING = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private final static String READ_GAME_COMMAND = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    public int readBridgeSize() {
        System.out.println(READ_BRIDGE_SIZE);
        String bridgeSize = Console.readLine();
        InputValidator.validateBridgeSize(bridgeSize);
        return Converter.convertBridgeSize(bridgeSize);
    }
    public Move readMoving() {
        System.out.println(READ_MOVING);
        String moving = Console.readLine();
        InputValidator.validateMoving(moving);
        return Move.findByCommand(moving);
    }

    public GameCommand readGameCommand() {
        System.out.println(READ_GAME_COMMAND);
        String gameCommand = Console.readLine();
        InputValidator.validateGameCommand(gameCommand);
        return GameCommand.findByCommand(gameCommand);
    }

}
