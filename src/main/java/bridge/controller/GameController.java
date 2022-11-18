package bridge.controller;

import bridge.domain.MatchResult;
import bridge.dto.BridgeDto;
import bridge.service.GameService;
import bridge.service.ViewService;
import bridge.view.InputView;
import bridge.view.OutputView;

public class GameController {
    private final ViewService viewService;
    private final GameService gameService;

    public GameController() {
        this.viewService = new ViewService(new InputView(), new OutputView());
        this.gameService = GameService.createNewGame(viewService);
    }

    public GameController(ViewService viewService, GameService gameService) {
        this.viewService = viewService;
        this.gameService = gameService;
    }

    public void run() {
        MatchResult matchResult;
        do {
            matchResult = chooseMovement();
        } while (matchResult.equals(MatchResult.SUCCESS));
        viewService.askReGame();
    }

    private MatchResult chooseMovement() {
        String movement = viewService.askMovement();
        MatchResult recentResult = gameService.moveForward(movement);
        BridgeDto dto = gameService.getMyBridgeToPrint(recentResult);
        viewService.printBridge(dto);
        return recentResult;
    }

//    private GameResult chooseReGame() {
//
//    }
}
