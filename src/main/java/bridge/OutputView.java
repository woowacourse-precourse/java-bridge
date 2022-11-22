package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private final String startGameMessage = "다리 건너기 게임을 시작합니다.";
    private final String lastGameResultMessage = "최종 게임 결과";
    private final String resultTypeMessage = "게임 성공 여부: ";
    private final String totalNumberOfTryMessage = "총 시도한 횟수: ";

    public void printGameStart() {
        System.out.println(startGameMessage);
        System.out.println();
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(Result result) {
        MapGenerator mapGenerator = new MapGenerator();
        List<String> map = mapGenerator.generateMap(result);
        for (String row : map) {
            System.out.println(row);
        }
        System.out.println();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(Result result) {
        System.out.println(lastGameResultMessage);
        printMap(result);
        System.out.println(resultTypeMessage + result.getLastResultType().toKoreanString());
        System.out.println(totalNumberOfTryMessage + result.getCount());
    }
}
