package bridge;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    public static int count=0;
    public  int round_count=1;
    private BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();

    private BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    private BridgeGame bridgeGame = new BridgeGame();
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private List<String> bridge = new ArrayList<>();

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

    public void start() {
            String get=RetryorExit();
            if (get.equals("playing")) {
                count = 0;
                round_count++;
                return;
            }
            outputView().printMap();
            count++;

    }
    public String RetryorExit() {
        String position = inputView().readMoving();
        if (BridgeGame().move(position, Bridge(), count).equals("call")) {
            return BridgeGame().retry(inputView().readGameCommand());
        }
        return "End";
    }

    public void total_print(){
        if (BridgeGame.game_status.equals("End")) {
            outputView().printResult(round_count, "실패");
        }
        if (Bridge().size() == count) {
            outputView().printResult(round_count, "성공");
        }
    }

}
