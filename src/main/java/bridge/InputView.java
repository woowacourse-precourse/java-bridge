package bridge;

import camp.nextstep.edu.missionutils.Console;

import bridge.Validation.InputType;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final OutputView outputView = new OutputView();

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String lineInput = readInput(InputType.BRIDGELENGTH);
        return Integer.parseInt(lineInput);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() { return readInput(InputType.MOVINGCOMMAND); }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() { return readInput(InputType.GAMECOMMAND); }

    private String readInput(InputType inputType) {
        String lineInput = Console.readLine();
        try {
            new Validation(lineInput, inputType);
            return lineInput;
        } catch(IllegalArgumentException e) {
            outputView.printMessage(e.getMessage());
        }
        return readInput(inputType);
    }
}
