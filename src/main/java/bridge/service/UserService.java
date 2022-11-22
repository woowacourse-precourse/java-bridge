package bridge.service;

import bridge.domain.User;

import java.util.ArrayList;

public class UserService {

    public static User generateUser() {
        return new User(new ArrayList<>(), new ArrayList<>());
    }


    public static void initializeUser(User user) {
        user.init();
    }
}
