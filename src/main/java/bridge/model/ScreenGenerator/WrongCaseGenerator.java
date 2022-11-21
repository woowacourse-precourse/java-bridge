package bridge.model.ScreenGenerator;

import bridge.view.Sentence;
import java.util.List;
import java.util.stream.Collectors;

public class WrongCaseGenerator implements ScreenGenerator {

    private List<String> firstRowAnswer;
    private List<String> secondRowAnswer;

    @Override
    public void generatedTable(List<String> answer, int current) {
        BridgeEachRowGenerator bridgeEachRowGenerator = new BridgeEachRowGenerator(answer, current - 1);
        rowAppender(answer, current, bridgeEachRowGenerator);
    }

    private void rowAppender(List<String> answer, int current, BridgeEachRowGenerator bridgeEachRowGenerator) {
        firstRowAnswer = bridgeEachRowGenerator.generateRowInList(1);
        secondRowAnswer = bridgeEachRowGenerator.generateRowInList(0);
        inputIsU(answer, current);
        inputIsD(answer, current);
    }

    private void inputIsU(List<String> answer, int current) {
        if (answer.get(current).equals(Sentence.UP_CHUNK.getValue())) {
            firstRowAnswer.add(Sentence.THREE_SIZE_BLANK.getValue());
            secondRowAnswer.add(Sentence.THREE_SIZE_X.getValue());
        }
    }

    private void inputIsD(List<String> answer, int current) {
        if (answer.get(current).equals(Sentence.DOWN_CHUNK.getValue())) {
            firstRowAnswer.add(Sentence.THREE_SIZE_X.getValue());
            secondRowAnswer.add(Sentence.THREE_SIZE_BLANK.getValue());
        }
    }

    @Override
    public String toString() {
        return firstRowAnswer.stream().collect(Collectors.joining("|", "[", "]")) +
                "\n" + secondRowAnswer.stream().collect(Collectors.joining("|", "[", "]"));
    }
}
