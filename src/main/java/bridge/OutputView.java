package bridge;

import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

import static message.GeneralMessage.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    StringJoiner stringJoiner = new StringJoiner(" | ", "[ ", " ]" );

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<List<String>> bridges) {
        for (List<String> bridge : bridges) {
            System.out.println(convertListToStringBridge(bridge));
        }
        System.out.println();
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
    public void printResult(List<List<String>> bridges, boolean success, int gameCount) {
        System.out.println(GAME_RESULT.getMessage());
        printMap(bridges);
        System.out.println(getSuccess(success));
        System.out.println(getTry(gameCount));
    }

    public String getSuccess(boolean success) {
        System.out.print(SUCCESS_OR_NOT.getMessage());
        if (success) {
            return "성공";
        }
        return "실패";
    }

    public int getTry(int gameCount) {
        System.out.print(NUMBER_OF_TRY.getMessage());
        return gameCount;
    }
}
