package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private List<String> answerBridge;
    private User user;
    private int bridgeLength;
    private int gameTryNumber;

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String userInputValue) {
        user.getUserBridge().add(makeField(userInputValue));
    }

    private Field makeField(String userInputValue){

         if (answerBridge.get(user.getGameCount()).equals(userInputValue)){
             return new Field(userInputValue, true);
        }
         return new Field(userInputValue, false);
    }

    public void fieldValueValidation(String userInputValue){
        if(userInputValue != "U" && userInputValue != "D"){
            throw new IllegalArgumentException("[ERROR] 이동 칸은 U 또는 D만 입력 가능합니다.");
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }

    public void retryValueValidation(String userInputValue) {
        if(userInputValue != "R" && userInputValue != "Q"){
            throw new IllegalArgumentException("[ERROR] 재시작은 R, 종료는 Q를 입력해주세요.");
        }
    }
}
