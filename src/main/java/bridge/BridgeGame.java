package bridge;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public class Information {
        Boolean retry = Boolean.TRUE;
        String instruction;
        public Information(String instruction){
            this.instruction = instruction;
        }
    }
    public Information move(int index_bridge, List<String> bridge) {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String instruction = "back";
        while (instruction.equals("back")) {instruction = new InputView().readMoving();}
        OutputView output = new OutputView();
        output.printMap(index_bridge, instruction, bridge);
        Information inf = new Information(instruction);
        if (instruction.equals(bridge.get(index_bridge))){return inf;}
        inf.retry = Boolean.FALSE; // 다르면 다시 해야함 -> False
        return inf;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
