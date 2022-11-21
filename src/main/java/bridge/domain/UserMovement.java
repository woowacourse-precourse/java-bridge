package bridge.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 유저 이동 정보와 관련 메서드
 */
public class UserMovement {
    private List<String> userMovement = new ArrayList<>();

    /**
     * 유저 움직임 추가한다.
     *
     * @param movement "U" 또는 "D"
     */
    public void addMovement(String movement) {
        userMovement.add(movement);
    }

    /**
     * 유저의 이전 움직임을 반환한다.
     *
     * @return 이전까지 이동한 모든 칸 정보.
     */
    public List<String> getUserMovement() {
        return userMovement;
    }

    /**
     * 유저의 직전에 이동한 칸 정보를 삭제한다.
     */
    public void undoMove() {
        if (userMovement.size() != 0) {
            userMovement.remove(userMovement.size() - 1);
        }
    }
}
