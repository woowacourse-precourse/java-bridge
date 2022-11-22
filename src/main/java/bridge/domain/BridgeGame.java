package bridge.domain;

import bridge.Application;
import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.data.constant.OutputConstants;
import bridge.data.way.DownSide;
import bridge.data.way.UpSide;

import java.util.List;

public class BridgeGame {
    public List<String> bridge;
    public String movingInput;
    public UpSide upSide;
    public DownSide downSide;
    public int movingTurn;
    public boolean success;

    public BridgeGame(int size) {
        this.upSide = new UpSide();
        this.downSide = new DownSide();
        this.movingTurn = 0;
        this.success = false;
        createBridge(size);
    }

    public void move() {
        if (isRightWay()) {
            rightWayMove();
            this.movingTurn++;
            return;
        }
        wrongWayMove();
        this.movingTurn++;
    }

    public void retry() {
        this.upSide = new UpSide();
        this.downSide = new DownSide();
        this.movingTurn = 0;
        Application.totalTrial++;
    }

    public void rightWayMove() {
        if (movingInput.equals(OutputConstants.UP)) {
            this.upSide.upSideArr.add(OutputConstants.CORRECT);
            this.downSide.downSideArr.add(OutputConstants.BLANK);
        }
        if (movingInput.equals(OutputConstants.DOWN)) {
            this.upSide.upSideArr.add(OutputConstants.BLANK);
            this.downSide.downSideArr.add(OutputConstants.CORRECT);
        }
    }

    public void wrongWayMove() {
        if (movingInput.equals(OutputConstants.UP)) {
            this.upSide.upSideArr.add(OutputConstants.WRONG);
            this.downSide.downSideArr.add(OutputConstants.BLANK);
        }
        if (movingInput.equals(OutputConstants.DOWN)) {
            this.upSide.upSideArr.add(OutputConstants.BLANK);
            this.downSide.downSideArr.add(OutputConstants.WRONG);
        }
    }

    public boolean isRightWay() {
        String rightWay = bridge.get(this.movingTurn);
        return rightWay.equals(movingInput);
    }

    public boolean isWrongWay() {
        return !isRightWay();
    }

    public void createBridge(int size) {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        this.bridge = bridgeMaker.makeBridge(size);
    }

}
