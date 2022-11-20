package bridge.view.game;

import static bridge.domain.BridgeLocation.initBridgeLocation;
import static bridge.value.BridgeCharacter.DOWN;
import static bridge.value.BridgeCharacter.UP;

import bridge.domain.BridgeLocation;
import bridge.domain.bridge.BridgeAndPasser;
import bridge.value.BridgeCharacter;
import java.util.List;

public class GameStatusView {

    private final List<BridgeCharacter> bridgeCharacters;
    private final BridgeLocation endLocation;

    public GameStatusView(BridgeAndPasser bridgeAndPasser) {
        this.bridgeCharacters = bridgeAndPasser.getBridge().characters();
        this.endLocation = bridgeAndPasser.getBridgePasser().getLocation();
    }

    public static GameStatusView makeGameStatusView(BridgeAndPasser bridgeAndPasser) {
        return new GameStatusView(bridgeAndPasser);
    }

    public String renderStatus() {
        StringBuffer stringBuffer = new StringBuffer();

        fillLine(stringBuffer, UP);
        stringBuffer.append(System.lineSeparator());
        fillLine(stringBuffer, DOWN);

        return stringBuffer.toString();
    }

    private void fillLine(StringBuffer stringBuffer, BridgeCharacter currLocationCharacter) {
        BridgeLocation currLocation = initBridgeLocation();

        fillStartCharacter(stringBuffer);
        fillBridge(stringBuffer, currLocationCharacter, currLocation);
//        if (bridgeCharacters.get(endLocation.value()) == currLocationCharacter) {
//            stringBuffer.append("X");
//        }

        fillEndCharacter(stringBuffer);
    }

    private void fillBridge(StringBuffer stringBuffer, BridgeCharacter currLocationCharacter,
                           BridgeLocation currLocation) {
        while (!currLocation.equals(endLocation)) {
            fillBridgeCharacter(stringBuffer, currLocationCharacter, currLocation);
            fillSeparator(stringBuffer);
            currLocation =  currLocation.next();
        }
        popLastCharacter(stringBuffer);
    }

    private void fillBridgeCharacter(StringBuffer stringBuffer, BridgeCharacter currLocationCharacter,
                           BridgeLocation currLocation) {
        stringBuffer.append(characterFor(currLocationCharacter, bridgeCharacters, currLocation));
    }

    private static void fillEndCharacter(StringBuffer stringBuffer) {
        stringBuffer.append("]");
    }

    private static void fillSeparator(StringBuffer stringBuffer) {
        stringBuffer.append("|");
    }

    private static void fillStartCharacter(StringBuffer stringBuffer) {
        stringBuffer.append("[");
    }

    private static void popLastCharacter(StringBuffer stringBuffer) {
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
    }

    private static String characterFor(BridgeCharacter currLocationCharacter, List<BridgeCharacter> bridgeCharacters,
                                       BridgeLocation currLocation) {
        if (bridgeCharacters.get(currLocation.value()) == currLocationCharacter) {
            return " O ";
        }

        return "   ";
    }
}
