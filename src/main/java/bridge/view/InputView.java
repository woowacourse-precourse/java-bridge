package bridge.view;

import bridge.config.InputConfig;
import bridge.domain.Command;
import camp.nextstep.edu.missionutils.Console;

import java.util.Optional;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String BRIDGE_LENGTH_INPUT_MESSAGE = "다리의 길이를 입력해주세요.";
    private static final String MOVING_INPUT_MESSAGE = "이동할 칸을 선택해주세요. ";
    private static final String RETRY_OR_QUIT_INPUT_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. ";
    private static final String TWO_CHOICE_FORMAT = "(%s: %s, %s: %s)";

    private final InputConfig inputConfig;

    public InputView() {
        this.inputConfig = new InputConfig();
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public Optional<Integer> readBridgeSize() {
        System.out.println(BRIDGE_LENGTH_INPUT_MESSAGE);
        try {
            String input = Console.readLine().trim();
            System.out.println();
            inputConfig.checkBridgeLength(input);

            return Optional.of(Integer.parseInt(input));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return Optional.empty();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public Optional<String> readMoving() {
        printMovingUpOrDown();
        try {
            String input = Console.readLine().trim();
            inputConfig.checkMovingInput(input);

            return Optional.of(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return Optional.empty();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public Optional<String> readGameCommand() {
        printRetryOrQuit();
        try {
            String input = Console.readLine().trim();
            inputConfig.checkAskReGameInput(input);

            return Optional.of(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return Optional.empty();
        }
    }

    private void printRetryOrQuit() {
        String tmp = printTwoChoice(Command.RETRY, Command.QUIT);
        System.out.println(RETRY_OR_QUIT_INPUT_MESSAGE + tmp);
    }

    private void printMovingUpOrDown() {
        String tmp = printTwoChoice(Command.UP, Command.DOWN);
        System.out.println(MOVING_INPUT_MESSAGE + tmp);
    }

    private String printTwoChoice(Command command1, Command command2) {
        String formatted = String.format(TWO_CHOICE_FORMAT, command1.getKor(), command1.getAbbreviation(), command2.getKor(), command2.getAbbreviation());
        return formatted;
    }
}
