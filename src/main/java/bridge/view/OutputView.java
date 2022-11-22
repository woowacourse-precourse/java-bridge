package bridge.view;

import org.w3c.dom.ls.LSOutput;

import java.util.HashMap;
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
    public void printMap(int compareValue, String userMoving) {
        if(compareValue == 1){
            printCollectMap(userMoving);
            return;
        }
        printWrongMap(userMoving);
        return;
    }

    public void printCollectMap(String userMoving){
        if(userMoving.equals("U")){
            System.out.println("| O |");
            System.out.println("|   |");
            return;
        }
        System.out.println("|   |");
        System.out.println("| O |");
        return;
    }

    public void printWrongMap(String userMoving){
        if(userMoving.equals("U")){
            System.out.println("| X |");
            System.out.println("|   |");
            return;
        }
        System.out.println("|   |");
        System.out.println("| X |");
        return;
    }

    public void printFirstMap(int compare, String userMoving){
        if(compare == 1){
            printFirstCollectMap(userMoving);
            return;
        }
        printFirstWrongMap(userMoving);
        return;
    }

    public void printFirstCollectMap(String userMoving){
        if(userMoving.equals("U")){
            System.out.println("[ O |");
            System.out.println("[   |");
            return;
        }
        System.out.println("[   |");
        System.out.println("[ O |");
        return;
    }

    public void printFirstWrongMap(String userMoving){
        if(userMoving.equals("U")){
            System.out.println("[ X |");
            System.out.println("[   |");
            return;
        }
        System.out.println("[   |");
        System.out.println("[ X |");
        return;
    }

    public void printLastMap(int compare, String userMoving){
        if(compare == 1){
            printLastCollectMap(userMoving);
            return;
        }
        printLastWrongMap(userMoving);
        return;
    }
    public void printLastCollectMap(String userMoving){
        if(userMoving.equals("U")){
            System.out.println("| O ]");
            System.out.println("|   ]");
            return;
        }
        System.out.println("|   ]");
        System.out.println("| O ]");
        return;
    }

    public void printLastWrongMap(String userMoving){
        if(userMoving.equals("U")){
            System.out.println("| X ]");
            System.out.println("|   ]");
            return;
        }
        System.out.println("|   ]");
        System.out.println("| X ]");
        return;
    }


    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(int passCount, int BridgeSize) {

    }

    public void printTryCount(int tryCount){

    }

    private void checkResult(String result){

    }

    private void checkTryCount(int tryCount){

    }

    public static void printStart(){
        System.out.println("다리의 길이를 입력해주세요.");
    }

    public static void printUserMove(){
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    public static void printRetry() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }
}
