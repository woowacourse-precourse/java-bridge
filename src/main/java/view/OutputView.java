package view;

import static util.ConsoleMessage.*;

import bridge.BridgeDirect;
import bridge.BridgeStatus;
import java.util.List;
import model.User;
import model.UserProgress;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String START_BRIDGE="[ ";
    private static final String END_BRIDGE=" ]";
    private static final String DIVIDE_BRIDGE = " | ";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(User user) {
        List<UserProgress> userProgress = user.getUserProgress();

        printStairs(userProgress, BridgeDirect.UP);
        printStairs(userProgress, BridgeDirect.DOWN);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(User user) {
        System.out.println(FINAL_RESULT);
        printMap(user);
        printUser(user);
    }

    private void printUser(User user) {
        System.out.printf(WHETHER_SUCCESS, user.getStatus().getStatus());
        System.out.printf(TOTAL_RETRY_COUNT,user.getRetryCount());
    }

    public void printStartGame(){
        System.out.println(START_BRIDGE_GAME);
    }

    public void printReceiveBridgeSize(){
        System.out.println(RECEIVE_BRIDGE_SIZE);
    }

    public void printError(String message){
        System.out.println(message);
    }
    
    public void printSelectMove(){
        System.out.println(SELECT_MOVE);
    }

    public void printRetry() {
        System.out.println(SELECT_RETRY);
    }




    private void printStairs(List<UserProgress> userProgress, BridgeDirect stairs) {
        System.out.print(START_BRIDGE);
        for (int index = 0; index < userProgress.size(); index++) {
            BridgeDirect userInput = userProgress.get(index).getDirect();
            BridgeStatus userStatus = userProgress.get(index).getStatus();
            printPerStatus(stairs, userInput, userStatus);
            printDivide(userProgress, index);
        }
        System.out.println(END_BRIDGE);
    }

    private void printDivide(List<UserProgress> userProgress, int index) {
        if(index < userProgress.size()-1)
            System.out.print(DIVIDE_BRIDGE);
    }

    private void printPerStatus(BridgeDirect stairs, BridgeDirect userInput, BridgeStatus status) {
        System.out.printf("%s", judgeUserStairs(stairs,userInput,status));
    }

    private String judgeUserStairs(BridgeDirect stairs,BridgeDirect userInput,BridgeStatus status) {
        if (userInput==stairs) {
            return status.getStatus();
        }
        return " ";
    }


}
