package bridge.game;

import bridge.Application;
import bridge.control.InputView;
import bridge.control.OutputView;
import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final List<String> current = new ArrayList<>();
    private int bridge_construction_time = 0;
    private int game_time = 1;
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    private final int bridge_length;
    public BridgeGame(int bridge_length){
        this.bridge_length = bridge_length;
    }
    public boolean move(String way) {
        if(Application.bridge.get(bridge_construction_time).equals(way)){
            current.add(way);
            bridge_construction_time++;
            new OutputView().printMap(current);
            return move_check();
        }
        current.add(way + "_X");
        new OutputView().printMap(current);
        return move_check();
    }
    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    private boolean move_check() {
        if(bridge_construction_time == bridge_length){
            new OutputView().printResult(current, game_time, "성공");
            return false;
        }
        int last_index = current.size() - 1;
        if(current.get(last_index).equals("U_X") || current.get(last_index).equals("D_X")){
            return more_stop();
        }
        return true;
    }
    private boolean more_stop(){
        new InputView().readGameCommand();
        if(InputView.input_GameCommand.equals("R")){
            bridge_construction_time = 0;
            game_time++;
            current.clear();
            return true;
        }
        new OutputView().printResult(current, game_time, "실패");
        return false;
    }
}
