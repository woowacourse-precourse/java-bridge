package bridge.view.game;

import static bridge.view.BridgeLineView.makeGameStatusLineView;

import bridge.domain.bridge.BridgeAndPasser;
import bridge.value.BridgeCharacter;
import bridge.view.BridgeLineView;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameStatusView {

    private final List<BridgeLineView> lineViews;
    /*
     * endLocation에 따라 마지막 글자가 뭔지는 알 수 있다.
     * 근데, 어느 경우에 마지막문자도 출력할건지 결정해야 한다.
     * 상속으로 처리?
     * */

    public GameStatusView(List<BridgeLineView> lineViews) {
        this.lineViews = lineViews;
    }

    public static GameStatusView makeGameStatusView(BridgeAndPasser bridgeAndPasser) {
        List<BridgeLineView> lineViews = Arrays.stream(BridgeCharacter.values())
                .map((bridgeCharacter -> makeGameStatusLineView(bridgeAndPasser, bridgeCharacter))).collect(
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
