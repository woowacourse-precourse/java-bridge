package bridge.service;

import bridge.domain.User;

import java.util.ArrayList;

public class UserService {

    public static User generateUser() {
        return new User(new ArrayList<>(), new ArrayList<>());
    }


    public static void initUser(User user) {
        user.init();
    }
}
