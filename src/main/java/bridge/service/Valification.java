package bridge.service;

import bridge.service.constants.Command;
import bridge.service.constants.Move;

import java.util.Objects;

public class Valification {

    private final int MIN_NUMBER = 3;
    private final int MAX_NUMBER = 20;

    public void verifyBridgeSize(int size) {
        if (!(MIN_NUMBER <= size && size <= MAX_NUMBER)) {
            throw new IllegalArgumentException();
        }
    }

    public void verifyUorD(String move) {
        if (!(Objects.equals(move, Move.UPBRIDGE) || Objects.equals(move, Move.DOWNBRIDGE))) {
            throw new IllegalArgumentException();
        }
    }

    public void verifyQorR(String hi) {
        if (!(Objects.equals(hi, Command.RETRY) || Objects.equals(hi, Command.QUIT))) {
            throw new IllegalArgumentException();
        }
    }
}
