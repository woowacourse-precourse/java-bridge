package bridge;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BridgeGame {
    public static InputView inputView = new InputView();
    public static OutputView outputView = new OutputView();

    static List<String> bridge_answer = new ArrayList<>();

    static int play_count = 1;

    public static void resultBridge(List<String> user_answer) {
        initBridgeStringBuilder();
        for (int i = 0; i < OutputView.now_size + 1; i++) {
            if (checkAnswer(bridge_answer.get(i), user_answer.get(i))) {
                addAnswer(bridge_answer.get(i), i);
            }
            if (!checkAnswer(bridge_answer.get(i), user_answer.get(i))) {
                addWrongAnswer(bridge_answer.get(i), i);
                break;
            }
        }
    }

    public static void playBridgeGame() {
        initForBridgeGame();
        for (OutputView.now_size = 0; OutputView.now_size < BridgeGame.bridge_answer.size(); OutputView.now_size++) {
            InputView.readMoving();
            resultBridge(inputView.getMove());
            if (!whenAnswerIsWrong())
                break;
            if (whenAnswerIsCorrect())
                break;
            outputView.printResult();
        }
    }

    public static void initForBridgeGame() {
        outputView.initNowSize();
        inputView.clearMove();
    }

    public static Boolean whenAnswerIsCorrect() {
        if (checkCorrectAnswer(inputView.getMove(), bridge_answer)) {
            outputView.printResult();
            outputView.printSuccess();
            return true;
        }
        return false;
    }

    public static Boolean whenAnswerIsWrong() {
        if (!checkAnswer(bridge_answer.get(OutputView.now_size), inputView.getMove().get(OutputView.now_size))) {
            outputView.printResult();
            InputView.readGameCommand();
            return false;
        }
        return true;
    }

    public static Boolean checkCorrectAnswer(List<String> Answer, List<String> userAnswer) {
        return Objects.equals(Answer, userAnswer);
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

    public static void addAnswer(String answer, int i) {
        if (Objects.equals(answer, "U")) {
            OutputView.upBridge.append("O ");
            OutputView.downBridge.append("  ");
        }
        if (Objects.equals(answer, "D")) {
            OutputView.upBridge.append("  ");
            OutputView.downBridge.append("O ");
        }
        addAndOr(OutputView.now_size, i);
    }


    public static void addWrongAnswer(String answer, int i) {
        if (Objects.equals(answer, "D")) {
            OutputView.upBridge.append("X ");
            OutputView.downBridge.append("  ");
        }
        if (Objects.equals(answer, "U")) {
            OutputView.upBridge.append("  ");
            OutputView.downBridge.append("X ");
        }
        addAndOr(OutputView.now_size, i);
    }

    public static void addAndOr(int now_size, int end_size) {
        if (now_size == end_size) {
            OutputView.upBridge.append("]");
            OutputView.downBridge.append("]");
            return;
        }
        OutputView.upBridge.append("| ");
        OutputView.downBridge.append("| ");
    }


    public List<String> getBridgeAnswer() {
        return bridge_answer;
    }
}
