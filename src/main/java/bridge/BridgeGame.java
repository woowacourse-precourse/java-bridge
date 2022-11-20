package bridge;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BridgeGame {
    static List<String> bridge_answer = new ArrayList<>();

    static int play_count = 1;

    public void resultBridge(List<String> user_answer) {
        initBridgeStringBuilder();
        for (int i = 0; i < OutputView.now_size+1 ; i++) {
            if (checkAnswer(bridge_answer.get(i), user_answer.get(i))) {
                addAnswer(bridge_answer.get(i), i);
            }
            if (!checkAnswer(bridge_answer.get(i), user_answer.get(i))) {
                addWrongAnswer(bridge_answer.get(i), i);
                break;
            }
        }
    }

    public static void initBridgeStringBuilder() {
        OutputView.upBridge.setLength(0);
        OutputView.downBridge.setLength(0);
        OutputView.upBridge.append("[ ");
        OutputView.downBridge.append("[ ");
    }

    public static Boolean checkAnswer(String a, String b) {
        return a.equals(b);
    }

    public static void addAnswer(String a, int i) {
        if (Objects.equals(a, "U")) {
            OutputView.upBridge.append("O ");
            OutputView.downBridge.append("  ");
        }
        if (Objects.equals(a, "D")) {
            OutputView.upBridge.append("  ");
            OutputView.downBridge.append("O ");
        }
        addAndOr(OutputView.now_size, i);
    }

    public static void addWrongAnswer(String a, int i) {
        if (Objects.equals(a, "D")) {
            OutputView.upBridge.append("X ");
            OutputView.downBridge.append("  ");
        }
        if (Objects.equals(a, "U")) {
            OutputView.upBridge.append("  ");
            OutputView.downBridge.append("X ");
        }
        addAndOr(OutputView.now_size, i);
    }

    public static void addAndOr(int a, int b) {
        if (a == b) {
            OutputView.upBridge.append("]");
            OutputView.downBridge.append("]");
            return;
        }
        OutputView.upBridge.append("| ");
        OutputView.downBridge.append("| ");
    }


    public List<String> getBridgeAnswer(){
        return bridge_answer;
    }
}
