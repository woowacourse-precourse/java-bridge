package bridge.view;

import bridge.controller.BridgeGame;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private String SPACE = " ";
    private String BLOCK = "|";
    private String RIGHT = "O";
    private String NOPE = "X";

    public static List<String> upList = new ArrayList<>();
    public static List<String> downList = new ArrayList<>();


    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> upBridge, List<String> downBridge) {

        System.out.println(upBridge.toString().replaceAll(",","|"));
        System.out.println(downBridge.toString().replaceAll(",","|"));
    }


    public List<String> falseUpList(String ans, int count) {
        if(ans.equals("U")) {
            if (count == 0) {
                upList.add(NOPE);
            }
            if (count > 0) {
                upList.add(SPACE + BLOCK + SPACE+ NOPE);
            }
            return upList;
        }

            if(count == 0){
                upList.add(SPACE);
            }
            if(count > 0){
                upList.add(SPACE + BLOCK + SPACE +SPACE);
            }
        return upList;
    }

    public List<String> falseDownList(String ans, int count) {
        if(ans.equals("U")) {
            if (count == 0) {
                downList.add(SPACE);
            }
            if (count > 0) {
                downList.add(BLOCK + SPACE +SPACE);
            }
        }
        if(ans.equals("D")){
            if(count == 0){
                downList.add(NOPE);
            }
            if(count > 0){
                downList.add(BLOCK + SPACE +NOPE);
            }
        }
        return downList;
    }


    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(String result) {
        System.out.println("\n최종 게임 결과");
        System.out.println(upList.toString().replaceAll(",",""));
        System.out.println(downList.toString().replaceAll(",",""));
        System.out.println("\n게임 성공 여부: " + result);
        System.out.println("총 시도한 횟수: " + BridgeGame.gameCount);

    }


    public List<String> rightDownList(int count, String next) {
        if(next.equals("D")) {
            if (count == 0) {
                downList.add(SPACE + RIGHT);
                upList.add(SPACE+SPACE);
            }
            if (count > 0) {
                downList.add(RIGHT+SPACE);
                upList.add(SPACE+SPACE);

            }
        }

        return downList;
    }

    public List<String> rightUpList(int count,String next) {
        if(next.equals("U")){
            if(count == 0){
                upList.add(" O ");
                downList.add("   ") ;
            }
            if(count > 0){

                upList.add(RIGHT+SPACE);
                downList.add(SPACE+SPACE);
            }
        }
        return upList;
    }
}
