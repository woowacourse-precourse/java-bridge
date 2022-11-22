package bridge;

import java.util.ArrayList;
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

    // static 선언하면 new 새로운 객체를 생성해도 값이 그대로 남는다.
    List<String> upBridgeMap = new ArrayList<>();
    List<String> downBridgeMap = new ArrayList<>();

    public boolean printMap(int count,String command,List<String> Bridge) {
        String mark=checkMap(command,count,Bridge);
        if (mark.equals(Constants.CROSS_MARK)){
            printOX(mark,command);
            printMartix(upBridgeMap,downBridgeMap);
            return false;
        };
        printOX(mark,command);
        printMartix(upBridgeMap,downBridgeMap);
        return true;
    }

    public void printResult(int number,boolean gameStatus) {
        String whether = "실패";
        System.out.println("최종 게임 결과");
        printMartix(upBridgeMap,downBridgeMap);
        if (gameStatus){whether = "성공";}
        System.out.println("게임 성공 여부: " + whether);
        System.out.println("총 시도한 횟수: " +number);
    }

    public String checkMap(String command,int count,List<String>Bridge) {
        int index = 0;
        // 1차원 배열에서 2의 배수씩 다음 칸으로 넘어가고, U는 0으로, D는 1로 표기하여 계산함
        if (command.equals("U")) {
            index = (count * 2) + 0;
            if (Bridge.get(index).equals("1")) {
                return Constants.CIRCLE_MARK;
            }
        }
        if (command.equals("D")) {
            index = (count * 2) + 1;
            if (Bridge.get(index).equals("1")) {
                return Constants.CIRCLE_MARK;
            }
        }
        return Constants.CROSS_MARK;
    }

    public void printOX(String mark,String command){
        if (command.equals("U")) {
            upBridgeMap.add(mark);
            downBridgeMap.add(Constants.BLANK_MARK);
        }
        if (command.equals("D")) {
            upBridgeMap.add(Constants.BLANK_MARK);
            downBridgeMap.add(mark);
        }
    }

    public void printMartix(List<String> upBridgeMap,List<String> downBridgeMap){
        System.out.printf("[" + String.join("|", upBridgeMap) + "]\n");
        System.out.printf("[" + String.join("|", downBridgeMap) + "]\n");
        System.out.println();

    }
}
