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
                break;
            }

            boolean isMoved = move(idx);
            if (!isMoved) {
                isPlaying = retry();
            }
        }
        
    }

    public boolean move(int idx) {
        String moving = inputView.readMoving();
        return true;
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
