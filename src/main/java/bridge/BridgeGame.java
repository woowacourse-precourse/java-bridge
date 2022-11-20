package bridge;


public class BridgeGame {

    public static void move() {
        MoveInsert.moveInsert();
    }

    public static void retry() {
        Application.upSide = new UpSide();
        Application.downSide = new DownSide();
        Application.movingTurn = 1;
        Application.totalTrial++;
    }
}
