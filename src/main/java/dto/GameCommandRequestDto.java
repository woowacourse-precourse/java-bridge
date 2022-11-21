package dto;

public class GameCommandRequestDto {
	private final String gameCommand;

	public GameCommandRequestDto(String gameCommand) {
		this.gameCommand = gameCommand;
	}

	public String getGameCommand() {
		return gameCommand;
	}
}
