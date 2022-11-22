package bridge.model.ScreenGenerator;

import bridge.view.Sentence;
import java.util.List;
import java.util.stream.Collectors;

public class WrongCaseGenerator implements ScreenGenerator {

    private List<String> firstRowAnswer;
    private List<String> secondRowAnswer;

    private static final int FIRST_ROW_GEN = 1;
    private static final int SECOND_ROW_GEN = 0;

    @Override
    public void generatedTable(final List<String> answer, final int current) {
        BridgeEachRowGenerator bridgeEachRowGenerator = new BridgeEachRowGenerator(answer, current - 1);
        rowAppender(answer, current, bridgeEachRowGenerator);
    }

    private void rowAppender(final List<String> answer, final int current,
            final BridgeEachRowGenerator bridgeEachRowGenerator) {
        firstRowAnswer = bridgeEachRowGenerator.generateRowInList(FIRST_ROW_GEN);
        secondRowAnswer = bridgeEachRowGenerator.generateRowInList(SECOND_ROW_GEN);
        inputIsU(answer, current);
        inputIsD(answer, current);
    }

    private void inputIsU(final List<String> answer, final int current) {
        if (answer.get(current).equals(Sentence.UP_CHUNK.getValue())) {
            firstRowAnswer.add(Sentence.THREE_SIZE_BLANK.getValue());
            secondRowAnswer.add(Sentence.THREE_SIZE_X.getValue());
        }
    }

    private void inputIsD(final List<String> answer, final int current) {
        if (answer.get(current).equals(Sentence.DOWN_CHUNK.getValue())) {
            firstRowAnswer.add(Sentence.THREE_SIZE_X.getValue());
            secondRowAnswer.add(Sentence.THREE_SIZE_BLANK.getValue());
        }
    }

    @Override
    public String toString() {
        return firstRowAnswer.stream().collect(Collectors.joining(Sentence.DELIMITER.getValue(),
                Sentence.START_BRIDGE.getValue(), Sentence.END_BRIDGE.getValue())) +
                "\n" + secondRowAnswer.stream().collect(Collectors.joining(Sentence.DELIMITER.getValue(),
                Sentence.START_BRIDGE.getValue(), Sentence.END_BRIDGE.getValue()));
    }
}
