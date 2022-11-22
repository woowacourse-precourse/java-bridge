package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.BridgePlayer;
import bridge.utils.constants.BridgeGameCommand;
import bridge.views.InputView;
import bridge.views.OutputView;

public class BridgeGameController {

    private static final BridgeGameController instance = new BridgeGameController();
    private InputView inputView;
    private OutputView outputView;
    private BridgeGame bridgeGame;

    public static BridgeGameController getInstance() {
        return instance;
    }

    private void init(){
        initView();
        initBridgeGame();
    }

    public void run(){
        init();
        playGame();
        printGameResult();
    }

    private void initView(){
        inputView = InputView.getInstance();
        outputView = OutputView.getInstance();
    }

    private void initBridgeGame(){
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        Bridge bridge = new Bridge(bridgeMaker.makeBridge(inputView.readBridgeSize()));
        BridgePlayer bridgePlayer = new BridgePlayer();

        bridgeGame = new BridgeGame(bridge, bridgePlayer);
    }

    private void playGame(){
        for(int i = 0; i<bridgeGame.bridgeSize(); i++){
            boolean isSuccess = bridgeGame.move(inputView.readMoving());
            outputView.printMap(bridgeGame.getBridgeMap().getCurrentMap());
            if(!isSuccess){
                break;
            }
        }
        if(!bridgeGame.isCompletedGame()){
            askRetry();
        }
    }

    private void askRetry(){
        if(inputView.readGameCommand().equals(BridgeGameCommand.RETRY)){
            gameRetry();
        }
    }

    private void gameRetry(){
        bridgeGame.retry();
        playGame();
    }

    private void printGameResult(){
        outputView.printResult(bridgeGame.isCompletedGame(), bridgeGame.getPlayerAttemptCount());
    }
}
