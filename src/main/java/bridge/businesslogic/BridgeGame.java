package bridge.businesslogic;

import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.UI.InputView;
import bridge.UI.OutputView;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private Bridge bridge;
    private boolean isGameWinningClosed = true;
    private int gameCount;

    public void initBridgeGame(){
        gameCount = 0;
        int bridgeSize = inputView.readBridgeSize();
        BridgeNumberGenerator numberGenerator = () -> new BridgeRandomNumberGenerator().generate();
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        bridge = new Bridge(bridgeMaker, bridgeSize);
    }

    public void play(){
        while(!bridge.isBridgeAllCrossed()){
            outputView.printRequestHowToMove();
            String usersPick = inputView.readMoving();
            boolean continueGame = move(usersPick);
            if(!continueGame){
                break;
            }
        }
        outputView.printResult(isGameWinningClosed,gameCount);
    }


    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String usersPick) {
        boolean isUsersPickRight = bridge.isSelectedBridgesRight(usersPick);
        String userPickResult = convertUsersPick(isUsersPickRight);
        bridge.crossBridge();

        outputView.printMap(bridge.getAlreadyCrossedBridge(userPickResult));

        return isUsersPickRight || retry();
    }

    private String convertUsersPick(boolean isUsersPickRight){
        if(isUsersPickRight){
            return "Y";
        }
        return "N";
    }


    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry() {
        bridge.dead();
        gameCount++;
        isGameWinningClosed = askUserToRetry();
        return isGameWinningClosed;
    }

    public boolean askUserToRetry(){
        outputView.printRequestStartAgain();
        String requestResult = inputView.readGameCommand();
        return requestResult.equals("R");
    }
}
