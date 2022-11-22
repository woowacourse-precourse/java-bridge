package bridge.type;

public enum GameStatus implements ProcessCondition {

    START("S"),
    ONGOING("O"),
    RESTART("R"),
    QUIT("Q");

    private final String statusSymbol;

    GameStatus(String statusSymbol) {
        this.statusSymbol = statusSymbol;
    }

    public static GameStatus getGameStatusByGameCommand(String statusSymbol) {
        if (statusSymbol.equals(START.statusSymbol)) return START;
        if (statusSymbol.equals(ONGOING.statusSymbol)) return ONGOING;
        if (statusSymbol.equals(RESTART.statusSymbol)) return RESTART;
        if (statusSymbol.equals(QUIT.statusSymbol)) return QUIT;
        return null;
    }
}
