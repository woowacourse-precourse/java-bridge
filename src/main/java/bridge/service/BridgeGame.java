package bridge.service;

import bridge.constant.Directions;
import bridge.domain.Bridge;
import bridge.domain.User;
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
    private static BridgeGame instance = new BridgeGame();

    public static BridgeGame getInstance() {
        return instance;
    }

    private BridgeGame() {}

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(Bridge bridge, User user, String userChoice) {
        user.playNextRound();
        boolean isUserChoiceCorrect = bridge.isCorrectPanel(user.getRound(), userChoice);
        modifyStatusAfterChoice(bridge, user, isUserChoiceCorrect);
    }

    private void modifyStatusAfterChoice(Bridge bridge, User user, boolean isUserChoiceCorrect) {
        if (isUserChoiceCorrect && bridge.isEnd(user.getRound())) {
            user.clearGame();
        }

        if (!isUserChoiceCorrect) {
            user.failRound();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(User user) {
        user.playSameRoundAgain();
    }

    public List<List<ChoiceResult>> obtainGameLog(Bridge bridge, User user) {
        int userRound = user.getRound();
        List<List<ChoiceResult>> gameLog = new ArrayList<>();
        Arrays.stream(Directions.values())
                .forEach(direction -> gameLog.add(obtainGameLogOfLine(bridge, userRound, direction.getSymbol())));
        if (user.getStatus() == GameStatus.FAIL) {
            putFailLogElement(gameLog, userRound);
        }
        return gameLog;
    }

    private List<ChoiceResult> obtainGameLogOfLine (Bridge bridge, int userRound, String line) {
        return bridge.getBridge().stream()
                .limit(userRound)
                .map(panel -> createLogElement(panel, line))
                .collect(Collectors.toList());
    }

    private ChoiceResult createLogElement (String panel, String line) {
        if (panel.equals(line)) {
            return ChoiceResult.CORRECT;
        }
        return ChoiceResult.NOT_CHOSEN;
    }

    private void putFailLogElement(List<List<ChoiceResult>> gameLog, int userRound) {
        for (List<ChoiceResult> lineLog : gameLog) {
            putFailureElementToLine(lineLog, userRound);
        }
    }

    private void putFailureElementToLine (List<ChoiceResult> lineLog, int userRound) {
        int lastPanelIndex = userRound - 1;
        ChoiceResult lastPanel = lineLog.get(lastPanelIndex);
        if (lastPanel == ChoiceResult.NOT_CHOSEN) {
            lineLog.set(lastPanelIndex, ChoiceResult.WRONG);
            return;
        }
        if (lastPanel == ChoiceResult.CORRECT) {
            lineLog.set(lastPanelIndex, ChoiceResult.NOT_CHOSEN);
        }
    }

    public boolean isGameCleared(User user) {
        return user.getStatus() == GameStatus.SUCCESS;
    }
}
