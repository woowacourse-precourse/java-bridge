package bridge;

import java.util.ArrayList;
import java.util.List;
/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    Application app = new Application();
    int size;
    List<String> bridge_answer;
    List<String> bridge_input = new ArrayList<>();
    int count = 0;
    String[] Bridge_out;

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String choice) {
        bridge_input.add(choice);
        int num = bridge_input.size() - 1;
        String bridge_now = bridge_answer.get(num);
        String input_now = bridge_input.get(num);
        boolean same =  input_now.equals(bridge_now);
        Bridge_out =  app.printMap(bridge_input,choice,same);
        return same;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        String retry_choice =  app.thirdStep();
        if(retry_choice.equals("R")) clear_global();
        if(retry_choice.equals("Q")){
            app.printResult(Bridge_out,false,count);
        }
    }
    public void clear_global(){
        bridge_input.clear();
        repeat_input();
    }
    public void start(){
        size = app.firstStep();
        BridgeRandomNumberGenerator Maker = new BridgeRandomNumberGenerator();
        BridgeMaker Bridge = new BridgeMaker(Maker);
        bridge_answer =  Bridge.makeBridge(size);
        repeat_input();
    }

    public void repeat_input(){
        count++;
        boolean answer = true;
        for(int i = 0 ; i < size ; i++) {
            String choice = app.secondStep();
            answer =  move(choice);
            if(!answer) break;
        }
        if(answer) app.printResult(Bridge_out,true,count);
        if(!answer) retry();
    }

}
