package bridge;

import View.InputView;
import View.OutputView;
import java.util.List;

public class BridgeGameController {
    static final BridgeMaker bridgemaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    static final InputView inputView = new InputView();
    static final OutputView outputView = new OutputView();

    private int gameCount = 0;
    private boolean isGameSuccess = true;
    private List<List<String>> result;
    private List<String> answerBridge;

    public BridgeGameController(List<String> answerBridge) {
        this.answerBridge = answerBridge;
    }

    static List<String> startSettingBridge(){
        while(true){
            outputView.printReadBridgeSize();
            try{
                int bridgeSize = inputView.readBridgeSize();
                return bridgemaker.makeBridge(bridgeSize);
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    List<List<String>> start() {
        BridgeGame bridgeGame = new BridgeGame(answerBridge);
        for(int movingIndex = 0; movingIndex < answerBridge.size(); movingIndex++) {
            result = move(bridgeGame, movingIndex);
            if(bridgeGame.isGameFailed(result)) {
                result = processFailed(bridgeGame);
                break;
            }
        }
        gameCount++;
        return result;
    }

    List<List<String>> processFailed(BridgeGame bridgeGame) {
        while(true) {
            outputView.printReadGameCommand();
            try {
                String gameCommand = inputView.readGameCommand();
                return processRetryOrQuit(bridgeGame,gameCommand);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    List<List<String>> processRetryOrQuit(BridgeGame bridgeGame, String gameCommand){
        if (bridgeGame.retry(gameCommand)) {
            return start();
        }
        isGameSuccess = false;
        return result;
    }

    void end(List<List<String>> result){
        outputView.printResult(result,isGameSuccess,gameCount);
    }

    List<List<String>> move (BridgeGame bridgeGame, int index){
        while(true){
            outputView.printReadMoving();
            try{
                List<List<String>> movedBridge = bridgeGame.move(inputView.readMoving(), index);
                outputView.printMap(movedBridge);
                return movedBridge;
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
