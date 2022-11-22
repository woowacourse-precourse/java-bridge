package bridge;

import java.util.List;

public class GameController {
    private static final String SUCCESS = "성공";
    private static final String FAIL = "실패";
    private BridgeMaker bridgeMaker;
    private InputView inputView;
    private OutputView outputView;
    private Bridge bridge;
    private BridgeGame bridgeGame;
    private String endGameCheck = FAIL;

    public static int GAME_COUNT = 1;

    public GameController() {
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    void gameProcess(){
        try {
            makeRandomBridgeProcess();
            processBridgeGame();
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    void makeRandomBridgeProcess(){
        String bridgeLength = inputView.readBridgeSize();
        List<String> randomBridge = bridgeMaker.makeRandomBridgeProcess(bridgeLength);
        bridge = new Bridge(randomBridge);
        bridgeGame = new BridgeGame(bridge);
    }

    void processBridgeGame(){
        playBridgeGame();
        checkSuccessBridgeGame();

        if(endGameCheck.equals(FAIL)){
            restartBridgeGame();
        }
        outputView.printResult(endGameCheck, bridge);
    }

    void playBridgeGame(){
        while (bridge.getPlayResult().equals(true)){
            String inputBridge = inputView.readMoving();
            bridgeGame.move(inputBridge);
            outputView.printMap(bridge);
        }
    }

    void restartBridgeGame(){
        String tryGame = inputView.readGameCommand();

        if (tryGame.equals(GameRestart.YES.getAns())){
            GAME_COUNT ++;
            bridgeGame.retry();
            processBridgeGame();
        }
    }

    void checkSuccessBridgeGame(){
        if (bridge.randomBridge.size() == bridge.resultUpBridge.size()){
            endGameCheck = SUCCESS;
        }
    }
}
