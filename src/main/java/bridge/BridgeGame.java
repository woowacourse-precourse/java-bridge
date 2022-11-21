package bridge;


import bridge.ways.DownSide;
import bridge.ways.UpSide;

public class BridgeGame {
    public static UpSide upSide = new UpSide();
    public static DownSide downSide = new DownSide();
    public static int totalTrial = 1;

    public static void move() {
        if (StartGame.isRightWay()) {
            rightWayMove();
            return;
        }
        wrongWayMove();
    }

    public static void retry() {
        upSide = new UpSide();
        downSide = new DownSide();
        Application.movingTurn = 1;
        totalTrial++;
    }

    public static void rightWayMove() {
        if (StartGame.movingInput.equals(OutputConstants.UP)) {
            upSide.upSideArr.add(OutputConstants.CORRECT);
            downSide.downSideArr.add(OutputConstants.BLANK);
        }
        if (StartGame.movingInput.equals(OutputConstants.DOWN)) {
            upSide.upSideArr.add(OutputConstants.BLANK);
            downSide.downSideArr.add(OutputConstants.CORRECT);
        }
    }

    public static void wrongWayMove() {
        if (StartGame.movingInput.equals(OutputConstants.UP)) {
            upSide.upSideArr.add(OutputConstants.WRONG);
            downSide.downSideArr.add(OutputConstants.BLANK);
        }
        if (StartGame.movingInput.equals(OutputConstants.DOWN)) {
            upSide.upSideArr.add(OutputConstants.BLANK);
            downSide.downSideArr.add(OutputConstants.WRONG);
        }
    }
}
