package bridge;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    public boolean score = true;//결과과 X면(-1) 게임 계속 할 지 묻기

    public boolean printMap(int i, int val ,String udsel, int[] arry) {

        System.out.print("[ ");
        if(udsel.equals("U") && val == 0) {//U가 입력되고 U가 0 틀릴때
            System.out.print("X");
            score=false;
        }else if(udsel.equals("U") && val == 1){ //U가 입력되고 U가 1 맞을때
            System.out.print("O");
            score=true;
        }else { System.out.print(" "); }
        System.out.print(" ]\r\n");
        System.out.print("[ ");
        if(udsel.equals("D") && val == 0) {//U가 입력되고 U가 0 틀릴때
            System.out.print("O");
            score=true;
        }else if(udsel.equals("D") && val == 1){ //U가 입력되고 U가 1 맞을때
            System.out.print("X");
            score=false;
        }else { System.out.print(" "); }
        System.out.print(" ]");

        return score;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}