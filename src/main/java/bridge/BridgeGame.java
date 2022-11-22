package bridge;

import controller.Util;
import model.*;
import view.GameMessage;
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

    public MovingResult movingResult;

    public BridgeGame() {
        util = new Util();
        user = new User(new ArrayList<>());
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        movingResult = new MovingResult(new ArrayList<>());
        outputView = new OutputView();
        gameResult = new GameResult();
    }

    public void run() {
        System.out.println(GameMessage.START_MESSAGE);
        int size = util.inputSize();
        bridge = new Bridge(bridgeMaker.makeBridge(size));
        while(true){
            move();
            enterResult();
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
        String moving = util.inputMoving();
        user.setCurrentMoving(moving);
        user.addMovingRoute(moving);
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
        List<String> currentResult = new ArrayList<>();
        String movingResult = compareBridge();
        currentResult.add(user.getCurrentMoving());
        currentResult.add(movingResult);
        this.movingResult.setCurrentResult(currentResult);
        this.movingResult.addTotalMovingResult(currentResult);
    }

    private String compareBridge() {
        int currentLocation = user.getMovingRoute().size();
        if (user.getCurrentMoving().equals(bridge.getAnswer(currentLocation))) {
            return "O";
        }
        return "X";
    }

    private boolean checkRestart() {
        String restart = util.inputRestart();
        if (restart.equals("Q"))
            return false;
        return true;
    }
}
