package bridge.service;

import bridge.domain.User;

import java.util.ArrayList;

public class UserService {

    public static User generateUserResult() {
        return new User(new ArrayList<>(), new ArrayList<>());
    }


    public static void initUserResult(User user) {
        user.init();
    }
}
