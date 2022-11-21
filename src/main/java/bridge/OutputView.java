package bridge;

import java.util.List;

public class OutputView {
    public static void printStartGame(){
        System.out.println(Constant.START_GAME_MESSAGE);
    }

    public static void printMap(List<String> userLocation, List<String> bridgeAnswer) {
        for(int i=0;i<2;i++) {
            System.out.print(Constant.OPEN_BRACKET);
            printMapUpDown(userLocation, i, bridgeAnswer);
            System.out.println(Constant.CLOSE_BRACKET);
        }
    }

    public static void printMapUpDown(List<String> userLocation, int moveIndex, List<String> bridgeAnswer){
        for(int i=0;i<userLocation.size();i++){
                if(!isRightBridge(userLocation.get(i), bridgeAnswer.get(i)) && (userLocation.get(i).equals("U") && moveIndex==0 || userLocation.get(i).equals("D") && moveIndex==1)){
                    System.out.print(Constant.WRONG_WAY);
                    return;
            }
                if((userLocation.get(i).equals("U") && moveIndex==0) || (userLocation.get(i).equals("D") && moveIndex==1))
                    System.out.print(Constant.RIGHT_WAY);
                else
                    System.out.print(Constant.EMPTY_WAY);
                if(userLocation.size()-1!=i)
                    System.out.print(Constant.CONNECT_WAY);
        }
    }

    public static boolean isRightBridge(String currentUserLocation, String bridgeLocation){
        if(currentUserLocation.equals(bridgeLocation))
            return true;
        return false;
    }
    public static void printRequireSize(){
        System.out.println(Constant.REQUEST_BRIDGE_SIZE);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(Success successResult, int tryCounts) {
        System.out.println(Constant.GAME_IS_SUCCESS_MESSAGE+successResult.getIsSuccessWord());
        System.out.println(Constant.TOTAL_TRY_COUNT+tryCounts);
    }
}
