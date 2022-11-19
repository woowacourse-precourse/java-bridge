package bridge.system.controller;

import bridge.domain.Bridge;
import bridge.domain.BridgeBlock;
import bridge.domain.Phase;
import bridge.system.service.BridgeGame;
import bridge.system.util.BridgeMaker;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

import static bridge.domain.BridgeBlock.*;

public class BridgeController {

    private final BridgeGame bridgeGame;
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeMaker bridgeMaker;

    public BridgeController(InputView inputView, OutputView outputView, BridgeGame bridgeGame, BridgeMaker bridgeMaker) {
        this.bridgeGame = bridgeGame;
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeMaker = bridgeMaker;
    }

    public void playBridgeGame() {
        //입력값 받기
        outputView.printGameStartMessage();
        Bridge bridge = new Bridge(convertType(makeBridgeByInputSize()));
        Phase phase = new Phase();

        //다리 선택
        outputView.printSelectBlock();
        BridgeBlock bridgeBlock = valueOf(inputView.readMoving());

        //선택한 다리 확인
        String move = bridgeGame.move(bridge, bridgeBlock, phase);

    }

    private List<String> makeBridgeByInputSize() {
        return bridgeMaker.makeBridge(inputView.readBridgeSize());
    }
}
