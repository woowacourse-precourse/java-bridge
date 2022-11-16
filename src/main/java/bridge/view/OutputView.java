package bridge.view;

import bridge.domain.GameResults;
import bridge.domain.Player;
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

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(GameResults gameResults) {
        // TODO 현재까지 유저가 건넌 다리의 상태를 출력해야 한다.
        // TODO 이는 Bridge 관련 로직 구현 후에 구현하자.

        // moveSign이 "U"이고, resultSign이 "O" 인 경우
        // upResult에 O를 더하고, downResult에는 " "를 더함

        // moveSign이 "U"이고, resultSign이 "X" 인 경우
        // upResult에 X를 더하고, downResult에는 " "를 더함

        // 게임이 연속되면 결과에 계속 값을 쌓아야 함.
        // 게임을 재시작 하면 결과를 초기화해야 함.

        List<String> upResults = gameResults.upResults();
        List<String> downResults = gameResults.downResults();

        String upString = String.join(" | ", upResults);
        String downString = String.join(" | ", downResults);

        System.out.println("[ " + upString + " ]");
        System.out.println("[ " + downString + " ]");
        // O | O | X
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(GameResults gameResults, Player player, String success) {
        System.out.println("최종 게임 결과");
        // TODO 최종 게임 결과를 출력해야 한다.

        List<String> upResults = gameResults.upResults();
        List<String> downResults = gameResults.downResults();

        String upString = String.join(" | ", upResults);
        String downString = String.join(" | ", downResults);

        System.out.println("[ " + upString + " ]");
        System.out.println("[ " + downString + " ]");

        System.out.println("게임 성공 여부: " + success);
        System.out.println("총 시도한 횟수: " + player.totalNumberOfChallenges());
    }
}
