package bridge.model.ScreenGenerator;

import java.util.ArrayList;
import java.util.List;

public class BridgeEachRowGenerator {

    static final List<String> zeroAndBlank = List.of(" O ", "   ");
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
        StringBuilder sb = new StringBuilder();
        if (answer.get(index).equals("U")) {
            sb.append(zeroAndBlank.get( (divisor+1)% 2));
        } else if (answer.get(index).equals("D")) {
            sb.append(zeroAndBlank.get( (divisor)% 2));
        }
        return sb.toString();
    }
}
