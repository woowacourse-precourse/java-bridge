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
    String[] correctUp;
    String[] correctDown;

    public OutputView(){
        answer = new ArrayList<>();
    }
    public void printMap(String direction, List<String> bridge, GameState state) {
        int size = bridge.size();
        correctUp = new String[size];
        correctDown = new String[size];
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





    public void init(){
        answer = new ArrayList<>();
    }
    public void gameStart(){
        System.out.println("다리 건너기 게임을 시작합니다.");
    }
    public void printResult(GameState state ,int retryStack) {
        System.out.println("최종 게임 결과");
        printList(correctUp);
        printList(correctDown);
        if(state == GameState.FALL){
            System.out.println("게임 성공 여부: 실패");}
        if(state == GameState.WIN){
            System.out.println("게임 성공 여부: 성공");}
        System.out.println("총 시도한 횟수: " + retryStack);
    }
}
