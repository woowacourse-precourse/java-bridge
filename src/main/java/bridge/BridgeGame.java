package bridge;

import bridge.enums.BlockExpression;
import bridge.enums.GameCommand;
import bridge.enums.GameOver;
import bridge.enums.GameResult;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final BridgeChecker bridgeChecker;
    private final BridgeMaker bridgeMaker;

    public BridgeGame(BridgeChecker bridgeChecker, BridgeMaker bridgeMaker) {
        this.bridgeChecker = bridgeChecker;
        this.bridgeMaker = bridgeMaker;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(List<String> userInput, String moving) {
        userInput.add(moving);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(List<String> userInput, GameProgress gameProgress) {
        userInput.clear();
        gameProgress.resetGameOver();
        gameProgress.retrialGameCommand();
        gameProgress.resetGameResult();
  //      gameProgress.gameOver = GameOver.YET;
  //      gameProgress.gameCommand = GameCommand.RETRIAL;
  //      gameProgress.gameResult = GameResult.UNDETERMINED;
        gameProgress.plusTrial();
    }

    public void verifyGameSuccess(List<String> bridge, List<String> userInput, GameProgress gameProgress) {
        List<String> matchingResult = bridgeChecker.checkBridgeMatching(bridge, userInput);
        final int LAST_INDEX = matchingResult.size()-1;

        if(matchingResult.get(LAST_INDEX).equals(BlockExpression.DIFF.getMark())) {
            //gameProgress.gameOver = GameOver.OVER;
            gameProgress.gameOver();
            //gameProgress.gameResult = GameResult.FAILED;
            gameProgress.gameFailed();
            return;
        }
        if(bridge.size()==userInput.size()) {
            //gameProgress.gameOver = GameOver.OVER;
            gameProgress.gameOver();
            //gameProgress.gameResult = GameResult.SUCCESS;
            gameProgress.gameSuccess();
        }
    }

    public BridgeMaker getBridgeMaker() {
        return bridgeMaker;
    }
}
