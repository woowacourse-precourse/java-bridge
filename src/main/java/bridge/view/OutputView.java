package bridge.view;

import bridge.model.Bridge;
import bridge.model.Result;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;


/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String START_OUTPUT_MESSAGE = "다리 건너기 게임을 시작합니다.\n";
    private static final String SUCCESS_OUTPUT_MESSAGE = "게임 성공 여부: 성공";
    private static final String FAIL_OUTPUT_MESSAGE = "게임 성공 여부: 성공";
    private static final String RETRY_COUNT_OUTPUT_MESSAGE = "총 시도한 횟수: %d";
    private static final String Final_OUTPUT_MESSAGE = "최종 게임 결과";

    public static void printStart() {
        System.out.println(START_OUTPUT_MESSAGE);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     *
     * @param
     */
    public static void printMap(List<Bridge> map, int width) {
        List<String> result = new ArrayList<>();
        IntStream.range(0, width).forEach(i -> {
            List<String> bridge = new ArrayList<>();
            map.stream().forEach(e -> {
                if (Result.getCode(e.getPosition()) == i) {
                    bridge.add(e.getResult());
                } else {
                    bridge.add(" ");
                }
            });
            result.add(String.format("[ %s ]\n", String.join(" | ", bridge)));
        });
        Collections.reverse(result);
        System.out.println(String.join("", result));
    }

    public static void printFinal() {
        System.out.println(Final_OUTPUT_MESSAGE);
    }

    public static String isSuccess(boolean result) {
        if (result){
            return SUCCESS_OUTPUT_MESSAGE;
        }
        return FAIL_OUTPUT_MESSAGE;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(boolean result, int count) {
        System.out.println(isSuccess(result));
        System.out.printf(RETRY_COUNT_OUTPUT_MESSAGE, count);
    }
}
