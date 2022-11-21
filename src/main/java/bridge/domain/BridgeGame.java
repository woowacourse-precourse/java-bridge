package bridge.domain;

import bridge.Application;
import bridge.data.constant.OutputConstants;
import bridge.data.way.DownSide;
import bridge.data.way.UpSide;

public class BridgeGame {
    public UpSide upSide = new UpSide();
    public DownSide downSide = new DownSide();

    public void move() {
        if (StartGame.isRightWay()) {
            rightWayMove();
            return;
        }
        wrongWayMove();
    }

    public void retry() {
        this.upSide = new UpSide();
        this.downSide = new DownSide();
        Application.movingTurn = 0;
        StartGame.totalTrial++;
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
}
