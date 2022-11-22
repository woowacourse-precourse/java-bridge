package bridge;

import bridge.constant.State;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Result {
    private final List<String> input;
    private final List<String> answer;
    private final int time;
    private final State state;
    private int size;
    private String top;
    private String bottom;

    public Result(List<String> input, List<String> answer, int time, State state) {
        this.input = input;
        this.answer = answer;
        this.time = time;
        this.state = state;
        this.size = input.size();
        top = setString(input, answer, "U", "D");
        bottom = setString(input, answer, "D", "U");
    }

    private String setString(List<String> input, List<String> answer, String correct, String wrong) {
        Map<String, String > map = new HashMap<>();
        map.put(correct, " O ");
        map.put(wrong, " X ");
        String a = "[";
        a += setContent(input, answer, map, correct);
        a += "]";
        return a;
    }

    private String setContent(List<String> input, List<String> answer, Map<String, String> map, String correct) {
        int size = input.size();
        String ret = "";
        for (int i = 0; i < size; i++) {
            if (notCorrectPosition(input, correct, i)) {
                ret += printBlank(size, i);
                continue;
            }
            ret += printOX(answer.get(i), map);
            ret += printBar(size, i);
        }
        return ret;
    }

    private boolean notCorrectPosition(List<String> input, String trg, int i) {
        return !trg.equals(input.get(i));
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

    public int getSize() {
        return size;
    }

    public State getState() {
        return state;
    }

    public int getTime() {
        return time;
    }
}
