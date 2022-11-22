package game;

public enum Restart {

    RESTART("R"),
    END("Q");

    private final String restart;

    Restart(String restart) {
        this.restart = restart;
    }

    public String getRestartMessage() {
        return restart;
    }
}
