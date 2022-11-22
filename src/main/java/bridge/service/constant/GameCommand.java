package bridge.service.constant;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;

public enum GameCommand {
    Retry("R", true),
    Quit("Q", false);
    private String gameCommand;
    private boolean doRetry;
    GameCommand(String gameCommand, boolean doRetry){
        this.gameCommand=gameCommand;
        this.doRetry=doRetry;
    }

}
