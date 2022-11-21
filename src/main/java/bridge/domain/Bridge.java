package bridge.domain;

import java.util.List;

public class Bridge {

    private static final int BRIDGE_MAX_SIZE = 20;
    private static final int BRIDGE_MIN_SIZE = 3;
    private static final int UP_NUMBER = 1;
    private static final int DOWN_NUMBER = 0;

    private final List<Integer> bridgeSpace;

    public Bridge(List<Integer> bridgeSpace){
        validate(bridgeSpace);
        this.bridgeSpace = bridgeSpace;
    }

    private void validate(List<Integer> bridgeSpace){
        validateSize(bridgeSpace.size());
        validateNumber(bridgeSpace);
    }

    private void validateSize(int size){
        if(size<BRIDGE_MIN_SIZE || size> BRIDGE_MAX_SIZE){
            throw new IllegalArgumentException("[ERROR] 다리 길이가 범위를 벗어납니다.");
        }
    }

    private void validateNumber(List<Integer> bridgeSpace){
        if(!bridgeSpace.stream().allMatch(a->a==UP_NUMBER||a==DOWN_NUMBER)){
            throw new IllegalArgumentException("[ERROR] 리스트가 0혹은 1로 이루어져 있지 않습니다.");
        }
    }






}
