package bridge.view;

import bridge.message.ProgressMessage;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    List<String> upList;
    List<String> downList;

    // 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
    public void printMap(List<String> makeBridgeList, List<String> userSelectList) {
        this.upList = new ArrayList<>();
        this.downList = new ArrayList<>();
        addUpAndDownList(makeBridgeList, userSelectList);
        printMapForm(upList);
        printMapForm(downList);
        System.out.println();
    }

    // 주어진 List에 따라 다리의 그림을 출력하는 기능
    public void printMapForm(List<String> oxList) {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ").append(oxList.get(0));
        for (int i = 1 ; i < oxList.size(); i++) {
            sb.append(" | ").append(oxList.get(i));
        }
        sb.append(" ]");
        System.out.println(sb);
    }

    // 유저 List의 U와 D를 비교하여 두개의 List에 저장하는 기능
    public void addUpAndDownList(List<String> makeBridgeList, List<String> userSelectList) {
        for (int i = 0 ; i < userSelectList.size(); i++) {
            String ox = compareOX(makeBridgeList.get(i),userSelectList.get(i));
            if (userSelectList.get(i).equals("U")) {
                addOX(ox, " ");
            }
            if (userSelectList.get(i).equals("D")) {
                addOX(" ", ox);
            }
        }
    }

    // ox와 빈칸을 저장하는 기능
    private void addOX(String addUp, String addDown) {
            upList.add(addUp);
            downList.add(addDown);
    }

    // 유저 List와 정답 List를 비교하여 OX를 저장하는 기능
    public String compareOX(String makeBridge, String userSelect) {
        if (makeBridge.equals(userSelect)) {
           return "O";
        }
        return "X";
    }

    // 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
    public void printResult(boolean isSuccess,int gameCount) {
        System.out.println(ProgressMessage.GAME_RESULT_MESSAGE);
        printMapForm(upList);
        printMapForm(downList);
        System.out.println();
        successOrFail(isSuccess);
        System.out.print(ProgressMessage.TOTAL_GAME_COUNT_MESSAGE);
        System.out.println(gameCount);
    }

    // 성공 실패 여부를 출력하는 기능
    private void successOrFail(boolean isSuccess) {
        if (isSuccess) {
            System.out.println(ProgressMessage.SUCCESS_GAME_MESSAGE);
        }
        if (!(isSuccess)) {
            System.out.println(ProgressMessage.FAIL_GAME_MESSAGE);
        }
    }

}
