package bridge.view.bridge;

import static bridge.domain.bridge.BridgeLocation.initBridgeLocation;
import static bridge.util.StringBufferUtility.popLastCharacter;
import static bridge.value.BridgeLineCharacter.BRIDGE_SEPARATOR;
import static bridge.value.BridgeLineCharacter.END_LINE;
import static bridge.value.BridgeLineCharacter.START_LINE;
import static bridge.value.BridgeLineCharacter.characterFor;

import bridge.domain.bridge.BridgeAndPasser;
import bridge.domain.bridge.BridgeLocation;
import bridge.value.BridgeCharacter;
import java.util.List;

public class BridgeLineView {

    protected final List<BridgeCharacter> bridgeCharacters;

    protected final BridgeLocation endLocation;
    protected final BridgeCharacter lineCharacter;

    protected final StringBuffer renderBuffer;

    public BridgeLineView(BridgeAndPasser bridgeAndPasser, BridgeCharacter lineCharacter) {
        this.bridgeCharacters = bridgeAndPasser.getBridge().characters();

        this.endLocation = bridgeAndPasser.getBridgePasser().getLocation();
        this.lineCharacter = lineCharacter;

        this.renderBuffer = new StringBuffer();
    }

    public static BridgeLineView makeBridgeLineView(BridgeAndPasser bridgeAndPasser, BridgeCharacter lineCharacter) {
        return new BridgeLineView(bridgeAndPasser, lineCharacter);
    }

    public String renderLine() {
        addStartCharacter();
        fillBridge();
        addEndCharacter();

        return renderBuffer.toString();
    }

    protected void fillBridge() {
        BridgeLocation currLocation = initBridgeLocation();

        fillSquares(currLocation);
        popLastCharacter(renderBuffer);
    }

    protected void fillSquares(BridgeLocation currLocation) {

        while (!currLocation.equals(endLocation)) {
            fillSquare(currLocation);

            currLocation = currLocation.next();
        }
    }

    private void fillSquare(BridgeLocation currLocation) {
        renderBuffer.append(squareCharacter(currLocation));
        addSeparator();
    }

    protected void addSeparator() {
        renderBuffer.append(BRIDGE_SEPARATOR.getCharacter());
    }

    protected void addEndCharacter() {
        renderBuffer.append(END_LINE.getCharacter());
    }

    protected void addStartCharacter() {
        renderBuffer.append(START_LINE.getCharacter());
    }

    protected String squareCharacter(BridgeLocation currLocation) {
        return characterFor(lineCharacter, bridgeCharacters.get(currLocation.value())).getCharacter();
    }
}
