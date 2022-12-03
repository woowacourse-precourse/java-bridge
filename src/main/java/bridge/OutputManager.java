package bridge;

import data.PrintData;
import java.util.List;
import view.OutputView;

/**
 * 다리상황과 플레이어의 선택을 비교해서 출력하는 클래스
 */
public class OutputManager {

    private final OutputView outputView = new OutputView();

    public void welcomePlayer() {
        outputView.printWelcome();
    } // 다리 건너기 게임 시작 출력.

    public boolean movePlayer(List<String> bridge, List<String> player) {
        return outputView.printMap(bridge, player, player.size());
    }

    public void printResultBridge(List<String> bridge, List<String> player) {
        PrintData.RESULT.printGuideWithLine();
        outputView.printMap(bridge, player, player.size());
    }

    public String compareBridge(List<String> bridge, List<String> player) {
        if (bridge.containsAll(player)) {
            return PrintData.SUCCESS.getPrintGuide();
        }
        return PrintData.FAIL.getPrintGuide();
    }

    public void printResult(String result, int attempt) {
        outputView.printResult(result, attempt);
    }
}
