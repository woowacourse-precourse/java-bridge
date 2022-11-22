package bridge.domain.command;

import java.util.Arrays;

public enum BridgeMoveCommand {
	UP("U", 1),
	DOWN("D", 0);
	private String command;
	private int number;


	BridgeMoveCommand(String command, int number) {
		this.command = command;
		this.number = number;
	}

	public static String getBridgeColumn(int number) {
		return Arrays.stream(values())
				.filter(bridgeColumn -> bridgeColumn.number == number)
				.findAny()
				.orElseThrow(IllegalArgumentException::new)
				.getCommand();
	}

	public String getCommand() {
		return command;
	}
}