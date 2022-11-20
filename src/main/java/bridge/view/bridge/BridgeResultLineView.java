package bridge.view.bridge;

import static bridge.domain.BridgeLocation.initBridgeLocation;
import static bridge.value.BridgeLineCharacter.MOVABLE_SQUARE;
import static bridge.value.BridgeLineCharacter.resultCharacterFor;

import bridge.domain.BridgeLocation;
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
        }
    }

    private BridgeLineCharacter resultSquareCharacter() {
//        if(isSuccess()) {
//            return MOVABLE_SQUARE;
//        }
        return resultCharacterFor(lineCharacter, bridgeCharacters.get(endLocation.value()));
    }

    private boolean isSuccess() {
        return bridgeCharacters.size() == endLocation.value();
    }
}
