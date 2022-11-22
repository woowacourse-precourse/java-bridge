package bridge.game;

import bridge.*;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class Game {
    private static final String DIVIDE_LETTER = "|";
    private final InputView inputView;
    private final OutputView outputView;

    private final BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    private BridgeGame bridgeGame;
    private Bridge bridge;

    private String result;
    private int position;
    private int playCount = 1;
    private List<Bridge> resultBridge;

    public Game() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    /**
     * 게임 시작: initialize, 다리 생성
     */
    public void startGame() {
        outputView.printGameStart();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        this.bridge = new Bridge(bridgeMaker.makeBridge(inputView.readBridgeSize()));
        this.bridgeGame = new BridgeGame(bridge.getBridge());
        playBridgeGame();
    }

    /**
     * 사용자가 다리를 건너는 메서드
     * 사용자가 다리 끝까지 갔을 때까지 반복한다. 만약 중간에 틀리면 멈춘다.
     * 계속 움직일 수 있다면: continueGame(direction)
     * 움직일 수 없다면: stopGame(direction)
     * 반복문 밖으로 나온다면(게임을 틀리지 않았다면): successGame(direction)
     */
    private void playBridgeGame() {
        initGame();
        while (position < bridge.getBridge().size()) {
            String direction = inputView.readMoving();
            if (bridge.canMove(direction, position)) {
                position++;
                continueGame(direction, resultBridge);
                continue;
            }
            stopGame(direction);
            return;
        }
        result = Result.SUCCESS.getLabel();
        finishGame();
    }

    /**
     * direction에 따라 position을 이동시키고, 새로운 bridge를 생성하여 출력한다.
     *
     * @param direction
     * @param bridges
     */
    private void continueGame(String direction, List<Bridge> bridges) {
        outputView.printMap(bridgeGame.move(direction, bridges));
        prepareGame(bridges);
    }

    /**
     * 게임을 종료하고 재입력을 받는다.
     * @param direction
     */

    private void stopGame(String direction) {
        outputView.printMap(bridgeGame.stop(direction, resultBridge));
        String command = inputView.readGameCommand();
        if (bridgeGame.retry(command)) {
            playCount++;
            playBridgeGame();
        }
        result = Result.FAIL.getLabel();
        finishGame();
    }

    /**
     * 게임을 초기화한다. (현재 위치, 최초의 다리 생성)
     */
    private void initGame() {
        this.position = 0;
        this.resultBridge = bridge.drawInitialBridge();
    }

    /**
     * 게임을 종료한다.
     */
    private void finishGame() {
        outputView.printFinalGameResult();
        outputView.printMap(resultBridge);
        outputView.printResult(result, playCount);
    }

    /**
     * 다음을 준비한다. 추가된 닫힘을 제거하고, 디바이더로 교체한다.
     *
     * @param bridges
     */
    private void prepareGame(List<Bridge> bridges) {
        for (int i = 0; i < bridges.size(); i++) {
            bridges.get(i).getBridge().remove(bridges.get(i).getBridge().size() - 1);
            bridges.get(i).getBridge().add(DIVIDE_LETTER);
        }
    }
}