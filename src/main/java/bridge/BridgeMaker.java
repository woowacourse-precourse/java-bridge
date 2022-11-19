package bridge;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {


    private final BridgeNumberGenerator bridgeNumberGenerator;
    static int now_size = 0;
    static List<String> bridge_answer = new ArrayList<>();
    static StringBuilder upBridge = new StringBuilder();
    static StringBuilder downBridge = new StringBuilder();

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {

        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        for (int i = 0; i < size; i++) {
            int a = bridgeRandomNumberGenerator.generate();
            if (a == 0)
                bridge_answer.add("U");
            if (a == 1)
                bridge_answer.add("D");
        }
        return null;
    }

    public void resultBridge(List<String> user_answer) {
        initBridgeStringBuilder();
        for (int i = 0; i < now_size + 1; i++) {
            if (checkAnswer(bridge_answer.get(i), user_answer.get(i))) {
                addAnswer(bridge_answer.get(i), i);
            }
            if (!checkAnswer(bridge_answer.get(i), user_answer.get(i))) {
                addWrongAnswer(bridge_answer.get(i), i);
            }
        }
        now_size++;
        showBridge();
    }

    public static void showBridge() {
        System.out.println(upBridge.toString());
        System.out.println(downBridge.toString());
    }

    public static void initBridgeStringBuilder() {
        upBridge.setLength(0);
        downBridge.setLength(0);
        upBridge.append("[ ");
        downBridge.append("[ ");
    }

    public static Boolean checkAnswer(String a, String b) {
        return a.equals(b);
    }

    public static void addAnswer(String a, int i) {
        if (Objects.equals(a, "U")) {
            upBridge.append("O ");
            downBridge.append("  ");
        }
        if (Objects.equals(a, "D")) {
            upBridge.append("  ");
            downBridge.append("O ");
        }
        addAndOr(now_size, i);
    }

    public static void addWrongAnswer(String a, int i) {
        if (Objects.equals(a, "D")) {
            upBridge.append("X ");
            downBridge.append("  ");
        }
        if (Objects.equals(a, "U")) {
            upBridge.append("  ");
            downBridge.append("X ");
        }
        addAndOr(now_size, i);
    }

    public static void addAndOr(int a, int b) {
        if (a == b) {
            System.out.println("U 정답 끝");
            upBridge.append("]");
            downBridge.append("]");
            return;
        }
        System.out.println("U 정답 안끝");
        upBridge.append("| ");
        downBridge.append("| ");
    }
}
