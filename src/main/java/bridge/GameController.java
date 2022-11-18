package bridge;
/**
 * 게임의 진행을 관리하는 역할을 한다.
 */
public class GameController {
    public void begin(){
        OutputView outputView =new OutputView();
        InputView inputView = new InputView();
        outputView.gameStartMessage();
        outputView.bridgeSizeMessage();
        int size = inputView.readBridgeSize();
    }
}
