package bridge;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final List<String> answerBridge; // 만들어진 다리
    private List<String> playerCommands; // 사용자가 이동한 칸들
    private int tryCount; // 총 시도한 횟수

    public BridgeGame(List<String> answerBridge) {
        this.answerBridge = answerBridge;
        this.playerCommands = new ArrayList<>();
        this.tryCount = 1;
    }

    public int getTryCount() {
        return tryCount;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     */
    public void move(String movingCommand) {
        playerCommands.add(movingCommand);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     */
    public void retry() {
        playerCommands.clear();
        tryCount++;
    }

    /**
     * 다리의 index번째 칸의 문자를 O/X/공백으로 출력
     *
     * @param index    다리의 몇 번째를 출력할지
     * @param expected 보고싶은 다리 방향 (U: 위, D: 아래)
     * @return 보고싶은 다리의 방향이 아니라면 공백, 맞다면 정답 여부에 따라 O 또는 X출력
     */
    private String calculateBridgeCharacter(int index, String expected) {
        if (!playerCommands.get(index).equals(expected)) {
            return " ";
        }
        if (!playerCommands.get(index).equals(answerBridge.get(index))) {
            return "X";
        }
        return "O";
    }

    /**
     * 현재까지 전부 건널 수 있는 다리만 건넜는지 여부 리턴
     *
     * @return 이동가능한 칸만 건너왔다면 true, 아니면 false 리턴
     */
    public boolean isCorrectChoice() {
        return playerCommands.equals(answerBridge.subList(0, playerCommands.size()));
    }

    /**
     * 다리를 끝까지 건넜는지 여부 리턴
     *
     * @return 다리를 끝까지 건넌 상태면 true, 아니면 false 리턴
     */
    public boolean isSuccess() {
        return playerCommands.equals(answerBridge);
    }

    public String getBridgeStatusString() {
        StringJoiner upperLine = new StringJoiner(" | ", "[ ", " ]");
        StringJoiner lowerLine = new StringJoiner(" | ", "[ ", " ]");
        for (int i = 0; i < playerCommands.size(); i++) {
            upperLine.add(calculateBridgeCharacter(i, "U"));
            lowerLine.add(calculateBridgeCharacter(i, "D"));
        }
        return upperLine.toString() + "\n" + lowerLine.toString();
    }
}
