package view;

import domain.Message;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public static void printStartMessage() {
        System.out.println(Message.START_BRIDGE_GAME.get());
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> moveList, boolean success) {
        System.out.println(getRows(moveList, success, "U"));
        System.out.println(getRows(moveList, success, "D"));
    }

    public String getRows(List<String> moveList, boolean success, String position){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < moveList.size(); i ++) {
            String temp = "   |";
            if (moveList.get(i).equals(position)) {
                temp = appendElement(success, moveList.size() -1 == i);
            }
            result.append(temp);
        }
        return "[" + result.substring(0, result.length() - 1) + "]";
    }

    public String appendElement(boolean success, boolean last) {
        String temp = "";
        if (!success && last) {
            temp = " X |";
        }
        if (success){
            temp = " O |";
        }
        return temp;
    }

    public static void printInitialMap(){
        System.out.printf("[");
    }

    public static void printLastMap(){
        System.out.println("]");
    }


    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    public void printResult() {
    }
}
