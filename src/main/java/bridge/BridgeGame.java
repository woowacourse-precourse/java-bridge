package bridge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {


    private InputView inputView;
    private OutputView outputView;
    private List<String> history;
    public BridgeGame(List<String> value) {
        inputView = new InputView();
        outputView = new OutputView();
        history = value;
    }

    /**
     *  사용자가 게임을 시작할 때 사용하는 메서드
     * @param bridge : U, D 로 이루어진 리스트
     * */
    public void play(List<String> bridge) {
        List<String> history = new ArrayList<>();
        Integer historyCount = 0;
        for (String stair : bridge) {
            history.add(stair);
            move(stair, history);
            historyCount++;
            if(historyCount == bridge.size()){
                retry(history);
            }
        }
    }
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String stair, List<String> history) {
        String movement = inputView.readMoving();
        if ( stair.equals(movement) ) {
            outputView.printMap(history);
        }
        retry(history);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(List<String> history) {
        //        현 X 포함 out View
//        실패당시 Output View

    }
}
