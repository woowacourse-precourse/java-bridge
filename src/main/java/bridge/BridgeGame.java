package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    public void GAME_START_MSG(){
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    public boolean IS_MOVE_SAFE(List<String> Bridge_Correct, String Input_History) {
        boolean result = true;
        String LAST_STONE = Bridge_Correct.get(Input_History.length()-1);
        String LAST_JUMP  = Input_History.substring(Input_History.length()-1);
        if (!LAST_STONE.equals(LAST_JUMP)) { result = false; }
        return result;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(List<String> Bridge_Correct, String Input_History) {
        return IS_MOVE_SAFE(Bridge_Correct, Input_History);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String USER_INTENT) {
        if (USER_INTENT.toUpperCase().equals("R")) {
            return true;
        }
        return false;
    }
}
