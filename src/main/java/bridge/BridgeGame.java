package bridge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public List<String> move(List<String> bridge, String status, String direction) {
        List<String> result = new ArrayList<>();
        if(direction.equals("U")){
            result = moveUp(bridge, status);
        }
        if(direction.equals("D")){
            result = moveDown(bridge, status);
        }
        return result;
    }


    public List<String> moveUp(List<String> bridge){
        List<String> result = new ArrayList<>();
        if(bridge.get(0).length()<=3){
            result.add(bridge.get(0).substring(0, bridge.get(0).length()-1) + status + "]");
            result.add(bridge.get(1).substring(0, bridge.get(1).length()-1) + " " + "]");
        }
        if(bridge.get(0).length()>3){
            result.add(bridge.get(0).substring(0, bridge.get(0).length()-1) + "|" + status + "]");
            result.add(bridge.get(1).substring(0, bridge.get(1).length()-1) + "|" + " " + "]");
        }
        return result;
    }

    public List<String> moveDown(List<String> bridge){
        List<String> result = new ArrayList<>();
        if(bridge.get(1).length()<=3){
            result.add(bridge.get(0).substring(0,bridge.get(0).length()-1) + " " + "]");
            result.add(bridge.get(1).substring(0,bridge.get(1).length()-1) + status + "]");
        }
        if(bridge.get(1).length()>3){
            result.add(bridge.get(0).substring(0,bridge.get(0).length()-1) + "|" + " " + "]");
            result.add(bridge.get(1).substring(0,bridge.get(1).length()-1) + "|" + status + "]");
        }
        return result;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String input) {
        ExceptionRetry(input);
        if(input.equals("Q")){
            return false;
        }
        return true;
    }

    public void ExceptionRetry(String input){
        if(!input.equals("Q") && !input.equals("R")) {
            throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다");
        }
    }
}
