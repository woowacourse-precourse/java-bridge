package bridge.gameInput;

public enum GameCommand {
	RE_START("R"), QUIT("Q");

	private String command;

	GameCommand(String command) {
		this.command = command;
	}

	public String getCommand() {
		return command;
	}
}
