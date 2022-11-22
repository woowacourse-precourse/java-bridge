package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeGameController {
    private static final BridgeGameService bridgeGameService = new BridgeGameService();

    private List<String> bridge = new ArrayList<>();
    private List<String> map = new ArrayList<>();
    private int tryCount = 0;

    public void run() {
        initGameRoutine();
        do {
            mainGameRoutine();
        } while (!bridgeGameService.isSuccess(bridge, map) && bridgeGameService.isRetry(bridgeGameService.askCommand()));
        finishGameRoutine();
    }

    private void initGameRoutine() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        Integer bridgeSize = bridgeGameService.askBridgeSize();
        bridge = bridgeGameService.makeBridge(bridgeSize);
    }

    private void mainGameRoutine() {
        tryCount++;
        map.clear();
        do {
            map.add(bridgeGameService.askMoving());
            bridgeGameService.printMapStatus(bridge, map);
        } while (bridgeGameService.isMovable(bridge, map));
    }

    private void finishGameRoutine() {
        System.out.println("\n최종 게임 결과");
        bridgeGameService.printMapStatus(bridge, map);
        bridgeGameService.printResult(bridge, map, tryCount);
    }
}
