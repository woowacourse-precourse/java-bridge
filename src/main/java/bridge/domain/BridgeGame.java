package bridge.domain;

import bridge.Enum.GameOutput;
import bridge.Enum.PlayerInput;
import bridge.controller.GameController;

import java.util.ArrayList;
import java.util.List;

public class BridgeGame {
    private static List<String> upBlocks;
    private static List<String> downBlocks;

    public void initBridgeStatus() {
        upBlocks = new ArrayList<>();
        downBlocks = new ArrayList<>();
    }

    public void move(String input) {
        if(input.equals(String.valueOf(PlayerInput.UP))) {
            upBlocks.add(String.valueOf(GameOutput.PASS_POSSIBLE));
            downBlocks.add(String.valueOf(GameOutput.EMPTY));
            return;
        }
        if(input.equals(String.valueOf(PlayerInput.DOWN))){
            upBlocks.add(String.valueOf(GameOutput.EMPTY));
            downBlocks.add(String.valueOf(GameOutput.PASS_POSSIBLE));
        }
    }
    public void WrongMove(String input){
        if(input.equals(String.valueOf(PlayerInput.UP))) {
            upBlocks.add(String.valueOf(GameOutput.PASS_IMPOSSIBLE));
            downBlocks.add(String.valueOf(GameOutput.EMPTY));
            return;
        }
        if(input.equals(String.valueOf(PlayerInput.DOWN))){
            upBlocks.add(String.valueOf(GameOutput.EMPTY));
            downBlocks.add(String.valueOf(GameOutput.PASS_IMPOSSIBLE));
        }
    }

    private boolean validateMovement(String movement, String space){
        if(movement.equals(space)) return true;
        return false;
    }

    public boolean retry(String gameRetry) {
        if (gameRetry.equals(String.valueOf(PlayerInput.UP))) {
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
