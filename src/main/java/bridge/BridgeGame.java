package bridge;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final String ANSWER_BRIDGE = "[ O ]";
    private final String WRONG_BRIDGE = "[ X ]";
    private final String BLANK_BRIDGE = "[   ]";
    private String upperMap = new String();
    private String lowerMap = new String();
    private String move;
    private List<String> answers = new ArrayList<>();
    private int moveCount = 1;
    private int playCount = 1;
    private boolean keepPlaying = true;

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String move, List<String> answers) {
        this.move = move;
        this.answers = answers;
        moving();
    }


    private void moving() {
        upperAnswer(move, answers);
        upperWrong(move, answers);
        lowerAnswer(move, answers);
        lowerWrong(move, answers);
        moveCount++;
    }

    private void upperAnswer(String moving, List<String> answers) {
        if (Objects.equals(moving, "U") && Objects.equals(answers.get(moveCount - 1), "U")) {
            upperMap += ANSWER_BRIDGE;
            lowerMap += BLANK_BRIDGE;
            keepPlaying = true;
        }
    }

    private void upperWrong(String moving, List<String> answers) {
        if (Objects.equals(moving, "U") && Objects.equals(answers.get(moveCount - 1), "D")) {
            upperMap += WRONG_BRIDGE;
            lowerMap += BLANK_BRIDGE;
            keepPlaying = false;
        }
    }

    private void lowerAnswer(String moving, List<String> answers) {
        if (Objects.equals(moving, "D") && Objects.equals(answers.get(moveCount - 1), "D")) {
            lowerMap += ANSWER_BRIDGE;
            upperMap += BLANK_BRIDGE;
            keepPlaying = true;
        }
    }

    private void lowerWrong(String moving, List<String> answers) {
        if (Objects.equals(moving, "D") && Objects.equals(answers.get(moveCount - 1), "U")) {
            lowerMap += WRONG_BRIDGE;
            upperMap += BLANK_BRIDGE;
            keepPlaying = false;
        }
    }

    public boolean getKeepPlaying() {
        return keepPlaying;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public void setMoveCount() {
        moveCount = 1;
    }

    public String getUpperMap() {
        return upperMap;
    }

    public String getLowerMap() {
        return lowerMap;
    }

    public void setMap() {
        upperMap = "";
        lowerMap = "";
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(String inputRetry) {
        if (inputRetry.equals("R")) {
            keepPlaying = true;
            playCount++;
        }
        if (inputRetry.equals("Q")) {
            keepPlaying = false;
        }
    }

    public int getPlayCount() {
        return playCount;
    }
}
