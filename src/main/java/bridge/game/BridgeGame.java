package bridge.game;

import bridge.domain.BridgeMaker;
import bridge.domain.BridgeNumberGenerator;
import bridge.domain.BridgeRandomNumberGenerator;
import bridge.domain.Count;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

    OutputView outputView = new OutputView();
    InputView inputView = new InputView();
    Count count = new Count();
    int crossCount = count.crossCount;
    int bridgeSize = inputView.readBridgeSize();
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
        startGame();
        gameing();
        lastGame();
    }

    private void startGame(){
        if(crossCount == 0){
            String userMoving = inputView.readMoving();
            String bridgeNumber = bridgeMaker.makeBridge(bridgeSize).get(0);
            outputView.printFirstMap(compareUserValue(userMoving, bridgeNumber), userMoving);
            crossCount++;
            return;
        }
    }

    private void gameing(){
        String userMoving = inputView.readMoving();
        String bridgeNumber = bridgeMaker.makeBridge(bridgeSize).get(crossCount);
        outputView.printMap(compareUserValue(userMoving, bridgeNumber), userMoving);
        return;
    }

    private void lastGame(){
        if(crossCount == bridgeSize){
            String userMoving = inputView.readMoving();
            String bridgeNumber = bridgeMaker.makeBridge(bridgeSize).get(crossCount);
            outputView.printLastMap(compareUserValue(userMoving, bridgeNumber), userMoving);
            crossCount++;
            return;
        }
    }
    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {

    }

    private int addTryCount(int tryCount){
        return 0;
    }

    public int compareUserValue(String userValue, String bridgeValue){
        if(userValue.equals(bridgeValue)) return 1;
        return 0;
    }

    public HashMap<Integer, String> correctValue(int compareValue, String userValue){


        return null;
    }

    public HashMap<Integer, String> wrongValue(int compareValue, String userValue){
        return null;
    }
}
