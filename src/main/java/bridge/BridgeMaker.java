package bridge;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

public class BridgeMaker {
    private final int minLength = 3;
    private final int maxLength = 20;
    private final BridgeNumberGenerator bridgeNumberGenerator;

    public final static List<String> UP_DOWN_SELECTOR = List.of("D", "U");

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeRandomBridgeProcess(String size){
        validationBridgeInteger(size);
        validationBridgeRange(Integer.valueOf(size));
        return makeBridge(Integer.valueOf(size));
    }
    private void validationBridgeInteger(String size){
        if (!Pattern.matches("[0-9]*", size)){
            throw new IllegalArgumentException(Errors.ONLY_NUMBER.getMessage());
        }
    }
    private void validationBridgeRange(int size){
        if(size < minLength || size > maxLength){
            throw new IllegalArgumentException(Errors.BRIDGE_LENGTH.getMessage());
        }
    }

    public List<String> makeBridge(int size) {
        return  IntStream.range(0, size)
                .map(n -> bridgeNumberGenerator.generate())
                .mapToObj(UP_DOWN_SELECTOR::get)
                .collect(toList());
    }
}
