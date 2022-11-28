package bridge;

import bridge.domain.Bridge;
import bridge.domain.BridgeConst;
import bridge.domain.BridgeGame;
import bridge.view.Input;
import bridge.view.OutputView;
import bridge.view.ProxyInputView;

public class Application {
    private static Input inputView = new ProxyInputView(new InputValidation());
    private static OutputView outputView = new OutputView();

    public static void main(String[] args) {
        startGame();
        BridgeGame bridgeGame = new BridgeGame(makeBridge());
        do {
            playingGame(bridgeGame);
        }while (isRetry(bridgeGame));
        finalResult(bridgeGame);
    }
    static void finalResult(BridgeGame bridgeGame){
        outputView.printResult(bridgeGame.returnMap(),bridgeGame.getCount());
    }
    static boolean isRetry(BridgeGame bridgeGame){
        if(bridgeGame.isComplete())return false;
        String command = inputView.readGameCommand();
        if(command.equals(BridgeConst.QUIT)) return false;
        bridgeGame.retry();
        return true;
    }
    static void playingGame(BridgeGame bridgeGame){
        while(bridgeGame.isContinue()) {
            String moving = inputView.readMoving();
            bridgeGame.move(moving);
            bridgeGame.changeStatus();
            String map = bridgeGame.returnMap();
            outputView.printMap(map);
        }
    }
    static void startGame(){
        System.out.println("다리 건너기 게임을 시작합니다.");
    }
    static Bridge makeBridge(){
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        int size = inputView.readBridgeSize();
        Bridge bridge = new Bridge(bridgeMaker.makeBridge(size));
        return bridge;
    }
}
