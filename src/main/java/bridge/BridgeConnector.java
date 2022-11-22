package bridge;

import bridge.constant.BridgeConstant;
import bridge.constant.GameCommand;
import bridge.constant.Status;
import java.util.List;

/**
 * 출력하여 보여줄 다리를 만드는 기능을 담당
 */
public class BridgeConnector {
    private String upperSide;
    private String lowerSide;


    public void connect(List<Status> statuses) {
        upperSide = "";
        lowerSide = "";
        for (int section = 0; section < statuses.size(); section++) {
            if (section > 0) {
                connectBridge(BridgeConstant.JOINT.getBridgeConstant());
            }
            addStatus(statuses.get(section));
        }

    }

    private void connectBridge(String bridgeComponent) {
        upperSide += bridgeComponent;
        lowerSide += bridgeComponent;
    }

    private void recordResult(String currInput, String selectResult) {
        if (currInput.equals(GameCommand.GO_UP.getGameCommand())) {
            upperSide += selectResult;
            lowerSide += BridgeConstant.BLANK.getBridgeConstant();
        }
        if (currInput.equals(GameCommand.GO_DOWN.getGameCommand())) {
            upperSide += BridgeConstant.BLANK.getBridgeConstant();
            lowerSide += selectResult;
        }
    }

    private void addStatus(Status status) {
        if (status.getIsRight()) {
            recordResult(status.getCurrSelected(), BridgeConstant.CAN_GO.getBridgeConstant());
        }
        if (!status.getIsRight()) {
            recordResult(status.getCurrSelected(), BridgeConstant.CAN_NOT_GO.getBridgeConstant());
        }
    }

    @Override
    public String toString() {
        return upperSide + "\n" + lowerSide;
    }

}
