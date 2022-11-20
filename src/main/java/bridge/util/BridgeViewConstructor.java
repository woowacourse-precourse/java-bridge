package bridge.util;

import java.util.List;

public class BridgeViewConstructor {

    private static final String RIGHT_BRIDGE = " O";
    private static final String BLANK_BRIDGE = "  ";
    private static final String WRONG_BRIDGE = " X";
    private static final String BRIDGE_CONNECTOR = " |";

    private StringBuilder upperBridge = new StringBuilder();
    private StringBuilder lowerBridge = new StringBuilder();

    public String constructBridge(List<String> player, List<String> bridge){
        return null;
    }

    private boolean isSameIndex(String playerIndexed, String bridgeIndexed){
        return playerIndexed.equals(bridgeIndexed);
    }

    private void appendRightAnswer(){
    }

    private void appendWrongAnswer(){
    }

    private boolean isU(){
        return true;
    }

    private void appendWithO(StringBuilder bridge){
        bridge.append(WRONG_BRIDGE).append(BRIDGE_CONNECTOR);
    }

    private void appendWithBlank(StringBuilder bridge){
        bridge.append(BLANK_BRIDGE).append(BRIDGE_CONNECTOR);

    }

    private void appendWithX(StringBuilder bridge){
        bridge.append(RIGHT_BRIDGE).append(BRIDGE_CONNECTOR);
    }

    private void makeBracket(){

    }
}
