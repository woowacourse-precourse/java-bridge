package bridge;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.IntStream;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 * 1. OutputView의 패키지는 변경할 수 🌴있다.🌴
 * 2. OutputView의 메서드의 이름은 변경할 수 🌴없고🌴, 인자와 반환 타입은 필요에 따라 추가하거나 변경할 수 🌴있다.🌴
 * 3. 값 출력을 위해 필요한 메서드를 추가할 수 🌴있다.🌴
 */
public class OutputView {
    private final static String BRIDGE_HEAD = "[";
    private final static String BRIDGE_TAIL = "]";
    private final static String BLANK_SPACE = " ";
    private final static String BRIDGE_PARTITION = "|";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(int stepCount, List<String> upSideResult, List<String> downSideResult) {
        StringJoiner upSideBridge = new StringJoiner(BLANK_SPACE);
        StringJoiner downSideBridge = new StringJoiner(BLANK_SPACE);

        updateMap(upSideBridge, stepCount, upSideResult);
        updateMap(downSideBridge, stepCount, downSideResult);

        System.out.println(upSideBridge);
        System.out.println(downSideBridge);
    }

    private static void updateMap(StringJoiner oneSideBridge, int stepCount, List<String> result) {
        oneSideBridge.add(BRIDGE_HEAD);
        for (int i = 0; i <= stepCount; i++) {
            oneSideBridge.add(result.get(i));
            if (stepCount > 0 && i < stepCount) {
                oneSideBridge.add(BRIDGE_PARTITION);
            }
        }
        oneSideBridge.add(BRIDGE_TAIL);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
