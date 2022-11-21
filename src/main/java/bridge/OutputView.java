package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private final String wrongAnswer = "X";
    private final String rightAnswer = "O";
    private final String upPosition = "U";
    private final String downPosition = "D";
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> bridge, List<String> answer) {
        System.out.print("[");
        for(int i = 0; i < answer.size(); i++){
            printUpperMap(bridge.get(i), answer.get(i));
            if(i < answer.size() - 1) System.out.print("|");
        }
        System.out.println("]");
        System.out.print("[");
        for(int i = 0; i < answer.size(); i++){
            printBelowMap(bridge.get(i), answer.get(i));
            if(i < answer.size() - 1) System.out.print("|");
        }
        System.out.println("]");
    }
    private void printUpperMap(String bridge, String answer){
        if(answer.equals(rightAnswer) && bridge.equals(upPosition)) {
            System.out.print(" O ");
            return;
        }
        if(answer.equals(wrongAnswer) && bridge.equals(downPosition)){
            System.out.print(" X ");
            return;
        }
    }

    private void printBelowMap(String bridge, String answer){
        if(answer.equals(rightAnswer) && bridge.equals(downPosition)) {
            System.out.print(" O ");
            return;
        }
        if(answer.equals(wrongAnswer) && bridge.equals(upPosition)){
            System.out.print(" X ");
            return;
        }
    }
    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String> bridge, List<String> answer, int tryCount) {
        System.out.println("최종 게임 결과");
        printMap(bridge, answer);
        if(bridge.size() == answer.size() && answer.get(answer.size()-1).equals(rightAnswer)){
            System.out.println("게임 성공 여부 : 성공");
            System.out.println("총 시도한 횟수 : " + tryCount);
            return;
        }
        if(answer.get(answer.size()-1).equals(wrongAnswer)){
            System.out.println("게임 성공 여부 : 실패");
            System.out.println("총 시도한 횟수 : " + tryCount);
        }
    }
}
