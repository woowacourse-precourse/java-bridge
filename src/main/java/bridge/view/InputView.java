package bridge.view;

import bridge.utils.FormValidation;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final FormValidation formValidation = new FormValidation();

    public int readBridgeSize() {
        String bridgeSizeInput = input();

        formValidation.validateBridgeSizeInputForm(bridgeSizeInput);
        return Integer.valueOf(bridgeSizeInput);
    }

    public String readMoving() {
        String selectUpOrDownInput = input();

        formValidation.validateMovingInputForm(selectUpOrDownInput);
        return selectUpOrDownInput;
    }

    public String readGameCommand() {
        String gameCommandInput = input();

        formValidation.validateGameCommandInputForm(gameCommandInput);
        return gameCommandInput;
    }

    private String input() {
        return Console.readLine();
    }
}