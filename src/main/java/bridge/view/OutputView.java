package bridge.view;

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
    private StringBuilder sb;
    public void printMap(List<String> bridges, int index, boolean isSuccess) {
        sb = new StringBuilder();
        sb.append("[");
        printTop(bridges,index,isSuccess);
        sb.append("]\n");
        sb.append("[");
        printDown(bridges,index,isSuccess);
        sb.append("]\n");
        System.out.println(sb);
    }

    private void printTop(List<String> bridges, int index, boolean isSuccess) {
        for(int i = 0; i <= index; i++){
            if(i!=0) sb.append("|");
            if(index == i && isSuccess && bridges.get(i).equals("U")) sb.append(" O ");
            if(index == i && isSuccess && bridges.get(i).equals("D")) sb.append("   ");
            if(index == i && !isSuccess && bridges.get(i).equals("U")) sb.append("   ");
            if(index == i && !isSuccess && !bridges.get(i).equals("U")) sb.append(" X ");
            if(index != i && bridges.get(i).equals("U"))sb.append(" O ");
            if(index != i && !bridges.get(i).equals("U")) sb.append("   ");
        }
    }

    private void printDown(List<String> bridges, int index, boolean isSuccess) {
        for(int i = 0; i <= index; i++){
            if(i!=0) sb.append("|");
            if(index == i && isSuccess && bridges.get(i).equals("D")) sb.append(" O ");
            if(index == i && isSuccess && bridges.get(i).equals("U")) sb.append("   ");
            if(index == i && !isSuccess && bridges.get(i).equals("D")) sb.append("   ");
            if(index == i && !isSuccess && !bridges.get(i).equals("D")) sb.append(" X ");
            if(index != i && bridges.get(i).equals("D"))sb.append(" O ");
            if(index != i && !bridges.get(i).equals("D")) sb.append("   ");
        }
    }



    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String> bridges, int index, boolean isRunning, int count) {
        System.out.println("최종 게임 결과");
        System.out.println("");
        if(isRunning) {
            printMap(bridges, index-1 , true);
            System.out.println("게임 성공 여부: 성공");
        }
        if(!isRunning) {
            printMap(bridges, index-1 , false);
            System.out.println("게임 성공 여부: 실패");
        }
        System.out.printf("총 시도한 횟수: %d", count);
    }
}
