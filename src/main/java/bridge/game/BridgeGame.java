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
    public static boolean go_stop = true; // 다음 단계로 갈지
    private String game_status = "성공";
    private static List<String> current = new ArrayList<>();
    private static int bridge_construction_time = 0; // 다리 건설 몇번째 인가
    private int game_time = 1;
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String way) {
        if(Application.bridge.get(bridge_construction_time).equals(way)){
            current.add(way);
            new OutputView().printMap(current);
            bridge_construction_time++;
        }
        else{
            if(way.equals("U")){
                current.add("U_X");
            }
            else{
                current.add("D_X");
            }
            new OutputView().printMap(current);
        }

    }
    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        if(bridge_construction_time == 3){
            go_stop = false;
            new OutputView().printResult(current, game_time, game_status);
        }
        int last_index = current.size() - 1;
        if(current.get(last_index).equals("U_X") || current.get(last_index).equals("D_X")){
            new InputView().readGameCommand();
            if(InputView.input_GameCommand == "R"){
                bridge_construction_time = 0;
                game_time++;
            }
            else{
                go_stop = false;
                new OutputView().printResult(current, game_time, game_status);
            }
        }
    }
}
