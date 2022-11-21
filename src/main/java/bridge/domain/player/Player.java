package bridge.domain.player;

import bridge.view.InputView;

public class Player {
    private PlayerCommand playerCommand;
    private final InputView inputView = new InputView();;
    public void getInputMoving(String command){
        playerCommand = new PlayerCommand(command);
    }
    public boolean playerCommandTypeCheck(){
        return playerCommand.getCommand().equals("D");
    }
}
