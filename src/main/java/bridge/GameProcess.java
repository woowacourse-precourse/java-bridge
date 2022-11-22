package bridge;

import static bridge.messages.error.*;
import static bridge.messages.words.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameProcess {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static final BridgeGame bridgeGame = new BridgeGame();
    private static final BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    private static final BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

    public static int gameCnt = 0;
    public static String length;
    public static int size;
    public static List<String> bridge;
    public static List<String> makingBridge = new ArrayList<>(Arrays.asList("[ ]","[ ]"));

    public static void gameStart(){
        outputView.printStart();
        try {
            gameProceeding();
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    private static void gameProceeding() {
        size = getSize();
        bridge = bridgeMaker.makeBridge(size);
        while (true) {
            gameCnt++;
            if (!gameRunning(bridge, size)) break;
        }
        gameEnd(makingBridge, gameCnt);
    }

    public static int getSize() {
        try{
            length = inputView.readBridgeSize();
            size = Integer.parseInt(length);
        }
        catch(NumberFormatException e){
            throw new IllegalArgumentException(inputE);
        }
        if(size>max || size<min) throw new IllegalArgumentException(rangeE);
        return size;
    }

    private static boolean gameRunning(List<String> bridge, int size) {
        makingBridge = new ArrayList<>(Arrays.asList("[ ]","[ ]"));
        for (int i = 0; i < size; i++) {
            String status = getStatus(bridge,i);
            if(status.equals(wrong)) return bridgeGame.retry(inputView.readGameCommand());
        }
        return false;
    }

    private static String getStatus(List<String> bridge, int idx) {
        String moving = inputView.readMoving();
        checkMoving(moving);
        String status = BridgeGame.rightOrWrong(bridge,moving,idx);
        makingBridge = bridgeGame.move(makingBridge,status,moving);
        outputView.printMap(makingBridge);
        return status;
    }

    private static void checkMoving(String moving) {
        if(!moving.equals(up) && !moving.equals(down)){
            throw new IllegalArgumentException(inputE);
        }
    }


    public static void gameEnd(List<String> makingBridge, int gameCnt){
        outputView.printResult(makingBridge,gameCnt);
    }
}
