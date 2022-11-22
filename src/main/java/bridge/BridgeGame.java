package bridge;

import static Constant.MoveCondition.*;
/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {


    private Bridge bridge;
    private int stepCount;
    private PrintManager printManager;
    private int tryCount;
    private boolean gameResult;
    BridgeGame(){
        stepCount = 0;
        bridge = new Bridge();
        printManager = new PrintManager(bridge);
        tryCount = 1;
        gameResult=false;
    }

    public void startGame(){
        boolean repeat = true;
        do{
            gameResult = move();
            if(gameResult==FAIL.getCond()){
                repeat = retry();
            }
        }while(!bridge.isArrive() && repeat);
        printResult();
        //결과 출력
    }
    public void printResult(){
        printManager.putResult(gameResult,tryCount);
        printManager.printResult();
    }



    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move() {
        boolean result = bridge.nextStep();
        printManager.printMap();
        return result;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry() {
        if(bridge.resetStep()){
            tryCount++;
            return true;
        }
        return false;
    }
}
