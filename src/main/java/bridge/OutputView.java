package bridge;

import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

import static message.GeneralMessage.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    StringJoiner stringJoiner = new StringJoiner(" | ", "[ ", " ]" )

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<List<String>> bridges) {
        // getter가 여기서 필요한 것 같다..
        for (List<String> bridge : bridges) {
            System.out.println(convertListToStringBridge(bridge));
        }
    }

    public String convertListToStringBridge(List<String> bridge) {
        String stringBridge = bridge.stream().collect(Collectors.joining(" | ", "[ ", " ]"));
        return stringBridge;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
        System.out.println(GAME_RESULT);
//        printMap(); // 최종 다리 모양 출력
        System.out.println(SUCCESS_OR_NOT); // + 실패 or 성공
        System.out.println(NUMBER_OF_TRY); // + 횟수(int)
    }
}
