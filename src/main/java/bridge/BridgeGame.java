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
        if (StartGame.movingInput.equals("U")) {
            upSide.upSideArr.add("O");
            downSide.downSideArr.add(" ");
        }
        if (StartGame.movingInput.equals("D")) {
            upSide.upSideArr.add(" ");
            downSide.downSideArr.add("O");
        }
    }

    public static void wrongWayMove() {
        if (StartGame.movingInput.equals("U")) {
            upSide.upSideArr.add("X");
            downSide.downSideArr.add(" ");
        }
        if (StartGame.movingInput.equals("D")) {
            upSide.upSideArr.add(" ");
            downSide.downSideArr.add("X");
        }
    }
}
