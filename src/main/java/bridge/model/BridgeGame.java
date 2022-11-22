package bridge.model;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.constant.CmdStatus;
import bridge.constant.GameSuccessOrNotStatus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final List<String> bridge;
    private final List<Stack<String>> userBridge;
    private int userBridgeSize;
    private boolean gameOver;
    private String gameSuccess;
    private int tryCount;

    public BridgeGame(int bridgeSize) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        this.userBridge = new ArrayList<>(Arrays.asList(new Stack<>(), new Stack<>()));
        this.userBridgeSize = 0;
        this.gameOver = false;
        this.bridge = bridgeMaker.makeBridge(bridgeSize);
        this.gameSuccess = GameSuccessOrNotStatus.Not.getGameSuccess();
        this.tryCount = 1;
    }

    public void move(String cmd) {
        if (bridge.get(userBridgeSize).equals(cmd)){
            this.userBridgeSize += 1;
            userBridgeMove(cmd);
            return;
        }
        moveFailed(cmd);
        this.gameOver = true;
    }

    public void userBridgeMove(String cmd){
       if (CmdStatus.MoveUp.getAlpha().equals(cmd)){
           this.userBridge.get(0).add("O");
           this.userBridge.get(1).add(" ");
           return;
       }
        this.userBridge.get(0).add(" ");
        this.userBridge.get(1).add("O");
    }

    public void moveFailed(String cmd){
        if (CmdStatus.MoveUp.getAlpha().equals(cmd)){
            this.userBridge.get(0).add("X");
            this.userBridge.get(1).add(" ");
            return;
        }
        this.userBridge.get(0).add(" ");
        this.userBridge.get(1).add("X");
    }

    public void retry(String cmd) {
        if (CmdStatus.Start.getAlpha().equals(cmd)){
            this.tryCount += 1;
            this.gameOver = false;
            this.userBridge.get(0).pop();
            this.userBridge.get(1).pop();
        }
    }

    public boolean isGameOver(){
        return this.gameOver;
    }

    public List<Stack<String>> getUserBridge() {
        return userBridge;
    }

    public boolean gameSuccessCheck(){
        if (userBridgeSize == bridge.size()){
            this.gameSuccess = GameSuccessOrNotStatus.Success.getGameSuccess();
            return true;
        }
        return false;
    }

    public String getGameSuccess() {
        return gameSuccess;
    }

    public int getTryCount() {
        return tryCount;
    }
}
