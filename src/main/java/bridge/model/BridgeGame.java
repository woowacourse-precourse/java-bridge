package bridge.model;

import bridge.MODEnum;

import java.util.ArrayList;
import java.util.List;

import static bridge.MODEnum.*;

public class BridgeGame {
    
    private List<String> bridge;
    private List<String> upPresentBridge;
    private List<String> downPresentBridge;
    private List<String> userMoveList;
    private String gameBoolean;
    private int gameCount=1;

    public BridgeGame(List<String> bridge) {
        this.bridge=bridge;
        upPresentBridge=new ArrayList<>();
        downPresentBridge=new ArrayList<>();
        userMoveList=new ArrayList<>();
        gameBoolean =SUCCESS_GAME_MESSAGE.getMessage();
    }

    public void move(String userMove) {
        userMoveList.add(userMove);
        if(userMove.equals(UP_GO.getMessage())) {
            userMoveU(userMove);
            return;
        }
        userMoveD(userMove);
    }

    private void userMoveU(String userMove){
        if (bridge.get(userMoveList.size() - 1).equals(userMove)) {
            upPresentBridge.add(CAN_GO.getMessage());
            downPresentBridge.add(CAN_NOT_GO.getMessage());
            return;
        }
        upPresentBridge.add(CAN_NOT_GO.getMessage());
        downPresentBridge.add(CAN_GO.getMessage());
        gameBoolean = FAIL_GAME_MESSAGE.getMessage();
    }

    private void userMoveD(String userMove){
        if (bridge.get(userMoveList.size() - 1).equals(userMove)) {
            upPresentBridge.add(CAN_NOT_GO.getMessage());
            downPresentBridge.add(CAN_GO.getMessage());
            return;
        }
        upPresentBridge.add(CAN_GO.getMessage());
        downPresentBridge.add(CAN_NOT_GO.getMessage());
        gameBoolean =FAIL_GAME_MESSAGE.getMessage();
    }

    public boolean gameContinue(){
        return gameBoolean.equals(SUCCESS_GAME_MESSAGE.getMessage())&&upPresentBridge.size()!=bridge.size();
    }

    public void retry() {
        upPresentBridge.clear();
        downPresentBridge.clear();
        gameBoolean = SUCCESS_GAME_MESSAGE.getMessage();
        userMoveList.clear();
    }

    public List<String> getUpPresentBridge() {
        return upPresentBridge;
    }

    public List<String> getDownPresentBridge() {
        return downPresentBridge;
    }

    public List<String> getBridge() {
        return bridge;
    }

    public List<String> getUserMoveList() {
        return userMoveList;
    }

    public String getGameBoolean() {
        return gameBoolean;
    }

    public int getGameCount() {
        return gameCount;
    }

    public void totalGamePlus(){
        gameCount++;
    }
}
