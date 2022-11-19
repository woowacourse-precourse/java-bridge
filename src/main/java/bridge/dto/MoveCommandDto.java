package bridge.dto;

public class MoveCommandDto {
	private final String moveCommand;
	private final boolean moveFlag;
	private final boolean gameClear;

	public MoveCommandDto(String moveCommand, boolean moveFlag, boolean gameClear) {
		this.moveCommand = moveCommand;
		this.moveFlag = moveFlag;
		this.gameClear = gameClear;
	}

	public String getMoveCommand() {
		return moveCommand;
	}

	public boolean getMoveFlag() {
		return moveFlag;
	}

	public boolean getGameClear() {
		return gameClear;
	}
}
