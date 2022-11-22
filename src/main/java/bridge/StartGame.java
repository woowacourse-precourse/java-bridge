package bridge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StartGame {
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
        gameCnt = 0;
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
            throw new IllegalArgumentException("[ERROR] 해당 입력은 숫자만 허용됩니다.");
        }
        if(size>20 || size<3) throw new IllegalArgumentException("[ERROR] 다리의 길이는 3~20 사이입니다.");
        return size;
    }
    private static boolean gameRunning(List<String> bridge, int size) {
        makingBridge = new ArrayList<>(Arrays.asList("[ ]","[ ]"));
        for (int i = 0; i < size; i++) {
            String status = getStatus(bridge,i);
            if(status.equals("X")) return bridgeGame.retry(inputView.readGameCommand());
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
        if(!moving.equals("U") && !moving.equals("D")){
            throw new IllegalArgumentException("[ERROR] 허용된 입력은 U or D 입니다.");
        }
    }
    public static void gameEnd(List<String> makingBridge, int gameCnt){
        outputView.printResult(makingBridge,gameCnt);
    }
}
