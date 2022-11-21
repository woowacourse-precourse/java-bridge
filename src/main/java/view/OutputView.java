package view;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String BLANK = " ";
    private static final String CORRECT = "O";
    private static final String WRONG = "X";
    private static final String START_STRING = "[ ";
    private static final String END_STRING = " ]";
    private static final String SEPARATION = " | ";


    public void printStart(){
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> upperLine, List<String> lowerLine) {
        System.out.println(START_STRING +String.join(SEPARATION,upperLine)+END_STRING);
        System.out.println(START_STRING +String.join(SEPARATION,lowerLine)+END_STRING);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    public void printEndMessage(){
        System.out.println("최종 게임 결과 ");
    }

    public void printResult(boolean success, int count ) {
        if (success) { System.out.println("게임 성공 여부: 성공"); }
        if (!success) { System.out.println("게임 성공 여부: 실패"); }
        System.out.printf("총 시도한 횟수: %d",count);
    }
}
