package bridge;

import bridge.model.Direction;
import bridge.model.ErrorMessage;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        isValidRange(size);
        List<Integer> preBridge = makePreBridge(size);
        return makeFinalBridge(preBridge);
    }

    public int getSizeInteger(String size){
        try{
            return Integer.parseInt(size);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMERIC_VALUE.getOutput());
        }
    }

    private void isValidRange(int size){
        if(size < 3 || size > 20){
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMERIC_VALUE.getOutput());
        }
    }

    private List<Integer> makePreBridge(int size){
        return Stream.generate(bridgeNumberGenerator::generate)
                .limit(size)
                .collect(Collectors.toUnmodifiableList());
    }

    private List<String> makeFinalBridge(List<Integer> preBridge){
        return preBridge.stream()
                .map(Direction::getInputByValue)
                .collect(Collectors.toUnmodifiableList());
    }
}
