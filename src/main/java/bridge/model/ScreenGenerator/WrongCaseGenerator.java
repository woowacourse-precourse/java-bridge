package bridge.model.ScreenGenerator;

import java.util.List;
import java.util.stream.Collectors;

public class WrongCaseGenerator implements ScreenGenerator{

    @Override
    public String generatedTable(List<String> answer, int current) {
        BridgeEachRowGenerator bridgeEachRowGenerator = new BridgeEachRowGenerator(answer, current-1);
        String firstRow = firstRowAppender(answer, current, bridgeEachRowGenerator);
        String secondRow =  secondRowAppender(answer, current, bridgeEachRowGenerator);
        return (firstRow + "\n" + secondRow);
    }

    public String firstRowAppender(List<String> answer, int current, BridgeEachRowGenerator bridgeEachRowGenerator) {
        List<String> firstRowAnswer = bridgeEachRowGenerator.generateRowInList(1);
        if (answer.get(current).equals("U")) {
            firstRowAnswer.add("   ");
        } else if (answer.get(current).equals("D")) {
            firstRowAnswer.add(" X ");
        }
        return firstRowAnswer.stream().collect(Collectors.joining("|", "[", "]"));
    }

    public String secondRowAppender(List<String> answer, int current, BridgeEachRowGenerator bridgeEachRowGenerator) {
        List<String> secondRowAnswer = bridgeEachRowGenerator.generateRowInList(0);
        if (answer.get(current).equals("U")) {
            secondRowAnswer.add(" X ");
        } else if (answer.get(current).equals("D")) {
            secondRowAnswer.add("   ");
        }
        return secondRowAnswer.stream().collect(Collectors.joining("|", "[", "]"));
    }


}
