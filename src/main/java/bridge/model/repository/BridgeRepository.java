package bridge.model.repository;

import bridge.constant.Constant;
import bridge.constant.SuccessOrFail;
import bridge.model.domain.Bridges;
import bridge.model.dto.GameResultDto;
import java.util.List;

public class BridgeRepository {

    private static Bridges bridges;
    private static int retryCount = Constant.INITIAL_RETRY_COUNT;
    private static int position = Constant.BRIDGE_INITIAL_POSITION;
    private static SuccessOrFail successOrFail = SuccessOrFail.SUCCESS;

    public void createBridge(List<String> bridges) {
        this.bridges = new Bridges(bridges);
    }

    public void modifyToGameFail() {
        successOrFail = SuccessOrFail.FAIL;
    }

    public void initPosition() {
        position = Constant.BRIDGE_INITIAL_POSITION;
    }

    public void addRetryCount() {
        retryCount++;
    }

    public void addPosition() {
        position++;
    }

    public String findBridge() {
        return bridges.findBridgeByPosition(position);
    }

    public boolean isMovableStatus() {
        return position != bridges.size() - Constant.INDEX_ZEROING_NUMBER;
    }

    public GameResultDto findGameResult() {
        return new GameResultDto(successOrFail, retryCount);
    }

    public List<String> findBridgeMap() {
        return bridges.findBridgeMapByPosition(position);
    }
}
