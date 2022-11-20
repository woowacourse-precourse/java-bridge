package bridge.Model;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.Enum.CrossResult;
import bridge.Enum.GameStatus;
import bridge.Model.VO.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    UserChoices userChoices;
    CrossResults crossResults;
    Bridge bridge;

    public BridgeGame(BridgeSize bridgeSize){
        userChoices = new UserChoices();
        crossResults = new CrossResults();
        bridge = new Bridge(makeBridge(bridgeSize));
    }
    private List<String> makeBridge(BridgeSize bridgeSize){
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        int size = bridgeSize.getSize();
        return bridgeMaker.makeBridge(size);
    }
    public void move(UserChoice userChoice) {
        CrossResult crossResult = bridge.cross(userChoice, crossResults.position());
        userChoices.add(userChoice);
        crossResults.appendResult(crossResult);
    }

    public GameStatus checkGameStatus(){
        GameStatus status = GameStatus.RUNNING;
        if(isEndPoint()){
            status = GameStatus.SUCCESS;
        }
        if(isFailed()){
            status = GameStatus.FAIL;
        }
        return status;
    }

    private boolean isEndPoint(){
        return bridge.length() - crossResults.position() == 0;
    }

    private boolean isFailed(){
        return crossResults.contain(CrossResult.FAIL);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        userChoices = new UserChoices();
        crossResults = new CrossResults();
    }

    public UserChoices getUserChoices(){
        return userChoices;
    }

    public CrossResults getCrossResults(){
        return crossResults;
    }
}
