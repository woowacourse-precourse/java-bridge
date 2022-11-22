package bridge;

import domain.Bridge;

public class MainController {

    private static final InputView input = new InputView();
    private static final OutputView output = new OutputView();
    public static final int RESET = -1;

    /**
     * 게임 성공여부 에러
     * 게임 시도 횟수 에러
     */
    public void run() {
        try {
            Bridge bridge = new Bridge(input.readBridgeSize());
            BridgeGame game = new BridgeGame(bridge);
            mainGame(bridge, game);
            output.printResult(game, game.getGameCount());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void mainGame(Bridge bridge, BridgeGame game) {
        for(int count = 0; count < bridge.size(); count++) {
            game.move(count, input.readMoving());
            output.printMap(game);
            if(game.isWrong()) {
                if(!game.retry(input.readGameCommand())){ break; }
                game.plusGameCount();
                count = RESET;
            }
        }
    }

}