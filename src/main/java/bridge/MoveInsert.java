package bridge;

public class MoveInsert {

    public static void moveInsert() {
        if (BridgeGame.isRightWay()) {
            rightWayInsert();
            return;
        }
        wrongWayInsert();
    }

    public static void rightWayInsert() {
        if (Application.movingInput.equals("U")) {
            Application.upSide.upSideArr.add("O");
            Application.downSide.downSideArr.add(" ");
        }
        if (Application.movingInput.equals("D")) {
            Application.upSide.upSideArr.add(" ");
            Application.downSide.downSideArr.add("O");
        }
    }

    public static void wrongWayInsert() {
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
