package bridge.input;

import static bridge.input.InputError.*;
import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.NoSuchElementException;

public class InputView {

    public int readBridgeSize() {
        String input = readInput();
        nonAllowedInputCheck(input, NOT_NUMBER);
        int size = Integer.parseInt(input);
        boundaryCheck(size);
        return size;
    }

    public String readMoving() {
        String input = readInput();
        inputLengthCheck(input);
        nonAllowedInputCheck(input, WRONG_MOVING_INPUT);
        return input;
    }

    public String readGameCommand() {
        String input = readInput();
        inputLengthCheck(input);
        nonAllowedInputCheck(input, WRONG_GAME_COMMAND_INPUT);
        return input;
    }
    private String readInput() {
        String input = "";
        try {
            input = readLine();
        } catch (NoSuchElementException unentered) {
            makeError(UNENTERED);
        }
        return input;
    }
}
