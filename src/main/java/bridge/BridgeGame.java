package bridge;

import java.util.*;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    static List<String> currentUpState = new ArrayList<>();
    static List<String> currentDownState = new ArrayList<>();

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String move(List<String> bridge, int index, String moveBrdige) {
        if(bridge.get(index).equals(moveBrdige))
            return "O";
        return "X";
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(String gameCommand) {
        if(gameCommand.equals("R")){
            currentUpState.clear();
            currentDownState.clear();
        }
    }

    public void playing(List<String>bridge,String upDown,int i){
        if(upDown.equals("U")){
            updateUpState(bridge,upDown,i);
        }
        if(upDown.equals("D")){
            updateDownState(bridge,upDown,i);
        }
    }
    public void updateUpState(List<String>bridge,String upDown,int i){
        currentUpState.add(move(bridge,i,upDown));
        currentDownState.add(" ");
    }

    public void updateDownState(List<String>bridge,String upDown,int i){
        currentUpState.add(" ");
        currentDownState.add(move(bridge,i,upDown));
    }

    public List<String> getCurrentUpState(){
        return currentUpState;
    }

    public List<String> getCurrentDownState(){
        return currentDownState;
    }

    public boolean success(List<String> bridge){
        if(bridge.size()==currentDownState.size()){
            if(!currentUpState.contains("X")&&!currentDownState.contains("X"))
                return true;
        }
        return false;
    }

    public boolean fail(int i){
        if(currentUpState.get(i).equals("X")||currentDownState.get(i).equals("X"))
            return true;
        return false;
    }
}
