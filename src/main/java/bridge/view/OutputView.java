package bridge.view;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String UP = "U";
    private static final String DOWN = "D";
    private static final String LINE = "|";
    private static final String EMPTY = "   ";
    private static final String CIRCLE = " O ";
    private static final String X_MARK = " X ";
    private static final String FINAL_GAME_RESULTS_MESSAGE = "최종 게임 결과\n";
    private static final String GAME_SUCCESS = "게임 성공 여부: 성공";
    private static final String GAME_FAIL = "게임 성공 여부: 실패";
    private static final String TOTAL_ATTEMPTS_MADE_MESSAGE = "총 시도한 횟수: %d";

    private StringBuilder gameProgress;
    public void printMap(List<String> bridges, int index, boolean isSuccess) {
        gameProgress = new StringBuilder();
        gameProgress.append("[");
        printTop(bridges,index,isSuccess);
        gameProgress.append("]\n");
        gameProgress.append("[");
        printDown(bridges,index,isSuccess);
        gameProgress.append("]\n");
        System.out.println(gameProgress);
    }

    private void printTop(List<String> bridges, int index, boolean isSuccess) {
        for(int i = 0; i <= index; i++){
            if(i!=0) gameProgress.append(LINE);
            // 1. 건널 수 있는 다리인 위쪽을 선택하여 건넜을 경우 O
            if(index == i && isSuccess && bridges.get(i).equals(UP)) gameProgress.append(CIRCLE);
            // 2. 건널 수 있는 다리인 아래쪽을 선택하여 건넜을 경우 빈칸
            if(index == i && isSuccess && bridges.get(i).equals(DOWN)) gameProgress.append(EMPTY);
            // 3. 잘못된 다리인 아래쪽을 선택하여 건넜을 경우 빈칸
            if(index == i && !isSuccess && bridges.get(i).equals(UP)) gameProgress.append(EMPTY);
            // 4. 잘못된 다리인 위쪽을 선택하여 건넜을 경우 X
            if(index == i && !isSuccess && !bridges.get(i).equals(UP)) gameProgress.append(X_MARK);
            // 이전 다리들 출력하는 것
            if(index != i && bridges.get(i).equals(UP)) gameProgress.append(CIRCLE);
            if(index != i && !bridges.get(i).equals(UP)) gameProgress.append(EMPTY);
        }
    }

    private void printDown(List<String> bridges, int index, boolean isSuccess) {
        for(int i = 0; i <= index; i++){
            if(i!=0) gameProgress.append(LINE);
            // 1. 건널 수 있는 다리인 아래쪽을 선택하여 건넜을 경우 O
            if(index == i && isSuccess && bridges.get(i).equals(DOWN)) gameProgress.append(CIRCLE);
            // 2. 건널 수 있는 다리인 위쪽을 선택하여 건넜을 경우 빈칸
            if(index == i && isSuccess && bridges.get(i).equals(UP)) gameProgress.append(EMPTY);
            // 3. 잘못된 다리인 위쪽을 선택하여 건넜을 경우 빈칸
            if(index == i && !isSuccess && bridges.get(i).equals(DOWN)) gameProgress.append(EMPTY);
            // 4. 잘못된 다리인 아래쪽을 선택하여 건넜을 경우 X
            if(index == i && !isSuccess && !bridges.get(i).equals(DOWN)) gameProgress.append(X_MARK);
            // 이전 다리들 출력하는 것
            if(index != i && bridges.get(i).equals(DOWN)) gameProgress.append(CIRCLE);
            if(index != i && !bridges.get(i).equals(DOWN)) gameProgress.append(EMPTY);
        }
    }

    public void printResult(List<String> bridges, int index, boolean isRunning) {
        System.out.println(FINAL_GAME_RESULTS_MESSAGE);
        if(isRunning) {
            printMap(bridges, index-1 , true);
            System.out.println(GAME_SUCCESS);
        }
        if(!isRunning) {
            printMap(bridges, index-1 , false);
            System.out.println(GAME_FAIL);
        }
    }

    public void printTotalAttemptsMade(int numberOfAttempts){
        System.out.printf(TOTAL_ATTEMPTS_MADE_MESSAGE, numberOfAttempts);
    }
}
