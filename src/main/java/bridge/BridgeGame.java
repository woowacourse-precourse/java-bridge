package bridge;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private boolean isGameWinningClosed = true;
    private int gameCount;

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static Bridge bridge;

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
        outputView.printResult(bridge,isGameWinningClosed,gameCount);
    }


    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String usersPick) {
        boolean isUsersPickRight = bridge.isSelectedBridgesRight(usersPick);
        bridge.crossBridge(usersPick);

        outputView.printMap(bridge.getAlreadyCrossedBridge(isUsersPickRight));

        return isUsersPickRight || retry();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry() {
        gameCount++;
        isGameWinningClosed = askUserToRetry();
        if(isGameWinningClosed){//retry 할때, 게임을 새로 시작해야 할 때
            bridge.reset();
        }
        return isGameWinningClosed;
    }

    public boolean askUserToRetry(){
        outputView.printRequestStartAgain();
        String requestResult = inputView.readGameCommand();
        return requestResult.equals("R");
    }
}
