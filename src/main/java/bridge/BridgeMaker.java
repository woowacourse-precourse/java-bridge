package bridge;

import bridge.view.Sentence;

import java.util.ArrayList;

import java.util.List;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    private static final int ONE = 1;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        checkInputSize(size);
        List<Integer> generatedAnswerNumeric = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            generatedAnswerNumeric.add(bridgeNumberGenerator.generate());
        }
        return changeToUAndD(generatedAnswerNumeric);
    }

    private void checkInputSize(int size) {
        if (size < ONE) {
            throw new IllegalArgumentException(Sentence.LENGTH_NOT_IN_RANGE.getValue());
        }
    }

    private List<String> changeToUAndD(List<Integer> generatedValue) {
        List<String> convertedValue = new ArrayList<>();
        for (Integer integer : generatedValue) {
            addChunkToConverted(convertedValue, integer);
        }
        return convertedValue;
    }

    private static void addChunkToConverted(List<String> convertedValue, Integer integer) {
        if (integer == ONE) {
            convertedValue.add(Sentence.UP_CHUNK.getValue());
        } else if (integer == 0) {
            convertedValue.add(Sentence.DOWN_CHUNK.getValue());
        }
    }
}
