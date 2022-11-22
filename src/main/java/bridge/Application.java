package bridge;

import java.util.ArrayList;
import java.util.List;

public class Application {

    static InputView inputView = new InputView();
    static OutputView outputView = new OutputView();
    static BridgeGame bridgeGame= new BridgeGame();

    public static void main(String[] args) {
        try {
            outputView.printGameStart();
            init();
            gameStart();
            printGameResult();
        }catch (IllegalArgumentException illegalArgumentException){
            System.out.println(illegalArgumentException.getMessage());
        }
    }

    private static void init() {
        String input = inputView.readBridgeSize();
        bridgeGame.init(input);
    }

    private static void gameStart() {
        while (true){
            boolean keep = move();
            if(!keep && !retry()){
                break;
            }
            if(bridgeGame.isGameCompleted()){
                break;
            }
        }
    }

    private static boolean move() {
        String direction = inputView.readMoving();
        boolean isRightDirection = bridgeGame.move(direction);
        printUpBridge();
        printDownBridge();

        return isRightDirection;
    }

    static private void printDownBridge() {
        List<String> downBridge = bridgeGame.getDownBridge();
        outputView.printMap(downBridge);
    }

    static private void printUpBridge() {
        List<String> upBridge = bridgeGame.getUpBridge();
        outputView.printMap(upBridge);
    }

    static private boolean retry(){
        String select = inputView.readGameCommand();
        return bridgeGame.retry(select);
    }

    static private void printGameResult(){
        outputView.printEnding();
        printUpBridge();
        printDownBridge();
        String result = bridgeGame.getGameResult();
        int tryNum = bridgeGame.getTryNum();
        outputView.printResult(result,tryNum);
    }



}

