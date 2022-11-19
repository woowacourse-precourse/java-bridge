package bridge.view;


import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    List<String> upList;
    List<String> downList;


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
                upList.add(ox);
                downList.add(" ");
            }
            if (userSelectList.get(i).equals("D")) {
                upList.add(" ");
                downList.add(ox);
            }
        }
    }

    // 유저 List와 정답 List를 비교하여 OX를 저장하는 기능
    public String compareOX(String makeBridge, String userSelect) {
        if (makeBridge.equals(userSelect)) {
           return "O";
        }
        return "X";
    }

}
