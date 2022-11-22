package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    private final List<String> bridge;
    private final static InputView input = new InputView();
    private final static OutputView output = new OutputView();
    private static int tryCount =1;
    private ArrayList<String> oriPlayerMove;
    private int moveCount =0;
    private static boolean isLive = true;


    private MapArray mapArray;

    public BridgeGame(BridgeMaker bm) {
        this.bridge = bm.makeBridge(getInput().readBridgeSize());
        this.mapArray = new MapArray("","");

    }

    public static void setIsLive(boolean isLive) {
        BridgeGame.isLive = isLive;
    }

    public InputView getInput() {
        return input;
    }

    public OutputView getOutput() {
        return output;
    }

    public ArrayList<String> getOriPlayerMove() {
        return oriPlayerMove;
    }

    public List<String> getBridge() {
        return bridge;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public int getTryCount() {
        return tryCount;
    }
    public void playGame(){
        output.printGameStart();
        while (isLive){
            if(moveCount == bridge.size()){
                output.printResult(mapArray,true,this);
                return;
            }
            isLive=move(input.readMoving());
            if(isLive==false){
                checkRetry();
            }
        }
    }
    public boolean move(String input) {
        if(input.equals(bridge.get(moveCount))){
        mapArray.addMapO(input);
        output.printMap(mapArray);
        moveCount++;
        return true;
        }

        mapArray.addMapX(input);
        output.printMap(mapArray);
        output.printResult(mapArray,false,this);
        return false;


    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void checkRetry(){
        output.printRetry();
        String isRetry = input.readGameCommand();
        if(isRetry.equals("R")){
            retry();
            return;
        }
        if(isRetry.equals("Q")){
            return;
        }
    }
    public void retry() {
        tryCount++;
        isLive=true;
        mapArray.retry();
        moveCount = 0;
    }
}
