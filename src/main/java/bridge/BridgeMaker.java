package bridge;

import bridge.domain.UpDown;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {
    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<Integer> numbers = generateNumbers(size);

        List<String> bridge = convertNumbersToUpAndDown(numbers);

        return bridge;
    }

    public List<String> convertNumbersToUpAndDown(List<Integer> numbers) {
        List<String> convertResult = new ArrayList<>();

        for (int number : numbers) {
            String result = numberToUpAndDown(number);
            convertResult.add(result);
        }
        return convertResult;
    }

    public String numberToUpAndDown(int number) {
        String result = "";

        for (UpDown upDown : UpDown.values()) {
            if (number == upDown.getNumber()) {
                result = upDown.getResult();
            }
        }

        return result;
    }


    public List<Integer> generateNumbers(int size) {
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            numbers.add(bridgeNumberGenerator.generate());
        }

        return numbers;
    }
}
