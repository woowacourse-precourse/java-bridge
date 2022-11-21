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
        String lineInput = getLineInput(InputType.BRIDGESIZE);
        return Integer.parseInt(lineInput);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() { return getLineInput(InputType.MOVINGCOMMAND); }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() { return getLineInput(InputType.GAMECOMMAND); }

    private String getLineInput(InputType inputType) { return validateLineInput(Console.readLine(), inputType); }

    private String validateLineInput(String lineInput, InputType inputType) {
        try {
            new Validation(lineInput, inputType);
            return lineInput;
        } catch(IllegalArgumentException e) {
            outputView.printNewLine();
            outputView.printMessage(e.getMessage());
        }
        return getLineInput(inputType);
    }
}
