package bridge.enums;

public enum GameStatus {
    START("R"),
    QUIT("Q");

    private String gameCommand;

    private GameStatus(String gameCommand){
        this.gameCommand = gameCommand;
    }

    public String getCommand(){
        return this.gameCommand;
    }
}
