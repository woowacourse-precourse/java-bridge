package bridge.domain;

import static bridge.util.Constants.*;

/**
 * 다리 건너기 게임을 관리하는 클래스
 * 1. BridgeGame에 필드(인스턴스 변수)를 추가할 수 🌴있다.🌴
 * 2. BridgeGame의 패키지는 변경할 수 🌴있다.🌴
 * 3. BridgeGame의 메서드의 이름은 변경할 수 🌴없고🌴, 인자와 반환 타입은 필요에 따라 추가하거나 변경할 수 🌴있다.🌴
 * 4. 게임 진행을 위해 필요한 메서드를 추가 하거나 변경할 수 🌴있다.🌴
 * 5. BridgeGame 클래스에서 InputView, OutputView 클래스를 사용하지 않는다.
 */
public class BridgeGame {
    private static final int INITIAL_COUNT = 1;
    private static final String SUCCESS = "성공";
    private static final String FAILURE = "실패";
    private static final String CORRECT_MOVE = "O";
    private static final String WRONG_MOVE = "X";

    private final OneSideResults upsideResults;
    private final OneSideResults downsideResults;
    
    private int totalTrialCount;
    private String finalResult;

    public BridgeGame() {
        upsideResults = new UpsideResults();
        downsideResults = new DownsideResults();
        
        totalTrialCount = INITIAL_COUNT;
        finalResult = SUCCESS;
    }

    public String move(String playerMove, String answerMove) {
        if (playerMove.equals(answerMove)) {
            return CORRECT_MOVE;
        }
        return WRONG_MOVE;
    }

    public void retry() {
        resetBothSidesResults();
        totalTrialCount++;
    }

    public void quit() {
        finalResult = FAILURE;
    }

    public void updateBothSidesResults(String playerMove, String matchResult) {
        upsideResults.update(playerMove, matchResult);
        downsideResults.update(playerMove, matchResult);
    }

    public void resetBothSidesResults() {
        upsideResults.reset();
        downsideResults.reset();
    }
    
    public boolean hasWrongMove() {
        return checkIfUpsideResultsContainsWrongMove() ||
                checkIfDownsideResultsContainsWrongMove();
    }
    
    public boolean checkIfUpsideResultsContainsWrongMove() {
        return upsideResults.getResults().contains(WRONG_MOVE);
    }

    public boolean checkIfDownsideResultsContainsWrongMove() {
        return downsideResults.getResults().contains(WRONG_MOVE);
    }

    public OneSideResults getUpsideResults() {
        return upsideResults;
    }

    public OneSideResults getDownsideResults() {
        return downsideResults;
    }

    public String getFinalResult() {
        return finalResult;
    }

    public int getTotalTrialCount() {
        return totalTrialCount;
    }
}
