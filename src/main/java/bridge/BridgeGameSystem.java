package bridge;

import java.util.List;

import static bridge.Bridge.*;

public class BridgeGameSystem {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static int tryCount = 1;
    private static int index = 0;

    public void startBridgeGame(){
        startGame();
        int bridgeSize = BridgeGame.getBridgeSize();
        List<String> bridge = BridgeGame.getBridge(bridgeSize);
        System.out.println(bridge);
        boolean success = playGame(bridge, bridgeSize);
        outputView.printResult(tryCount, success);
    }

    public static void startGame(){
        inputView.printStartMessage();
    }

    public static boolean playGame(List<String> bridge, int bridgeSize){
        boolean flag = true;
        while(flag){
            Bridge block = toCrossBridge(bridge, BridgeGame.getMoveDirect(), index);
            outputView.printMap(toCrossBridgeResult(bridge, block));
            flag = isAvailableGame(block);
            if(isSuccess(bridgeSize, index)){
                --index;
                outputView.printResultMap(toCrossBridgeResult(bridge, block));
                return true;
            }
        }
        return false;
    }

    public static StringBuilder toCrossBridgeResult(List<String> bridge, Bridge block){
        return outputView.makeSide(bridge, block, index);
    }

    public static Bridge toCrossBridge(List<String> bridge, String direct, int index){
        boolean movingResult = BridgeGame.move(bridge, direct, index);
        if(movingResult && direct.equals("U")){
            return SUCCESS_UPPER;
        }
        if(!movingResult && direct.equals("U")){
            return FAILURE_UPPER;
        }
        if(movingResult && direct.equals("D")){
            return SUCCESS_LOWER;
        }
        return FAILURE_LOWER;
    }

    public static boolean isAvailableGame(Bridge block){
        if(BridgeGame.retry(block)){
            boolean gameCommand = BridgeGame.getGameCommand();
            return isExit(gameCommand);
        }
        index++;
        return true;
    }

    public static boolean isExit(boolean gameCommand){
        if(gameCommand){
            index = 0;
            tryCount++;
            return true;
        }
        return false;
    }

    public static boolean isSuccess(int bridgeSize, int index){
        return bridgeSize == index;
    }


}