package bridge.domain;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static final String CROSS_SUCCEEDED = "O";
    private static final String CROSS_FAILED = "X";
    private final User user;
    private final List<String> answerBridge;

    public BridgeGame(User user, List<String> answerBridge) {
        this.user = user;
        this.answerBridge = answerBridge;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String move(int currBridgeOrder, List<String> answerBridge, String userInput) {
        String currentAnswerSpace = answerBridge.get(currBridgeOrder - 1);
        if (currentAnswerSpace.equals(userInput)) {
            return CROSS_SUCCEEDED;
        }
        return CROSS_FAILED;
    }

    // 각 라운드 진행(move() 호출하여 칸 이동, 이동 결과 저장)
    public String processEachRound(int round, String selectedSpace) {
        String movingResult = move(round, answerBridge, selectedSpace);
        user.addCrossingResult(Space.getIndexByRepresented(selectedSpace), round, movingResult);

        return movingResult;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(User user) {
        user.resetCurrentBridge();
        user.increaseTrialCount();
    }
}
