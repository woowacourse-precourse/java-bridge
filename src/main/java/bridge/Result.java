package bridge;

import bridge.constant.State;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Result {
    private final int time;
    private final State state;
    private final String top;
    private final String bottom;
    private final Map<String, String > map = new HashMap<>();

    public Result(List<String> answer, UserInfo userInfo) {
        this.time = userInfo.getTime();
        this.state = userInfo.getState();
        top = setString(userInfo.getInput(), answer, "U", "D");
        bottom = setString(userInfo.getInput(), answer, "D", "U");
    }

    private String setString(List<String> input, List<String> answer, String correct, String wrong) {
        map.clear();
        map.put(correct, " O ");
        map.put(wrong, " X ");
        return  "["+setContent(input, answer, correct)+"]";
    }

    private String setContent(List<String> input, List<String> answer, String correct) {
        int size = input.size();
        String ret = "";
        for (int i = 0; i < size; i++) {
            if (notCorrectPosition(correct, input.get(i))) {
                ret += printBlank() + printBar(size, i);
                continue;
            }
            ret += printOX(answer.get(i), map) + printBar(size, i);
        }
        return ret;
    }

    private boolean notCorrectPosition(String a, String b) {
        return !a.equals(b);
    }

    private String printBlank() {
        return  "   ";
    }

    private String printOX(String s, Map<String, String> map) {
        return map.get(s);
    }

    private String printBar(int size, int i) {
        if (i != size - 1) {
            return "|";
        }
        return "";
    }

    public String getTop() {
        return top;
    }

    public String getBottom() {
        return bottom;
    }

    public State getState() {
        return state;
    }

    public int getTime() {
        return time;
    }
}
