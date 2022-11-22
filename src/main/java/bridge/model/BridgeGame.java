package bridge.model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static bridge.model.BridgeGame.resultFinal;
import static bridge.view.InputView.*;
import static bridge.view.OutputView.printMap;
import static bridge.view.OutputView.printResult;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private BridgeMaker bridgeMaker;
    static ArrayList<String> equalsCheck = new ArrayList<>();
    public static ArrayList<String> resultFinal = new ArrayList<>();
    static int successCount = 0;


    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static ArrayList<String> move(int count, String upAndDown, List<String> bridges) {
        String bridge = bridges.get(count);

        if(upAndDown.equals(bridge)){
            equalsCheck.add("O");
        }

        if(!upAndDown.equals(bridge)){
            equalsCheck.add("X");
        }

        return equalsCheck;
    }

    public static ArrayList<String> moveResult(int bridgeLen, int index, String upAndDown, ArrayList<String> bridges, List<String> move, int startCount){
        String first = "";
        String second = "";
        equalsCheck = move(index, upAndDown, bridges);
        if(equalsCheck.get(index).equals("O")){
            successCount++;
        }

        moveResultFirst(index, move);


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
        inputResultFinal(index, bridgeLen, first, second);
        resultFinal = optionRandQ(index, startCount, bridgeLen, bridges);

        return resultFinal;
    }

    public static void moveResultFirst(int index, List<String> move){
        if(index == 0 && move.get(0).equals("U")){
            System.out.println("[ " + equalsCheck.get(index) + " ]");
            System.out.println("[   ]");
        }

        if(index == 0 && move.get(0).equals("D")){
            System.out.println("[   ]");
            System.out.println("[ " + equalsCheck.get(index) + " ]");
        }

    }

    public static void moveResultSecond1(String first, String second, List<String> move){
        if(move.get(0).equals("U")){
            first += "[ " + equalsCheck.get(0) + " |";
            second += "[   |";
        }
        if(move.get(0).equals("D")){
            first += "[   |";
            second += "[ " + equalsCheck.get(0) + " |";
        }

    }
    public static void moveResultSecond2(int index, String first, String second, List<String> move){
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
    }

    public static void moveResultSecond3(int index, String first, String second, List<String> move){
        if(move.get(index).equals("U")){
            first += " " + equalsCheck.get(index) + " ]";
            second += "   ]";
        }
        if(move.get(index).equals("D")){
            first += "   ]";
            second += " " + equalsCheck.get(index) + " ]";
        }
    }
    public static void inputResultFinal(int index, int bridgeLen, String first, String second){
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
    }

    public static ArrayList<String> optionRandQ(int index, int startCount, int bridgeLen, ArrayList<String> bridges){
        if(equalsCheck.get(index).equals("X")){
            String input = readGameCommand();
            if(input.equals("R")){
                startCount++;
                retry(bridgeLen, bridges, startCount);
            }
            if(input.equals("Q")){
                printResult(resultFinal, startCount, 1);
                resultFinal.clear();
                resultFinal.add(String.valueOf(bridgeLen+1));
            }
        }
        return resultFinal;
    }

    public static void gameResult(ArrayList<String> resultFinal, int bridgeLen, ArrayList<String> bridges, int startCount){
        int successCount = Integer.parseInt(resultFinal.get(0));

        if(successCount == bridgeLen){
            printResult(resultFinal, startCount, 0);
        }

    }



    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void retry(int bridgeLen, ArrayList<String> bridges, int startCount) {
        equalsCheck.clear();
        successCount = 0;
        int check = 0;
        ArrayList<String> resultFinal = new ArrayList<>();
        resultFinal.clear();

        ArrayList<String> inputMove = new ArrayList<>();

        for (int count = 0; count < bridgeLen; count++) {

            System.out.println("count" + count);
            String move = readMoving();
            moveCheck(move);
            inputMove.add(move);
            resultFinal = moveResult(bridgeLen, count, move, bridges, inputMove, startCount);
            //System.out.println("result: " + resultFinal.toString());

            if(resultFinal.size() != 0 && Integer.parseInt(resultFinal.get(0)) == bridgeLen){
                //System.out.println("여기");
                check++;
                break;
            }

        }

        //System.out.println("check" + check);
        if(check == 0){
            gameResult(resultFinal, bridgeLen, bridges, startCount);
        }

    }


}
