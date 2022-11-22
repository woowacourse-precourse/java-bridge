package bridge.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final List<String> answer_bridge;
    private List<String> user_bridge;

    public BridgeGame(List<String> answer_bridge) {
        this.answer_bridge = answer_bridge;
        this.user_bridge = new ArrayList<>();
    }

    public List<String> getUser_bridge() {
        return user_bridge;
    }


    public List<String> getAnswer_bridge() {
        return answer_bridge;
    }


    public void setUser_bridge(List<String> user_bridge) {
        this.user_bridge = user_bridge;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String way) {
        user_bridge.add(way);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        user_bridge.clear();
    }

    public boolean isEnd() {
        int size = user_bridge.size();
        if (size == answer_bridge.size())
            return true;    //유저의 입력수와 다리의 길이가 같으면 종료
        if (!user_bridge.get(size - 1).equals(answer_bridge.get(size - 1)))
            return true;    //유저의 입력이 틀리면 종료
        return false;   //다리의 길이도 다르고, 틀리지 않았으면 아직 종료x
    }

    public boolean isSuccess() {
        return Arrays.equals(user_bridge.toArray(), answer_bridge.toArray());
    }
}
