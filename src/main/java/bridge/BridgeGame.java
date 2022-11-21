package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    int inputBridgeSize, tryCount=0;
    boolean isSuccess=true;
    BridgeNumberGenerator numberGenerator=new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker=new BridgeMaker(numberGenerator);
    public void start(){
        OutputView.printStartGame();
        OutputView.printRequireSize();
        inputBridgeSize=InputView.readBridgeSize();
        bridgeMaker.startMakeBridge(inputBridgeSize);
        tryCount++;
        move();
    }
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    public void move() {
        int moveCount=0;
        List<String> userLocation=new ArrayList<>();
        while(moveCount<inputBridgeSize){
            String userMove=InputView.readMoving();
            userLocation.add(userMove);
            OutputView.printMap(userLocation, bridgeMaker.getBridge().getBridgeAnswer());
            if(!isBridge(userMove, bridgeMaker.getBridge().getBridgeAnswer().get(moveCount))){
                isSuccess=false;
                break;
            }
            moveCount++;
        }
        if(!isSuccess)
            askRetry();
    }

    public boolean isBridge(String userMove, String bridgeShape){
        if(userMove.equals(bridgeShape))
            return true;
        return false;
    }
    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        tryCount++;
        move();
    }

    public void askRetry(){
        String userRetry=InputView.readGameCommand();
        if(userRetry.equals("R"))
            retry();
        else
            OutputView.printResult(isBridgeEnd(), tryCount);
    }

    public Success isBridgeEnd(){
        if(isSuccess)
            return Success.SUCCESS;
        return Success.FAIL;
    }
}
