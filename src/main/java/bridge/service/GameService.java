package bridge.service;

import bridge.domain.User;

import java.util.List;

public class GameService {
    public static boolean judgeMoving(List<String> bridge, User user, String userMoving) {
            String movingResult = user.canMove(bridge,userMoving);
            record(user,movingResult,userMoving);
            if(movingResult.equals("O")){
                return true;
            }
            return false;
    }

    public static void record(User user, String movingResult, String userMoving) {
        user.recordResult(movingResult,userMoving);
    }

}
