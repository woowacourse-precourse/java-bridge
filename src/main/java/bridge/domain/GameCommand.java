package bridge.domain;

import bridge.utils.validator.GameCommandValidator;

public class GameCommand {
    private final String gameCommand;
    private boolean isRetry;
    public GameCommand(String gameCommand){
        new GameCommandValidator(gameCommand);
        this.gameCommand = gameCommand;
        this.isRetry = isRetry();
    }

    private boolean isRetry(){
        if(this.gameCommand == "R"){
            return true;
        }
        return false;
    }
}
