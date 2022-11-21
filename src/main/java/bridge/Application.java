package bridge;

import bridge.control.InputView;
import bridge.game.BridgeGame;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static List<String> bridge = new ArrayList<>();
    public static String input_move;
    public static boolean go_stop = true;
    public static void main(String[] args) {
        InputView new_input_view = new InputView();
        new_input_view.readBridgeSize();
        if(new_input_view.input_bridge_length > 2) {
            BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
            BridgeMaker bridgemaker = new BridgeMaker(bridgeRandomNumberGenerator);
            bridge = bridgemaker.makeBridge(new_input_view.input_bridge_length);
            BridgeGame new_bridge_game = new bridge.game.BridgeGame();
            while (go_stop) {
                input_move = new_input_view.readMoving();
                go_stop = new_bridge_game.move(input_move);
            }
        }
    }
}
