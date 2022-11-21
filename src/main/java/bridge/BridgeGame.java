package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final OutputView outputView = new OutputView();
    private List<String> bridgeList;

    private final List<String> upBridge;
    private final List<String> downBridge;

    private int moveCount;
    private int gameAttemptCount;
    private boolean progressStatus;

    public BridgeGame(List<String> bridgeList) {
        this.bridgeList = bridgeList;
        this.moveCount = 0;
        this.gameAttemptCount = 1;
        this.progressStatus = true;
        upBridge = new ArrayList<>();
        downBridge = new ArrayList<>();
    }
    public void gameInProgress(String moving) {
        progressStatus = true;
        createBridgeResult(moving);
        outputView.printMap(upBridge);
        outputView.printMap(downBridge);
        moveCount++;
    }

    public void createBridgeResult(String moving){
        if (moving.equals("U")) {
            createUpBridgeResult(moveCount);
        }
        if (moving.equals("D")) {
            createDownBridgeResult(moveCount);
        }
    }
    public void createUpBridgeResult(int moveCount) {
        downBridge.add(" ");
        if (bridgeList.get(moveCount).equals("U")) {
            upBridge.add("O");
        }
        if (bridgeList.get(moveCount).equals("D")) {
            upBridge.add("X");
            progressStatus = false;
        }
    }
    public void createDownBridgeResult(int moveCount) {
        upBridge.add(" ");
        if (bridgeList.get(moveCount).equals("D")) {
            downBridge.add("O");
        }
        if (bridgeList.get(moveCount).equals("U")) {
            downBridge.add("X");
            progressStatus = false;
        }
    }

}
