package bridge;

import java.util.Arrays;

public enum Step {
    D(0),
    U(1);

    public final int value;

    Step(int value) {
        this.value = value;
    }

    public static Step getStep(int value){
        return Arrays.stream(Step.values()).filter(c -> c.value == value).findFirst().get();
    }

    public static boolean validStep(String str){
        return Arrays.stream(Step.values()).filter(c -> c.name().equals(str)).findAny().orElse(null) != null ? true : false;
    }
}
