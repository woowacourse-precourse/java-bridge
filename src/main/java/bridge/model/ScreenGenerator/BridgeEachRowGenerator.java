package bridge.model.ScreenGenerator;

import bridge.view.Sentence;
import java.util.ArrayList;
import java.util.List;

public class BridgeEachRowGenerator {

    private static final int DIVISOR = 2;

    private final List<String> answer;
    private final int current;

    public BridgeEachRowGenerator(final List<String> answer, final int current) {
        this.answer = answer;
        this.current = current;
    }

    public List<String> generateRowInList(final int divisor) {
        List<String> rowAnswer = new ArrayList<>();
        for (int i = 0; i <= current; i++) {
            rowAnswer.add(addOkOrBlank(answer, i, divisor));
        }
        return rowAnswer;
    }

    private String addOkOrBlank(final List<String> answer, final int index, final int divisor) {
        List<String> zeroAndBlank = List.of(Sentence.THREE_SIZE_O.getValue(), Sentence.THREE_SIZE_BLANK.getValue());
        StringBuilder sb = new StringBuilder();
        if (answer.get(index).equals(Sentence.UP_CHUNK.getValue())) {
            return sb.append(zeroAndBlank.get((divisor + 1) % DIVISOR)).toString();
        }
        return sb.append(zeroAndBlank.get((divisor) % DIVISOR)).toString();
    }
}
