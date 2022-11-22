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
        arry = new int[arry.length];

        System.out.print("[");

        for(int j=0;j<=i;j++) {
            if(udsel.equals("U")) {
                if(arry[i] == 0) { // U가 0이면 아니므로  X
                    System.out.print("X");
                    score=false;
                }else if(arry[i] == 1){
                    System.out.print("O");
                    score=true;
                }
            }else {
                System.out.print(" ");
            }

            if(i>0 && i!=j) {
                System.out.print("|");
            }
        }

        System.out.print("]\r\n");

        System.out.print("[");

        for(int j=0;j<=i;j++) {
            if(udsel.equals("D")) {
                if(arry[i] == 1) { // U가 0이면 아니므로  X
                    System.out.print("X");
                    score=false;
                }else if(arry[i] == 0){
                    System.out.print("O");
                    score=true;
                }else {
                    System.out.print(" ");
                }

            }else {
                System.out.print(" ");
            }

            if(i>0 && i!=j) {
                System.out.print("|");
            }

        }

        System.out.print("]");

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