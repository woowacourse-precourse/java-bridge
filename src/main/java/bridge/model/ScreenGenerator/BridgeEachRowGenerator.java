package bridge.model.ScreenGenerator;

import bridge.view.Sentence;
import java.util.ArrayList;
import java.util.List;

public class BridgeEachRowGenerator {

    private final List<String> answer;
    private final int current;

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
            return sb.append(zeroAndBlank.get((divisor + 1) % 2)).toString();
        }
        return sb.append(zeroAndBlank.get((divisor) % 2)).toString();
    }
}
