package bridge.domain;

import bridge.Errors;

import java.util.Arrays;

public class Player {
    private String nextCurrent;
    public Player(String s) {
            validationPlay(s);
            this.setNextCurrent(s);
    }

    public void setNextCurrent(String nextCurrent) {
        this.nextCurrent = nextCurrent;
    }

    public String getNextCurrent() {
        return nextCurrent;
    }

    PlayerConstant validationPlay(String s){
         return Arrays.stream(PlayerConstant.values())
                 .filter(value -> value.location.equals(s))
                 .findAny()
                 .orElseThrow(() -> new IllegalArgumentException(Errors.FAIL_INPUT.getMessage()));
    }
}
