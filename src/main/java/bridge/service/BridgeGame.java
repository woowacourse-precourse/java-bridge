package bridge.service;

import java.util.List;

import bridge.domain.BridgeMaker;
import bridge.domain.BridgeNumberGenerator;
import bridge.domain.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;


/**
 * 다리 건너기 게임을 관리하는 클래스
 */

public class BridgeGame {
    InputView inputview = new InputView();
    BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    private List<String> bridgeAnswer ;
    public int bridgeNum ;

    public void getRandomBridge(int bridgeNum){
        bridgeAnswer = bridgeMaker.makeBridge(bridgeNum);
    }

    public int getBridgeNum() {
        int inputSize = inputview.readBridgeSize();
        return inputSize;
    }
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String move() {
        String inputMove = inputview.readMoving();
        return inputMove;
    };

    public void playGame(){
        bridgeNum = getBridgeNum();
        getRandomBridge(bridgeNum);
        OutputView outputview = new OutputView();
        for (int i=0; i<bridgeNum; i++){
            String inputMove = move();
            if (inputMove != bridgeAnswer.get(i)){
                retry();
                break;
            }
            outputview.printMap(inputMove, inputMove == bridgeAnswer.get(i));
        }
    }


    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        String retryStr = inputview.readGameCommand();
        if (retryStr == "R"){
            playGame();
        }
    }
}
