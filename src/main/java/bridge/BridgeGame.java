package bridge;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    final InputView inputView = new InputView();
    final OutputView outputView = new OutputView();
    static int now_size = 0;
    static List<String> bridge_answer = new ArrayList<>();



    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {


    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }


    public void resultBridge(List<String> user_answer) {
        initBridgeStringBuilder();
        for (int i = 0; i < OutputView.now_size + 1; i++) {
            if (checkAnswer(bridge_answer.get(i), user_answer.get(i))) {
                addAnswer(bridge_answer.get(i), i);
            }
            if (!checkAnswer(bridge_answer.get(i), user_answer.get(i))) {
                addWrongAnswer(bridge_answer.get(i), i);
            }
        }
        now_size++;
        outputView.printResult();
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
        addAndOr(now_size, i);
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
        addAndOr(now_size, i);
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
