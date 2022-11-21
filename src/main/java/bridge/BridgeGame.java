package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    boolean isSuccess=true;
    BridgeNumberGenerator numberGenerator=new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker=new BridgeMaker(numberGenerator);
    UserMove user=new UserMove();
    public void start(){
        prepare();
        user.increaseMoveCount();
        move();
    }
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    public void prepare(){
        OutputView.printStartGame();
        OutputView.printRequireSize();
        user.setUserBridgeSize(InputView.readBridgeSize());
        bridgeMaker.startMakeBridge(user.getUserBridgeSize());
    }

    public void move() {
        user.initMove();
        while(user.getMoveCount()<user.getUserBridgeSize()){
            String userMove=InputView.readMoving();
            user.moveUser(userMove);
            OutputView.printMap(user.getUserLocation(), bridgeMaker.getBridge().getBridgeAnswer());
            if(!isBridge(bridgeMaker.getBridge().getBridgeAnswer().get(user.getMoveCount()))){
                isSuccess=false;
                break;
            }
            user.increaseMoveCount();
        }
        if(!isSuccess)
            askRetry();
    }

    public boolean isBridge(String bridgeShape){
        if(user.getUserLocation().equals(bridgeShape))
            return true;
        return false;
    }
    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        user.increaseTryCount();
        move();
    }

    public void askRetry(){
        String userRetry=InputView.readGameCommand();
        if(userRetry.equals(Constant.RETRY)){
            retry();
            return;
        }
        meetEnd();
    }

    public Success isBridgeEnd(){
        if(isSuccess)
            return Success.SUCCESS;
        return Success.FAIL;
    }

    public void meetEnd(){
        OutputView.printResult(isBridgeEnd(), user.getTryCount());
    }
}
