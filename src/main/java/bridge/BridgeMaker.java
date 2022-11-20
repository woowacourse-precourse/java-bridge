package bridge;

import bridge.view.Sentence;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        List<Integer> generatedAnswerNumeric = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            generatedAnswerNumeric.add(bridgeNumberGenerator.generate());
        }
        return changeToUD(generatedAnswerNumeric);
    }

    private List<String> changeToUD(List<Integer> generatedValue) {
        List<String> convertedValue = new ArrayList<>();
        for (Integer integer : generatedValue) {
            addChunkToConverted(convertedValue, integer);
        }
        return convertedValue;
    }

    private static void addChunkToConverted(List<String> convertedValue, Integer integer) {
        if (integer == 1) {
            convertedValue.add(Sentence.UP_CHUNK.getValue());
        } else if (integer == 0) {
            convertedValue.add(Sentence.DOWN_CHUNK.getValue());
        }
    }
}
