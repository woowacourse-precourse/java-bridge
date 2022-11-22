package bridge.controller;


import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    public static int gameCount;
    public static boolean end;
    public static List<String> bridge;

    public static String restartGame(List<String> bridge, int index) {
        if(!end){
            return "FAIL";
        }
        if(bridge.size() == index){
            return "SUCCESS";
        }
        return "GOON";
    }
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String move(List<String> bridgeList, String answer,int index) {
            bridge = bridgeList;
            String ans = bridge.get(index);
            if (ans.equals(answer)) {
                if(answer.equals("U")){
                    return "U";
                }
                if(answer.equals("D")){
                    return "D";
                }

            }
            end = false;
            return "F";
        }


    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static String retry(String com) {
           if(com.equals("R")){
               gameCount++;
               return "R";
           }
           return "Q";
    }



}