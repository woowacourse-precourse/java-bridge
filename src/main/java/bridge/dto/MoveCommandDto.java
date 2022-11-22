package bridge.dto;

public class MoveCommandDto {
	private final String moveCommand;
	private final boolean isAbleToMove;
	private final boolean isGameClear;

	public MoveCommandDto(String moveCommand, boolean isAbleToMove, boolean isGameClear) {
		this.moveCommand = moveCommand;
		this.isAbleToMove = isAbleToMove;
		this.isGameClear = isGameClear;
	}

	public String getMoveCommand() {
		return moveCommand;
	}

	public boolean isAbleToMove() {
		return isAbleToMove;
	}

	public boolean isGameClear() {
		return isGameClear;
	}
}
