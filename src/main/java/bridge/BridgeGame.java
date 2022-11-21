package bridge;

import java.util.*;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void move(int bridge_size) {
        Map<String, String> mineMap = new HashMap<String, String>() {
            {
                put("U", "1");
                put("D", "0");
            }

        };
        String blank;
        int bridge_index=0;
        boolean check = true;
        List<Integer> list =  new ArrayList();
        List<String> list2 =  new ArrayList();
        List<String> bridge=BridgeMaker.makeBridge(bridge_size);
        System.out.println(bridge);
        while (check==true){
            blank=InputView.readMoving();
            if(Objects.equals(bridge.get(bridge_index), blank)){

                list.add(1);
                list2.add(blank);
                bridge_index+=1;
                OutputView.printMap(list,list2,bridge_index);
                continue;
            }
            check=false;
            list.add(0);
            list2.add(blank);
            bridge_index+=1;
            OutputView.printMap(list,list2,bridge_index);

        }

    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static boolean retry() {
        String retry;
        retry=InputView.readGameCommand();
        if(!retry.equals("R")){
            OutputView.printResult();
            return false;}
        if(retry.equals("R")){
            return true;
        }
        return true;

    }
}
