package bridge.controller;

import bridge.service.BridgeService;
import bridge.view.inputview.InputViewInterface;
import bridge.view.outputview.OutputView;
import bridge.vo.Bridge;
import bridge.vo.GameResult;
import bridge.vo.StepResult;
import bridge.dto.TryCountDto;
import bridge.vo.enums.Command;
import bridge.vo.enums.Step;

import java.util.ArrayList;
import java.util.List;

public class BridgeController {
    private final OutputView outputView;
    private final InputViewInterface inputView;
    private final BridgeService bridgeService;

    public BridgeController(OutputView outputView, InputViewInterface inputView, BridgeService bridgeService) {
        this.outputView = outputView;
        this.inputView = inputView;
        this.bridgeService = bridgeService;
    }

    public Bridge makeBridge() {
        outputView.printAskingBridgeSizeMessage();
        int bridgeSize = inputView.readBridgeSize();

        return bridgeService.makeBridge(bridgeSize);
    }

    public GameResult doGame(Bridge bridge) {
        TryCountDto tryCount = new TryCountDto();
        tryCount.addCount();

        List<StepResult> stepResults = crossBridge(bridge, tryCount);
        return new GameResult(stepResults, tryCount);
    }

    private List<StepResult> crossBridge(Bridge bridge, TryCountDto tryCount) {
        List<StepResult> stepHistory = new ArrayList<>();
        for (Step step : bridge.getSteps()) {
            StepResult stepResult = moveForward(step, stepHistory);
            if (!stepResult.isCorrect()) {
                return handleFailure(bridge, tryCount, stepHistory);
            }
        }
        return stepHistory;
    }

    private List<StepResult> handleFailure(Bridge bridge, TryCountDto tryCount, List<StepResult> stepHistory) {
        outputView.printAskingGameCommandMessage();
        if (getCommand().isRetrying()) {
            bridgeService.retry(tryCount);
            return crossBridge(bridge, tryCount);
        }
        return stepHistory;
    }

    private Command getCommand() {
        return Command.getByValue(inputView.readGameCommand());
    }

    private StepResult moveForward(Step answerStep, List<StepResult> stepHistory) {
        StepResult stepResult = bridgeService.move(getNextStep(), answerStep);
        stepHistory.add(stepResult);
        outputView.printMap(stepHistory);
        return stepResult;
    }

    private Step getNextStep() {
        outputView.printAskingNextStepMessage();
        return Step.getByValue(inputView.readMoving());
    }
}
