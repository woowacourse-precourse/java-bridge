package bridge;

import bridge.domain.BridgeGame;

import java.util.List;

import static bridge.view.InputView.*;
import static bridge.view.OutputView.*;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            printGameStart();
            boolean run = true;
            int count = 0;

            while(run) {
                String status = "성공";
                int size = readBridgeSize();
                BridgeRandomNumberGenerator generator = new BridgeRandomNumberGenerator();
                BridgeMaker maker = new BridgeMaker(generator);
                List<String> bridge = maker.makeBridge(size);

                BridgeGame game = new BridgeGame();
                game.clear();

                int idx = 0;
                while(idx < size) {
                    String input = readMoving();

                    game.move(bridge, idx, input);

                    printMap(game.getUpBridge(), game.getDownBridge());

                    // check
                    if(game.isGameOver(bridge, idx, input)) {
                        status = "실패";
                        break;
                    }

                    idx++;
                }

                count++;

                if(status.equals("성공")) {
                    printResult(game.getUpBridge(), game.getDownBridge(), status, count);
                    break;
                }

                // 게임 종료
                run = BridgeGame.retry(readGameCommand());

                if(!run) {
                    printResult(game.getUpBridge(), game.getDownBridge(), status, count);
                }
            }
        } catch(IllegalArgumentException e) {
            System.out.println(e);
        }
    }
}
