package bridge.service;

import bridge.domain.UserResult;

import java.util.ArrayList;

public class GameResultService {

    public static UserResult initGameResult() {
        return new UserResult(new ArrayList<>(), new ArrayList<>());
    }
}
