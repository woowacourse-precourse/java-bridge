package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private List<String> userBridge= new ArrayList<>();
    public List<String> upBridge;
    public List<String> downBridge;
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String input) {
        upBridge = new ArrayList<>();
        downBridge = new ArrayList<>();
        userBridge.add(input);
        return validateMove(userBridge,Controller.answerBridge);
    }

    private boolean validateMove(List<String> userBridge, List<String> answerBridge){
        for(int i=0; i<userBridge.size(); i++){
            if(!userBridge.get(i).equals(answerBridge.get(i))){
                validateMoveAddX(i);
                return false;
            }
            validateMoveAddO(i);
        }
        return true;
    }
    private void validateMoveAddX(int index){
        if(userBridge.get(index).equals("U")){
            upBridge.add("X");
            downBridge.add(" ");
        }
        else if(userBridge.get(index).equals("D")){
            upBridge.add(" ");
            downBridge.add("X");
        }
    }
    private void validateMoveAddO(int index){
        if(userBridge.get(index).equals("U")){
            upBridge.add("O");
            downBridge.add(" ");
        }
        else if(userBridge.get(index).equals("D")){
            upBridge.add(" ");
            downBridge.add("O");
        }
    }
    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(boolean isSuccess) {
        return isSuccess;
    }

}
