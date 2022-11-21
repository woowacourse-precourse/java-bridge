package bridge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameProcess {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static final BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    private static final BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

    public static int gameCnt = 0;
    public static String length;
    public static int size;
    public static List<String> bridge;
    public static List<String> makingBridge = new ArrayList<>(Arrays.asList("[]","[]"));

    public static void gameStart(){
        outputView.printStart();
        size = getSize();
        bridge = bridgeMaker.makeBridge(size);
        gameRunning(bridge, size);
    }

    public static int getSize() {
        try{
            length = inputView.readBridgeSize();
            size = Integer.parseInt(length);
        }
        catch(NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 다리 길이 입력값이 잘못됨.");
        }
        if(size>20 || size<3){
            throw new IllegalArgumentException("[ERROR] 다리 길이 입력범위가 잘못됨.");
        }
        return size;
    }

    public static void gameRunning(List<String> bridge, int size){
        makingBridge = new ArrayList<>(Arrays.asList("[]","[]"));

    }

    public static void gameEnd(){
    }
}
