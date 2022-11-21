package bridge.domain.player;

import bridge.view.InputView;

public class Player {
    private PlayerCommand playerCommand;
    private GameCommand gameCommand;
    private final InputView inputView = new InputView();;
    public void getInputMoving(String command){
        playerCommand = new PlayerCommand(command);
    }
    public void setGameCommand(){
        gameCommand = new GameCommand(inputView.readGameCommand());
    }
    public boolean playerCommandTypeCheck(int index){
        return playerCommand.getCommand().equals("D");
    }
}
