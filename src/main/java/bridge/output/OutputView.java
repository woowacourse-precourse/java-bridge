package bridge.output;

import java.util.List;
import java.util.StringJoiner;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 * @version 1.0.0
 * @author CHO Min Ho
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
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력합니다.
     * @param bridge 원본 다리
     * @param userInput 사용자의 입력들
     * @param tryCount 총 시도한 횟수
     */
    public void printResult(List<String> bridge, List<String> userInput, int tryCount) {
        System.out.println("최종 게임 결과");
        printMap(bridge, userInput);
        String gameResult = "게임 성공 여부: 성공";
        if (userInput.size() != bridge.size() ||
                !userInput.get(userInput.size() - 1).equals(bridge.get(bridge.size() - 1))) {
            gameResult = gameResult.substring(0, 10) + "실패";
        }
        System.out.println(gameResult);
        System.out.println("총 시도한 횟수: " + tryCount);
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
