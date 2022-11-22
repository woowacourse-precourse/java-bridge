package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private static final String UP = "U";
    private static final String DOWN = "D";
    private static final String BLANK = " ";
    private static final String SUCCESS = "O";
    private static final String FAULT = "X";
    private static final String QUIT = "Q";
    private static final String RESTART = "R";

    public List<String> bridge;
    public List<List<String>> result;
    public int moveCount;
    public int retryCount;
    public boolean finish;
    public boolean goAlright;
    public boolean reTry;

    public BridgeGame(int size){
        this.moveCount = 0;
        this.retryCount = 1;
        this.finish = false;
        this.goAlright = false;
        this.reTry = true;
        buildBridge(size);
    }
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(int size) {
        for(int i=0; i<size; i++){
            if(isGoAlright() == false){
                OutputView.printMap(result);
                goAlright = false;
                break;
            }
            OutputView.printMap(result);
            goAlright = true;
        }
        finish = true;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        setRetry();
        if(reTry == false)
            return;
        this.moveCount =0;
        this.result = new ArrayList<>();
        this.retryCount++;
    }

    public void buildBridge(int size) {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        this.bridge = bridgeMaker.makeBridge(size);
    }

    private boolean isGoAlright(){
        String inputMove = InputView.readMoving();
        if(bridge.get(moveCount).equals(inputMove)){
            MoveSuccess(inputMove);
            return true;
        }
        MoveFault(inputMove);
        return false;
    }

    private void MoveSuccess(String inputMove){
        if(inputMove.equals(UP)) {
            this.result.get(0).add(SUCCESS);
            this.result.get(1).add(BLANK);
            return;
        }
        this.result.get(0).add(BLANK);
        this.result.get(1).add(SUCCESS);
    }


    private void MoveFault(String inputMove){
        if(inputMove.equals(UP)) {
            this.result.get(0).add(FAULT);
            this.result.get(1).add(BLANK);
            return;
        }
        this.result.get(0).add(BLANK);
        this.result.get(1).add(FAULT);
    }

    private void setRetry(){
        String inputTry = InputView.readGameCommand();
        if(inputTry.equals(RESTART)){
            reTry = true;
            return;
        }
        reTry = false;
    }
}
