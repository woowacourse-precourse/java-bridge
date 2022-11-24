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
        int size = setSize();
        Bridge bridge = new Bridge(size);
        BridgeGame game = new BridgeGame(bridge);
        mainGame(bridge, game);
        output.printResult(game, game.getGameCount());
    }

    private int setSize() {
        try {
            return input.readBridgeSize();
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return setSize();
        }
    }

    private void mainGame(Bridge bridge, BridgeGame game) {
        for(int count = 0; count < bridge.size(); count++) {
            moving(game, count);
            if(game.isWrong()) {
                if(!game.retry(getGameCommand())){
                    break;
                }
                count = retrySetting(game);
            }
        }
    }

    private String getGameCommand() {
        try {
            return input.readGameCommand();
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return getGameCommand();
        }
    }

    private int retrySetting(BridgeGame game) {
        game.plusGameCount();
        return RESET;
    }

    private void moving(BridgeGame game, int count) {
        try {
            String command = input.readMoving();
            game.move(count, command);
            output.printMap(game);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            moving(game, count);
        }
    }

}