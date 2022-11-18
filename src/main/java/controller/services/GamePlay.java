package controller.services;

import bridge.constants.CommandTable;
import model.Bridge;
import model.RouteMap;
import model.User;
import view.InputView;
import view.OutputView;

import java.util.List;

public class GamePlay {
    private Bridge bridge;
    private User user;
    private BridgeGame bridgeGame;
    private RouteMap routeMap;
    private int countOfAttempt=0;

    public GamePlay(List<String> bridgeMap){
        bridge = new Bridge(bridgeMap);
    }

    public int repeatGame() {
        for (; ; ) {
            countOfAttempt++;
            user = new User();
            int result = playGame();

            if (result != CommandTable.RETRY.getCommandNumber()) {
                return result;
            }
        }
    }

    private int playGame() {
        bridgeGame = new BridgeGame(bridge, user);

        for (int loop = 0; loop < bridge.getBridgeSize(); loop++) {
            if (tryMoving()) {
                return bridgeGame.retry(InputView.readGameCommand());
            }
        }
        return CommandTable.SUCCESS.getCommandNumber();
    }

    private boolean tryMoving(){
        boolean accessibleDirection = bridgeGame.move(InputView.readMoving());
        routeMap = new RouteMap(user.getUserMap());

        OutputView.printMap(routeMap.getRouteMap());
        return accessibleDirection;
    }

    public int getCountOfAttempt() {
        return countOfAttempt;
    }

    public RouteMap getRouteMap() {
        return routeMap;
    }
}
