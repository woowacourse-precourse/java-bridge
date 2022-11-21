package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    int count = 1;
    int idx = 0;
    public void simulate(List<String> bridge) {
        boolean isPlaying = true;
        boolean isEnd = false;
        while (true) {
            if (!isPlaying) {
                break;
            }
            if (idx==bridge.size()) {
                isEnd = true;
                idx = bridge.size()-1;
                break;
            }

            boolean isMoved = move(bridge);
            if (!isMoved) {
                isPlaying = retry();
            }
        }

        if (isEnd) {
            outputView.printResult(count, idx, bridge,true);
            return;
        }
        outputView.printResult(count,idx, bridge, false);
    }

    public boolean move(List<String> bridge) {
        //up : 1, down : 0
        String moving = inputView.readMoving();

        if (bridge.get(idx).equals(moving)) {
            outputView.printMap(idx,bridge,true);
            idx++;
            return true;
        }
        outputView.printMap(idx,bridge,false);
        return false;
    }

    public boolean retry() {
        String command = inputView.readGameCommand();
        if (command.equals("R")){
            count++;
            idx=0;
            return true;
        }
        return false;
    }
}
