package bridge.domain;

import java.util.Arrays;

public enum GameCommand {
    QUIT("Q"), RETRY("R");

    private final String inputLetter;

    GameCommand(String inputLetter) {
        this.inputLetter = inputLetter;
    }

    public static GameCommand from(String inputLetter) {
        return Arrays.stream(values())
                .filter(retry -> retry.inputLetter.equals(inputLetter))
                .findFirst()
                .get();
    }

}
