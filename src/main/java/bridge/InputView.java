package bridge;

import camp.nextstep.edu.missionutils.Console;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class InputView {

    public static OutputView outputView = new OutputView();
    static int size = 0;
    static List<String> move = new ArrayList<>();

    public void readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        try {
            size = write_bridge_size();
            checkSizeValidation(size);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            readBridgeSize();
        }
    }

    public int write_bridge_size() {
        int answer;
        try {
            answer = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 잘못된 입력을 하였습니다.");
        }
        return answer;
    }

    public static void checkSizeValidation(int size){
        if(size < 3 || size > 20){
            throw new IllegalArgumentException("[ERROR] 다리의 크기는 3 이상 20 이하이여야 합니다.");
        }
    }

    public static void readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        try {
            move.add(checkMoving());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            readMoving();
        }
    }

    public static String checkMoving() {
        String answer = "";
        try {
            answer = Console.readLine();
            movingValidation(answer);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 잘못된 입력을 하였습니다.");
        }
        return answer;
    }

    public static void movingValidation(String answer){
        if(!Objects.equals(answer, "U") && !Objects.equals(answer, "D")){
            throw new IllegalArgumentException("[ERROR] U와 D로만 입력해주세요.");
        }

    }

    public static String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String a = "";
        try {
            a = Console.readLine();
            checkGameCommandValidation(a);
            checkGameCommand(a);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            readGameCommand();
        }
        return a;
    }

    public int getSize() {
        return size;
    }

    public List<String> getMove() {
        return move;
    }

    public static void checkGameCommand(String a){
        if(Objects.equals(a, "R")){
            restartGame();
        }
        if(Objects.equals(a,"Q")){
            endGame();
        }
    }

    public static void restartGame(){
        ++BridgeGame.play_count;
        OutputView.now_size = 0;
        move.clear();
        BridgeGame.playBridgeGame();
    }

    public static void endGame(){
        System.out.println("최종 게임 결과");
        outputView.printResult();
        System.out.println("\n게임 성공 여부 : 실패" +"\n" +
                "총 시도한 횟수 : " + BridgeGame.play_count);
    }

    public static void checkGameCommandValidation(String a){
        if(!Objects.equals(a, "Q") && !Objects.equals(a, "R")){
            throw new IllegalArgumentException("[ERROR] Q 와 R로만 입력해주세요.");
        }

    }
    public void clearMove(){
        move.clear();
    }

}
