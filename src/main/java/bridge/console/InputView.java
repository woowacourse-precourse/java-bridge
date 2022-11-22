package bridge.console;

import java.util.NoSuchElementException;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private static final String EMPTY_STRING = "";

    private static InputView instance;

    private InputView() {

    }

    public static InputView getInputView() {
        if (instance == null) {
            instance = new InputView();
        }
        return instance;
    }

    public String readBridgeSize() {
        String bridgeSize;

        try {
            bridgeSize = readLine();
        } catch (NoSuchElementException exception) {
            bridgeSize = EMPTY_STRING;
        }

        return bridgeSize;
    }

    public String readMove() {
        String move;

        try {
            move = readLine();
        } catch (NoSuchElementException exception) {
            move = EMPTY_STRING;
        }

        return move;
    }

    public String readGameCommand() {
        String gameCommand;

        try {
            gameCommand = readLine();
        } catch (NoSuchElementException exception) {
            gameCommand = EMPTY_STRING;
        }

        return gameCommand;
    }
}
