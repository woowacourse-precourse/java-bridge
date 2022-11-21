package bridge;

import java.util.*;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private int playerLocationIndex = -1;
    private Boolean askRetryMarker = false;
    private List<String> upMap = new ArrayList<>();
    private List<String> downMap = new ArrayList<>();

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(List<String> bridge, String playerChoice) {
        String isRightAnswer;

        playerLocationIndex++;
        isRightAnswer = checkAnswer(bridge, playerChoice);
        updateMap(playerChoice, isRightAnswer);
    }

    private String checkAnswer(List<String> bridge, String playerChoice) {
        String answer = "X";

        if (bridge.get(playerLocationIndex).equals(playerChoice)) {
            askRetryMarker = false;
            answer = "O";
        } else if (!bridge.get(playerLocationIndex).equals(playerChoice)) {
            askRetryMarker = true;
        }
        return answer;
    }

    private void updateMap(String playerChoice, String isRightBridge) {
        if (playerChoice.equals(BridgeAnswer.UP.getName())) {
            upMap.add(playerLocationIndex, isRightBridge);
            downMap.add(playerLocationIndex, " ");
        } else if (playerChoice.equals(BridgeAnswer.DOWN.getName())) {
            upMap.add(playerLocationIndex, " ");
            downMap.add(playerLocationIndex, isRightBridge);
        }
    }
    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }

    public int getPlayerLocationIndex() {
        return playerLocationIndex;
    }

    public Boolean getAskRetryMarker() {
        return askRetryMarker;
    }

    public List<String> getUpMap() {
        return upMap;
    }

    public List<String> getDownMap() {
        return downMap;
    }
}
