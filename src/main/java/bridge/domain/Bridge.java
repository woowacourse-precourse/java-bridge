package bridge.domain;

import java.util.List;
import java.util.Objects;

import bridge.constant.ErrorCode;
import bridge.constant.MatchConst.Size;

public class Bridge {

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
        if(size< Size.BRIDGE_MIN_SIZE|| size> Size.BRIDGE_MAX_SIZE){
            throw new IllegalArgumentException(ErrorCode.OUT_OF_RANGE.getMessage());
        }
    }

    private void validateNumber(List<String> bridgeSpace){
        if(!bridgeSpace.stream().allMatch(a-> Objects.equals(a, BridgeShape.UP.getKeyword()) || Objects.equals(a, BridgeShape.DOWN.getKeyword()))){
            throw new IllegalArgumentException(ErrorCode.WRONG_WORD_IN_LIST.getMessage());
        }
    }

    public List<String> getBridgeSpace(){
        return this.bridgeSpace;
    }

}
