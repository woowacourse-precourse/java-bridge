package bridge.view;


/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {


    // 유저 List와 정답 List를 비교하여 OX를 저장하는 기능
    public String compareOX(String makeBridge, String userSelect) {
        if (makeBridge.equals(userSelect)) {
           return "O";
        }
        return "X";
    }


}
