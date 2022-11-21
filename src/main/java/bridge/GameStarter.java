package bridge;

import java.util.List;

public class GameStarter {
    public static InputView inputView = new InputView();
    public static OutputView outputView = new OutputView();

    public GameStarter() {
        List<String> bridge = makeBridge();
        int totalCount = 1;
        while (startGame(bridge, totalCount)) {
            totalCount++;
        }
    }

    // 게임 시작
    public static boolean startGame(List<String> bridge, int totalCount) {
        BridgeGame bridgeGame = new BridgeGame(bridge);
        boolean continueGame = true;
        if (gameInProgress(continueGame, bridgeGame)) {    // 재시도
            return true;
        }
        // 최종 결과 보기
        outputView.printResult(bridgeGame.getGameState(), bridgeGame.getIsSuccess(), totalCount);
        // 게임이 종료
        return false;
    }

    // 다리 생성 후 게임 진행 시작 메서드
    public static boolean gameInProgress(boolean continueGame, BridgeGame bridgeGame) {
        while (continueGame) {
            continueGame = moveForward(bridgeGame);
            // 게임이 끝났을 때 (실패OR성공) && 실패일 때
            if (retryCheck(continueGame, bridgeGame)) {
                return true;
            }
            outputView.printMap(bridgeGame.getGameState(), continueGame, bridgeGame.getIsSuccess());
        }
        return false;
    }

    // 재시도 여부 확인하는 메서드
    public static boolean retryCheck(boolean continueGame, BridgeGame bridgeGame) {
        if (!continueGame && !bridgeGame.getIsSuccess()) {
            boolean retryCheck = inputReTry(outputView, bridgeGame, continueGame);
            // R 입력
            if (retryCheck) {
                return true;
            }
        }
        // Q 입력
        return false;
    }

    // R과 Q에 대한 값 구별 메서드
    public static boolean inputReTry(OutputView outputView, BridgeGame bridgeGame, boolean continueGame) {
        outputView.printMap(bridgeGame.getGameState(), continueGame, bridgeGame.getIsSuccess());
        String whetherRetryGame = inputView.readGameCommand();
        //true 면 R (다시)
        return bridgeGame.retry(whetherRetryGame);
    }

    // U와 D에 대한 값 구별 메서드
    public static boolean moveForward(BridgeGame bridgeGame) {
        if (bridgeGame.move(inputView.readMoving())) {
            return true;
        }
        return false;
    }

    // 다리 생성 메서드
    public static List<String> makeBridge() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

        System.out.println("다리 건너기 게임을 시작합니다.");
        int size = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(size);

        return bridge;
    }
}
