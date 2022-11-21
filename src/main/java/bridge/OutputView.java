package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap() {
        if(Application.currentLocation == 0){
            return;
        }
        String upSide = "[";
        String downSide = "[";
        String correctSquare = "O";
        String failureSquare = " ";
        System.out.println(Application.currentLocation);
        for(int i = 0; i < Application.currentLocation; i++){
            if(!Application.success && i == Application.currentLocation - 1){
                correctSquare = " ";
                failureSquare = "X";
            }
            if(Application.bridge.get(i).equals("U")){
                upSide += (" "+ correctSquare +" |");
                downSide += (" "+ failureSquare +" |");
                continue;
            }
            upSide += (" "+ failureSquare +" |");
            downSide += (" "+ correctSquare +" |");
        }

        upSide = upSide.substring(0, upSide.length() - 1);
        downSide = downSide.substring(0, downSide.length() - 1);
        upSide += ("]");
        downSide += ("]");
        System.out.println(upSide);
        System.out.println(downSide);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
        System.out.println("최종 게임 결과");
        printMap();
        if(Application.success){
            System.out.println("게임 성공 여부: 성공");
            System.out.println("총 시도한 횟수: " + Application.tryCount);
            return;
        }
        System.out.println("게임 성공 여부: 실패");
        System.out.println("총 시도한 횟수: " + Application.tryCount);
    }
}
