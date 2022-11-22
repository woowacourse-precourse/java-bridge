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

    private int retryCount; //재시작 수

    public void init(int size){
        success = true;
        user = new User();
        bridge = new Bridge();
        upBridge = new ArrayList<>();
        downBridge = new ArrayList<>();
        user.init();
        bridge.init();
        bridge.setBridge(size);
        retryCount=1;
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

    /**
     * 입력값을 받아서 일치하는 쪽에 O 더하기
     */
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


    /**
     * 입력값을 받아서 일치 하지 않는 쪽에 X 더하기
     */
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
            retryCount++;
        }
    }


    /**
     * 최종 결과 출력 메서드
     */
    public Map<String,List<String>> getResult(){
        Map<String,List<String>> resultBridge = new HashMap<>();
        resultBridge.put("up",upBridge);
        resultBridge.put("down",downBridge);
        return resultBridge;
    }

    public boolean getSuccess(){
        return success;
    }

    public int getRetryCount(){
        return retryCount;
    }
}
