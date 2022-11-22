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

    public Result(List<String> input, List<String> answer, int time, State state) {
        this.time = time;
        this.state = state;
        top = setString(input, answer, "U", "D");
        bottom = setString(input, answer, "D", "U");
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
                ret += printBlank(size, i);
            }
            else {
                ret += printOX(answer.get(i), map);
                ret += printBar(size, i);
            }
        }
        return ret;
    }

    private boolean notCorrectPosition(String a, String b) {
        return !a.equals(b);
    }

    private String printBlank(int size, int i) {
        String s = "   ";
        s += printBar(size, i);
        return s;
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
