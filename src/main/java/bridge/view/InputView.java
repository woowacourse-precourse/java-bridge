package bridge.view;

import bridge.config.BridgeInformation;
import bridge.dto.InputValidationDto.Request;
import bridge.dto.InputValidationDto.Response;
import bridge.type.BridgeSpaceStatus;
import bridge.type.InputType;
import bridge.validation.InputValidationChain;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final String BRIDGE_SIZE_INFORMATION_PHRASE = "다리의 길이를 입력해주세요.";
    private static final String MOVE_SELECT_INFORMATION_PHRASE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String GAME_COMMAND_INFORMATION_PHRASE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize(final InputValidationChain validator)
        throws IllegalArgumentException {
        System.out.println(BRIDGE_SIZE_INFORMATION_PHRASE);
        String input = getInput(validator, InputType.BRIDGE_LENGTH);
        return Integer.parseInt(input);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static BridgeSpaceStatus readMoving(final InputValidationChain validator)
        throws IllegalArgumentException {
        System.out.println(MOVE_SELECT_INFORMATION_PHRASE);
        return BridgeSpaceStatus.findByLetter(getInput(validator, InputType.MOVE_SELECT));
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static boolean readGameCommand(final InputValidationChain validator)
        throws IllegalArgumentException {
        System.out.println(GAME_COMMAND_INFORMATION_PHRASE);
        String input = getInput(validator, InputType.RESTART_OR_QUIT);
        return input.equals(BridgeInformation.RESTART);
    }

    private static String getInput(final InputValidationChain validator, final InputType inputType) {
        String input = Console.readLine();
        validate(validator, inputType, input);
        return input;
    }

    private static void validate(final InputValidationChain validator, final InputType inputType,
        final String input) {
        Request request = new Request(inputType, input);
        Response response = validator.validate(request);
        if (!response.isValid()) {
            throw new IllegalArgumentException(response.getErrorMessage());
        }
    }
}
