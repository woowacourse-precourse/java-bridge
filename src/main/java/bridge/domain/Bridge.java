package bridge.domain;

import bridge.core.exception.Error;
import bridge.core.exception.InvalidInputException;

import java.util.List;

public class Bridge {

    private final List<String> bridgeMap;

    public Bridge(List<String> bridgeMap) {
        this.bridgeMap = bridgeMap;
    }

    public Boolean checkPassableBlock(Integer nextPosition, String selectBlock) {
        validate(selectBlock);
        String passableBlock = bridgeMap.get(nextPosition);
        if (selectBlock.equals(passableBlock)) return true;
        return false;
    }

    public Boolean checkWhetherLastBlock(Integer currentPosition) {
        if (currentPosition == bridgeMap.size() - 1) return true;
        return false;
    }

    public List<String> getBridgeMapUntil(Integer currentPosition) {
        return bridgeMap.subList(0, currentPosition + 1);
    }

    //== validation ==//
    private void validate(String selectBlock) {
        if (selectBlock.equals("U") || selectBlock.equals("D")) {
            return;
        }
        throw new InvalidInputException(Error.SELECT_BLOCK_ERROR);

    }
}
