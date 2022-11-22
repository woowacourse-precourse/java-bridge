package bridge.view;

import bridge.controller.BridgeGame;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private String START = "[";
    private String END = "]";
    private String SPACE = " ";
    private String BLOCK = "|";
    private String RIGHT = "O";
    private String NOPE = "X";

    private static List<String> upList;
    private static List<String> downList;


    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> upBridge, List<String> downBridge) {
        System.out.println(START + String.join("", upBridge) + END);
        System.out.println(START + String.join("", downBridge) +END);
    }


    public List<String> falseUpList(String ans, int count) {
        if(ans.equals("U")) {
            if (count == 0) {
                upList.add(NOPE);
            }
            if (count > 0) {
                upList.add(SPACE + BLOCK + SPACE+ NOPE);
            }
        }
        if(ans.equals("D")){
            if(count == 0){
                upList.add(SPACE);
            }
            if(count > 0){
                upList.add(SPACE + BLOCK + SPACE +SPACE);
            }
        }
        return upList;
    }

    public List<String> falseDownList(String ans, int count) {
        if(ans.equals("U")) {
            if (count == 0) {
                downList.add(SPACE);
            }
            if (count > 0) {
                downList.add(SPACE + BLOCK + SPACE +SPACE);
            }
        }
        if(ans.equals("D")){
            if(count == 0){
                downList.add(NOPE);
            }
            if(count > 0){
                downList.add(SPACE + BLOCK + SPACE +NOPE);
            }
        }
        return downList;
    }

    private void rightPrint(String ans ,int count) {
        if(ans.equals("U")){
            if(count == 0){
                upList.add(RIGHT);
                downList.add(SPACE);
            }
            if(count > 0){
                upList.add(SPACE + BLOCK + SPACE+RIGHT);
                downList.add(SPACE + BLOCK + SPACE+SPACE);
            }
        }
        if(ans.equals("D")){
            if(count == 0){
                upList.add(SPACE);
                downList.add(RIGHT);
            }
            if(count > 0){
                upList.add(SPACE + BLOCK + SPACE+SPACE);
                downList.add(SPACE + BLOCK + SPACE+RIGHT);
            }
        }
    }


    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(String result, int gameCount) {
        System.out.println("\n최종 게임 결과");
        System.out.println(START + upList + END);
        System.out.println(START + downList + END);
        System.out.println("\n게임 성공 여부: " + result);
        System.out.println("총 시도한 횟수: " + 0);

    }

    public void restart() {
    }

    public List<String> rightDownList(int count) {
        if(count == 0){
            downList.add(RIGHT);
        }
        if(count > 0){
            downList.add(SPACE + BLOCK + SPACE+RIGHT);
        }
        return downList;
    }

    public List<String> rightUpList(int count) {
        if(count == 0){
            upList.add(RIGHT);
        }
        if(count > 0){
            upList.add(SPACE + BLOCK + SPACE+RIGHT);

        }
        return upList;
    }
}
