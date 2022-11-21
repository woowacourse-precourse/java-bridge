package bridge.view;

import bridge.domain.bridge.BridgeMove;
import bridge.domain.game.BridgeGame;
import bridge.domain.history.BridgeGameHistory;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    
    public void printStartMessage() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }
    
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(BridgeGame bridgeGame) {
        printMapBySides(bridgeGame.getCurrentHistory().getMoveResultMap());
    }
    
    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGame bridgeGame) {
        System.out.println("최종 게임 결과");
        Optional<BridgeGameHistory> historyOfBestRecord = bridgeGame.getHistoryOfBestRecord();
    
        historyOfBestRecord.ifPresent((history) -> {
            printMapBySides(history.getMoveResultMap());
    
            printSuccessOrFailure(bridgeGame);
            printTryCount(bridgeGame);
        });
    }
    
    private void printMapBySides(Map<BridgeMove, List<String>> moveResults) {
        for (BridgeMove bridgeMove : BridgeMove.values()) {
            System.out.println(getSideResult(moveResults.get(bridgeMove)));
        }
    }
    
    private String getSideResult(List<String> results) {
        return "[" + String.join("|", results) + "]";
    }
    
    private void printSuccessOrFailure(BridgeGame bridgeGame) {
        System.out.print("게임 성공 여부: ");
        if (bridgeGame.isReachedLastPosition()) {
            System.out.println("성공");
            return;
        }
        System.out.println("실패");
    }
    
    private void printTryCount(BridgeGame bridgeGame) {
        System.out.println("총 시도한 횟수: " + bridgeGame.getTryCount());
    }
}
