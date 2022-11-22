package bridge;

import bridge.domain.User;
import bridge.domain.Bridge;
import bridge.service.BridgeService;
import bridge.service.ViewService;

public class BridgeController {
    private static final String RETRY = "R";
    private static final String QUIT = "Q";
    private final BridgeService bridgeService = new BridgeService();
    private final ViewService viewService = new ViewService();

    public void start(){
        showStartMessage();
        Bridge bridge=bridgeService.bridgeMaker();
        User user = new User();
        play(user, bridge);
    }

    public void showStartMessage(){
        viewService.printGameStart();
    }

    public void play(User user, Bridge bridge){
        while (!user.isGameDone()) {
            String movement = viewService.requestMovement();
            boolean isCorrect = bridge.isCorrectMovement(movement);
            viewService.printMap(bridge.getCurrentBlock(), movement, isCorrect);
            process(bridge, user, isCorrect);
        }
        viewService.printResult(user);
    }

    public void process(Bridge bridge, User user, boolean isCorrect){
        if (!isCorrect) {
            String status = viewService.requestDecision();
            processFailure(bridge, user, status);
            return;
        }
        processSuccess(bridge, user);
    }

    public void processFailure(Bridge bridge, User user, String status){
        if (status.equals(RETRY)) {
            viewService.initMap();
            user.retry();
            bridge.retry();
        }
        if (status.equals(QUIT)) {
            user.loseGame();
        }
    }

    public void processSuccess(Bridge bridge, User user){
        if (bridge.isLastBlock()) {
            user.winGame();
            return;
        }
        bridge.move();
    }
}
