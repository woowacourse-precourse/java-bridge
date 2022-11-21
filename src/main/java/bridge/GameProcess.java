package bridge;

import java.util.List;

public class GameProcess {
    private static final InputView inputView = new InputView();
    private static final BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    private static final BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
    public static String length;
    public static int size;

    public static void gameStart(){
        size = getSize();
        bridgeMaker.makeBridge(size);
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
}
