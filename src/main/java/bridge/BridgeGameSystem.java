package bridge;

import java.util.List;

public class BridgeGameSystem {
    private static final InputView inputView = new InputView();

    public void startBridgeGame(){
        startGame();
        int bridgeSize = getBridgeSize();
        List<String> bridge = getBridge(bridgeSize);
//        String move = getMoveDirect();
    }

    public static void startGame(){
        inputView.printStartMessage();
    }
    public static int getBridgeSize(){
        try{
            return inputView.readBridgeSize();
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return getBridgeSize();
        }
    }

    public static String getMoveDirect(){
        try{
            return inputView.readMoving();
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return getMoveDirect();
        }
    }

    public static List<String> getBridge(int bridgeSize){
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        return bridgeMaker.makeBridge(bridgeSize);
    }

}
