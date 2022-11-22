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

        upUI = progressUI(bridgeGame,true);
        downUI = progressUI(bridgeGame, false);

        System.out.println(upUI);
        System.out.println(downUI);
    }

    private StringBuilder progressUI(BridgeGame bridgeGame, boolean isUp){
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for(int i=0; i<bridgeGame.getMoveProgress().size(); i++){
            sb.append(progressUIMiddle(bridgeGame, isUp, i));
            if(bridgeGame.getMoveProgress().size()-1 != i){
                sb.append(" | ");
            }
        }
        sb.append(" ]");
        return sb;
    }

    private String progressUIMiddle(BridgeGame bridgeGame, boolean isUp, int index){
        if(isUp && bridgeGame.getMoveProgress().get(index).equals("U")){
            return middleResult(bridgeGame,index);
        }
        if(!isUp && bridgeGame.getMoveProgress().get(index).equals("D")){
            return middleResult(bridgeGame,index);
        }
        return " ";
    }

    private String middleResult(BridgeGame bridgeGame, int index){
        if(!bridgeGame.isMoveOk() && index == bridgeGame.getMoveProgress().size()-1)
            return "X";
        return "O";
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
