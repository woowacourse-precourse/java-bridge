package bridge.controller;

import bridge.service.BridgeGame;
import bridge.view.inputview.InputViewInterface;
import bridge.view.outputview.OutputView;
import bridge.vo.*;
import bridge.vo.enums.Command;
import bridge.vo.enums.Step;

import java.util.ArrayList;
import java.util.List;

public class BridgeController {
    private final OutputView outputView;
    private final InputViewInterface inputView;
    private final BridgeGame bridgeGame;

    public BridgeController(OutputView outputView, InputViewInterface inputView, BridgeGame bridgeGame) {
        this.outputView = outputView;
        this.inputView = inputView;
        this.bridgeGame = bridgeGame;
    }

    public GameResult doGame(Bridge bridge) {
        TryCount tryCount = new TryCount();
        tryCount.addCount();

        List<StepResult> stepResults = crossBridge(bridge, tryCount);
        return new GameResult(stepResults, tryCount);
    }

    private List<StepResult> crossBridge(Bridge bridge, TryCount tryCount) {
        List<StepResult> stepHistory = new ArrayList<>();
        for (Step step : bridge.getSteps()) {
            StepResult stepResult = moveForward(step, stepHistory);
            if (!stepResult.isCorrect()) {
                return handleFailure(bridge, tryCount, stepHistory);
            }
        }
        return stepHistory;
    }

    private List<StepResult> handleFailure(Bridge bridge, TryCount tryCount, List<StepResult> stepHistory) {
        outputView.printAskingGameCommandMessage();
        if (getCommand().isRetrying()) {
            return crossBridge(bridge, bridgeGame.retry(tryCount));
        }
        return stepHistory;
    }

    private Command getCommand() {
        return Command.getByValue(inputView.readGameCommand());
    }

    private StepResult moveForward(Step answerStep, List<StepResult> stepHistory) {
        StepResult stepResult = bridgeGame.move(getNextStep(), answerStep);
        stepHistory.add(stepResult);
        outputView.printMap(stepHistory);
        return stepResult;
    }

    private Step getNextStep() {
        outputView.printAskingNextStepMessage();
        return Step.getByValue(inputView.readMoving());
    }
}
