package bridge;

import java.util.List;

/**
 * 게임의 진행을 관리하는 역할을 한다.
 */
public class GameController {
    private OutputView outputView =new OutputView();
    private InputView inputView = new InputView();
    private BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    public void begin(){
        outputView.gameStartMessage();
        outputView.bridgeSizeMessage();

        int size = inputView.readBridgeSize();

        List<String> answer_bridge = bridgeMaker.makeBridge(size);

        BridgeGame bridgeGame = new BridgeGame(answer_bridge);
        moveStep(bridgeGame);
        moveStep(bridgeGame);
    }
    private void moveStep(BridgeGame bridgeGame){
        //move message 출력
        outputView.moveMessage();
        //input move
        String way = inputView.readMoving();
        //move
        bridgeGame.move(way);
        //printMap
        outputView.printMap(bridgeGame);

    }
}
