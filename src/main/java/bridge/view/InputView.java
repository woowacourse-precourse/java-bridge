package bridge.view;

import bridge.domain.BridgeSize;
import bridge.domain.BridgeState;
import bridge.domain.GameCommand;
import bridge.domain.InputException;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String BRIDGE_SIZE_GUIDE_STRING = "다리의 길이를 입력해주세요.";
    private static final String MOVE_INPUT_GUIDE_STRING = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String RETRY_INPUT_GUIDE_STRING = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(BRIDGE_SIZE_GUIDE_STRING);
        String userBridgeSize = Console.readLine();
        validateBridgeSizeIsBlank(userBridgeSize);
        validateBridgeSizeFormat(userBridgeSize);
        validateBridgeSizeRange(userBridgeSize);
        int bridgeSize = changeStringToInt(userBridgeSize);
        return bridgeSize;
    }

    public void validateBridgeSizeIsBlank(String uncheckedInput) {
        if(uncheckedInput.isBlank()) {
            throw new IllegalArgumentException(InputException.BLANK_BRIDGE_LENGTH.getExceptionMessage());
        }
    }

    public void validateBridgeSizeFormat(String uncheckedInput) {
        try {
            changeStringToInt(uncheckedInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(InputException.NOT_NUMBER_BRIDGE_LENGTH.getExceptionMessage());
        }
    }

    private int changeStringToInt(String checkedInput) {
        return Integer.parseInt(checkedInput);
    }

    public void validateBridgeSizeRange(String uncheckedInput) {
        int bridgeSize = changeStringToInt(uncheckedInput);
        if(bridgeSize < BridgeSize.SIZE_MINIMUM.getSize() || bridgeSize > BridgeSize.SIZE_MAXIMUM.getSize()) {
            throw new IllegalArgumentException(InputException.OUT_OF_RANGE_BRIDGE_LENGTH.getExceptionMessage());
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(MOVE_INPUT_GUIDE_STRING);
        String userMove = Console.readLine();
        validateBlankMove(userMove);
        validateInvalidMove(userMove);
        return userMove;
    }

    public void validateBlankMove(String uncheckedInput) {
        if(uncheckedInput.isBlank()) {
            throw new IllegalArgumentException(InputException.BLANK_PLAYER_MOVE.getExceptionMessage());
        }
    }

    public void validateInvalidMove(String uncheckedInput) {
        if(uncheckedInput.equals(BridgeState.UP.getState()) ||
                uncheckedInput.equals(BridgeState.DOWN.getState())){
            return;
        }
        throw new IllegalArgumentException(InputException.INVALID_PLAYER_MOVE.getExceptionMessage());
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(RETRY_INPUT_GUIDE_STRING);
        String gameCommand = Console.readLine();
        validateBlankCommand(gameCommand);
        validateInvalidCommand(gameCommand);
        return gameCommand;
    }

    public void validateBlankCommand(String uncheckedInput) {
        if(uncheckedInput.isBlank()) {
            throw new IllegalArgumentException(InputException.BLANK_GAME_END_INPUT.getExceptionMessage());
        }
    }

    public void validateInvalidCommand(String uncheckedInput) {
        for(GameCommand command: GameCommand.values()) {
            if(uncheckedInput.equals(command.getGameCommand())) {
                return;
            }
        }
        throw new IllegalArgumentException(InputException.INVALID_GAME_END_INPUT.getExceptionMessage());
    }
}
