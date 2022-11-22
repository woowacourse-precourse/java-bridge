package bridge;

import java.util.List;
import java.util.NoSuchElementException;

public class GameController {
    private final InputView inputView = new InputView();
    private final BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    private final BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
    private List<String> bridge;
    private final BridgeGame bridgeGame = new BridgeGame();
    private final OutputView outputView = new OutputView();
    private int count = 1;
    private boolean isSuccess = true;

    public void getSizeAndMakeBridge() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
        int bridgeSize = 0;
        try {
            bridgeSize = inputView.readBridgeSize();
            this.bridge = bridgeMaker.makeBridge(bridgeSize);
        }
        catch (NoSuchElementException e) {
            //System.out.println("[ERROR] 여기서 에러 발생");
            //System.out.println(e.getMessage());
            throw new IllegalArgumentException(e.getMessage());
        }

    }


    public boolean getMovingResult(int inputIdx) {
        String inputMoving = "";
        while (true) {
            try {
                inputMoving = inputView.readMoving();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return bridgeGame.move(bridge, inputMoving, inputIdx);
    }

    public String isRetryReceiver() {
        String isRetry = "";
        while (true) {
            try {
                isRetry = inputView.readGameCommand();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return isRetry;
    }

    public boolean isRetryProcessor() {
        if (isRetryReceiver().equals("R")) {
            bridgeGame.retry();
            count++;
            return true;
        }
        return false;
    }

    public void printLongMap() {
        outputView.printLongMap(bridgeGame.userInputList(), bridgeGame.getResult());
        System.out.println();
    }

    public void printShortMap() {
        outputView.printShortMap(bridgeGame.userInputList(), bridgeGame.getResult());
        System.out.println();
    }

    public void printMap() {
        if (bridgeGame.getUserInputListLength() == 1) {
            printShortMap();
            return;
        }
        printLongMap();
    }

    public List<String> getbridge() {
        return bridge;
    }

    public int getbridgeLength() {
        return bridge.size();
    }

    public void printResult(){
        outputView.printTotalResult(bridgeGame.userInputList(), bridgeGame.getResult());
        System.out.println();
        outputView.printResult(isSuccess,count);
    }
    public void setSuccess(boolean success){
        this.isSuccess=success;
    }
}
