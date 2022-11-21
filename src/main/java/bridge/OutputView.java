package bridge;

import java.util.List;

public class OutputView {
    public static void printStartGame(){
        System.out.println("다리 건너기 게임을 시작합니다. \n");
    }

    public static void printMap(List<String> userLocation, List<String> bridgeAnswer) {
        System.out.println("유저 정보"+userLocation+", 정답:"+bridgeAnswer);

        for(int i=0;i<2;i++) {
            System.out.print("[");

            printMapUpDown(userLocation, i);
            System.out.println("]");
        }
    }

    public static void printMapUpDown(List<String> userLocation, int moveIndex){
        for(int i=0;i<userLocation.size();i++){
                if((userLocation.get(i).equals("U") && moveIndex==0) || (userLocation.get(i).equals("D") && moveIndex==1))
                    System.out.print(" O ");
                else
                    System.out.print("   ");
                if(userLocation.size()-1!=i)
                    System.out.print(" | ");
        }
    }
    public static void printRequireSize(){
        System.out.println("다리 길이를 입력해주세요.");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(Success successResult, int tryCounts) {
        System.out.println("게임 성공 여부: "+successResult.getIsSuccessWord());
        System.out.println("총 시도한 횟수: "+tryCounts);
    }
}
