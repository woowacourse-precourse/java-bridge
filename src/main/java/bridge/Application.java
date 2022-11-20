package bridge;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        // 변수 선언
        OutputView output = new OutputView();
        InputView input = new InputView();
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker maker = new BridgeMaker(bridgeNumberGenerator);
        BridgeGame game = new BridgeGame();


        maker.makeBridge(input.readBridgeSize());

        // 다리 위, 아래 리스트
        List<String> up_bridge = new ArrayList<>(InputView.bridge_size);
        List<String> down_bridge = new ArrayList<>(InputView.bridge_size);

        while (BridgeMaker.bridge_index < InputView.bridge_size) {
            String moving = input.readMoving();
            String result = game.move(moving, up_bridge, down_bridge);


            if (result.equals("U")) {
                up_bridge.add(" O ");
                down_bridge.add("   ");
                BridgeMaker.bridge_index++;
                output.printMap(up_bridge, down_bridge);

                if (BridgeMaker.bridge_index == InputView.bridge_size) {
                    output.printResult(up_bridge, down_bridge, 1);
                    break;
                }

            }
            if (result.equals("D")) {
                up_bridge.add("   ");
                down_bridge.add(" O ");
                BridgeMaker.bridge_index++;
                output.printMap(up_bridge, down_bridge);

                if (BridgeMaker.bridge_index == InputView.bridge_size) {
                    output.printResult(up_bridge, down_bridge, 1);
                    break;
                }

            }
            if (result.equals("UX")) {
                up_bridge.add(" X ");
                down_bridge.add("   ");
                BridgeMaker.bridge_index++;
                output.printMap(up_bridge, down_bridge);

                String command = input.readGameCommand();
                if (command.equals("R")) {
                    game.retry(up_bridge,down_bridge);
                }
                if (command.equals("Q")) {
                    output.printResult(up_bridge, down_bridge, 0);
                    break;
                }
            }
            if (result.equals("DX")) {
                up_bridge.add("   ");
                down_bridge.add(" X ");
                BridgeMaker.bridge_index++;
                output.printMap(up_bridge, down_bridge);

                String command = input.readGameCommand();
                if (command.equals("R")) {
                    game.retry(up_bridge,down_bridge);
                    System.out.println(BridgeMaker.bridge_index);
                }
                if (command.equals("Q")) {
                    output.printResult(up_bridge, down_bridge, 0);
                    break;
                }
            }



        }

    }
}
