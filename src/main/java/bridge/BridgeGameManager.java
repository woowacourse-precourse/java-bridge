package bridge;

import bridge.constant.command.GameCommand;
import bridge.model.BridgeRoadMap;
import bridge.model.UserRoadMap;
import java.util.ArrayList;

public class BridgeGameManager {
    private static BridgeGameManager manager;

    private int trialCount;
    private BridgeRoadMap bridgeRoadMap;

    private final BridgeRandomNumberGenerator bridgeRandomNumberGenerator;
    private final BridgeMaker bridgeMaker;
    private final UserRoadMap userRoadMap;
    private final BridgeGame game;
    private final InputView inputView;
    private final OutputView outputView;

    private BridgeGameManager(){
        trialCount = 0;

        bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        userRoadMap = new UserRoadMap(new ArrayList<>());
        game = new BridgeGame(userRoadMap);

        inputView = new InputView();
        outputView = new OutputView();
    }

    public static BridgeGameManager gameManager(){
        if(manager == null){
            manager = new BridgeGameManager();
        }
        return manager;
    }

    public void play(){
        try {
            initialize();
            do {
                run();
            } while (isRetry());
            finish();
        }catch (Exception e){
            outputView.printErrorMessage(e.getMessage());
        }
    }

    private void initialize(){
        outputView.printGameStart();

        outputView.printInputBridgeLength();
        int bridgeSize = inputView.readBridgeSize();

        bridgeRoadMap = new BridgeRoadMap(bridgeMaker.makeBridge(bridgeSize));
    }

    private void run(){
        do{
            outputView.printInputMove();
            String direction = inputView.readMoving();
            game.move(direction);
            trialCount++;

            outputView.printMap(bridgeRoadMap, userRoadMap);
        }while(!userRoadMap.isFail(bridgeRoadMap));
    }

    private boolean isRetry(){
        outputView.printInputRetry();
        String command = inputView.readGameCommand();

        if(command.equals(GameCommand.RETRY.getValue())){
            game.retry();
            return true;
        }
        return false;
    }

    private void finish(){
        outputView.printResult(trialCount, bridgeRoadMap, userRoadMap);
    }
}
