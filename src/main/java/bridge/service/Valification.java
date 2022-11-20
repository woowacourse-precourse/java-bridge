package bridge.service;

import bridge.service.constants.Command;
import bridge.service.constants.Move;

import java.util.Objects;

public class Valification {

    private final int MIN_NUMBER = 3;
    private final int MAX_NUMBER = 20;

    public void verifyBridgeSize(int size) {
        if (!(MIN_NUMBER <= size && size <= MAX_NUMBER)) {
            throw new IllegalArgumentException("다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    public void verifyUorD(String move) {
        if (!(Objects.equals(move, Move.UPBRIDGE) || Objects.equals(move, Move.DOWNBRIDGE))) {
            throw new IllegalArgumentException("U, D 두개 중에 하나 선택 해야 합니다.");
        }
    }

    public void verifyQorR(String hi) {
        if (!(Objects.equals(hi, Command.RETRY) || Objects.equals(hi, Command.QUIT))) {
            throw new IllegalArgumentException("R, Q 두개 중에 하나 선택 해야 합니다.");
        }
    }
}
