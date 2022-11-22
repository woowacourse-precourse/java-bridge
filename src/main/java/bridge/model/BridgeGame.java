package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class BridgeGame {
    private List<String> bridge;
    private List<String> upPresentBridge;
    private List<String> downPresentBridge;
    private List<String> userMoveList;
    private String gameSuccess;
    private int gameCount=1;

    public BridgeGame(List<String> bridge) {
        this.bridge=bridge;
        upPresentBridge=new ArrayList<>();
        downPresentBridge=new ArrayList<>();
        userMoveList=new ArrayList<>();
        gameSuccess="성공";
    }

    public void move(String userMove) {
        userMoveList.add(userMove);
        if(userMove.equals("U")) {
            userMoveU(userMove);
            return;
        }
        userMoveD(userMove);
    }

    private void userMoveU(String userMove){
        if (bridge.get(userMoveList.size() - 1).equals(userMove)) {
            upPresentBridge.add("O");
            downPresentBridge.add("X");
            return;
        }
        upPresentBridge.add("X");
        downPresentBridge.add("O");
        gameSuccess="실패";
    }

    private void userMoveD(String userMove){
        if (bridge.get(userMoveList.size() - 1).equals(userMove)) {
            upPresentBridge.add("X");
            downPresentBridge.add("O");
            return;
        }
        upPresentBridge.add("O");
        downPresentBridge.add("X");
        gameSuccess="실패";
    }

    public void retry() {
        upPresentBridge.clear();
        downPresentBridge.clear();
        gameSuccess="성공";
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

    public String getGameSuccess() {
        return gameSuccess;
    }

    public int getGameCount() {
        return gameCount;
    }

    public void totalGamePlus(){
        gameCount++;
    }
}
