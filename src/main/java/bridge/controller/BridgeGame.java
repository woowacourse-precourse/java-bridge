package bridge.controller;

import bridge.model.Bridge;
import bridge.model.BridgeMaker;
import bridge.model.Player;
import bridge.service.BridgeService;
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

    private int bridgeSize;
    private String playerMove;
    private int totalGameCount;
    private boolean isRoundOver;
    private boolean isGameOver;

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
    public void move() {
        while(!isRoundOver) {
            setPlayerMove();
            boolean canMove = eachMove();
            outputView.printMap(player);
            isRoundOver = !canMove;
        }
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
    }

    public void initGame() {
        outputView.printGameStartInfo();
        setBridgeSize();
        setBridge(bridgeSize);
    }

    public void startRond() {
        while (!isGameOver) {
            retry();
            move();
        }

    }

    /**
     * 입력받는 다리의 사이즈 확인 후 예외 발생 시 다시 입력 받는 함수
     */
    public void setBridgeSize() {
        try {
            outputView.printInfo(OutputPharses.BRIDGE_LENGTH_MSG.getMsg());
            bridgeSize = inputView.readBridgeSize();
            outputView.printInfo(OutputPharses.EMPTY_LINE.getMsg());
        } catch (IllegalArgumentException exception) {
            outputView.printInfo(exception.getMessage());
            outputView.printInfo(OutputPharses.EMPTY_LINE.getMsg());
            setBridgeSize();
        }
    }

    /**
     * 입력받는 플레이어의 이동 확인 후 예외 발생 시 다시 입력 받는 함수
     */
    public void setPlayerMove() {
        try{
            outputView.printInfo(OutputPharses.MOVE_MSG.getMsg());
            playerMove = inputView.readMoving();
            player.setCurrentMove(playerMove);
        } catch (IllegalArgumentException exception) {
            outputView.printInfo(exception.getMessage());
            outputView.printInfo(OutputPharses.EMPTY_LINE.getMsg());
            setPlayerMove();
        }
    }
}
