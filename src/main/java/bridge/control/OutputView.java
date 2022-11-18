package bridge.control;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private StringBuilder new_build_up = new StringBuilder("[ ");
    private StringBuilder new_build_down = new StringBuilder("[ ");

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> bridge) {
        for(String signal : bridge){
            if(signal.equals("U")) new_build_up.append("O | ");
            if(signal.equals("D")) new_build_down.append("O | ");
            if(signal.equals("U_X")) new_build_up.append("X | ");
            if(signal.equals("D_X")) new_build_down.append("X | ");
        }
        int temper = new_build_up.length()-1;
        System.out.println();
        new_build_up.deleteCharAt(temper).deleteCharAt(temper-1);
        new_build_down.deleteCharAt(temper).deleteCharAt(temper-1);
        new_build_up.append("]");
        new_build_down.append("]");
        System.out.println(new_build_up + "\n" + new_build_down + "\n");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String> bridge, int game_time, String game_status) {
        System.out.println("최종 게임 결과");
        printMap(bridge);
        System.out.println("게임 성공 여부: " + game_status);
        System.out.println("총 시도한 횟수: " + game_time);
    }
}
