package bridge.util;

import java.util.List;

import static bridge.enums.BridgeType.UPPER;
import static bridge.enums.BridgeViewComponent.*;

public class BridgeViewConstructor {

    private StringBuilder upperBridge = new StringBuilder();
    private StringBuilder lowerBridge = new StringBuilder();

    public String constructBridge(List<String> player, List<String> bridge){
        constructBeforeLast(player);
        constructLast(player, bridge);
        return makeBracket();
    }

    private void constructBeforeLast(List<String> player){
        for(int bridgeEach = 0; bridgeEach < player.size()-1; bridgeEach++){
            appendRightAnswer(player.get(bridgeEach));
        }
    }

    private void constructLast(List<String> player, List<String> bridge){
        if(isSameLast(player, bridge)) {
            appendRightAnswer(getLastIndex(player));
            return;
        }
        appendWrongAnswer(getLastIndex(player));
    }

    private String getLastIndex(List<String> list){
        return list.get(list.size()-1);
    }

    private boolean isSameLast(List<String> player, List<String> bridge){
        return getLastIndex(player).equals(bridge.get(player.size()-1));
    }

    private void appendRightAnswer(String playerIndexed){
        if(isU(playerIndexed)){
            appendWithO(upperBridge);
            appendWithBlank(lowerBridge);
            return;
        }
        appendWithBlank(upperBridge);
        appendWithO(lowerBridge);
    }

    private void appendWrongAnswer(String playerIndexed){
        if(isU(playerIndexed)){
            appendWithX(upperBridge);
            appendWithBlank(lowerBridge);
            return;
        }
        appendWithBlank(upperBridge);
        appendWithX(lowerBridge);
    }

    private boolean isU(String playerIndexed){
        return playerIndexed.equals(UPPER.getCommand());
    }

    private void appendWithO(StringBuilder bridge){
        bridge.append(RIGHT_BRIDGE.getSymbol())
                .append(BRIDGE_CONNECTOR.getSymbol());
    }

    private void appendWithBlank(StringBuilder bridge){
        bridge.append(BLANK_BRIDGE.getSymbol())
                .append(BRIDGE_CONNECTOR.getSymbol());

    }

    private void appendWithX(StringBuilder bridge){
        bridge.append(WRONG_BRIDGE.getSymbol())
                .append(BRIDGE_CONNECTOR.getSymbol());
    }

    private String makeBracket(){
        String upper = BRACKET_STARTED.getSymbol() + deleteLastDivider(upperBridge) + BRACKET_FINISHER.getSymbol();
        String lower = BRACKET_STARTED.getSymbol() + deleteLastDivider(lowerBridge) + BRACKET_FINISHER.getSymbol();
        return upper + LINE_DIVIDER.getSymbol() + lower;
    }

    private String deleteLastDivider(StringBuilder stringBuilder){
        return stringBuilder.substring(0, stringBuilder.toString().length()-2);
    }
}
