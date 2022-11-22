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
        Word topWord = new Word("U", "D");
        Word bottomWord = new Word("D", "U");
        top = setString(userInfo.getInput(), answer, topWord);
        bottom = setString(userInfo.getInput(), answer, bottomWord);
    }

    private String setString(List<String> input, List<String> answer, Word word) {
        map.clear();
        map.put(word.correct, " O ");
        map.put(word.wrong, " X ");
        return  "["+setContent(input, answer, word.correct)+"]\n";
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

    private class Word {
        private final String correct;
        private final String wrong;

        public Word(String correct, String wrong) {
            this.correct = correct;
            this.wrong = wrong;
        }
    }
}
