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
        List<String> bridge = bridgeGame.getBridge();
        List<String> playerCommand = bridgeGame.getPlayerCommand();
        int size = playerCommand.size();

        System.out.print("[");
        for (int i=0; i<size; i++){
            if(playerCommand.get(i).equals("U")){
                if(bridge.get(i).equals(playerCommand.get(i))){
                    System.out.print(" O ");
                }
                if(!bridge.get(i).equals(playerCommand.get(i))){
                    System.out.print(" X ");
                }
            }
            if(playerCommand.get(i).equals("D")){
                System.out.print("   ");
            }
            if(i+1 != size){
                System.out.print("|");
            }
        }
        System.out.println("]");

        System.out.print("[");
        for (int i=0; i<size; i++){
            if(playerCommand.get(i).equals("D")){
                if(bridge.get(i).equals(playerCommand.get(i))){
                    System.out.print(" O ");
                }
                if(!bridge.get(i).equals(playerCommand.get(i))){
                    System.out.print(" X ");
                }
            }
            if(playerCommand.get(i).equals("U")){
                System.out.print("   ");
            }
            if(i+1 != size){
                System.out.print("|");
            }
        }
        System.out.println("]");
    }



    public void printErrorMessage(String message){
        System.out.println(message);
    }

    public void printStartMessage(){
        System.out.println("다리 건너기 게임을 시작합니다.");
    }
}
