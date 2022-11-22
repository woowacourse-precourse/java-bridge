package bridge.view;

import java.util.List;

import static bridge.view.ConsoleMessage.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private MapGenerator mapGenerator;

    public OutputView(MapGenerator mapGenerator) {
        this.mapGenerator = mapGenerator;
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> bridge, List<String> bridgeStatus) {
        mapGenerator.makeMap(bridge, bridgeStatus);

        System.out.println(mapGenerator.getUpperMap());
        System.out.println(mapGenerator.getLowerMap());
        System.out.println();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
        System.out.println(GAME_RESULT.getMessage());
        System.out.println(mapGenerator.getUpperMap());
        System.out.println(mapGenerator.getLowerMap());
        System.out.println();
    }

    public void printSuccess() {
        System.out.println(GAME_SUCCESS.getMessage());
    }

    public void printFailure() {
        System.out.println(GAME_FAILURE.getMessage());
    }

    public void printTrialCnt(int trialCnt) {
        System.out.println(NUM_OF_TRIAL.getMessage() + trialCnt);
    }
}
