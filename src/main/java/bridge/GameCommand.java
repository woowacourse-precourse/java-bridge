package bridge;

public class GameCommand implements InputValidator{

	private final String gameCommand;
	private static final String COMMAND_RETRY = "R";
	private static final String COMMAND_QUIT = "Q";

	public GameCommand(String gameCommand){
		validate(gameCommand);
		this.gameCommand = gameCommand;
	}

	public static GameCommand valueOf(String gameCommand){
		return new GameCommand(gameCommand);
	}

	@Override
	public void validate(Object inputGameCommand) {
		isAssignedCommand((String) inputGameCommand);
	}

	private void isAssignedCommand(String movement){
		System.out.println(movement);
		if (!movement.equals(COMMAND_RETRY) && !movement.equals(COMMAND_QUIT)){
			throw new InputException(InputException.GAME_COMMAND_NOT_ASSIGNED_COMMAND);
		}
	}

	public String getGameCommand() {
		return gameCommand;
	}
}
