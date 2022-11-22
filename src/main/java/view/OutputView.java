package view;

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
    public static void printMap(List<String> up_bridge, List<String> down_bridge) {
        System.out.println(make_string(up_bridge));
        System.out.println(make_string(down_bridge)+"\n");
    }
    public static String make_string(List<String> bridge){
        String str_bridge = "[ ";
        for (int i=0;i<bridge.size();i++) {
            if(i==0) str_bridge+=bridge.get(i);
            else str_bridge += " | " + bridge.get(i);
        }
        str_bridge+=" ]";
        return str_bridge;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(boolean success, int try_count) {
        if(success==true)
            System.out.println("게임 성공 여부: 성공");
        else
            System.out.println("게임 성공 여부: 실패");
        System.out.println("총 시도한 횟수: " + try_count);
    }
}
