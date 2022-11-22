package bridge;

import bridge.View.InputView;
import bridge.View.OutputView;
import bridge.View.mainView;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    public static int count = 0;
    public static int round_count = 1;

    private BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    private BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    private BridgeGame bridgeGame = new BridgeGame();
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private List<String> bridge = new ArrayList<>();
    private mainView mainView = new mainView(outputView,bridge);

    public void set_bridge(int input) {
        bridge = bridgeMaker.makeBridge(input);
    }

    public List<String> Bridge() {
        return bridge;
    }

    public BridgeGame BridgeGame() {
        return bridgeGame;
    }

    public InputView inputView() {
        return inputView;
    }

    public OutputView outputView() {
        return outputView;
    }


    public void total_print() {
        if (BridgeGame.game_status.equals("End")) {
            outputView().printResult(round_count, "실패");
        }
        if (bridge.size() == count) {
            outputView().printResult(round_count, "성공");
        }
    }

    public void all_print() {
        outputView().printMap();
        count++;
        total_print();
    }



    public String retrycheck() {
        String get = BridgeGame().retry(inputView().readGameCommand());
        if (get.equals("playing")) {
            count = 0;
            round_count++;
            return "continue";
        }
        return "";
    }

    public boolean moveCheck(String position) {
        if (BridgeGame().move(position, bridge, count).equals("call")) {
            if (retrycheck().equals("continue")) {
                return false;
            }
        }
        return true;
    }

    public String start() {
        while (BridgeGame.game_status.equals("playing") && bridge.size() != count) {
            String position = inputView().readMoving();
            if(position.equals("EXIT")) return "EXIT";
            if (!moveCheck(position)) continue;
            all_print();
        }
        return "";
    }
}


