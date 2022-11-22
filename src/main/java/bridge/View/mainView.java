package bridge.View;

import bridge.BridgeGame;
import bridge.GameController;

import java.util.List;

import static bridge.GameController.count;
import static bridge.GameController.round_count;

public class mainView {
    private OutputView outputView;
    private List<String> bridges;

    public mainView(OutputView outputView, List<String> bridge){
        this.outputView=outputView;
        this.bridges=bridge;
    }


    public void all_print() {
        outputView.printMap();
        count++;
        total_print();
    }

    public void total_print() {

        if (BridgeGame.game_status.equals("End")) {
            outputView.printResult(round_count, "실패");
        }
        if (bridges.size() == count) {
            outputView.printResult(round_count, "성공");
        }
    }
}
