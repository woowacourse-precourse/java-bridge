package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class UserMovement {
    private static List<String> userMovement = new ArrayList<>();

    /**
     * 유저 움직임 추가한다.
     * @param movement U 또는 D 문자열
     */
    public static void addMovement(String movement) {
        userMovement.add(movement);
    }

    /**
     * 유저의 이전 움직임을 반환한다.
     * @return 이전까지 이동한 모든 칸 정보.
     */
    public static List<String> getUserMovement() {
        return userMovement;
    }

    /* Consider when userMovement is empty */

    /**
     * 유저의 직전에 이동한 칸 정보를 삭제한다.
     */
    public static void undoMove() {
        userMovement.remove(userMovement.size() - 1);
    }
}
