package bridge;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final String UP_BRIDGN_SIGN = "U";
    private final String EMPTY_SIGN = " ";
    private List<String> upBridge;
    private List<String> downBridge;
    private int moveCount;
    public int gameCount;
    public boolean gameStatus;

    BridgeGame(){
        upBridge = new ArrayList<>();
        downBridge = new ArrayList<>();
        moveCount = 0;
        gameCount = 1;
        gameStatus = false;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(List<String> answerBrige, String userCommand) {
        boolean isChecked = userCommand.equals(answerBrige.get(moveCount));
        checkUserCommand(isChecked,userCommand);
        moveCount++;
        return isChecked;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        upBridge.clear();
        downBridge.clear();
        moveCount = 0;
        gameCount +=1;
    }

    public boolean compareMoveCount(int brideSize){
        if(moveCount == brideSize){
            gameStatus = true;
            return true;
        }
        return false;
    }

    public void checkUserCommand(boolean isChecked,String userCommand){
        String input = InputBridgeElement.inputLetterChecked(isChecked);
        if (userCommand.equals(UP_BRIDGN_SIGN)){
            upBridge.add(input);
            downBridge.add(EMPTY_SIGN);
            return;
        }
        upBridge.add(EMPTY_SIGN);
        downBridge.add(input);
    }

    public String getBridgeToString(){
        StringBuilder bridgeToString = new StringBuilder();
        String printUpBridge = upBridge.stream()
                .collect(Collectors.joining(" | ","[ "," ]"));
        String printDownBridge = downBridge.stream()
                .collect(Collectors.joining(" | ","[ "," ]"));
        bridgeToString.append(printUpBridge).append("\n").append(printDownBridge).append("\n");
        return bridgeToString.toString();
    }
}
