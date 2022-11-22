package bridge;


import java.util.List;

public class Game {
    private BridgeGame bridgeGame;
    private final BridgeMaker bridgeMaker;
    private static final InputView inputController = new InputView();
    private static final OutputView outputController = new OutputView();
    private final Map map;
    private boolean isPlaying;

    Game() {
        BridgeRandomNumberGenerator numberGenerator = new BridgeRandomNumberGenerator();
        this.bridgeMaker = new BridgeMaker(numberGenerator);
        this.map = new Map();
        this.isPlaying = true;
    }

    /**
     * 게임 시작
     */
    public void start() {
        this.makeBridgeGame();
        this.play();
        this.printGameResult();
    }

    /**
     * 사용자 입력받아 다리를 생성
     */
    private void makeBridgeGame() {
        outputController.printComment(Comment.START_GAME, "\n");
        outputController.printComment(Comment.INPUT_SIZE_OF_BRIDGE);
        int size = inputController.readBridgeSize();
        System.out.println(); // 줄 바꿈
        List<String> bridge = this.bridgeMaker.makeBridge(size);
        this.bridgeGame = new BridgeGame(bridge);
    }

    /**
     * 게임 진행
     * 반복 (사용자 이동 -> 맵 업데이트 및 출력 -> 실패했는지 확인)
     */
    private void play() {
        while (!this.bridgeGame.isEndOfBridge() && this.isPlaying) {
            String playerMovement = movePlayer();
            boolean isPlayerSafe = this.bridgeGame.checkBridgeAndPlayer();
            updateAndPrintMap(playerMovement, isPlayerSafe);

            this.checkGameState(isPlayerSafe);
        }
    }

    /**
     * 게임 결과 출력
     */
    public void printGameResult() {
        outputController.printResult(this.map, this.bridgeGame.isEndOfBridge(), this.bridgeGame.getTotalAttempts());
    }

    /**
     * 사용자 입력 받아 이동
     * @return 사용자의 이동 입력
     */
    private String movePlayer() {
        outputController.printComment(Comment.INPUT_MOVEMENT);
        String playerMovement = inputController.readMoving();
        this.bridgeGame.move(playerMovement);
        return playerMovement;
    }

    /**
     * 맵 업데이트 후에 출력
     */
    private void updateAndPrintMap(String playerMovement, boolean isPlayerSafe) {
        this.map.update(playerMovement, isPlayerSafe);
        outputController.printMap(this.map);
    }

    /**
     * 플레이어가 죽었다면 재시작/종료 물어봄
     */
    public void checkGameState(boolean isPlayerSafe) {
        if (!isPlayerSafe) {
            resetOrQuitGame();
        }
    }

    /**
     * 재시작/종료 처리
     */
    private void resetOrQuitGame() {
        if (this.isPlayerRetrying()) {
            this.bridgeGame.retry();
            this.map.clear();
            return;
        }
        this.isPlaying = false;
        this.bridgeGame.clearPlayerCurrentStep();
    }

    /**
     * 재시작/종료 입력 받음
     */
    private boolean isPlayerRetrying() {
        outputController.printComment(Comment.INPUT_GAME_COMMEND);
        String retryInput = inputController.readGameCommand();
        return retryInput.equals("R");
    }
}
