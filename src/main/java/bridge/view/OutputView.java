package bridge.view;

import bridge.domain.BridgeGame;
import bridge.domain.MoveResults;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 * TODO 메서드의 이름은 변경 불가!!!
 * TODO 인자와 반환 타입은 필요에 따라 추가하거나 변경 가능
 * TODO 메서드 추가 가능
 */
public class OutputView {

    public void printStartMessage() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    public void printMap(MoveResults moveResults) {
        List<String> upResults = moveResults.upResults();
        List<String> downResults = moveResults.downResults();

        String upString = String.join(" | ", upResults);
        String downString = String.join(" | ", downResults);

        System.out.println("[ " + upString + " ]");
        System.out.println("[ " + downString + " ]");
    }

    public void printResult(BridgeGame bridgeGame, String gameResult) {
        System.out.println("최종 게임 결과");
        printMap(bridgeGame.moveResults());

        System.out.println("게임 성공 여부: " + gameResult);
        System.out.println("총 시도한 횟수: " + bridgeGame.totalNumberOfChallenges());
    }
}
