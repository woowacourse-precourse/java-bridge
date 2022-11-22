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
    public int movingCount;
    public boolean finish;
    public boolean goingRight;

    public BridgeGame(int size) {
        this.upSide = new UpSide();
        this.downSide = new DownSide();
        this.movingCount = 0;
        this.finish = false;
        this.goingRight = false;
        createBridge(size);
    }

    public void move(int size) {
        if (isRightWay()) {
            rightWayMove();
            if (isSucceed(size)) {
                this.finish = true;
                return;
            }
            return;
        }
        wrongWayMove();
    }

    public void retry() {
        this.upSide = new UpSide();
        this.downSide = new DownSide();
        this.movingCount = 0;
        Application.totalTrial++;
    }

    public void rightWayMove() {
        movingCount++;
        this.goingRight = true;
        if (movingInput.equals(OutputConstants.UP)) {
            this.upSide.upSideArr.add(OutputConstants.CORRECT);
            this.downSide.downSideArr.add(OutputConstants.BLANK);
            return;
        }
        this.upSide.upSideArr.add(OutputConstants.BLANK);
        this.downSide.downSideArr.add(OutputConstants.CORRECT);
    }

    public void wrongWayMove() {
        movingCount = 0;
        this.goingRight = false;
        if (movingInput.equals(OutputConstants.UP)) {
            this.upSide.upSideArr.add(OutputConstants.WRONG);
            this.downSide.downSideArr.add(OutputConstants.BLANK);
            return;
        }
        this.upSide.upSideArr.add(OutputConstants.BLANK);
        this.downSide.downSideArr.add(OutputConstants.WRONG);
    }

    public boolean isRightWay() {
        return bridge.get(this.movingCount).equals(movingInput);
    }

    public boolean isWrongWay() {
        return !isRightWay();
    }

    public void createBridge(int size) {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        this.bridge = bridgeMaker.makeBridge(size);
    }

    public boolean isSucceed(int size) {
        if (this.movingCount == size) {
            return true;
        }
        return false;
    }
}
