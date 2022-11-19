package bridge.controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.model.BridgeDTO;
import bridge.presentation.InputView;
import bridge.presentation.OutputView;
import bridge.service.BridgeMaker;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();
    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        inputView.readGameCommand();
        // 입력에 대한 예외 검사 추가
    }// retry

    public void make() {
        BridgeDTO.setComputerResult(bridgeMaker.makeBridge(BridgeDTO.getSize()));
    }//make

    public void startSetUp() {
        outputView.startGuide();
        BridgeDTO.setSize(inputView.readBridgeSize());
        // 길이에 대한 에외 검사 추가
    }//lengthens

} // end class
