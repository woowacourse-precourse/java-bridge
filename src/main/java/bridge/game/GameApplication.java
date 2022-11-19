package bridge.game;

import bridge.bridge.BridgeGame;
import bridge.input.InputView;
import bridge.output.OutputView;

/**
 * 전체 게임 로직을 관리하는 클래스입니다.
 * @version 1.0.0
 * @author CHO Min Ho
 */
public class GameApplication {
    private final BridgeGame bridgeGame;
    private final InputView inputView;
    private final OutputView outputView;
    private int gameCount;

    public GameApplication() {
        this.bridgeGame = new BridgeGame();
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.gameCount = 0;
    }

    /**
     * 게임 시작 시, 다리의 길이를 입력받고, 해당 길이만큼의 다리를 생성하는 메서드입니다.
     */
    public void inputBridgeLength() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
        System.out.println("다리의 길이를 입력해주세요.");
        bridgeGame.makeBridge(inputView.readBridgeSize());
    }

    /**
     * 이동할 칸을 입력받고, 해당 방향으로 이동하는 메서드입니다.
     * @return 현재 이동이 성공한지 여부 (true : 성공, false : 실패)
     */
    public boolean singleStage() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        bridgeGame.move(inputView.readMoving());
        outputView.printMap(bridgeGame.getBridge(), bridgeGame.getUserInput());
        return bridgeGame.getUserInput().get(bridgeGame.getUserInput().size() - 1)
                .equals(bridgeGame.getBridge().get(bridgeGame.getUserInput().size() - 1));
    }

    /**
     * 재시작 여부를 입력받는 메서드입니다.
     * @return 재시작할지 여부 (true : 재시작, false : 종료)
     */
    public boolean inputIfRestart() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        return inputView.readGameCommand().equals("R");
    }

    /**
     * 게임이 종료되었을 때, 최종 출력을 하는 메서드입니다.
     */
    public void printTotalResult() {
        outputView.printResult(bridgeGame.getBridge(), bridgeGame.getUserInput(), gameCount);
    }

    /**
     * 한 번의 일련의 게임을 수행하는 메서드입니다.
     * @return 해당 게임에서 성공했는지 여부
     */
    public boolean singleGame() {
        gameCount++;
        for (int i = 0; i < bridgeGame.getBridge().size(); i++) {
            if (!singleStage()) {
                return false;
            }
        }
        return true;
    }
    
}
