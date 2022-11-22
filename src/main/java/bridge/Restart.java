package bridge;

import java.util.Arrays;

public enum Restart {
    R(true),
    Q(false);
    private boolean flag;
    Restart(boolean flag){
        this.flag=flag;
    }

    public boolean getFlag() {
        return flag;
    }

    public static Restart getRestart(boolean flag){
        return Arrays.stream(Restart.values())
                .filter(x-> x.flag==flag)
                .findAny()
                .orElse(null);
    }
}
