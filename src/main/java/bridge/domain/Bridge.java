package bridge.domain;

import java.util.List;
import java.util.Objects;

import bridge.domain.BridgeShape;

public class Bridge {

    private static final int BRIDGE_MAX_SIZE = 20;
    private static final int BRIDGE_MIN_SIZE = 3;
    private static final int UP_NUMBER = 1;
    private static final int DOWN_NUMBER = 0;

    private final List<String> bridgeSpace;

    public Bridge(List<String> bridgeSpace){
        validate(bridgeSpace);
        this.bridgeSpace = bridgeSpace;
    }

    private void validate(List<String> bridgeSpace){
        validateSize(bridgeSpace.size());
        validateNumber(bridgeSpace);
    }

    private void validateSize(int size){
        if(size<BRIDGE_MIN_SIZE || size> BRIDGE_MAX_SIZE){
            throw new IllegalArgumentException("[ERROR] 다리 길이가 범위를 벗어납니다.");
        }
    }

    private void validateNumber(List<String> bridgeSpace){
        if(!bridgeSpace.stream().allMatch(a-> Objects.equals(a, BridgeShape.UP.getKeyword()) || Objects.equals(a, BridgeShape.DOWN.getKeyword()))){
            throw new IllegalArgumentException("[ERROR] 다리 리스트에 적절하지 않은 문자가 있습니다.");
        }
    }






}
