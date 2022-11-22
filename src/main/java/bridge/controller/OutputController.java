package bridge.controller;

import bridge.model.BridgeState;
import bridge.view.Constants;
import bridge.view.OutputMessage;

public class OutputController {

    public String getUpper() {
        upperFix();
        return BridgeState.upper;
    }

    public String getLower() {
        lowerFix();
        return BridgeState.lower;
    }

    public void upperFix() {
        BridgeState.upper = BridgeState.upper.replace(OutputMessage.END.getOutputMsg(),OutputMessage.BAR.getOutputMsg());
        BridgeState.upper = BridgeState.upper.substring(Constants.ZERO, BridgeState.upper.length()-1);
        BridgeState.upper += OutputMessage.END.getOutputMsg();
    }

    public void lowerFix() {
        BridgeState.lower = BridgeState.lower.replace(OutputMessage.END.getOutputMsg(),OutputMessage.BAR.getOutputMsg());
        BridgeState.lower = BridgeState.lower.substring(Constants.ZERO, BridgeState.lower.length()-Constants.ONE);
        BridgeState.lower += OutputMessage.END.getOutputMsg();
    }

}
