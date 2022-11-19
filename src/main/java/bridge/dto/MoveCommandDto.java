package bridge.dto;

public class MoveCommandDto {
	private final String moveCommand;
	private final boolean moveFlag;

	public MoveCommandDto(String moveCommand, boolean moveFlag) {
		this.moveCommand = moveCommand;
		this.moveFlag = moveFlag;
	}

	public String getMoveCommand() {
		return moveCommand;
	}

	public boolean getMoveFlag() {
		return moveFlag;
	}
}
