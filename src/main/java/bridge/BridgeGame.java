package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    Application app = new Application();
    int size;
    int count=0;
    List<String> bridge_input = new ArrayList<>();
    List<String> finishedBridge;
    String[] Bridge_out;


    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String userInputUD) {
        bridge_input.add(userInputUD);
        int num = bridge_input.size() - 1;
        String bridge_now = finishedBridge.get(num); //만들어진 다리
        String input_now = bridge_input.get(num); //사용자 입력
        boolean same =  input_now.equals(bridge_now);
        Bridge_out =  app.printMap(bridge_input,userInputUD,same);
        return same;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        String retry_choice =  app.askToRetry();
        if(retry_choice.equals("R")) clearUserInput();
        if(retry_choice.equals("Q")){
            app.printResult(Bridge_out,false,count);
        }
    }

}
