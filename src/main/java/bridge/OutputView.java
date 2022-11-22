package bridge;

import java.util.List;

public class OutputView {

    public void printMap(List<List<String>> map) {
        for(List<String> halfmap : map) {
            System.out.print("[");
            for (int i = 0; i < halfmap.size(); i++) {
                System.out.print(" " + halfmap.get(i) + " ");
                printBarorEnd(i, halfmap.size());
            }
        }
    }

    private void printBarorEnd(int idx, int size) {
        if(idx+1 >= size) {
            System.out.println("]");
        }
        if(idx+1 < size) {
            System.out.print("|");
        }
    }

    public void printResult(boolean flag, List<List<String>> map, int count) {
        System.out.println("최종 게임 결과");
        printMap(map);
        printFaliorSuccess(flag);
        System.out.println("총 시도한 횟수: "+count);
    }

    private void printFaliorSuccess(boolean flag) {
        System.out.print("게임 성공 여부: ");
        if(flag) {
            System.out.println("성공");
        }
        if(!flag) {
            System.out.println("실패");
        }
    }
}
