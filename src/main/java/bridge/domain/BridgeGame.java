package bridge.domain;

import bridge.Application;
import bridge.data.constant.OutputConstants;
import bridge.data.way.DownSide;
import bridge.data.way.UpSide;

public class BridgeGame {
    public UpSide upSide;
    public DownSide downSide;
    public int movingTurn;

    public BridgeGame() {
        this.upSide = new UpSide();
        this.downSide = new DownSide();
        this.movingTurn = 0;
    }

    public void move() {
        if (isRightWay()) {
            rightWayMove();
            return;
        }
        wrongWayMove();
    }

    public void retry() {
        this.upSide = new UpSide();
        this.downSide = new DownSide();
        this.movingTurn = 0;
        Application.totalTrial++;
    }

    public void rightWayMove() {
        if (StartGame.movingInput.equals(OutputConstants.UP)) {
            this.upSide.upSideArr.add(OutputConstants.CORRECT);
            this.downSide.downSideArr.add(OutputConstants.BLANK);
        }
        if (StartGame.movingInput.equals(OutputConstants.DOWN)) {
            this.upSide.upSideArr.add(OutputConstants.BLANK);
            this.downSide.downSideArr.add(OutputConstants.CORRECT);
        }
    }

    public void wrongWayMove() {
        if (StartGame.movingInput.equals(OutputConstants.UP)) {
            this.upSide.upSideArr.add(OutputConstants.WRONG);
            this.downSide.downSideArr.add(OutputConstants.BLANK);
        }
        if (StartGame.movingInput.equals(OutputConstants.DOWN)) {
            this.upSide.upSideArr.add(OutputConstants.BLANK);
            this.downSide.downSideArr.add(OutputConstants.WRONG);
        }
    }

    public boolean isRightWay() {
        String rightWay = Application.bridge.get(this.movingTurn);
        return rightWay.equals(StartGame.movingInput);
    }

    public boolean isWrongWay() {
        return !isRightWay();
    }
}
