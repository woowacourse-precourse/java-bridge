package bridge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private List<String> bridge;
    private List<String> answerPath;
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
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public Map<String,List<String>> move(String moving) {
        this.answerPath.add(moving);
        return generateResultMap();
    }

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

    public boolean checkFail() {
        int index = answerPath.size() - 1;
        if (!bridge.get(index).equals(answerPath.get(index))) {
            return true;
        }
        return false;
    }

    public boolean checkSuccess(){
        if (bridge.size() == answerPath.size()) {
            return true;
        }
        return false;
    }


    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String command) {
        if ("Q".equals(command)) {
            return false;
        }
        this.answerPath = new ArrayList<>();
        this.attempts += 1;
        return true;
    }

    public int getAttempts() {
        return attempts;
    }
}
