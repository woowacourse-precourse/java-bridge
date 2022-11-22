package bridge;

import java.util.List;

public class Application {

    static InputView inputView = new InputView();
    static OutputView outputView = new OutputView();
    static BridgeGame bridgeGame= new BridgeGame();

    public static void main(String[] args) {
        try {
            init();
            gameStart();
            printGameResult();
        }catch (IllegalArgumentException illegalArgumentException){
            System.out.println(illegalArgumentException.getMessage());
        }
    }

    private static void init() {
        outputView.printGameStart();
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
        printBridge();

        return isRightDirection;
    }

    private static void printBridge() {
        List<String> upBridge = bridgeGame.getBridgeLine("U");
        List<String> downBridge = bridgeGame.getBridgeLine("D");

        outputView.printMap(upBridge);
        outputView.printMap(downBridge);
    }

    private static boolean retry(){
        String select = inputView.readGameCommand();
        return bridgeGame.retry(select);
    }

    private static void printGameResult(){
        outputView.printEnding();
        printBridge();
        String result = bridgeGame.getGameResult();
        int tryNum = bridgeGame.getTryNum();
        outputView.printResult(result,tryNum);
    }



}

