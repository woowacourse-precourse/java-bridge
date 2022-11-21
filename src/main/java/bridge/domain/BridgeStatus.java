package bridge.domain;

import java.util.ArrayList;
import java.util.List;

import static bridge.domain.PlayerStatus.*;
import static bridge.domain.BridgeBlock.*;
import static bridge.utils.constant.Constants.*;

public class BridgeStatus {
    private final List<String> upBridgeBlocks;
    private final List<String> downBridgeBlocks;

    public BridgeStatus() {
        this.upBridgeBlocks = new ArrayList<>();
        this.downBridgeBlocks = new ArrayList<>();
    }

    public void update(String direction, PlayerStatus status) {
        String block = getBlockByStatus(status);
        if(UP.matches(direction)) {
            addBlocks(block, EMPTY_BLOCK);
        }
        if(DOWN.matches(direction)) {
            addBlocks(EMPTY_BLOCK, block);
        }
    }

    public String getBlockByStatus(PlayerStatus status) {
        if(status == PLAYING) {
            return OK_BLOCK;
        }
        if(status == FAIL) {
            return FAIL_BLOCK;
        }
        return null;
    }

    public void addBlocks(String upBlock, String downBlock) {
        upBridgeBlocks.add(upBlock);
        downBridgeBlocks.add(downBlock);
    }
}
