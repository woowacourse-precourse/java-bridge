package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    // 사용자 이동 경로와 정답 경로를 비교 후 기록
    public List<List<String>> move(List<String> answer, User user) {
        List<String> choices = user.getUserMoveChoice();
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < choices.size(); i++) {
            result.add(markResult(choices, i, choices.get(i).equals(answer.get(i))));
        }
        return result;
    }

    // 사용자 선택 경로에 O, X 표시
    private List<String> markResult(List<String> choices, int i, boolean mark) {
        List<String> temp = new ArrayList<>();
        String marker = "X";
        if (mark) {
            marker = "O";
        }
        temp.add(marker);
        temp.add(choices.get(i));
        return temp;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String cmd) {
        if (cmd.equals("R")) {
            return true;
        }
        return false;
    }
}
