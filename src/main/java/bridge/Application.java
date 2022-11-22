package bridge;

import bridge.domain.PlayResult;
import bridge.domain.Stage;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;

public class Application {

    static BridgeGame game;

    public static void main(String[] args) {
        // 다리 생성 테스트
        System.out.println("크기 입력: ");
        int bridgeSize = Integer.parseInt(Console.readLine());
        game = new BridgeGame(buildBridge(bridgeSize));

        // 다리 건너기 테스트
        play();

        // 최종 결과
        System.out.println("게임 결과: " + (game.isClear() ? "승리" : "패배"));
        System.out.println("재시도: " + game.getAttempts());
    }

    private static List<Stage> buildBridge(final int bridgeSize) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        System.out.println("bridge = " + bridge);
        return bridge
            .stream()
            .map(Stage::new)
            .collect(Collectors.toList());
    }

    private static void play() {
        playGame();

        if (!game.isClear()) {
            askRestart();
        }
    }

    private static void playGame() {
        while (!game.isClear()) {
            System.out.println("방향 입력: ");
            String direction = Console.readLine();
            PlayResult playResult = game.move(direction);

            if (game.isOver()) {
                break;
            }
            System.out.println("통과!");
        }
    }

    private static void askRestart() {
        System.out.println("재시작 ?");
        String commend = Console.readLine();
        if ("R".equals(commend)) {
            resetGame();
            play();
        }
    }

    private static void resetGame() {
        game.retry();
    }
}
