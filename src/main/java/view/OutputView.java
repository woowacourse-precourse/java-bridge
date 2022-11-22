package view;

import java.util.List;

public class OutputView {

    private static final String START_STRING = "[ ";
    private static final String END_STRING = " ]";
    private static final String SEPARATION = " | ";


    public void printStart(){
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    public void printMap(List<String> upperLine, List<String> lowerLine) {
        System.out.println(START_STRING +String.join(SEPARATION,upperLine)+END_STRING);
        System.out.println(START_STRING +String.join(SEPARATION,lowerLine)+END_STRING);
    }

    public void printResult(boolean success, int count ) {
        System.out.println("최종 게임 결과 ");
        if (success) { System.out.println("게임 성공 여부: 성공"); }
        if (!success) { System.out.println("게임 성공 여부: 실패"); }
        System.out.printf("총 시도한 횟수: %d",count);
    }
}
