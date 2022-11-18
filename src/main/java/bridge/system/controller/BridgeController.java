package bridge.system.controller;

import bridge.service.BridgeGame;
import bridge.system.util.BridgeMaker;
import bridge.view.InputView;
import bridge.view.OutputView;
import bridge.vo.Bridge;
import bridge.vo.BridgeStep;
import bridge.vo.StepResult;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BridgeController {
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeMaker bridgeMaker;
    private final BridgeGame bridgeGame;

    public BridgeController(InputView inputView, OutputView outputView, BridgeMaker bridgeMaker, BridgeGame bridgeGame) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeMaker = bridgeMaker;
        this.bridgeGame = bridgeGame;
    }

    public void doGame() {
        outputView.printGameStartMessage();

        outputView.printAskingBridgeSizeMessage();
        int bridgeSize = inputView.readBridgeSize();

        List<BridgeStep> bridgeSteps = BridgeStep.from(bridgeMaker.makeBridge(bridgeSize));
        Bridge bridge = new Bridge(bridgeSteps);
        Iterator<BridgeStep> bridgeIter = bridge.toIterator();

        ArrayList<StepResult> stepResults = new ArrayList<>();

        while (bridgeIter.hasNext()) {
            outputView.printAskingNextStepMessage();
            BridgeStep nextMove = BridgeStep.getByValue(inputView.readMoving());

            StepResult stepResult = bridgeGame.move(nextMove, bridgeIter.next());
            stepResults.add(stepResult);
            outputView.printMap(stepResults);

            if (!stepResult.isCorrect()) {
                break;
            }
        }
    }
}
