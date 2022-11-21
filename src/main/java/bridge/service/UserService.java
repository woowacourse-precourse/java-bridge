package bridge.service;

import bridge.domain.UserResult;

import java.util.ArrayList;

public class UserService {

    public static UserResult generateUserResult() {
        return new UserResult(new ArrayList<>(), new ArrayList<>());
    }


    public static void initUserResult(UserResult userResult) {
        userResult.init();
        userResult.initCount();
    }
}
