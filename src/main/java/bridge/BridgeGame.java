package bridge;

import java.util.ArrayList;
import java.util.List;
/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    OutputView output = new OutputView();
    InputView input = new InputView();
    CheckError check = new CheckError();
    BridgeRandomNumberGenerator Maker = new BridgeRandomNumberGenerator();
    BridgeMaker Bridge = new BridgeMaker(Maker);
    int size;
    List<String> bridge_answer;
    List<String> bridge_input = new ArrayList<>();
    List<Integer> answer_list = new ArrayList<>();

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String choice) {
        bridge_input.add(choice);
        int num = bridge_input.size() - 1;
        boolean same =  bridge_input.get(num).equals(bridge_answer.get(num));
        output.printMap(bridge_input,choice,same);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }

    public void start(){
        output.printStart();
        firstStep();
        bridge_answer =  Bridge.makeBridge(size);
        System.out.println(bridge_answer);
        for(int i=0;i<size;i++) {
            String choice = secondStep();
            move(choice);
        }
    }

    public void firstStep(){
        output.printFirst();
        try {
            size = input.readBridgeSize();
            check.checkBridgeSize(size);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            firstStep();
        }
    }

    public String secondStep(){
        String input_temp = "";
        output.printSecond();
        try {
            input_temp = input.readMoving();
            check.checkChoice(input_temp);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return secondStep();
        }
        return input_temp;
    }
}
