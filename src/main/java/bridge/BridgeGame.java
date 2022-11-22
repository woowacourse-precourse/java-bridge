package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    List<String> bridge;
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    int bridgeSize;
    int count = 1;
    int current = 0;
    boolean gameEnd = false;

    public void gameStart(){
        outputView.printGameStart();
        try{
            makeBridge();
        }catch (IllegalArgumentException e){
            System.out.println(ErrorMessage.strError.getErrorMessage());
        }

    }

    private void makeBridge(){
        outputView.printGetBridgeSize();
        bridgeSize = inputView.readBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridge = bridgeMaker.makeBridge(bridgeSize);
    }
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move() {
        outputView.printMoveCommand();
        String command = inputView.readMoving();
        String now = bridge.get(current);
        if (command.equals("U") && now.equals("D")) {// 못감
            outputView.printMap(bridge, current, false);
            gameEnd = true;
        }
        if (command.equals("U") && now.equals("U")) { // 감
            // 갈 수 있음
            outputView.printMap(bridge, current, true);
            current++;
        }
        if (command.equals("D") && now.equals("D")) {     // 감
            outputView.printMap(bridge, current, true);
            current++;
        }
        if (command.equals("D") && now.equals("U")) { // 못감
            outputView.printMap(bridge, current, false);
            gameEnd = true;
        }
        return gameEnd;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        count++;
        current = 0;
        gameEnd = false;
    }

    public void gameResult(){
        if (gameEnd == false && current == bridgeSize){
            outputView.printResult(bridge, count, current, true);
        }
        if (gameEnd == true && count != bridgeSize) {
            outputView.printResult(bridge, count, current, false);
        }
    }
    public boolean checkEnd(){
        if (gameEnd == false && current == bridgeSize) {
            return true;
        }
        return false;
    }
    public boolean oneMore(){
        outputView.printGameRetry();
        String command = inputView.readGameCommand();
        if (command.equals("R")) {
           retry();
           return true;
        }
        gameResult();
        return false;
    }
}
