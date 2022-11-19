package bridge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    public List<String> upBridge = new ArrayList<>(List.of("[ ", " ]"));
    public List<String> downBridge = new ArrayList<>(List.of("[ ", " ]"));
    public int count = 1;
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String bridge, String user) {
        if (user.equals("U")) {uplist(bridge, user);}
        downlist(bridge, user);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public int retry(int bridgeSize, int i, String user) {
        if (user.equals("Q")){
            upBridge.remove(upBridge.size()-1);
            downBridge.remove(upBridge.size()-1);
            return bridgeSize;}
        upBridge = new ArrayList<>(List.of("[ ", " ]"));
        downBridge = new ArrayList<>(List.of("[ ", " ]"));
        count += 1;
        return -1;
    }

    public void uplist(String bridge, String user){
        if (user.equals(bridge)){
            upBridge.add(upBridge.size()-1, "O");
            downBridge.add(downBridge.size()-1, " ");
        }
        if (!user.equals(bridge)){
            upBridge.add(upBridge.size()-1, "X");
            downBridge.add(downBridge.size()-1, " ");
        }
    }
    public void downlist(String bridge, String user){
        if (user.equals(bridge)){
            downBridge.add(downBridge.size()-1, "O");
            upBridge.add(upBridge.size()-1, " ");
        }
        if (!user.equals(bridge)){
            downBridge.add(downBridge.size()-1, "X");
            upBridge.add(upBridge.size()-1, " ");
        }
    }

    public void midStick(){
        upBridge.add(upBridge.size()-1, " | ");
        downBridge.add(downBridge.size()-1, " | ");

    }

    public void gameStart(List<String> bridge){
        for(int i=0 ; i<bridge.size() ; i++){
            move(bridge.get(i), InputView.readMoving());
            OutputView.printMap(upBridge, downBridge);
            if (i != bridge.size() - 1 ){ midStick();}
            if (upBridge.contains("X") || downBridge.contains("X")) {i = retry(bridge.size(), i, InputView.readGameCommand());}
        }
        OutputView.printResult(upBridge, downBridge);
    }

    public int gameCount() {return count;}

}
