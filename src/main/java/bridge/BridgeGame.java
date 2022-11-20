package bridge;


import bridge.objects.DownSide;
import bridge.objects.UpSide;

public class BridgeGame {

    public static void move() {
        if (StartGame.isRightWay()) {
            rightWayMove();
            return;
        }
        wrongWayMove();
    }

    public static void retry() {
        Application.upSide = new UpSide();
        Application.downSide = new DownSide();
        Application.movingTurn = 1;
        Application.totalTrial++;
    }

    public static void rightWayMove() {
        if (Application.movingInput.equals("U")) {
            Application.upSide.upSideArr.add("O");
            Application.downSide.downSideArr.add(" ");
        }
        if (Application.movingInput.equals("D")) {
            Application.upSide.upSideArr.add(" ");
            Application.downSide.downSideArr.add("O");
        }
    }

    public static void wrongWayMove() {
        if (Application.movingInput.equals("U")) {
            Application.upSide.upSideArr.add("X");
            Application.downSide.downSideArr.add(" ");
        }
        if (Application.movingInput.equals("D")) {
            Application.upSide.upSideArr.add(" ");
            Application.downSide.downSideArr.add("X");
        }
    }
}
