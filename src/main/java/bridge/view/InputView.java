package bridge.view;

import bridge.config.InputConfig;
import bridge.domain.Command;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String BRIDGE_LENGTH_INPUT_MESSAGE = "다리의 길이를 입력해주세요.";
    private static final String MOVING_INPUT_MESSAGE = "이동할 칸을 선택해주세요. ";
    private static final String RETRY_OR_QUIT_INPUT_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. ";

    private final InputConfig inputConfig;

    public InputView() {
        this.inputConfig = new InputConfig();
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(BRIDGE_LENGTH_INPUT_MESSAGE);
        String input = Console.readLine();
        inputConfig.checkBridgeLength(input);
        return Integer.parseInt(input);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        printMovingUpOrDown();
        String input = Console.readLine();
        inputConfig.checkMovingInput(input);
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        printRetryOrQuit();
        String input = Console.readLine();
        inputConfig.checkAskReGameInput(input);
        return input;
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
        String tmp = "(%s: %c, %s: %c)";
        String formatted = String.format(tmp, command1.getKor(), command1.getAbbreviation(), command2.getKor(), command2.getAbbreviation());
        return formatted;
    }
}
