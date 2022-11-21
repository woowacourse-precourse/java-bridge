package bridge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public String toStringStair(List<String> answer, List<String> step){
        List<String> stair = makeStair(answer, step);
        String str = String.join(" | ", stair);
        return "[ " + str + " ]";
    }

    private List<String> makeStair(List<String> answer, List<String> step){
        List<String> stair = new ArrayList<>();
        for(int i = 0 ; i < answer.size(); i++){
            if(step.get(i).equals(this.name())){
                stair.add(answer.get(i));
                continue;
            }
            stair.add(" ");
        }
        return stair;
    }
}
