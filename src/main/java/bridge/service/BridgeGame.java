package bridge.service;

import bridge.view.inputview.InputViewInterface;
import bridge.view.outputview.OutputView;
import bridge.vo.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final OutputView outputView;
    private final InputViewInterface inputView;

    public BridgeGame(OutputView outputView, InputViewInterface inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public GameResult doGame(Bridge bridge) {
        TryCount tryCount = new TryCount();
        List<StepResult> stepResults = crossBridge(bridge, tryCount);
        return new GameResult(stepResults, tryCount);
    }

    private List<StepResult> crossBridge(Bridge bridge, TryCount tryCount) {
        tryCount.addCount();
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
        Command command = Command.getByValue(inputView.readGameCommand());
        if (command.equals(Command.R)) {
            return retry(bridge, tryCount);
        }
        return stepHistory;
    }

    private StepResult moveForward(Step answerStep, List<StepResult> stepHistory) {
        StepResult stepResult = move(getNextStep(), answerStep);
        stepHistory.add(stepResult);
        outputView.printMap(stepHistory);
        return stepResult;
    }

    private Step getNextStep() {
        outputView.printAskingNextStepMessage();
        return Step.getByValue(inputView.readMoving());
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public StepResult move(Step userStep, Step answerStep) {
        return new StepResult(userStep, userStep.equals(answerStep));
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public List<StepResult> retry(Bridge bridge, TryCount tryCount) {
        return crossBridge(bridge, tryCount);
    }
}
