package bridge.view.game;

import static bridge.view.bridge.BridgeLineView.makeBridgeLineView;
import static bridge.view.bridge.BridgeResultLineView.makeBridgeResultLineView;

import bridge.domain.bridge.BridgeAndPasser;
import bridge.value.BridgeCharacter;
import bridge.view.bridge.BridgeLineView;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameStatusView {

    private final List<BridgeLineView> lineViews;

    public GameStatusView(List<BridgeLineView> lineViews) {
        this.lineViews = lineViews;
    }

    public static GameStatusView makeGameStatusView(BridgeAndPasser bridgeAndPasser) {
        List<BridgeLineView> lineViews = Arrays.stream(BridgeCharacter.values())
                .map((bridgeCharacter -> makeBridgeLineView(bridgeAndPasser, bridgeCharacter))).collect(
                        Collectors.toList());
        return new GameStatusView(lineViews);
    }

    public static GameStatusView makeGameResultStatusView(BridgeAndPasser bridgeAndPasser) {
        List<BridgeLineView> lineViews = Arrays.stream(BridgeCharacter.values())
                .map((bridgeCharacter -> makeBridgeResultLineView(bridgeAndPasser, bridgeCharacter))).collect(
                        Collectors.toList());
        return new GameStatusView(lineViews);
    }

    public String renderStatus() {
        StringBuffer stringBuffer = new StringBuffer();

        lineViews.forEach(lineView -> appendLine(stringBuffer, lineView));

        return stringBuffer.toString();
    }

    private static void appendLine(StringBuffer stringBuffer, BridgeLineView lineView) {
        stringBuffer.append(lineView.renderLine());
        stringBuffer.append(System.lineSeparator());
    }

}
