package bridge;

import java.util.ArrayList;
import java.util.List;
/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    InputView input = new InputView();
    OutputView output = new OutputView();
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(List<String> bridge) {
        String user_move;
        ArrayList<String> step = new ArrayList<>();
        for(int i = 0; i < bridge.size(); i++){
            String updown = bridge.get(i);
            user_move = input.readMoving();

            if(!updown.equals(user_move)){
                step.add("fail");
                output.printMap(step,bridge);
                return false;
            }
            step.add("success");
            output.printMap(step, bridge);
        }
        return true;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String command = input.readGameCommand();
        return command.equals("R");
    }
}
