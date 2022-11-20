package bridge;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private static BridgeRandomNumberGenerator bridgeRandomNumberGenerator;
    private static BridgeMaker bridgeMaker;
    private static BridgeSizeInputException bridgeSizeInputException;

    public Controller() {
        bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
    }

    public void startGame() {
        try {
            int count = 0;
            boolean game = true;
            InputView inputView = new InputView();
            int bridgeSize = inputView.readBridgeSize();

            List<String> test = new ArrayList<>();

            test = bridgeMaker.makeBridge(bridgeSize);
            for (String s : test) {
                System.out.print(s + " ");
            }
            System.out.println();




            BridgeGame bridgeGame = new BridgeGame();
            while (game) {
                String moving = inputView.readMoving();
                game = bridgeGame.move(test, moving, count);

                count++;

                if (game == false && count == 3) {
                    System.out.println("다시 시작하시겠습니까?");
                    System.out.println("Yes");
                    game = true;
                    count = 0;
                } else if (game == true && count == 3) {
                    System.out.println("게임 종료");
                    game = false;
                }
            }


        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
