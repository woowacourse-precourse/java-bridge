package bridge.model.ScreenGenerator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WrongCaseGenerator implements ScreenGenerator{

    List<String> firstRowAnswer;
    List<String> secondRowAnswer;

    @Override
    public void generatedTable(List<String> answer, int current) {
        BridgeEachRowGenerator bridgeEachRowGenerator = new BridgeEachRowGenerator(answer, current-1);
        firstRowAppender(answer, current, bridgeEachRowGenerator);
        secondRowAppender(answer, current, bridgeEachRowGenerator);
        //return (firstRow + "\n" + secondRow);
    }

    public void firstRowAppender(List<String> answer, int current, BridgeEachRowGenerator bridgeEachRowGenerator) {
        firstRowAnswer = bridgeEachRowGenerator.generateRowInList(1);
        if (answer.get(current).equals("U")) {
            firstRowAnswer.add("   ");
        } else if (answer.get(current).equals("D")) {
            firstRowAnswer.add(" X ");
        }
    }

    public void secondRowAppender(List<String> answer, int current, BridgeEachRowGenerator bridgeEachRowGenerator) {
        secondRowAnswer = bridgeEachRowGenerator.generateRowInList(0);
        if (answer.get(current).equals("U")) {
            secondRowAnswer.add(" X ");
        } else if (answer.get(current).equals("D")) {
            secondRowAnswer.add("   ");
        }
    }

    @Override
    public String toString() {
        return firstRowAnswer.stream().collect(Collectors.joining("|", "[", "]"))
            + "\n"+ secondRowAnswer.stream().collect(Collectors.joining("|", "[", "]"));
    }


}
