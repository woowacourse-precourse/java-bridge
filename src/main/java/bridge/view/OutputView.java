package bridge.view;

import bridge.util.BridgeBlock;
import bridge.util.InformationMessage;
import java.util.List;

public class OutputView {

    public void printMap(List<String> movementsInUpBridge, List<String> movementsInDownBridge) {
        printUpBridgeMap(movementsInUpBridge);
        printDownBridgeMap(movementsInDownBridge);
    }

    public void printResultMap(List<String> movementsInUpBridge, List<String> movementsInDownBridge) {
        printEndMessage();
        printMap(movementsInUpBridge, movementsInDownBridge);
    }

    public void printSuccessOrNot(InformationMessage successOrNot) {
        System.out.println(InformationMessage.GAME_IS_SUCCESSFUL.getMessage() + successOrNot.getMessage());
    }

    public void printTrialCount(int trialCount) {
        System.out.println(InformationMessage.TRIAL_COUNT.getMessage() + trialCount);
    }

    private void printUpBridgeMap(List<String> movementsInUpBridge) {
        System.out.println(BridgeBlock.BRIDGE_START.getBlock()
                + String.join(BridgeBlock.BLOCK_DIVISOR.getBlock(), movementsInUpBridge)
                + BridgeBlock.BRIDGE_END.getBlock());
    }

    private void printDownBridgeMap(List<String> movementsInDownBridge) {
        System.out.println(BridgeBlock.BRIDGE_START.getBlock()
                + String.join(BridgeBlock.BLOCK_DIVISOR.getBlock(), movementsInDownBridge)
                + BridgeBlock.BRIDGE_END.getBlock());
    }

    public void printStartMessage() {
        System.out.println(InformationMessage.START.getMessage());
    }

    public void printEndMessage() {
        System.out.println(InformationMessage.END.getMessage());
    }

    public void printBridgeSizeInputMessage() {
        System.out.println(InformationMessage.BRIDGE_LENGTH.getMessage());
    }

    public void printPositionSelectionMessage() {
        System.out.println(InformationMessage.POSITION_SELECTION.getMessage());
    }

    public void printGameCommandSelectionMessage() {
        System.out.println(InformationMessage.GAME_COMMAND_SELECTION.getMessage());
    }
}
