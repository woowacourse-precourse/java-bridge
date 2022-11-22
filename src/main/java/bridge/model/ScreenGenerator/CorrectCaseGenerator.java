package bridge.model.ScreenGenerator;

import bridge.view.Sentence;
import java.util.List;
import java.util.stream.Collectors;

public class CorrectCaseGenerator implements ScreenGenerator {

    private static final int SELECT_FIRST = 1;
    private static final int SELECT_SECOND = 0;

    private List<String> secondRowAnswer;
    private List<String> firstRowAnswer;

    @Override
    public void generatedTable(final List<String> answer, final int current) {
        BridgeEachRowGenerator bridgeEachRowGenerator = new BridgeEachRowGenerator(answer, current);
        rowAppender(bridgeEachRowGenerator);
    }

    private void rowAppender(final BridgeEachRowGenerator bridgeEachRowGenerator) {
        firstRowAnswer = bridgeEachRowGenerator.generateRowInList(SELECT_FIRST);
        secondRowAnswer = bridgeEachRowGenerator.generateRowInList(SELECT_SECOND);
    }

    @Override
    public String toString() {
        return firstRowAnswer.stream().collect(
                    Collectors.joining(Sentence.DELIMITER.getValue(), Sentence.START_BRIDGE.getValue(),
                    Sentence.END_BRIDGE.getValue())) + "\n" + secondRowAnswer.stream().collect(
                    Collectors.joining(Sentence.DELIMITER.getValue(), Sentence.START_BRIDGE.getValue(),
                    Sentence.END_BRIDGE.getValue()));
    }
}


