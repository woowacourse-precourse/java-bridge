package bridge;

import java.util.List;
import java.util.Objects;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String[] print_final(String[] print_string, String instruction, String answer){
        if (answer.equals("U")){
            if (instruction.equals("D")){print_string[0] += "  ]"; print_string[1] += "X ]"; return print_string;}
            if (instruction.equals("U")){print_string[0] += "O ]"; print_string[1] += "  ]"; return print_string;}}
        if (answer.equals("D")){
            if (instruction.equals("D")){print_string[0] += "  ]"; print_string[1] += "O ]"; return print_string;}
            if (instruction.equals("U")){print_string[0] += "X ]"; print_string[1] += "  ]"; return print_string;}}
        return print_string;
    }


    public String[] print_middle(String[] print_string, String instruction){
        if (instruction.equals("U")){
            print_string[0] += "O | ";
            print_string[1] += "  | ";}
        if (instruction.equals("D")){
            print_string[0] += "  | ";
            print_string[1] += "O | ";}
        return print_string;
    }
    public String[] print_String(){
        String first = "[ ";
        String second = "[ ";
        return new String[] {first, second};
    }
    public void printMap(int index_number, String instruction, List<String> bridge) {
        String[] print_string = print_String();
        for (int i = 0; i <= (index_number-1); i++){print_string = print_middle(print_string, bridge.get(i));}
        print_string = print_final(print_string, instruction, bridge.get(index_number));
        System.out.println(print_string[0]);
        System.out.println(print_string[1]);
        System.out.println("\n");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(int index_number, String instruction, List<String> bridge, Boolean win, int trial) {
        System.out.println("최종 게임 결과");
        printMap(index_number, instruction, bridge);
        String you_win = "";
        if (win){you_win = "성공";}
        if (!win){you_win = "실패";}
        System.out.println(String.format("게임 성공 여부: %s", you_win));
        System.out.println(String.format("총 시도한 횟수: %d", trial));
    }
}
