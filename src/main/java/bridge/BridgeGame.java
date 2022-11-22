package bridge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    /**
     * 다리의 모양.
     * (U, D)로 이루어진 문자 배열.
     */
    private List<String> bridge;
    /**
     * 사용자가 입력한 답을 저장하는 배열.
     * (U, D)로 이루어진 문자 배열.
     */
    private List<String> answerPath;
    /**
     * 게임 시도 횟수
     */
    private int attempts;

    public BridgeGame() {
        this.attempts = 1;
    }

    /**
     * 게임을 시작할 때 사용하는 메서드
     * @param size 게임에 사용할 bridge 크기
     */
    public void start(int size) {
        this.bridge = new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(size);
        this.answerPath = new ArrayList<>();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * @param moving 움직일 방향 (U 또는 D)
     * @return "O", "X", " " 로 이루어진 upperLines, bottomLines
     */
    public Map<String,List<String>> move(String moving) {
        this.answerPath.add(moving);
        return generateResultMap();
    }

    /**
     * 현재까지 이동 경로에 대한 정보를 가진 맵을 생성하는 메서드
     * @return "O", "X", " " 로 이루어진 upperLines, bottomLines
     */
    public Map<String, List<String>> generateResultMap() {
        Map<String, List<String>> resultMap = new HashMap<>();
        List<String> upperLine = new ArrayList<>();
        List<String> bottomLine = new ArrayList<>();
        setUpperBottomLines(upperLine, bottomLine);
        resultMap.put("upperLine", upperLine);
        resultMap.put("bottomLine", bottomLine);
        return resultMap;
    }
    private void setUpperBottomLines(List<String> upperLine, List<String> bottomLine) {
        for (int index = 0; index < answerPath.size(); index++) {
            addIsCorrectToLines(index, upperLine, bottomLine);
        }
    }

    private void addIsCorrectToLines(int index, List<String> upperLine, List<String> bottomLine) {
        String isCorrect = getIsCorrect(index);
        upperLine.add(" ");
        bottomLine.add(" ");
        if ("U".equals(answerPath.get(index))) {
            upperLine.set(index, isCorrect);
            return;
        }
        bottomLine.set(index, isCorrect);
    }

    private String getIsCorrect(int index) {
        String isCorrect = "X";
        if (answerPath.get(index).equals(bridge.get(index))) {
            isCorrect = "O";
        }
        return isCorrect;
    }

    /**
     * 게임이 실패했는지 체크하는 메소드
     * @return 게임이 실패했으면 true, 게임이 실패하지 않았으면 false
     */
    public boolean checkFail() {
        int index = answerPath.size() - 1;
        if (!bridge.get(index).equals(answerPath.get(index))) {
            return true;
        }
        return false;
    }

    /**
     * 게임이 성공했는지 체크하는 메소드
     * @return 게임이 성공했으면 true, 성공하지 않았으면 false
     */
    public boolean checkSuccess(){
        if (bridge.size() == answerPath.size()) {
            return true;
        }
        return false;
    }


    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * @param command 게임을 재시작 할지 여부  (R 또는 Q)
     * @return 게임을 재시작하면 true, 재시작하지 않고 종료하면 false
     */
    public boolean retry(String command) {
        if ("Q".equals(command)) {
            return false;
        }
        this.answerPath = new ArrayList<>();
        this.attempts += 1;
        return true;
    }

    /**
     * 사용자의 시도 횟수를 받아오는 메서드
     * @return 사용자의 시도 횟수
     */
    public int getAttempts() {
        return attempts;
    }
}
