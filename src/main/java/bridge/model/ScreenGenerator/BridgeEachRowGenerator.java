package bridge.model.ScreenGenerator;

import java.util.List;
import java.util.ArrayList;

import bridge.view.Sentence;

public class BridgeEachRowGenerator {

    private final List<String> answer;
    private final int current;

    private static final int DIVISOR = 2;

    public BridgeEachRowGenerator(List<String> answer, int current) {
        this.answer = answer;
        this.current = current;
    }

    public List<String> generateRowInList(int divisor) {
        List<String> rowAnswer = new ArrayList<>();
        for (int i = 0; i <= current; i++) {
            rowAnswer.add(addOkOrBlank(answer, i, divisor));
        }
        return rowAnswer;
    }

    private String addOkOrBlank(List<String> answer, int index, int divisor) {
        List<String> zeroAndBlank = List.of(Sentence.THREE_SIZE_O.getValue(), Sentence.THREE_SIZE_BLANK.getValue());
        StringBuilder sb = new StringBuilder();
        if (answer.get(index).equals(Sentence.UP_CHUNK.getValue())) {
            return sb.append(zeroAndBlank.get((divisor + 1) % DIVISOR)).toString();
        }
        return sb.append(zeroAndBlank.get((divisor) % DIVISOR)).toString();
    }
}
