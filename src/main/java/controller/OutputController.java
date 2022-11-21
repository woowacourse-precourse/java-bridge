package controller;

import model.BridgeState;
import view.OutputMessage;

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
        BridgeState.upper = BridgeState.upper.substring(0, BridgeState.upper.length()-1);
        BridgeState.upper += OutputMessage.END.getOutputMsg();
    }

    public void lowerFix() {
        BridgeState.lower = BridgeState.lower.replace(OutputMessage.END.getOutputMsg(),OutputMessage.BAR.getOutputMsg());
        BridgeState.lower = BridgeState.lower.substring(0, BridgeState.lower.length()-1);
        BridgeState.lower += OutputMessage.END.getOutputMsg();
    }

}
