package bridge.domain;

import bridge.utils.Validation;

import java.util.ArrayList;
import java.util.List;

import static bridge.utils.Constants.*;

public class Player {
    private int attempts;
    private List<String> playerBlocks;
    private Validation validation;

    public Player(){
        attempts = 0;
        playerBlocks = new ArrayList<>();
        validation = new Validation();
    }

    public void MoveTo(String playerMove){
        validation.validatePlayerMove(playerMove);
        playerBlocks.add(playerMove);
    }

    public boolean isUpMove(int blockNumber){
        if(playerBlocks.get(blockNumber) == UP_BLOCK){
            return true;
        }
        return false;
    }

    public boolean isSuccess(Bridge bridge, int blockNumber){
        if(playerBlocks.get(blockNumber) == UP_BLOCK){
            if(bridge.isUpBlock(blockNumber) == true)
                return true;
        }
        if(playerBlocks.get(blockNumber) == DOWN_BLOCK){
            if(bridge.isUpBlock(blockNumber) == false)
                return true;
        }
        return false;
    }

    public void tryAgain(){
        attempts++;
        playerBlocks = new ArrayList<>();
    }

    public int getAttempts(){
        return attempts;
    }
}
