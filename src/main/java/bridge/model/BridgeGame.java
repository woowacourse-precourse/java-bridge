package bridge.model;
import bridge.view.Print;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    public static int round;
    private static int challenge = 1;

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
        round++;
    }

    /**
     * 사용자가 선택한 칸이 건널 수 있는 칸인지 확인하는 메서드
     */
    public boolean check(String userInput, List<String> bridge) {
        if(bridge.get(round-1).equals(userInput)){ //선택한 값이 같으면(건널 수 있는 칸 고른 것)
            return true;
        }
        return false;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String userRetryInput, int bridgeSize) {
        round = 0;
        return tryOrNot(userRetryInput, bridgeSize);
    }

    private boolean tryOrNot(String userInput, int bridgeSize) {
        if(userInput.equals("R")){
            challenge++;
            round = 0;
            return true;
        }
        if(userInput.equals("Q")){
            round = bridgeSize;
        }
        return false;
    }

    public void getResult(List<String> mark, List<String> bridge){
        if(mark.size()==bridge.size() && mark.get(bridge.size()-1).equals("O")){
            Print.successResult(challenge);
            return;
        }
        Print.failResult(challenge);
    }












}
