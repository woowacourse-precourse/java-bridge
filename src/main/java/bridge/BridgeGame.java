package bridge;

import java.util.ArrayList;
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

    public List<String> gameStart(int bridgeLength){
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

        List<String> bridge = bridgeMaker.makeBridge(bridgeLength);

        return bridge;

    }

    List<String> bridgeUpList = new ArrayList<>();
    List<String> bridgeDownList = new ArrayList<>();
    boolean success = true;

    public void move(List<String> bridge, String input, int cnt) {
        OutputView outputView = new OutputView();
        List<String> inputList = null;





        List<String> bridgeResultUp = new ArrayList<>();
        List<String> bridgeResultDown = new ArrayList<>();

        System.out.println("bridge:"+bridge);

        bridgeResultUp.add("[");
        for(int i = 0; i < cnt+1; i++){
            if(input.equals(bridge.get(cnt)) && bridge.get(i).equals("U")){     // 입력값, 첫째값 같으면, up
                bridgeResultUp.add("O");
            }
            if(input.equals(bridge.get(cnt)) && bridge.get(i).equals("D")){     // 입력값, 첫째값 같으면, up
                bridgeResultUp.add(" ");
            }
            if(!input.equals(bridge.get(cnt)) && input.equals("U")){     // 다르면 X
                bridgeResultUp.add("X");
            }
            if(i != cnt){
                bridgeResultUp.add("|");
            }

            System.out.println("cnt:"+bridge.get(i));
        }
        bridgeResultUp.add("]");
        System.out.println();

        System.out.println(bridgeResultUp);

        bridgeResultDown.add("[");
        for(int i = 0; i < cnt+1; i++){
            if(input.equals(bridge.get(cnt)) && bridge.get(i).equals("U")){     // 입력값, 첫째값 같으면, up
                bridgeResultDown.add(" ");
            }
            if(input.equals(bridge.get(cnt)) && bridge.get(i).equals("D")){     // 입력값, 첫째값 같으면, up
                bridgeResultDown.add("O");
            }
            if(!input.equals(bridge.get(cnt)) && input.equals("D")){     // 다르면 X
                bridgeResultDown.add(" ");
                success = false;
            }
            if(i != cnt){
                bridgeResultDown.add("|");
            }
        }
        bridgeResultDown.add("]");

        System.out.println(bridgeResultDown);

        if(bridge.size() == cnt+1){
            bridgeUpList = bridgeResultUp;
            bridgeDownList = bridgeResultDown;
        }

        success = true;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public List<String> upList() {
        return this.bridgeUpList;
    }

    public List<String> downList() {
        return this.bridgeDownList;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }



}
