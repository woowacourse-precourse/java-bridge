package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private List<String> answer;
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    public OutputView(){
        answer = new ArrayList<>();
    }
    public void printMap(String direction, List<String> bridge, GameState state) {
        int size = bridge.size();
        String[] correctUp = new String[size];
        String[] correctDown = new String[size];

        answer.add(direction);
        correctUp = makeUpList(answer,state);
        correctDown = makeDownList(answer,state);

        printList(correctUp);
        printList(correctDown);
    }
    public void printList(String[] UDList ){
        System.out.print(" [ ");
        System.out.print(String.join(" | " , UDList));
        System.out.println(" ] ");
    }

    private String[] makeUpList(List<String> answer,GameState state){
        int size = answer.size();
        String[] uplist = new String[size];
        for(int i = 0 ; i < size ; i++){
            uplist[i] = " ";
            if(answer.get(i).equals("U")){
                uplist[i] = "O";
            }
        }
        if(state == GameState.FALL){
            if(answer.get(size-1).equals("U")){
                uplist[size-1] = "X";
            }
        }
        return uplist;
    }
    private String[] makeDownList(List<String> answer,GameState state){

        int size = answer.size();
        String[] downlist = new String[size];

        for(int i = 0 ; i < size ; i++){

            downlist[i] = " " ;
            if(answer.get(i).equals("D")){
                downlist[i] = "O";
            }
        }
        if(state == GameState.FALL){
            if(answer.get(size-1).equals("D")){
                downlist[size-1] = "X";
            }
        }
        return downlist;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void init(){
        answer = new ArrayList<>();
    }
    public void printResult(List<String> bridge, int location , String directin) {
       // String[] result = new String[];


    }
}
