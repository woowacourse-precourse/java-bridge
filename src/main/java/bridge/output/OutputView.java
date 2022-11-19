package bridge.output;

import java.util.List;
import java.util.StringJoiner;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력합니다.
     * @param bridge 원본 다리
     * @param userInput 사용자의 입력들
     */
    public void printMap(List<String> bridge, List<String> userInput) {
        printSingleLineResult(bridge, userInput, "U");
        printSingleLineResult(bridge, userInput, "D");
        System.out.println();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }


    /**
     * 현재 결과를 가지고 게임 결과 문자열을 완성하고, 게임 결과의 한 라인을 출력합니다.
     * @param bridge 원본 다리
     * @param input 사용자의 입력들
     * @param direction 현재 어느 라인을 (U, D) 출력하는지
     */
    private void printSingleLineResult(List<String> bridge, List<String> input, String direction) {
        StringJoiner stringJoiner = makeSingleLineResult(bridge, input, direction);
        if (input.get(input.size() - 1).equals(direction) && bridge.get(input.size() - 1).equals(direction)) {
            System.out.println(stringJoiner.add("O"));
            return;
        }
        if (input.get(input.size() - 1).equals(direction) && !bridge.get(input.size() - 1).equals(direction)) {
            System.out.println(stringJoiner.add("X"));
            return;
        }
        System.out.println(stringJoiner.add(" "));
    }

    /**
     * 게임 결과의 한 라인을 생성합니다.
     * @param bridge 원본 다리
     * @param input 사용자의 입력들
     * @param direction 현재 어느 라인을 (U, D) 출력하는지
     * @return 생성된 결과 문자열
     */
    private StringJoiner makeSingleLineResult(List<String> bridge, List<String> input, String direction) {
        StringJoiner stringJoiner = new StringJoiner(" | ", "[ ", " ]");
        for (int i = 0; i < input.size() - 1; i++) {
            if (input.get(i).equals(direction) && bridge.get(i).equals(direction)) {
                stringJoiner.add("O");
                continue;
            }
            stringJoiner.add(" ");
        }
        return stringJoiner;
    }
}
