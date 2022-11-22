package bridge.domain.command;

import java.util.Arrays;

public enum BridgeMoveCommand {
	UP("U", 1),
	DOWN("D", 0);
	private String column;
	private int number;


	BridgeMoveCommand(String column, int number) {
		this.column = column;
		this.number = number;
	}

	public static String getBridgeColumn(int number) {
		return Arrays.stream(values())
				.filter(bridgeColumn -> bridgeColumn.number == number)
				.findAny()
				.orElseThrow(IllegalArgumentException::new)
				.getColumn();
	}

	public String getColumn() {
		return column;
	}
}