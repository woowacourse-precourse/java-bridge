package bridge.controller;

import bridge.model.Bridge;
import bridge.model.Player;
import bridge.service.BridgeService;
import bridge.util.BridgeGameStatus;
import bridge.util.OutputPharses;
import bridge.view.InputView;
import bridge.view.OutputView;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    private final BridgeService bridgeService;
    private Player player;
    private Bridge bridge;

    private int totalGameCount;
    private boolean isRoundOver; // 매 플레이어 진행 라운드
    private boolean isGameOver; // 전체 게임
    private boolean isSuccess; // 게임 성공

    public BridgeGame(BridgeService bridgeService) {
        this.bridgeService = bridgeService;
    }

    /**
     * 다리 생성하는 함수
     * @param bridgeSize
     */
    public void setBridge(int bridgeSize) {
        bridge = bridgeService.makeBridge(bridgeSize);
    }

    public Bridge getBridge() {
        return bridge;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move() {
        while(!isRoundOver) {
            moveSet();
            isRoundOver = !eachMove();
            outputView.printMap(player);
            if(isGameSuccess()) {
                return true;
            }
        }
        return false;
    }

    /**
     * 사용자에게 입력받은 값 초기 설정
     */
    public void moveSet() {
        inputView.readMoving();
        player.setCurrentMove(inputView.getPlayerMove());
    }

    public boolean eachMove() {
        return bridgeService.move(bridge, player);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        totalGameCount++;
        isRoundOver = false;
        player = new Player();
    }

    public void startGame() {
        initGame();
        startRond();
        printEnd();
    }

    public void initGame() {
        outputView.printGameStartInfo();
        inputView.readBridgeSize();
        int bridgeSize = inputView.getBridgeSize();
        //setBridgeSize();
        setBridge(bridgeSize);
    }

    public void startRond() {
        while (!isGameOver) {
            retry();
            if (move()){
                isSuccess = true;
                return;
            }
            inputView.readGameCommand();
            isGameOver = isQuit(inputView.getGameCommand());
        }
    }

    public void printEnd() {
        outputView.printInfo(OutputPharses.GAME_RESULT_MSG.getMsg());
        outputView.printMap(player);
        outputView.printResult(isSuccess, totalGameCount);
    }

    public boolean isQuit(String gameCommand) {
        return gameCommand.equals(BridgeGameStatus.QUIT.getGameStatus());
    }

    /**
     * 게임을 성공하였을때 : 플레이어가 완주한 상태로, 마지막 칸은 O로 끝나야 한다.
     * @return
     */
    public boolean isGameSuccess() {
        return bridgeService.isSuccess(bridge.getBridgeSize(), player.getCurrentLocation()) && !isRoundOver;
    }

}
