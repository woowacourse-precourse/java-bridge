package bridge;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        AcrossBridgeGame acrossBridgeGame = new AcrossBridgeGame();
        int ReturnValue = acrossBridgeGame.MakeBoard();
        if (ReturnValue != 1){
            acrossBridgeGame.GameStart();
        }
    }
}
