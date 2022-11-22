package bridge.view.game;

import static bridge.view.bridge.BridgeLineView.makeBridgeLineView;
import static bridge.view.bridge.BridgeResultLineView.makeBridgeResultLineView;

import bridge.domain.bridge.BridgeAndPasser;
import bridge.value.BridgeCharacter;
import bridge.view.bridge.BridgeLineView;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GameStatusView {

    private final List<BridgeLineView> lineViews;

    public GameStatusView(List<BridgeLineView> lineViews) {
        this.lineViews = lineViews;
    }

    public static GameStatusView makeGameStatusView(BridgeAndPasser bridgeAndPasser) {
        return new GameStatusView(fillLines(makeLine(bridgeAndPasser)));
    }

    public static GameStatusView makeGameResultStatusView(BridgeAndPasser bridgeAndPasser) {
        return new GameStatusView(fillLines(makeResultLine(bridgeAndPasser)));
    }

    private static List<BridgeLineView> fillLines(Function<BridgeCharacter, BridgeLineView> makeLineFunction) {
        return Arrays.stream(BridgeCharacter.values()).map(makeLineFunction)
                .collect(Collectors.toList());
    }

    private static Function<BridgeCharacter, BridgeLineView> makeLine(BridgeAndPasser bridgeAndPasser) {
        return bridgeCharacter -> makeBridgeLineView(bridgeAndPasser, bridgeCharacter);
    }

    private static Function<BridgeCharacter, BridgeLineView> makeResultLine(BridgeAndPasser bridgeAndPasser) {
        return bridgeCharacter -> makeBridgeResultLineView(bridgeAndPasser, bridgeCharacter);
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
