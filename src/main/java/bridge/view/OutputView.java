package bridge.view;

import bridge.constant.PrintString;
import bridge.domain.MapPrinting;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(String Result) {
        System.out.println(Result);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(int count, MapPrinting mapPrinting, boolean isSuccess) {
        String gameResult="실패";
        System.out.println("최종 게임 결과");
        mapPrinting.makeList();
        if(isSuccess){
            gameResult="성공";
        }
        System.out.println("게임 성공 여부: " + gameResult);
        System.out.println("총 시도한 횟수: " + count);
    }
    
    public void printException(IllegalArgumentException e){
        System.out.println(e.getMessage());
    }

    public void printSetSize(){
        System.out.println(PrintString.SET_SIZE.getPrint());
    }

    public void printStart(){
        System.out.println(PrintString.INIT_START.getPrint());
    }

    public void printMove(){
        System.out.println(PrintString.MOVE.getPrint());
    }


    public void printRestart() {
        System.out.println(PrintString.RESTART.getPrint());
    }



}
