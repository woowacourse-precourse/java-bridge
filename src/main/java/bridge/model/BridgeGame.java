package bridge.model;

import java.util.ArrayList;
import java.util.List;

import static bridge.model.BridgeMaker.makeBridge;
import static bridge.view.InputView.readMoving;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    static ArrayList<String> equalsCheck = new ArrayList<>();

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static ArrayList<String> move(int count, String upAndDown, List<String> bridges) {
        //String upAndDown = readMoving();
        String bridge = bridges.get(count);
        if(upAndDown.equals(bridge)){ // u u / u d / d d/ d u
            equalsCheck.add("O");
        }

        if(!upAndDown.equals(bridge)){
            equalsCheck.add("X");
        }


        System.out.println("equalsCheck:" + equalsCheck);
        return equalsCheck;
    }

    public static void moveResult(int index, String upAndDown, List<String> bridges, List<String> move){
        String first = "";
        String second = "";
        equalsCheck = move(index, upAndDown, bridges);

        // 1
        if(index == 0 && move.get(0).equals("U")){
            System.out.println("[ " + equalsCheck.get(index) + " ]");
            System.out.println("[   ]");
        }

        if(index == 0 && move.get(0).equals("D")){
            System.out.println("[   ]");
            System.out.println("[ " + equalsCheck.get(index) + " ]");
        }

        // 2
        if(index != 0){
            if(move.get(0).equals("U")){
                first += "[ " + equalsCheck.get(0) + " |";
                second += "[   |";
            }
            if(move.get(0).equals("D")){
                first += "[   |";
                second += "[ " + equalsCheck.get(0) + " |";
            }

            for(int cur = 1; cur < index; cur++){
                if(move.get(cur).equals("U")){
                    first += " " + equalsCheck.get(cur) + " |";
                    second += "   |";
                }
                if(move.get(cur).equals("D")){
                    first += "   |";
                    second += " " + equalsCheck.get(cur) + " |";
                }
            }
            if(move.get(index).equals("U")){
                first += " " + equalsCheck.get(index) + " ]";
                second += "   ]";
            }
            if(move.get(index).equals("D")){
                first += "   ]";
                second += " " + equalsCheck.get(index) + " ]";
            }

        }
        System.out.println(first);
        System.out.println(second);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
