package bridge.view;

import bridge.dto.input.ReadBridgeSizeDto;
import bridge.dto.input.ReadGameCommandDto;
import bridge.dto.input.ReadMovingDto;
import bridge.utils.common.BridgeConst;
import bridge.utils.common.CommandConst;
import bridge.utils.message.ExceptionMessageUtils;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final int COMMAND_LENGTH = 1;
    private static final int INPUT_CHAR_INDEX = 0;

    public ReadBridgeSizeDto readBridgeSize() {
        print(InputViewMessage.MAKE_BRIDGE.message);

        try {
            int playerInput = Integer.parseInt(Console.readLine());
            validateBridgeSize(playerInput);
            printNewLine();
            return new ReadBridgeSizeDto(playerInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessageUtils.WRONG_BRIDGE_SIZE.getMessage());
        }
    }

    private void validateBridgeSize(int size) {
        if (!isValidRangeSize(size)) {
            throw new IllegalArgumentException(ExceptionMessageUtils.WRONG_BRIDGE_SIZE.getMessage());
        }
    }

    private boolean isValidRangeSize(int size) {
        return BridgeConst.MIN_BRIDGE_SIZE <= size && size <= BridgeConst.MAX_BRIDGE_SIZE;
    }

    public ReadMovingDto readMoving() {
        print(InputViewMessage.GAME_PLAY.message);

        String playerInput = Console.readLine();

        if (isUpperCase(playerInput)) {
            return new ReadMovingDto(playerInput);
        }
        throw new IllegalArgumentException(ExceptionMessageUtils.WRONG_PLAYER_MOVE.getMessage());
    }

    public ReadGameCommandDto readGameCommand() {
        print(InputViewMessage.GAME_RETRY.message);

        String playerInput = Console.readLine();

        if (isUpperCase(playerInput)) {
            return new ReadGameCommandDto(playerInput);
        }
        throw new IllegalArgumentException(ExceptionMessageUtils.WRONG_GAME_COMMAND.getMessage());
    }

    private void print(String message) {
        System.out.println(message);
    }

    private void printNewLine() {
        System.out.println();
    }

    private boolean isUpperCase(String input) {
        return input.length() == COMMAND_LENGTH && Character.isUpperCase(input.charAt(INPUT_CHAR_INDEX));
    }

    private enum InputViewMessage {
        MAKE_BRIDGE("다리의 길이를 입력해주세요."),

        GAME_PLAY("이동할 칸을 선택해주세요. (위: %s, 아래: %s)",
                CommandConst.PLAYER_MOVE_UP,
                CommandConst.PLAYER_MOVE_DOWN),

        GAME_RETRY("게임을 다시 시도할지 여부를 입력해주세요. (재시도: %s, 종료: %s)",
                CommandConst.GAME_RETRY,
                CommandConst.GAME_QUIT);

        private final String message;

        InputViewMessage(String baseMessage, Object... replaces) {
            this.message = String.format(baseMessage, replaces);
        }
    }
}
