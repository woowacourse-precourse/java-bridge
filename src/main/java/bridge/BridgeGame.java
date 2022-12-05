package bridge;

import data.BridgeData;
import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    InputManager inputManager = new InputManager();
    OutputManager outputManager = new OutputManager();

    public void start() {
        orderWelcome();
        List<String> bridge;
        bridge = makeBridge(); // 다리 생성
        System.out.println();

        playGame(bridge); // 게임 시작
    }

    private void orderWelcome() {
        outputManager.welcomePlayer();
    }

    /**
     * 다리 생성할때 쓰이는 메서드
     */
    public List<String> makeBridge() {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

        int size;
        size = inputManager.getBridgeSize();
        List<String> bridge;

        bridge = bridgeMaker.makeBridge(size);
        return bridge;
    }
    
    private void playGame(List<String> bridge) {
        int attempt = 0;
        List<String> player;
        do {
            attempt++;
            player = new ArrayList<>(); // 플레이어 초기화
            if (move(bridge, player)) {
                break; // 생존에 성공 시 재시도를 묻지 않음.
            }
        } while (retry()); // 재시도를 선택했거나 성공했을경우 끝
        result(bridge, player, attempt);
    }

    public boolean move(List<String> bridge, List<String> player) {
        boolean isAlive = true;
        while (bridge.size() != player.size() && isAlive) {
            player.add(inputManager.getMoveCommand());
            isAlive = outputManager.movePlayer(bridge, player);
        }
        return isAlive;
    }

    public boolean retry() {
        String gameCommand;
        gameCommand = inputManager.getGameCommand();
        return gameCommand.equals(BridgeData.RESTART);
    }

    /**
     * 결과 출력할때 쓰는 메서드
     */
    public void result(List<String> bridge, List<String> player, int attempt) {
        String result;
        outputManager.printResultBridge(bridge, player);
        result = outputManager.compareBridge(bridge, player);
        outputManager.printResult(result, attempt);
    }
}
