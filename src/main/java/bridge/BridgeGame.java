package bridge;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    boolean isSuccess = true;
    BridgeNumberGenerator numberGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
    UserMove user = new UserMove();

    public void start() {
        prepare();
        user.increaseMoveCount();
        move();
    }

    public void prepare() {
        OutputView.printStartGame();
        OutputView.printRequireSize();
        String tmpBridgeSize=InputView.readBridgeSize();
        user.setUserBridgeSize(Integer.parseInt(tmpBridgeSize));
        bridgeMaker.startMakeBridge(user.getUserBridgeSize());
    }

    public void move() {
        user.initMove();
        while (user.getMoveCount() < user.getUserBridgeSize() && isSuccess) {
            String userMove=makeUserMove();
            if (!isBridge(userMove, bridgeMaker.getBridge().getBridgeAnswer().get(user.getMoveCount())))
                isSuccess = false;
            user.increaseMoveCount();
        }
        isMeetBridgeEnd();
    }

    public String makeUserMove(){
        String userMove = InputView.readMoving();
        user.moveUser(userMove);
        OutputView.printMap(user.getUserLocation(), bridgeMaker.getBridge().getBridgeAnswer());
        return userMove;
    }

    public void isMeetBridgeEnd(){
        if(!isSuccess){
            askRetry();
            return;
        }
        meetEnd();
    }

    public boolean isBridge(String currentUser, String currentBridge) {
        if (currentUser.equals(currentBridge))
            return true;
        return false;
    }
    
    public void retry() {
        user.increaseTryCount();
        isSuccess = true;
        move();
    }

    public void askRetry() {
        String userRetry = InputView.readGameCommand();
        if (userRetry.equals(Constant.RETRY)) {
            retry();
            return;
        }
        meetEnd();
    }

    public Success isBridgeEnd() {
        if (isSuccess)
            return Success.SUCCESS;
        return Success.FAIL;
    }

    public void meetEnd() {
        OutputView.printResultMap(user, bridgeMaker);
        OutputView.printResult(isBridgeEnd(), user.getTryCount());
    }
}
