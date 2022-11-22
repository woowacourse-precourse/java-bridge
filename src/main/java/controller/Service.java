package controller;

import model.Bridge;
import model.GameResult;
import model.MovingResult;
import model.User;
import view.OutputView;

public class Service {

    public static final String CORRECT = "O";
    public static final String WRONG = "X";
    private static final String UP = "U";
    private static final String DOWN = "D";

    private static final String QUIT = "Q";


    private User user;
    private MovingResult movingResult;
    private GameResult gameResult;

    private OutputView outputView;

    public Service() {
        user = new User();
        movingResult = new MovingResult();
        gameResult = new GameResult();
        outputView = new OutputView();
    }

    public void enterResult(String resultMoving) {
        if (user.getCurrentMoving().equals(UP)) {
            movingResult.addUpResult(resultMoving);
            movingResult.addDownResult(" ");
        }
        if (user.getCurrentMoving().equals(DOWN)) {
            movingResult.addDownResult(resultMoving);
            movingResult.addUpResult(" ");
        }
    }

    public void enterMoving(String moving) {
        user.setCurrentMoving(moving);
        user.addMovingRoute(moving);
    }

    public void showMoving() {
        outputView.printMap(movingResult);
    }

    public String compareBridge(Bridge bridge) {
        int currentLocation = user.sizeMovingRoute();
        if (user.getCurrentMoving().equals(bridge.getAnswer(currentLocation))) {
            return CORRECT;
        }
        return WRONG;
    }

    public boolean checkRetry(String retry) {
        if (retry.equals(QUIT)) {
            outputView.printResult(gameResult, movingResult);
            return true;
        }
        user.clearUser();
        movingResult.clearResult();
        gameResult.addRetry();
        return false;
    }

    public boolean checkSuccess(Bridge bridge) {
        if (user.sizeMovingRoute() == bridge.sizeBridge() && compareBridge(bridge).equals(CORRECT)) {
            gameResult.setSuccess(true);
            outputView.printResult(gameResult, movingResult);
            return true;
        }
        return false;
    }
}
