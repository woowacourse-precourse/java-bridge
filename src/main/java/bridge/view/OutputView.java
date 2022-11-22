package bridge.view;

import bridge.domain.Moving;
import bridge.domain.Round;
import java.util.List;
import java.util.Objects;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public static void printBridgeGameStartMessage() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(List<Round> rounds) {
        String upMap = "[";
        String downMap = "[";
        String endStr = "|";

        for (Round round : rounds) {
            if (Objects.equals(round, rounds.get(rounds.size() - 1))) {
                endStr = "]";
            }
            upMap += " " + getRoundMap(round, Moving.UP) + " " + endStr;
            downMap += " " + getRoundMap(round, Moving.DOWN) + " " + endStr;
        }
        System.out.println(upMap + "\n" + downMap);
    }


    public static String getRoundMap(Round round, Moving moving) {
        if (Objects.equals(round.getPlayerMoving(), moving)) {
            return round.getResult().getExpression();
        }
        return " ";
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(List<Round> rounds, int totalNumberOfAttempts) {
        System.out.println("최종 게임 결과");
        printMap(rounds);
        System.out.println(
                "게임 성공 여부: " + rounds.get(rounds.size() - 1).getResult().getDescription());
        System.out.println("총 시도한 횟수: " + totalNumberOfAttempts);

    }

}
