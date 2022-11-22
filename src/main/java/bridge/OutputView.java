package bridge;

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
    public void printMap(BridgeGame bridgeGame) {
        StringBuilder upUI;
        StringBuilder downUI;

        upUI = progressUI(bridgeGame.getMoveProgress(), true);
        downUI = progressUI(bridgeGame.getMoveProgress(), false);

        System.out.println(upUI);
        System.out.println(downUI);
    }

    private StringBuilder progressUI(List<String> progress, boolean isUp){
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for(int i=0; i<progress.size(); i++){
            sb.append(progressUIMiddle(progress.get(i), isUp));
            if(progress.size()-1 != i){
                sb.append(" | ");
            }
        }
        sb.append(" ]");
        return sb;
    }

    private String progressUIMiddle(String direction, boolean isUp){
        if(isUp && direction.equals("U")){
            return "O";
        }
        if(!isUp && direction.equals("D")){
            return "O";
        }
        return " ";
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGame bridgeGame) {
        System.out.println("최종 게임 결과");
        printMap(bridgeGame);

        String successText = "실패";
        if(bridgeGame.isMoveOk()){
            successText = "성공";
        }

        System.out.println("게임 성공 여부: " + successText);
        System.out.println("총 시도한 횟수: " + bridgeGame.getTryCnt());
    }
}
