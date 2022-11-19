package bridge;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private List<String> bridge = new ArrayList<>();
    BridgeGame bridgeGame;
    MapMaker mapMaker;
    private int count = 0;
    private boolean gameResult = true;

    public Controller(){
        try {
            OutputView.printStartMessage();
            createBridge();
            movingBridge();
            printResult();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }

    // TODO: 게임에 필요한 다리를 생성하고 초기화한다.
    private void bridgeGameSet(){
        bridgeGame = new BridgeGame(bridge);
    }

    // TODO: 다리를 생성한다.
    private void createBridge(){
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

        OutputView.printInputLengthOfBridge();
        bridge = bridgeMaker.makeBridge(InputView.readBridgeSize());
        OutputView.printEnter();
    }

    // TODO: 다리를 이동하며 게임을 진행한다.
    private void movingBridge(){
        do {
            count++;
            bridgeGameSet();
        } while (bridgeMoveRoutine());
    }

    // TODO: 다리 이동 루틴을 구현한다.
    private boolean bridgeMoveRoutine(){
        mapMaker = new MapMaker(bridge);
        while (true){
            OutputView.printInputDirectionToMove();
            boolean correctBridge = bridgeGame.move(InputView.readMoving());
            createMap(correctBridge);
            if(!correctBridge)
                return isRetry();

            if(bridgeGame.isEndBridge())
                return (gameResult = false);
        }
    }

    // TODO: 맵을 생성하고 출력하는 기능을 구현한다.
    private void createMap(boolean correctBridge){
        mapMaker.createMap(correctBridge);
        OutputView.printMap(mapMaker);
    }

    // TODO: 재시작을 입력받고 결과를 반환한다.
    private boolean isRetry(){
        OutputView.printInputGameRestartStatus();
        return bridgeGame.retry(InputView.readGameCommand());
    }

    // TODO: 결과를 출력한다.
    private void printResult(){
        OutputView.printResult(mapMaker, gameResult, count);
    }
}
