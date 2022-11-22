package bridge;

import java.util.List;
import java.util.Objects;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    int playedCount = 1;
    String GAME_STATE = "성공";
    StringBuilder FIRST_LINE_DATA = new StringBuilder();
    StringBuilder SECOND_LINE_DATA = new StringBuilder();

    InputView iv = new InputView();

    /**
     *
     * @param bridgeData 현재 전진할 다리의 정답 정보
     * @param inputMoving 이동할 칸 정보
     * @return 오답시에는 사용자가 입력한 정보 (R 혹은 Q) 가 반환, 정답시에는 null로 반환
     */
    public String getNowResult(String bridgeData, String inputMoving) {
        move(bridgeData, inputMoving);
        if (Objects.equals(GAME_STATE, "실패")) {
            return  iv.readGameCommand();
        }
        return null;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String bridgeData, String inputMoving) {
        // 정답 여부 판별
        if(!isCorrect(bridgeData, inputMoving)) {
            // 틀렸으면 처리
            playedCount++;
            GAME_STATE = "실패";
        }
        // 결과 출력 시키도록..
    }

    public boolean isCorrect(String bridgeData, String inputMoving) {
        return Objects.equals(bridgeData, inputMoving);
    }

    public void makeMapWhenFirstTime(String inputMoving) {
        if (Objects.equals(inputMoving, "U")) {
            FIRST_LINE_DATA.append("O");
            SECOND_LINE_DATA.append(" ");
        }
        if (Objects.equals(inputMoving, "D")) {
            FIRST_LINE_DATA.append(" ");
            SECOND_LINE_DATA.append("O");
        }
    }

    public void makeMapWhenNormalState(String inputMoving) {
        if (Objects.equals(inputMoving, "U")) {
            FIRST_LINE_DATA.append(" | " + "O");
            SECOND_LINE_DATA.append(" | " + " ");
        }
        if (Objects.equals(inputMoving, "D")) {
            FIRST_LINE_DATA.append(" | " + " ");
            SECOND_LINE_DATA.append(" | " + "O");
        }
    }

    public List<StringBuilder> getMap(String inputMoving) {
        if (FIRST_LINE_DATA.length() > 0) {
            makeMapWhenNormalState(inputMoving);
            return List.of(FIRST_LINE_DATA, SECOND_LINE_DATA);
        }
        makeMapWhenFirstTime(inputMoving);
        return List.of(FIRST_LINE_DATA, SECOND_LINE_DATA);
    }

    public void makeResultWhenFirstTime(String inputMoving) {
        if (Objects.equals(inputMoving, "U")) {
            FIRST_LINE_DATA.append("X");
            SECOND_LINE_DATA.append(" ");
        }
        if (Objects.equals(inputMoving, "D")) {
            FIRST_LINE_DATA.append(" ");
            SECOND_LINE_DATA.append("X");
        }
    }

    public void makeResultWhenNormalState(String inputMoving) {
        if (Objects.equals(inputMoving, "U")) {
            FIRST_LINE_DATA.append(" | " + "X");
            SECOND_LINE_DATA.append(" | " + " ");
        }
        if (Objects.equals(inputMoving, "D")) {
            FIRST_LINE_DATA.append(" | " + " ");
            SECOND_LINE_DATA.append(" | " + "X");
        }
    }

    public List<StringBuilder> getMapWhenFailed(String inputMoving) {
        if (FIRST_LINE_DATA.length() > 0) {
            makeResultWhenNormalState(inputMoving);
            return List.of(FIRST_LINE_DATA, SECOND_LINE_DATA);
        }
        makeResultWhenFirstTime(inputMoving);
        return List.of(FIRST_LINE_DATA, SECOND_LINE_DATA);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        GAME_STATE = "성공";
        FIRST_LINE_DATA = new StringBuilder();
        SECOND_LINE_DATA = new StringBuilder();
    }
}
