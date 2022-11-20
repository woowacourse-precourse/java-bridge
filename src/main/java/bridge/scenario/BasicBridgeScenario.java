package bridge.scenario;

import static bridge.game.BridgeGameStatus.*;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.game.BridgeGame;
import bridge.game.BridgeGameStatus;
import bridge.view.input.InputView;
import bridge.view.output.OutputView;
import java.util.List;

public class BasicBridgeScenario implements BridgeScenario {
    private final InputView input = new InputView();
    private final OutputView output = new OutputView();
    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());


    @Override
    public void play() {
        output.printStart();

        int size = input.readBridgeSize();

        List<String> answer = bridgeMaker.makeBridge(size);
        BridgeGame game = new BridgeGame(answer);

        while (!game.status().equals(FINISH)) {
            // move
            if(game.status().equals(RUNNING)){
                String command = input.readMoving();
                game.move(command);
                List<List<String>> progress = game.progress();
                output.printMap(progress);
            }
            // retry
            if(game.status().equals(STOP)){
                String command = input.readGameCommand();
                if (command.equals("Q")) {
                    break;
                }
                if (!command.equals("R")) {
                    throw new IllegalArgumentException("[ERROR]~~");
                }
                game.retry();
            }
        }

        output.printResult(game.status().text(), game.tryTimes());
    }
}
