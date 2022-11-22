package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    InputView inputView;
    OutputView outputView;
    BridgeMaker bridgeMaker;
    BridgeNumberGenerator bridgeNumberGenerator;
    BridgePlayerCheck bridgePlayerCheck;

    int tryCount; //게임 시도 횟수
    List<String> bridge; //생성된 다리
    List<String> player; //사용자 입력 다리

    public BridgeGame() {
        inputView = new InputView();
        outputView = new OutputView();
        bridgePlayerCheck = new BridgePlayerCheck();
        bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        tryCount = 0;
    }

    /**
     * 전체 게임 진행 메서드
     */
    public void game() {
        boolean success = true;
        start();
        while (bridge.size() != player.size()) {
            String move = move();
            if (checkCorrect(move)) continue;
            if (!retry()) {
                success = false;
                break;
            }
        }
        quit(success);
    }

    public boolean checkCorrect(String move) {
        int current = player.size() - 1;

        return bridgePlayerCheck.isO(bridge.get(current), player.get(current), move);
    }

    /**
     * 게임 시작 메서드
     */
    public void start() {
        int size = inputView.readBridgeSize();
        bridge = bridgeMaker.makeBridge(size);
        player = new ArrayList<>();
        tryCount += 1;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     */
    public String move() {
        String moving = inputView.readMoving();
        player.add(moving);
        outputView.printMap(bridge, player);

        return moving;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     */
    public boolean retry() {
        String gameCommand = inputView.readGameCommand();
        if (gameCommand.equals("R")) {
            tryCount += 1;
            player = new ArrayList<>();
            return true;
        }
        return false;
    }

    /**
     * 사용자 게임이 종료될 때 사용하는 메서드
     */
    public void quit(boolean isSuccess) {
        outputView.printResult();
        outputView.printMap(bridge, player);
        outputView.printSuccessOrFail(isSuccess);
        outputView.printTryCount(tryCount);
    }
}
