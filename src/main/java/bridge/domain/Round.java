package bridge.domain;

import static bridge.util.Constant.*;

public class Round {

    private int round;

    public Round() {
        this.round = 0;
    }

    // 첫 라운드인지 판별하는 기능
    public boolean checkRoundFirst() {
        return round == FIRST_ROUND;
    }

    // 라운드를 증가시키는 기능
    public void plusRound() {
        round++;
    }

    //라운드를 초기화하는 기능
    public void initRound() {
        round = INIT;
    }

    public int getRound() {
        return round;
    }
}
