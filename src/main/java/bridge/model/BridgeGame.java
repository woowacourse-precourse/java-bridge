package bridge.model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static bridge.model.BridgeMaker.makeBridge;
import static bridge.view.InputView.*;
import static bridge.view.OutputView.printMap;
import static bridge.view.OutputView.printResult;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    static ArrayList<String> equalsCheck = new ArrayList<>();
    public static ArrayList<String> resultFinal = new ArrayList<>();
    static int successCount = 0;

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static ArrayList<String> move(int count, String upAndDown, List<String> bridges) {
        //String upAndDown = readMoving();
        String bridge = bridges.get(count);

        if(upAndDown.equals(bridge)){ // u u / u d / d d/ d u
            equalsCheck.add("O");
        }

        if(!upAndDown.equals(bridge)){
            equalsCheck.add("X");
        }


        //System.out.println("equalsCheck:" + equalsCheck);
        return equalsCheck;
    }

    public static ArrayList<String> moveResult(int bridgeLen, int index, String upAndDown, ArrayList<String> bridges, List<String> move, int startCount){
        String first = "";
        String second = "";
        equalsCheck = move(index, upAndDown, bridges);
        if(equalsCheck.get(index).equals("O")){
            successCount++;
        }

        // 1
        if(index == 0 && move.get(0).equals("U")){
            System.out.println("[ " + equalsCheck.get(index) + " ]");
            System.out.println("[   ]");
        }

        if(index == 0 && move.get(0).equals("D")){
            System.out.println("[   ]");
            System.out.println("[ " + equalsCheck.get(index) + " ]");
        }

        // 2
        if(index != 0){
            if(move.get(0).equals("U")){
                first += "[ " + equalsCheck.get(0) + " |";
                second += "[   |";
            }
            if(move.get(0).equals("D")){
                first += "[   |";
                second += "[ " + equalsCheck.get(0) + " |";
            }

            for(int cur = 1; cur < index; cur++){
                if(move.get(cur).equals("U")){
                    first += " " + equalsCheck.get(cur) + " |";
                    second += "   |";
                }
                if(move.get(cur).equals("D")){
                    first += "   |";
                    second += " " + equalsCheck.get(cur) + " |";
                }
            }
            if(move.get(index).equals("U")){
                first += " " + equalsCheck.get(index) + " ]";
                second += "   ]";
            }
            if(move.get(index).equals("D")){
                first += "   ]";
                second += " " + equalsCheck.get(index) + " ]";
            }

        }
        printMap(first, second);

        if(index != (bridgeLen-1)){
            resultFinal.clear();
            resultFinal.add(String.valueOf(successCount));
            resultFinal.add(first);
            resultFinal.add(second);
        }


        if(index == (bridgeLen-1)){
            resultFinal.clear();
            resultFinal.add(String.valueOf(successCount));
            resultFinal.add(first);
            resultFinal.add(second);
        }
        if(equalsCheck.get(index).equals("X")){
            String input = readGameCommand();
            if(input.equals("R")){
                startCount++;
                retry(bridgeLen, bridges, startCount);
            }
            if(input.equals("Q")){
                //gameReStartFinal(resultFinal,startCount);
                printResult(resultFinal, startCount, 1);
                resultFinal.clear();
                resultFinal.add(String.valueOf(bridgeLen+1));
            }

        }
        return resultFinal;
    }

    public static void gameResult(ArrayList<String> resultFinal, int bridgeLen, ArrayList<String> bridges, int startCount){
        int successCount = Integer.parseInt(resultFinal.get(0));

        //System.out.println("successCount: " + successCount + ", bridgeLen:" + bridgeLen);
        if(successCount == bridgeLen){
            //gameResultFinal(resultFinal, startCount);
            printResult(resultFinal, startCount, 0);
        }

    }
    /*
    public static void gameResultFinal(ArrayList<String> resultFinal, int startCount){
        System.out.println("최종 게임 결과");
        System.out.println(resultFinal.get(1));
        System.out.println(resultFinal.get(2));
        System.out.println("");
        System.out.println("게임 성공 여부: 성공");
        System.out.println("총 시도한 횟수: " + startCount);
    }


     */



    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static int retry(int bridgeLen, ArrayList<String> bridges, int startCount) {
        equalsCheck.clear();
        successCount = 0;
        ArrayList<String> resultFinal = new ArrayList<>();
        resultFinal.clear();

        //System.out.println("equalsCheck: " + equalsCheck);
        //System.out.println("resultFinal: " + resultFinal);
        ArrayList<String> inputMove = new ArrayList<>();

        for (int count = 0; count < bridgeLen; count++) {
            System.out.println("count" + count);
            String move = readMoving();
            moveCheck(move);
            inputMove.add(move);
            resultFinal = moveResult(bridgeLen, count, move, bridges, inputMove, startCount);
        }

        //System.out.println("resultFinal: " + resultFinal);

        gameResult(resultFinal, bridgeLen, bridges, startCount);
        int count = bridgeLen;

        return count;

    }
    /*
    public static void gameReStartFinal(ArrayList<String> resultFinal, int startCount){
        System.out.println("최종 게임 결과");
        System.out.println(resultFinal.get(1));
        System.out.println(resultFinal.get(2));
        System.out.println("");
        System.out.println("게임 성공 여부: 실패");
        System.out.println("총 시도한 횟수: " + startCount);
    }

     */


}
