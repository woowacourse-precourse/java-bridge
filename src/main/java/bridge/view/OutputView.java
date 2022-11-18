package bridge.view;

import bridge.domain.GameResult;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String OPENING_PHRASE = "다리 건너기 게임을 시작합니다.";
    private static final String CLOSING_PHRASE = "최종 게임 결과";
    private final OutputMaker outputMaker = new OutputMaker();

    /**
     * 게임의 시작 문구를 출력한다.
     */
    public void printStart() {
        System.out.println(OPENING_PHRASE);
        System.out.println();
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> bridge, List<String> result) {
        String upperLayer = outputMaker.makeUpperLayer(bridge, result);
        String lowerLayer = outputMaker.makeLowerLayer(bridge, result);

        System.out.println(upperLayer);
        System.out.println(lowerLayer);
        System.out.println();
    }

    /**
     * 최종 게임 결과 문구를 출력한다.
     */
    public void printEndingPhrase() {
        System.out.println(CLOSING_PHRASE);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(GameResult gameResult, int tryCount) {
        System.out.printf("게임 성공 여부: %s\n", gameResult.toString());
        System.out.printf("총 시도한 횟수: %d", tryCount);
    }
}
