package bridge.game;


import java.util.Arrays;

public enum GameCommend {

    RESTART("R"),
    QUIT("Q"),
    ;

    private final String stringIdentifier;

    GameCommend(String stringIdentifier) {
        this.stringIdentifier = stringIdentifier;
    }

    public String getStringIdentifier() {
        return stringIdentifier;
    }
}
