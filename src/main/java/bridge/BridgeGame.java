package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private int retryConut;
    private List<Boolean> gameState; 
    
    private InputView inputView;
    private OutputView outputView;

    private Bridge bridge;
    private User user;

    public BridgeGame(){
        retryConut = 0;
        inputView = new InputView();
        outputView = new OutputView();
    }

    private void updateGameState(String direction){
        if(bridge.getBrideState().get(user.getUserCurrentLocation()) == direction){
            gameState.add(true);
            return;
        }
        gameState.add(false);
    }

    public void gameStart(){
        outputView.printStartMessage();
    }

    public void setBridgeSize(){
        outputView.printInputBridgeSizeMessage();
        int bridgeSize = inputView.readBridgeSize();

        bridge = new Bridge(bridgeSize);
        user = new User(bridgeSize);

        gameState = new ArrayList<>(bridgeSize);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
        outputView.printInputMovingMessage();
        String direction = inputView.readMoving();
        user.move(direction);
        updateGameState(direction);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
