package bridge.domain;

import bridge.Enum.GameOutput;
import bridge.Enum.PlayerInput;
import bridge.controller.GameController;

import java.util.ArrayList;
import java.util.List;

public class BridgeGame {
    private static List<String> upBlocks;
    private static List<String> downBlocks;

    public void initBridgeGame() {
        upBlocks = new ArrayList<>();
        downBlocks = new ArrayList<>();
    }

    public void move(String input) {
        if(input.equals(PlayerInput.UP.getValue())) {
            upBlocks.add(GameOutput.PASS_POSSIBLE.getMessage());
            downBlocks.add(GameOutput.EMPTY.getMessage());
            return;
        }
        if(input.equals(PlayerInput.DOWN.getValue())){
            upBlocks.add(GameOutput.EMPTY.getMessage());
            downBlocks.add(GameOutput.PASS_POSSIBLE.getMessage());
        }
    }
    public void WrongMove(String input){
        if(input.equals(PlayerInput.UP.getValue())) {
            upBlocks.add(GameOutput.PASS_IMPOSSIBLE.getMessage());
            downBlocks.add(GameOutput.EMPTY.getMessage());
            return;
        }
        if(input.equals(PlayerInput.DOWN.getValue())){
            upBlocks.add(GameOutput.EMPTY.getMessage());
            downBlocks.add(GameOutput.PASS_IMPOSSIBLE.getMessage());
        }
    }

    public boolean retry(String gameRetry) {
        if (gameRetry.equals(PlayerInput.RESTART.getValue())) {
            GameController gameController = new GameController();
            gameController.play();
            return true;
        }
        return false;
    }

    public List<String> getUpBlocks() {
        return upBlocks;
    }
    public List<String> getDownBlocks() {
        return downBlocks;
    }
}
