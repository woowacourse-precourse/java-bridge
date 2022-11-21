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
            // 1. 건널 수 있는 다리인 위쪽을 선택하여 건넜을 경우 O
            if(index == i && isSuccess && bridges.get(i).equals("U")) sb.append(" O ");
            // 2. 건널 수 있는 다리인 아래쪽을 선택하여 건넜을 경우 빈칸
            if(index == i && isSuccess && bridges.get(i).equals("D")) sb.append("   ");
            // 3. 잘못된 다리인 아래쪽을 선택하여 건넜을 경우 빈칸
            if(index == i && !isSuccess && bridges.get(i).equals("U")) sb.append("   ");
            // 4. 잘못된 다리인 위쪽을 선택하여 건넜을 경우 X
            if(index == i && !isSuccess && !bridges.get(i).equals("U")) sb.append(" X ");
            // 이전 다리들 출력하는 것
            if(index != i && bridges.get(i).equals("U"))sb.append(" O ");
            if(index != i && !bridges.get(i).equals("U")) sb.append("   ");
        }
    }

    private void printDown(List<String> bridges, int index, boolean isSuccess) {
        for(int i = 0; i <= index; i++){
            if(i!=0) sb.append("|");
            // 1. 건널 수 있는 다리인 아래쪽을 선택하여 건넜을 경우 O
            if(index == i && isSuccess && bridges.get(i).equals("D")) sb.append(" O ");
            // 2. 건널 수 있는 다리인 위쪽을 선택하여 건넜을 경우 빈칸
            if(index == i && isSuccess && bridges.get(i).equals("U")) sb.append("   ");
            // 3. 잘못된 다리인 위쪽을 선택하여 건넜을 경우 빈칸
            if(index == i && !isSuccess && bridges.get(i).equals("D")) sb.append("   ");
            // 4. 잘못된 다리인 아래쪽을 선택하여 건넜을 경우 X
            if(index == i && !isSuccess && !bridges.get(i).equals("D")) sb.append(" X ");
            // 이전 다리들 출력하는 것
            if(index != i && bridges.get(i).equals("D"))sb.append(" O ");
            if(index != i && !bridges.get(i).equals("D")) sb.append("   ");
        }
    }



    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String> bridges, int index, boolean isRunning) {
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
    }

    public void printTotalAttemptsMade(int numberOfAttempts){
        System.out.printf("총 시도한 횟수: %d", numberOfAttempts);
    }
}
