package bridge.model.ScreenGenerator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CorrectCaseGenerator implements ScreenGenerator {


    List<String> firstRowAnswer;
    List<String> secondRowAnswer;

    @Override
    public void generatedTable(List<String> answer, int current) {
        BridgeEachRowGenerator bridgeEachRowGenerator = new BridgeEachRowGenerator(answer, current);
        firstRowAppender(bridgeEachRowGenerator);
        secondRowAppender(bridgeEachRowGenerator);
    }


    public void firstRowAppender(BridgeEachRowGenerator bridgeEachRowGenerator) {
        firstRowAnswer = bridgeEachRowGenerator.generateRowInList(1);
    }

    public void secondRowAppender(BridgeEachRowGenerator bridgeEachRowGenerator) {
        secondRowAnswer = bridgeEachRowGenerator.generateRowInList(0);
    }

    @Override
    public String toString() {
        return firstRowAnswer.stream().collect(Collectors.joining("|", "[", "]"))
                + "\n"+ secondRowAnswer.stream().collect(Collectors.joining("|", "[", "]"));
    }
}


