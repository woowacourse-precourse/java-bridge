package bridge.Controller;

import bridge.Domain.BridgeGame;
import bridge.Domain.BridgeMaker;
import bridge.Domain.BridgeNumberGenerator;
import bridge.View.InputView;
import bridge.View.OutputView;

public class BridgeController {
    static int count_try;
    static int continue_game;

    public BridgeController() {
        OutputView.printStart();
        count_try = 1;
        continue_game = 0;
    }
    public void run(){
        BridgeGame game = new_BridgeGame();

        while (continue_game != 1 && continue_game != 4){
            String moving = InputView.readMoving();
            continue_game = OutputView.printMap(game.move(moving), moving);
            if (continue_game == 3) {
                continue_game = game.retry(InputView.readGameCommand());
            }
            if (continue_game == 3) {
                count_try++;
                OutputView.MapReset();
            }
            if (continue_game != 4)
                continue_game = game.check_over();
        }
        OutputView.printCount(continue_game, count_try);
    }

    private BridgeGame new_BridgeGame(){
        return new BridgeGame(InputView.readBridgeSize());
    }
}
