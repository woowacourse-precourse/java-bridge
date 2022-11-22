package bridge;

import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();
        BridgeGame bridgeGame = startBridgeGame(outputView, inputView);

        while (bridgeGame.isGameOn()) {
            bridgeGame = playBridgeGame(bridgeGame,outputView,inputView);
            bridgeGame = makeGameDecision(bridgeGame,outputView,inputView);
        }
        finishGame(outputView,bridgeGame);
    }

    public static BridgeGame startBridgeGame(OutputView outputView, InputView inputView){
        outputView.printAskingForSize();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(inputView.readBridgeSize());
        return new BridgeGame(bridge);
    }

    public static BridgeGame playBridgeGame(BridgeGame bridgeGame, OutputView outputView, InputView inputView){
        outputView.printSelection();
        bridgeGame.move(inputView.readMoving());
        outputView.printMap(bridgeGame);
        return bridgeGame;
    }

    public static BridgeGame makeGameDecision(BridgeGame bridgeGame, OutputView outputView, InputView inputView){
        if (bridgeGame.evaluateMove()){
            outputView.printRetry();
            bridgeGame.retry(inputView.readGameCommand());
        }
        return bridgeGame;
    }

    public static void finishGame(OutputView outputView, BridgeGame bridgeGame){
        System.out.println("최종 게임 결과");
        outputView.printMap(bridgeGame);
        outputView.printResult(bridgeGame.getGameResult());
    }
}
