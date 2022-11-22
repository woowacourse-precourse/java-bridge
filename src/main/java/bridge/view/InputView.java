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
    private static final String MOVING_INPUT_MESSAGE = "이동할 칸을 선택해주세요. %s";
    private static final String RETRY_OR_QUIT_INPUT_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. %s";
    private static final String TWO_CHOICE_FORMAT = "(%s: %s, %s: %s)";

    private final InputConfig inputConfig;

    public InputView() {
        this.inputConfig = new InputConfig();
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public Optional<Integer> readBridgeSize() {
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
        try {
            String input = Console.readLine().trim();
            inputConfig.checkAskReGameInput(input);
            return Optional.of(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return Optional.empty();
        }
    }

    public void printBridgeLengthInputMessage() {
        System.out.println(BRIDGE_LENGTH_INPUT_MESSAGE);
    }

    public void printRetryOrQuitInputMessage() {
        String tmp = printTwoChoice(Command.RETRY, Command.QUIT);
        System.out.println(String.format(RETRY_OR_QUIT_INPUT_MESSAGE, tmp));
    }

    public void printMoveUpOrDownMessage() {
        String tmp = printTwoChoice(Command.UP, Command.DOWN);
        System.out.println(String.format(MOVING_INPUT_MESSAGE, tmp));
    }

    private String printTwoChoice(Command cmd1, Command cmd2) {
        return String.format(TWO_CHOICE_FORMAT,
                cmd1.getKor(), cmd1.getAbbreviation(),
                cmd2.getKor(), cmd2.getAbbreviation());
    }
}
