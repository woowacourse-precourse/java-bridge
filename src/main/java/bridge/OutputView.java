package bridge;

import java.awt.*;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {


    public void Upbridge(List<String> bridge, List<Integer> position_map, String moving) {
        for(int i = 0; i < position_map.indexOf(1); i++) {
            if(bridge.get(i).equals("U")) {
                System.out.print(" O |");
            }
            if(bridge.get(i).equals("D")) {
                System.out.print("   |");
            }
        }
        if(bridge.get(position_map.indexOf(1)).equals("U") && moving.equals("U")) {
            System.out.print(" O ");
        }
        if(bridge.get(position_map.indexOf(1)).equals("U") && moving.equals("D")) {
            System.out.print("   ");
        }
        if(bridge.get(position_map.indexOf(1)).equals("D") && moving.equals("D")) {
            System.out.print("   ");
        }
        if(bridge.get(position_map.indexOf(1)).equals("D") && moving.equals("U")) {
            System.out.print(" X ");
        }
    }

    public void Downbridge(List<String> bridge, List<Integer> position_map, String moving) {
        for(int i = 0; i < position_map.indexOf(1); i++) {
            if(bridge.get(i).equals("D")) {
                System.out.print(" O |");
            }
            if(bridge.get(i).equals("U")) {
                System.out.print("   |");
            }
        }
        if(bridge.get(position_map.indexOf(1)).equals("D") && moving.equals("D")) {
            System.out.print(" O ");
        }
        if(bridge.get(position_map.indexOf(1)).equals("D") && moving.equals("U")) {
            System.out.print("   ");
        }
        if(bridge.get(position_map.indexOf(1)).equals("U") && moving.equals("U")) {
            System.out.print("   ");
        }
        if(bridge.get(position_map.indexOf(1)).equals("U") && moving.equals("D")) {
            System.out.print(" X ");
        }
    }


    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> bridge, List<Integer> position_map, String moving) {
        System.out.print("[");
        Upbridge(bridge, position_map, moving);
        System.out.print("]\n");

        System.out.print("[");
        Downbridge(bridge, position_map, moving);
        System.out.print("]\n");
    }

    public void fail_Upbridge(List<String> bridge, List<Integer> position_map) {
        for(int i = 0; i < position_map.indexOf(-1); i++) {
            if(bridge.get(i).equals("U")) {
                System.out.print(" O |");
            }
            if(bridge.get(i).equals("D")) {
                System.out.print("   |");
            }
        }
        if(bridge.get(position_map.indexOf(-1)).equals("U")) {
            System.out.print("   ");
        }
        if(bridge.get(position_map.indexOf(-1)).equals("D")) {
            System.out.print(" X ");
        }
    }

    public void fail_Downbridge(List<String> bridge, List<Integer> position_map) {
        for(int i = 0; i < position_map.indexOf(-1); i++) {
            if(bridge.get(i).equals("D")) {
                System.out.print(" O |");
            }
            if(bridge.get(i).equals("U")) {
                System.out.print("   |");
            }
        }
        if(bridge.get(position_map.indexOf(-1)).equals("U")) {
            System.out.print(" X ");
        }
        if(bridge.get(position_map.indexOf(-1)).equals("D")) {
            System.out.print("   ");
        }
    }

    public void success_Upbridge(List<String> bridge, List<Integer> position_map) {
        for(int i = 0; i < position_map.indexOf(1) - 1 ; i++) {
            if(bridge.get(i).equals("U")) {
                System.out.print(" O |");
            }
            if(bridge.get(i).equals("D")) {
                System.out.print("   |");
            }
        }
        if(bridge.get(position_map.indexOf(1) - 1).equals("U")) {
            System.out.print(" O ");
        }
        if(bridge.get(position_map.indexOf(1) - 1).equals("D")) {
            System.out.print("   ");
        }
    }

    public void success_Downbridge(List<String> bridge, List<Integer> position_map) {
        for(int i = 0; i < position_map.indexOf(1) - 1; i++) {
            if(bridge.get(i).equals("D")) {
                System.out.print(" O |");
            }
            if(bridge.get(i).equals("U")) {
                System.out.print("   |");
            }
        }
        if(bridge.get(position_map.indexOf(1) - 1).equals("D")) {
            System.out.print(" O ");
        }
        if(bridge.get(position_map.indexOf(1) - 1).equals("U")) {
            System.out.print("   ");
        }
    }

    public void printFail(List<String> bridge, List<Integer> position_map, int cnt) {
        System.out.print("[");
        fail_Upbridge(bridge, position_map);
        System.out.print("]\n");

        System.out.print("[");
        fail_Downbridge(bridge, position_map);
        System.out.print("]\n");

        System.out.println("게임 성공 여부: 실패");
        System.out.println("총 시도한 횟수: " + cnt);
    }

    public void printSuccess(List<String> bridge, List<Integer> position_map, int cnt) {
        System.out.print("[");
        success_Upbridge(bridge, position_map);
        System.out.print("]\n");

        System.out.print("[");
        success_Downbridge(bridge, position_map);
        System.out.print("]\n");

        System.out.println("게임 성공 여부: 성공");
        System.out.println("총 시도한 횟수: " + cnt);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String> bridge, List<Integer> position_map, int cnt) {
        if(position_map.contains(-1)) {
            printFail(bridge, position_map, cnt);
        }
        if(!position_map.contains(-1)) {
            printSuccess(bridge, position_map, cnt);
        }
    }
}
