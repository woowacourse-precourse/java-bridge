package bridge.controller;

import bridge.domain.Bridge;
import bridge.domain.BridgeBlock;
import bridge.domain.MovingResult;
import bridge.domain.Phase;
import bridge.service.BridgeGame;
import bridge.util.BridgeMaker;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.ArrayList;
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
        while (true) {
            doGame(bridge, phase);
        }
    }

    //TODO : 메서드명 변경 필요
    private void doGame(Bridge bridge, Phase phase) {
        outputView.printSelectBlock();
        BridgeBlock inputBlock = valueOf(inputView.readMoving());

        MovingResult movingResult = bridgeGame.move(bridge, inputBlock, phase);
        List<MovingResult> movingResults = new ArrayList<>();
        movingResults.add(movingResult);
        outputView.printMap(movingResults);
    }

    private List<String> makeBridgeByInputSize() {
        return bridgeMaker.makeBridge(inputView.readBridgeSize());
    }
}
