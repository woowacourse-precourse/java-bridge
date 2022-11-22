package bridge.serviceImpl;

import bridge.service.GameService;
import bridge.util.message.SystemMessage;

public class ExceptionGameServiceImpl implements GameService {

    private final GameService gameService;

    public ExceptionGameServiceImpl(GameService gameService) {
        this.gameService = gameService;
    }

    @Override
    public void startGame() {
        try {
            gameService.startGame();
        } catch (StackOverflowError e) {
            System.out.print(SystemMessage.TOO_MUCH_RTY);
        }
    }
}
