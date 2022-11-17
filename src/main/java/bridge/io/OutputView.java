package bridge.io;

import bridge.domain.CrossResult;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String SUCCESS = "성공";
    private static final String FAILURE = "실패";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<CrossResult> topRoad, List<CrossResult> downRoad) {
        printRoad(topRoad);
        printRoad(downRoad);
    }

    private void printRoad(List<CrossResult> road) {
        System.out.print("[ ");
        for (int i=0; i<road.size(); i++) {
            System.out.print(convertToStr(road.get(i)));
            System.out.print(" ");
            if (i != road.size() - 1)
                System.out.print("| ");
        }
        System.out.println(" ]");
    }

    private String convertToStr(CrossResult crossResult) {
        if (crossResult == CrossResult.SUCCESS)
            return "O";
        else if (crossResult == CrossResult.FAILURE)
            return "X";
        return " ";
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<CrossResult> topRoad, List<CrossResult> downRoad,
                            boolean isEnd, int numOfAttempts) {
        System.out.println("최종 게임 결과");
        printMap(topRoad, downRoad);
        System.out.println("게임 성공 여부: " + getSuccessOrNot(isEnd));
        System.out.println("총 시도한 횟수: " + numOfAttempts);
    }

    private String getSuccessOrNot(boolean isEnd) {
        if (isEnd)
            return SUCCESS;
        return FAILURE;
    }
}
