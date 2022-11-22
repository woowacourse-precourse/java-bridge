package bridge.view;

import bridge.message.PrintCommon;

import java.util.List;
import java.util.stream.Collectors;

// 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
public class OutputView {

    // 사용자가 건넌 다리를 만들어 출력하는 메소드
    public void printMap(List<String> passHistory) {
        System.out.println(generateUpCase(passHistory));
        System.out.println(generateDownCase(passHistory));
    }

    // 위의 다리를 만드는 메소드
    private String generateUpCase (List<String> passHistory) {

        List<String> upCase = passHistory.stream()
                        .map((el) -> {
                            if (el.equals("U")) return "O";
                            if (el.equals("UX")) return "X";
                            return " "; }).collect(Collectors.toList());

        return upCase.stream()
                .collect(Collectors.joining(" | ", "[ ", " ]"));
    }

    // 아래의 다리를 만드는 메소드
    private String generateDownCase (List<String> passHistory) {

        List<String> upCase = passHistory.stream()
                .map((el) -> {
                    if (el.equals("D")) return "O";
                    if (el.equals("DX")) return "X";
                    return " "; }).collect(Collectors.toList());

        return upCase.stream()
                .collect(Collectors.joining(" | ", "[ ", " ]"));
    }

    // 최종 결과를 출력하는 메소드
    public void printResult(int attempt, boolean outcome, List<String> passHistory) {
        PrintCommon.RESULT.print();
        printMap(passHistory);

        if (outcome) {
            System.out.println(PrintCommon.RESULT_CLEAR + "성공");
        }
        if (!outcome) {
            System.out.println(PrintCommon.RESULT_CLEAR + "실패");
        }
        System.out.println(PrintCommon.RESULT_NUMBER.toString() + attempt);
    }

    // 시작 메시지를 출력하는 메소드
    public void printStart () {
        PrintCommon.START.print();
    }
}
