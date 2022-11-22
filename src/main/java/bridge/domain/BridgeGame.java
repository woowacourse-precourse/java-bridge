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
     */
    public void move(String way) {
        user_bridge.add(way);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     */
    public void retry() {
        user_bridge.clear();
    }

    public boolean isEnd() { //더 이동할 수 없는 상황인지 확인하는 메서드
        try {
            if (user_bridge.size() == 0)
                throw new IllegalStateException("[ERROR]: 예기치 못한 에러가 발생했습니다.");
            if (user_bridge.size() == answer_bridge.size())
                return true;    //유저의 입력수와 다리의 길이가 같으면 종료
            if (!user_bridge.get(user_bridge.size() - 1).equals(answer_bridge.get(user_bridge.size() - 1)))
                return true;    //유저의 입력이 틀리면 종료
            return false;   //다리의 길이도 다르고, 틀리지 않았으면 아직 종료x
        } catch (IllegalStateException e) {
            return true;
        }
    }

    public boolean isSuccess() {
        return Arrays.equals(user_bridge.toArray(), answer_bridge.toArray());
    }
}
