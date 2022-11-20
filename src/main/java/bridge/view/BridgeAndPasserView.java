package bridge.view;

import static bridge.domain.BridgeLocation.initBridgeLocation;
import static bridge.value.BridgeCharacter.DOWN;
import static bridge.value.BridgeCharacter.UP;

import bridge.domain.BridgeLocation;
import bridge.domain.bridge.BridgeAndPasser;
import bridge.value.BridgeCharacter;
import java.util.List;

public class BridgeAndPasserView {

    private final List<BridgeCharacter> bridgeCharacters;
    private final BridgeLocation endLocation;

    public BridgeAndPasserView(BridgeAndPasser bridgeAndPasser) {
        this.bridgeCharacters = bridgeAndPasser.getBridge().characters();
        this.endLocation = bridgeAndPasser.getBridgePasser().getLocation();
    }

    public static BridgeAndPasserView makeGameStatusView(BridgeAndPasser bridgeAndPasser) {
        return new BridgeAndPasserView(bridgeAndPasser);
    }

    public String render() {
        StringBuffer stringBuffer = new StringBuffer();

        fillLine(stringBuffer, UP);
        stringBuffer.append(System.lineSeparator());
        fillLine(stringBuffer, DOWN);

        return stringBuffer.toString();
    }

    private void fillLine(StringBuffer stringBuffer, BridgeCharacter currLocationCharacter) {
        BridgeLocation currLocation = initBridgeLocation();

        stringBuffer.append("[");
        while (!currLocation.equals(endLocation)) {
            stringBuffer.append(characterFor(currLocationCharacter, bridgeCharacters, currLocation));
            stringBuffer.append("|");

            currLocation =  currLocation.next();
        }
        popLastCharacter(stringBuffer);
//        if (bridgeCharacters.get(endLocation.value()) == currLocationCharacter) {
//            stringBuffer.append("X");
//        }

        stringBuffer.append("]");
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
