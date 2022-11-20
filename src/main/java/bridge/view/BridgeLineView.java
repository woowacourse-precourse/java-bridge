package bridge.view;

import static bridge.domain.BridgeLocation.initBridgeLocation;
import static bridge.value.BridgeLineCharacter.BRIDGE_SEPARATOR;
import static bridge.value.BridgeLineCharacter.END_LINE;
import static bridge.value.BridgeLineCharacter.START_LINE;
import static bridge.value.BridgeLineCharacter.characterFor;
import static bridge.value.BridgeLineCharacter.resultCharacterFor;

import bridge.domain.BridgeLocation;
import bridge.domain.bridge.BridgeAndPasser;
import bridge.value.BridgeCharacter;
import java.util.List;

public class BridgeLineView {

    private final List<BridgeCharacter> bridgeCharacters;
    private final BridgeLocation endLocation;
    private final BridgeCharacter lineCharacter;
    private final StringBuffer renderBuffer;

    public BridgeLineView(BridgeAndPasser bridgeAndPasser, BridgeCharacter lineCharacter) {
        this.bridgeCharacters = bridgeAndPasser.getBridge().characters();
        this.endLocation = bridgeAndPasser.getBridgePasser().getLocation();
        this.lineCharacter = lineCharacter;
        this.renderBuffer = new StringBuffer();
    }

    public static BridgeLineView makeGameStatusLineView(BridgeAndPasser bridgeAndPasser, BridgeCharacter lineCharacter) {
        return new BridgeLineView(bridgeAndPasser, lineCharacter);
    }

    public String renderLine() {
        addStartCharacter();
        fillBridge();
        addEndCharacter();

        return renderBuffer.toString();
    }

    private void fillBridge() {

        BridgeLocation currLocation = initBridgeLocation();

        while (!currLocation.equals(endLocation)) {

            renderBuffer.append(squareCharacter(currLocation));
            addSeparator();

            currLocation = currLocation.next();
        }
        if (isResultRendering()) {
            addSeparator();
            renderBuffer.append(resultSquareCharacter());
            return;
        }

        popLastCharacter(renderBuffer);
    }

    private void addSeparator() {
        renderBuffer.append(BRIDGE_SEPARATOR.getCharacter());
    }

    private boolean isResultRendering() {
        return bridgeCharacters.size() == endLocation.value();
    }
    // 라인 = line
// 최근 = curr
// 정답 =
// 3가지가 같아야 함.
    /*
     * Line을 객체로 나누기
     * 입력 시 게임 종료 여부 넣기 종료되었다면? 마지막에 X 아니라면? 마지막도 O. 이전 로직은 동일하게 적용하기.
     * */

    private void addEndCharacter() {
        renderBuffer.append(END_LINE);
    }

    private void addStartCharacter() {
        renderBuffer.append(START_LINE.getCharacter());
    }


    private String resultSquareCharacter() {
        return resultCharacterFor(lineCharacter, bridgeCharacters.get(endLocation.value())).getCharacter();
    }

    private String squareCharacter( BridgeLocation currLocation) {
        return characterFor(lineCharacter, bridgeCharacters.get(currLocation.value())).getCharacter();
    }

    public static void popLastCharacter(StringBuffer stringBuffer) {
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
    }
}
