package bridge;

import bridge.control.InputView;
import bridge.game.BridgeGame;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static List<String> bridge = new ArrayList<>();
    public static void main(String[] args) {
        InputView new_input_view = new InputView();
        new_input_view.readBridgeSize();
        if(InputView.input_error) {
            BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
            BridgeMaker bridgemaker = new BridgeMaker(bridgeRandomNumberGenerator);
            bridge = bridgemaker.makeBridge(InputView.input_bridge_length);
            BridgeGame new_bridge_game = new bridge.game.BridgeGame();
            while (BridgeGame.go_stop) {
                new_input_view.readMoving();
                new_bridge_game.move(InputView.input_Moving);
                new_bridge_game.retry();
            }
        }
    }
}
