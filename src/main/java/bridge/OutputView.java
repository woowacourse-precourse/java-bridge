package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private StringBuilder sbUp = new StringBuilder();
    private StringBuilder sbDo = new StringBuilder();

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(String map) {
        System.out.println(map);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }

    public void printMapStart(){
        sbUp.append("[");
        sbDo.append("[");
    }

    public void printMapEnd(){
        sbUp.append("]");
        sbDo.append("]");
    }

    public void printMapBetween(){
        sbUp.append("|");
        sbDo.append("|");
    }

    public void printRequestUpDownMessage(){
        System.out.println("이동할 칸을 입력해주세요 (위: U, 아래: D)");
        System.out.println("");
    }

    public String printMoveUpDown(List<String> bridge, String input, int step){
        if(bridge.get(step).equals(input)){
            return " O ";
        }
        return " X ";
    }

    public void printGoUp(List<String> bridge, String input, int step){
        String result = printMoveUpDown(bridge, input, step);

        if(bridge.get(step).equals("U")) {
            if (result.equals(" O ")) {
                sbUp.append(result);
                sbDo.append("   ");
            }
            if (result.equals(" X ")) {
                sbUp.append("   ");
                sbDo.append(result);
            }
        }
    }

    public void printGoDown(List<String> bridge, String input, int step){
        String result = printMoveUpDown(bridge, input, step);

        if(bridge.get(step).equals("D")) {
            if (result.equals(" O ")) {
                sbUp.append("   ");
                sbDo.append(result);
            }
            if (result.equals(" X ")) {
                sbUp.append(result);
                sbDo.append("   ");
            }
        }
    }

    public void printEnd(List<String> bridge, int step){
        if(bridge.size() - 1  != step){
            printMapBetween();
        }
        if(bridge.size() - 1 == step){
            printMapEnd();
        }
    }

    public void printSuccess(List<String> bridge, int step){
        if(bridge.size() == step){
            System.out.println("게임 성공 여부 : 성공");
        }
        if(bridge.size() != step){
            System.out.println("게임 성공 여부 : 실패");
        }
    }

    public void printTryCount(int count){
        System.out.println("총 시도한 횟수: " + count);
    }
}
