package bridge;

import bridge.message.PrintInput;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> passHistory) {
        System.out.println(generateUpCase(passHistory));
        System.out.println(generateDownCase(passHistory));
    }

    private String generateUpCase (List<String> passHistory) {
        String upCaseResult;

        List<String> upCase = passHistory.stream()
                        .map((el) -> {
                            if (el.equals("U")) return "O";
                            if (el.equals("UX")) return "X";
                            return " ";
                        }).collect(Collectors.toList());

        return upCaseResult = upCase.stream()
                        .collect(Collectors.joining(" | ", "[ ", " ]"));
    }

    private String generateDownCase (List<String> passHistory) {
        String downCaseResult;

        List<String> upCase = passHistory.stream()
                .map((el) -> {
                    if (el.equals("D")) return "O";
                    if (el.equals("DX")) return "X";
                    return " ";
                }).collect(Collectors.toList());

        return downCaseResult = upCase.stream()
                .collect(Collectors.joining(" | ", "[ ", " ]"));
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(int attempt, boolean outcome) {
        if (outcome) {
            System.out.println(PrintInput.RESULT + "성공");
        }
        if (!outcome) {
            System.out.println(PrintInput.RESULT + "실패");
        }
        System.out.println(PrintInput.RESULT_NUMBER.toString() + attempt);
    }

    public void printStart () {
        PrintInput.START.print();
        System.out.println();
    }
}
