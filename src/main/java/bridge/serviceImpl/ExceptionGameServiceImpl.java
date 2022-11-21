package bridge.serviceImpl;

import bridge.service.GameService;

public class ExceptionGameServiceImpl implements GameService {

    private GameService gameService;

    public ExceptionGameServiceImpl(GameService gameService) {
        this.gameService = gameService;
    }

    @Override
    public void startGame() {
        try {
            gameService.startGame();
        } catch (IllegalArgumentException e) {
            System.out.print(e.getMessage());
        }
    }
}
