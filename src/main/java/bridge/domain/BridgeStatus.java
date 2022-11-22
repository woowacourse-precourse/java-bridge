package bridge.domain;

import java.util.ArrayList;
import java.util.List;

import static bridge.domain.PlayerStatus.*;
import static bridge.domain.Direction.*;
import static bridge.utils.constant.Constants.*;

public class BridgeStatus {
    private final List<String> upBridgeBlocks;
    private final List<String> downBridgeBlocks;

    public BridgeStatus() {
        this.upBridgeBlocks = new ArrayList<>();
        this.downBridgeBlocks = new ArrayList<>();
    }

    public void init() {
        upBridgeBlocks.clear();
        downBridgeBlocks.clear();
    }

    public void update(Direction direction, PlayerStatus status) {
        BridgeBlock block = getBlockByStatus(status);
        if(direction == UP) {
            addBlocks(block, BridgeBlock.EMPTY);
        }
        if(direction == DOWN) {
            addBlocks(BridgeBlock.EMPTY, block);
        }
    }

    public BridgeBlock getBlockByStatus(PlayerStatus status) {
        if(status == PLAYING) {
            return BridgeBlock.O;
        }
        if(status == FAIL) {
            return BridgeBlock.X;
        }
        return BridgeBlock.EMPTY;
    }

    public void addBlocks(BridgeBlock upBlock, BridgeBlock downBlock) {
        upBridgeBlocks.add(upBlock.getBridgeBlock());
        downBridgeBlocks.add(downBlock.getBridgeBlock());
    }

    @Override
    public String toString() {
        return upBridgeBlocks.toString().replaceAll(COMMA, DELIMITER) + ENTER +
                downBridgeBlocks.toString().replaceAll(COMMA, DELIMITER) + ENTER;
    }
}
