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
        boolean isEnd = false;
        while (!isEnd) {
            moveStep(bridgeGame);
            isEnd = bridgeGame.isEnd();
        }
        //if(정답 맞추면)
        //최종결과 출력
        //return;
        outputView.restartMessage();
        String command = inputView.readGameCommand();
        if(command.equals("R"))
            bridgeGame.retry();

        //if(command.equals("Q"))
            //최종결과 출력
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
