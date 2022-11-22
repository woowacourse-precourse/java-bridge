package bridge;

import domain.Bridge;

public class MainController {

    private static final InputView input = new InputView();
    private static final OutputView output = new OutputView();

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
        int count = 0;
        while(bridge.size() > count) {
            String in = input.readMoving();
            game.move(count, in);
            output.printMap(game);
            count++;
            if(game.isWrong()) {
                String command = input.readGameCommand();
                if(!game.retry(command)){
                    break;
                }
                game.plusGameCount();
                count = 0;
            }
        }
    }

}
