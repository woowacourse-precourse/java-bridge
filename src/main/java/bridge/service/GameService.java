package bridge.service;

import bridge.domain.UserResult;

import java.util.List;

public class GameService {
    public static boolean judgeMoving(List<String> bridge, UserResult userResult, String userMoving) {
            String movingResult = userResult.canMove(bridge,userMoving);
            record(userResult,movingResult,userMoving);
            if(movingResult.equals("O")){
                return true;
            }
            return false;
    }

    public static void record(UserResult userResult,String movingResult,String userMoving) {
        userResult.recordResult(movingResult,userMoving);
    }

}
