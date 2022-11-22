package bridge.View;

import java.util.List;

import bridge.Utils.Converter;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String BRACKET_START = "[ ";
    private static final String BRACKET_END = " ]";
    private static final String BAR = " | ";
    private static final String SUCCESS = "성공";

    private static final String FAILED = "실패";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(List<String> moveOutput) {
        printLine(Converter.getOddList(moveOutput));
        printLine(Converter.getEvenList(moveOutput));
        System.out.println();
    }


    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(int gameCount, List<String> currentBridge, boolean isSuccess) {
        System.out.println("최종 게임 결과");
        OutputView.printMap(currentBridge);
        System.out.println("게임 성공 여부: " + printSuccessOrFailed(isSuccess));
        System.out.println("총 시도한 횟수: " + gameCount);
    }

    private static String printSuccessOrFailed(boolean isSuccess) {
        if (isSuccess) {
            return SUCCESS;
        }
        return FAILED;
    }


    /**
     * @param moveOutput 게임에서 나온 결과 리스트
     */
    public static void printLine(List<String> moveOutput) {
        System.out.print(BRACKET_START);
        printInner(moveOutput);
        System.out.println(BRACKET_END);
    }

    /**
     * @param List 게임에서 나온 결과 리스트
     */
    public static void printInner(List<String> List) {
        for (int i = 0; i < List.size(); i++) {
            System.out.print(List.get(i));
            if ((List.size() != 1) && ((i + 1) != List.size())) {
                System.out.print(BAR); // 마지막이거나, 첫 게임에서는 나타나지 않도록 처리
            }
        }
    }
}
