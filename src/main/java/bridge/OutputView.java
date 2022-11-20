package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    public OutputView() {
        this.upResultList = new ArrayList<>();
        this.downResultList = new ArrayList<>();
    }

    private List<String> upResultList;
    private List<String> downResultList;
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap() {
        String UpResult = upResultList.toString().replace(", ","|");
        String DownResult = downResultList.toString().replace(", ","|");
        System.out.println(UpResult);
        System.out.println(DownResult);
    }
    public boolean makeResult(String Result,String input,boolean gameSet){
        if (Result.equals(input)){//정답일때
            if (input.equals("U")){
                // up 이면
                upResultList.add(" O ");
                downResultList.add("   ");
            }else {
                upResultList.add("   ");
                downResultList.add(" O ");
            }
        }else {
            //정답이 아닐때
            if (input.equals("U")){
                // up 이면
                upResultList.add(" X ");
                downResultList.add("   ");
                gameSet=true;
            }else {
                upResultList.add("   ");
                downResultList.add(" X ");
                gameSet=true;
            }
        }
        return gameSet;
    }
    public void printStart(){
        System.out.println("다리 건너기 게임을 시작합니다.");
    }


    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
