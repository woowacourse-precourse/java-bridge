package bridge.view.output;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void printStart() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> bridge) {
        if (bridge.size() == 0) {
            return;
        }

        StringBuilder output = new StringBuilder("[");

        for (int index = 0; index < bridge.size(); index++) {
            output.append(String.format(" %s ", bridge.get(index)));
            if (index != bridge.size() - 1) {
                output.append("|");
            }
        }
        output.append("]");

        System.out.println(output);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(String result, int tryCount) {
        System.out.printf("게임 성공 여부: %s\n"
                + "총 시도한 횟수: %d\n\n", result, tryCount);
    }
}
