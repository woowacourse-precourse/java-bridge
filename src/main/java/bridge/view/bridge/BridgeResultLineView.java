package bridge.view.bridge;

import static bridge.domain.bridge.BridgeLocation.initBridgeLocation;
import static bridge.value.BridgeLineCharacter.resultCharacterFor;

import bridge.domain.bridge.BridgeLocation;
import bridge.domain.bridge.BridgeAndPasser;
import bridge.value.BridgeCharacter;
import bridge.value.BridgeLineCharacter;

public class BridgeResultLineView extends BridgeLineView {

    public BridgeResultLineView(BridgeAndPasser bridgeAndPasser, BridgeCharacter lineCharacter) {
        super(bridgeAndPasser, lineCharacter);
    }

    public static BridgeLineView makeBridgeResultLineView(BridgeAndPasser bridgeAndPasser, BridgeCharacter lineCharacter) {
        return new BridgeResultLineView(bridgeAndPasser, lineCharacter);
    }

    public String renderLine() {
        addStartCharacter();
        fillBridge();
        addEndCharacter();
        return renderBuffer.toString();
    }

    @Override
    protected void fillBridge() {
        BridgeLocation currLocation = initBridgeLocation();

        fillSquares(currLocation);
        if(!isSuccess()) {
            renderBuffer.append(resultSquareCharacter().getCharacter());
            return;
        }
        popLastCharacter(renderBuffer);
    }

    private BridgeLineCharacter resultSquareCharacter() {
        return resultCharacterFor(lineCharacter, bridgeCharacters.get(endLocation.value()));
    }

    private boolean isSuccess() {
        return bridgeCharacters.size() == endLocation.value();
    }
}
