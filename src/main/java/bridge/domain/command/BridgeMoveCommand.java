package bridge.domain.command;

import java.util.Arrays;
import java.util.NoSuchElementException;

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
	public static boolean hasMoveCommand(String input) {
		return Arrays.stream(values())
				.anyMatch(bridgeMoveCommand -> bridgeMoveCommand.command.equals(input));

	}
	public static int getNumber(String input){
		return Arrays.stream(values())
				.filter(bridgeMoveCommand -> bridgeMoveCommand.command.equals(input))
				.findAny()
				.orElseThrow(NoSuchElementException::new)
				.getNumber();

	}
	public static int getSize(){
		return (int) Arrays.stream(values())
				.count();
	}

	public String getCommand() {
		return command;
	}

	public int getNumber() {
		return number;
	}
}