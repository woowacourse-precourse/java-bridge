package bridge;

import java.util.ArrayList;
import java.util.List;

interface InstanceCollection {
    OutputView output = new OutputView();
    InputView input = new InputView();
    BridgeGame game = new BridgeGame();
    BridgeMaker maker = new BridgeMaker(new BridgeRandomNumberGenerator());
    List<String> up_bridge = new ArrayList<>(InputView.bridge_size);
    List<String> down_bridge = new ArrayList<>(InputView.bridge_size);
}
public class Application implements InstanceCollection {

    public static void main(String[] args) {
        try {
            maker.makeBridge(input.readBridgeSize());
            while (BridgeMaker.bridge_index < InputView.bridge_size) {
                String result = game.move(input.readMoving(), up_bridge, down_bridge);
                if (result.equals("O") || result.equals("X")){
                    output.printMap(up_bridge, down_bridge);
                    if (isEndingCase(result)) break;
                }
            }
        } catch (IllegalArgumentException e){};
    }

    private static boolean isEndingCase(String result) {
        if (result.equals("O")) {
            if (BridgeMaker.bridge_index == InputView.bridge_size) {
                output.printResult(up_bridge, down_bridge, 1);
                return true;
            }
        }
        if (result.equals("X")) {
            String command = input.readGameCommand();
            if (checkQuit(command)) return true;
        }
        return false;
    }

    private static boolean checkQuit(String command) {
        if (command.equals("R")) {
            game.retry(up_bridge,down_bridge);
        }
        if (command.equals("Q")) {
            output.printResult(up_bridge, down_bridge, 0);
            return true;
        }
        return false;
    }

}
