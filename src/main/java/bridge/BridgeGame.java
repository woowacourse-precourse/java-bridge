package bridge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private User user;
    private Bridge bridge;

    private List<String> upBridge; //사용자가 입력 할 때마다 위에 있는 다리 표시
    private List<String> downBridge; //사용자가 입력 할 떄마다 아래에 있는 다리 표시

    private boolean success;  //성공 여부

    public void init(int size){
        success = true;
        upBridge = new ArrayList<>();
        downBridge = new ArrayList<>();
        user.init();
        bridge.init();
        bridge.setBridge(size);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public Map<String, List<String>> move(String input) {
        Map<String,List<String>> totalBridge = new HashMap<>();
        user.setUserBridge(input);
        int indexinput = user.getUserBridge().size();
        String bridgeinput = bridge.getBridge().get(indexinput-1);
        checkEqual(input,bridgeinput);
        checkNoEqual(input,bridgeinput);
        totalBridge.put("up",upBridge);
        totalBridge.put("down",downBridge);
        return totalBridge;
    }
    private void checkEqual(String input ,String bridgeInput){
        if(input.equals(bridgeInput)){
            if(input.equals("U")){
                upBridge.add("O");
                downBridge.add(" ");
            }
            if(input.equals("D")){
                upBridge.add(" ");
                downBridge.add("O");
            }
        }
    }

    private void checkNoEqual(String input ,String bridgeInput){
        if(!input.equals(bridgeInput)){
            if(input.equals("U")){
                upBridge.add("X");
                downBridge.add(" ");
            }
            if(input.equals("D")){
                upBridge.add(" ");
                downBridge.add("X");
            }
            success =false;
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(String input) {
        if(input.equals("R")){
            success = true;
            upBridge = new ArrayList<>();
            downBridge = new ArrayList<>();
            user.init();
        }
    }

    public boolean getSuccess(){
        return success;
    }
}
