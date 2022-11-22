package bridge.service;

import bridge.constant.Directions;
import bridge.domain.Bridge;
import bridge.domain.BridgeLength;
import bridge.service.constant.ChoiceResult;
import bridge.service.constant.GameStatus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private int attemptCount;
    private int panelOrder;
    private GameStatus status;
    private Bridge bridge;

    public BridgeGame (int lengthInput) {
        attemptCount = 1;
        panelOrder = 0;
        status = GameStatus.PLAYING;
        this.bridge = new Bridge(lengthInput);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String userChoice) {
        increaseOrder();
        boolean isUserChoiceCorrect = bridge.isCorrectPanel(panelOrder, userChoice);
        modifyStatusAfterChoice(isUserChoiceCorrect);
        return  isUserChoiceCorrect;
    }

    private void modifyStatusAfterChoice(boolean isUserChoiceCorrect) {
        if (isUserChoiceCorrect && bridge.isEnd(panelOrder)) {
            status = GameStatus.SUCCESS;
        }

        if (!isUserChoiceCorrect) {
            status = GameStatus.FAIL;
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        status = GameStatus.PLAYING;
        increaseAttemptCount();
        decreaseOrder();
    }

    private void increaseAttemptCount() {
        attemptCount++;
    }

    private void increaseOrder() {
        panelOrder++;
    }

    private void decreaseOrder() {
        panelOrder--;
    }

    public List<List<ChoiceResult>> obtainGameLog() {
        List<List<ChoiceResult>> gameLog = new ArrayList<>();
        Arrays.stream(Directions.values())
                .forEach(direction -> gameLog.add(obtainGameLogOfLine(direction.getSymbol())));
        if (status == GameStatus.FAIL) {
            putFailLogElement(gameLog);
        }
        return gameLog;
    }

    private List<ChoiceResult> obtainGameLogOfLine (String line) {
        return bridge.getBridge().stream()
                .limit(panelOrder)
                .map(panel -> createLogElement(panel, line))
                .collect(Collectors.toList());
    }

    private ChoiceResult createLogElement (String panel, String line) {
        if (panel.equals(line)) {
            return ChoiceResult.CORRECT;
        }
        return ChoiceResult.NOT_CHOSEN;
    }

    private void putFailLogElement(List<List<ChoiceResult>> gameLog) {
        for (List<ChoiceResult> lineLog : gameLog) {
            putFailureElementToLine(lineLog);
        }
    }

    private void putFailureElementToLine (List<ChoiceResult> lineLog) {
        int lastPanelIndex = panelOrder - 1;
        ChoiceResult lastPanel = lineLog.get(lastPanelIndex);
        if (lastPanel == ChoiceResult.NOT_CHOSEN) {
            lineLog.set(lastPanelIndex, ChoiceResult.WRONG);
            return;
        }
        if (lastPanel == ChoiceResult.CORRECT) {
            lineLog.set(lastPanelIndex, ChoiceResult.NOT_CHOSEN);
        }
    }

    public boolean isGameCleared() {
        return status == GameStatus.SUCCESS;
    }

    public int getAttemptCount() {
        return attemptCount;
    }

    public int getPanelOrder() {
        return panelOrder;
    }

    public GameStatus getStatus() {
        return status;
    }
}
