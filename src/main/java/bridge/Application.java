package bridge;

import java.util.List;

public class Application {
    public static int size;
    public static List<String> bridge;
    public static String movingInput;
    public static int movingTurn = 0;
    public static int totalTrial = 1;
    public static UpSide upSide = new UpSide();
    public static DownSide downSide = new DownSide();
    public static boolean success;

    public static void main(String[] args) {
        Initialization.init();
        while (StartGame.startGame()) {
            if (movingTurn == size) {
                success = true;
                break;
            }
        }
        OutputView.printResult();
    }
}
