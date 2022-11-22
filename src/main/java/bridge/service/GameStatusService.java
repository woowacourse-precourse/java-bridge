package bridge.service;

import bridge.model.GameStatus;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/11/22
 */
public class GameStatusService {

    public GameStatus find() {
        return GameStatus.getInstance();
    }

    public void setFinishWin() {
        find().setFinishTrue();
        find().setResultSuccess();
    }

    public void setFinishLose() {
        find().setFinishTrue();
    }

    public void reset() {
        find().reset();
    }
}
