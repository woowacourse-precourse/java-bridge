package controller;

import model.Bridge;
import model.GameResult;
import model.MovingResult;
import model.User;
import view.InputView;
import view.OutputView;

public class Service {
    private User user;
    private MovingResult movingResult;
    private GameResult gameResult;

    private OutputView outputView;
    public Service(){
        user = new User();
        movingResult = new MovingResult();
        gameResult = new GameResult();
        outputView = new OutputView();
    }

    public void enterResult(String resultMoving) {
        if (user.getCurrentMoving().equals("U")) {
            movingResult.addUpResult(resultMoving);
            movingResult.addDownResult(" ");
        }
        if (user.getCurrentMoving().equals("D")) {
            movingResult.addDownResult(resultMoving);
            movingResult.addUpResult(" ");
        }
    }

    public void enterMoving(String moving){
        user.setCurrentMoving(moving);
        user.addMovingRoute(moving);
    }

    public void showMoving(){
        outputView.printMap(movingResult);
    }

    public String compareBridge(Bridge bridge) {
        int currentLocation = user.sizeMovingRoute();
        if (user.getCurrentMoving().equals(bridge.getAnswer(currentLocation))) {
            return "O";
        }
        return "X";
    }

    public boolean checkRetry (String retry) {
        if (retry.equals("Q")){
            outputView.printResult(gameResult,movingResult);
            return true;
        }
        user.clearUser();
        movingResult.clearResult();
        gameResult.addRetry();
        return false;
    }

    public boolean checkSuccess(Bridge bridge){
        if(user.sizeMovingRoute() == bridge.sizeBridge() && compareBridge(bridge).equals("O"))
        {
            gameResult.setSuccess(true);
            outputView.printResult(gameResult,movingResult);
            return true;
        }
        return false;
    }
}
