package bridge.Controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.Domain.Bridge;
import bridge.Domain.Result;
import bridge.View.InputView;
import bridge.View.OutputView;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final Bridge bridge;
    private final Result result;
    private final InputView inputView;
    private final OutputView outputView;

    public BridgeGame(){
        bridge = new Bridge(new BridgeMaker(new BridgeRandomNumberGenerator()));
        result = new Result();
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void run(){
        outputView.printBridgeGameStart();

        makeBridge();

        crossBridge();

        showResult();
    }

    public void makeBridge(){

    }

    public void crossBridge(){

    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {

    }

    public void selectRetry(){

    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {

    }

    public void showResult(){

    }
}
