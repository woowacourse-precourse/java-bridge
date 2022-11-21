package bridge;

import java.util.NoSuchElementException;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private static final String EMPTY_STRING = "";

    public String readBridgeSize() {
        String bridgeSizeInput;

        try {
            bridgeSizeInput = readLine();
        } catch (NoSuchElementException exception) {
            bridgeSizeInput = EMPTY_STRING;
        }

        return bridgeSizeInput;
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
        return null;
    }
}
