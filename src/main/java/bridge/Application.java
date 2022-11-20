package bridge;

import bridge.service.GameService;
import bridge.serviceImpl.BridgeGame;
import bridge.serviceImpl.ExceptionGameServiceImpl;

public class Application {

    public static void main(String[] args) {

        GameService gameService = new ExceptionGameServiceImpl(new BridgeGame());
        gameService.startGame();
    }
}
