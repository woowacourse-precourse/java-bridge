package bridge;
/**
 * 게임의 진행을 관리하는 역할을 한다.
 */
public class GameController {
    public static void begin(){
        OutputView.gameStartMessage();
        OutputView.bridgeSizeMessgage();
    }
}
