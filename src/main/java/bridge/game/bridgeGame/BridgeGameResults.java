package bridge.game.bridgeGame;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BridgeGameResults {

    private static final int INDEX_UP_LINE = 0;
    private static final int INDEX_DOWN_LINE = 1;
    private static final String DELIMITER = " | ";
    private static final String START_FORMAT = "[ ";
    private static final String END_FORMAT = " ]";


    private final List<BridgeGameResult> bridgeResults;


    public BridgeGameResults() {
        this.bridgeResults = new ArrayList<>();
    }

    public void add(BridgeGameResult bridgeGameResult) {
        bridgeResults.add(bridgeGameResult);
    }

    @Override
    public String toString() {
        List<String> upLineValue = getLineValue(INDEX_UP_LINE);
        List<String> downLineValue = getLineValue(INDEX_DOWN_LINE);
        return formattingValue(upLineValue) + "\n" + formattingValue(downLineValue);
    }

    private List<String> getLineValue(int index) {
        return bridgeResults.stream()
                .map(bridgeResult -> bridgeResult.getBridgeGameResult()
                        .get(index))
                .collect(Collectors.toList());
    }

    private static String formattingValue(List<String> lineValue) {
        return START_FORMAT + String.join(DELIMITER, lineValue) + END_FORMAT;
    }

}