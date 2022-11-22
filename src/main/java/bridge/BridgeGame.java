package bridge;


import bridge.Bridge.Bridge;
import bridge.User.User;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    public int retryCount;
    public String successOrNot;

    public Bridge bridge;
    public User user;

    public void startGame(){
        retryCount = 1;
        successOrNot = "실패";

        bridge = new Bridge();
        user = new User();

        duringGame();
        finishGame();
    }

    public void duringGame(){
        while ((user.getTotalInputLength() < bridge.brdigeSize)){
            move(user);

            if (checkGameOver()){
                boolean selectRegame = regameOrNot();
                if(selectRegame){
                    retry();
                }
                if(!selectRegame){
                    gameOver();
                    break;
                }
            }
        }
    }

    public void finishGame(){
        if (checkSucces()){
            successOrNot = "성공";
        }
        gameOver();
    }

    public boolean checkGameOver(){
        if(this.user.correctnessHistory.contains("X")){
            return true;
        }
        return false;
    }

    public boolean regameOrNot(){
        OutputView.printReadCommand();
        String command = InputView.readGameCommand();

        if(command.equals("R") ){
            return true;
        }
        return false;
    }

    public boolean checkSucces(){
        if(!this.user.correctnessHistory.contains("X")){
            return true;
        }
        return false;
    }

    public void gameOver(){
        OutputView.printResult(Bridge.bridgePattern, user.inputHistory, successOrNot, retryCount);
    }
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(User user) {
        user.appendCurrentUserMovingInput();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        user = new User();
        ++retryCount;
    }
}
