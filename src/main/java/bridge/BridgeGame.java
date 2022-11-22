package bridge;

import controller.Util;
import model.*;
import view.GameMessage;
import view.InputMessage;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private Util util;
    private User user;

    private Bridge bridge;

    private GameResult gameResult;
    private BridgeMaker bridgeMaker;
    private OutputView outputView;
    private InputView inputView;

    public MovingResult movingResult;

    public BridgeGame() {
        util = new Util();
        inputView = new InputView();
        movingResult = new MovingResult();
        user = new User();
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        outputView = new OutputView();
        gameResult = new GameResult();
    }

    public void run() {
        System.out.println(GameMessage.START_MESSAGE);
        int size = util.inputSize(inputView);
        bridge = new Bridge(bridgeMaker.makeBridge(size));
        while(true){
            move();
            outputView.printMap(movingResult);
            if(retry()){
                outputView.printResult(gameResult,movingResult);
                return ;
            }
        }
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
        String moving = util.inputMoving(inputView);
        user.setCurrentMoving(moving);
        user.addMovingRoute(moving);
        enterResult();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry() {
        if (compareBridge().equals("X"))
            if (checkRestart()) {
                user.clearUser();
                movingResult.clearResult();
                return true;
            }
        return false;
    }

    public void enterResult() {
        String resultMoving = compareBridge();
        if(user.getCurrentMoving().equals("U")){
            movingResult.addUpResult(resultMoving);
            movingResult.addDownResult(" ");
        }
        if(user.getCurrentMoving().equals("D")){
            movingResult.addDownResult(resultMoving);
            movingResult.addUpResult(" ");
        }
    }


    private String compareBridge() {
        int currentLocation = user.getMovingRoute().size();
        if (user.getCurrentMoving().equals(bridge.getAnswer(currentLocation))) {
            return "O";
        }
        return "X";
    }

    private boolean checkRestart() {
        String restart = util.inputRestart(inputView);
        if (restart.equals("Q"))
            return false;
        return true;
    }
}
