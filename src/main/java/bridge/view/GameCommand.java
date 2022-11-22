package bridge.view;

public enum GameCommand {
    UP("U"), DOWN("D"), QUIT("Q"), RESTART("R");

    private final String command;

    GameCommand(String command) {
        this.command = command;
    }

    public boolean equals(String s) {
        return this.command.equals(s);
    }
}
