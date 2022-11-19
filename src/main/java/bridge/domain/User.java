package bridge.domain;

import java.util.HashMap;

public class User {

    private static HashMap<Integer, String> pastResult;
    public int currentBlock;

    public User() {
        pastResult = new HashMap<>();
    }

}
