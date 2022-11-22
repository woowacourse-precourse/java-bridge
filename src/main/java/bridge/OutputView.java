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
    public boolean PRINT_MAP_UPPER_LAST(String Bridge_Correct_Last, String Str_Last){
        if(Bridge_Correct_Last.equals(Str_Last)){
            if(Str_Last.equals("U")){System.out.println(" O ]");}
            if(Str_Last.equals("D")){System.out.println("   ]");}
        }
        if(!Bridge_Correct_Last.equals(Str_Last)){
            if(Str_Last.equals("U")){System.out.println(" X ]");}
            if(Str_Last.equals("D")){System.out.println("   ]");}
            return false;
        }
        return true;
    }

    public boolean PRINT_MAP_UPPER_LINE(List<String> Bridge_Correct, String Input_History){
        System.out.print("[");
        for(int i = 0; i < Input_History.length()-1; i++){
            if(Bridge_Correct.get(i).equals("U")){System.out.print(" O |");}
            if(Bridge_Correct.get(i).equals("D")){System.out.print("   |");}
        }
        return PRINT_MAP_UPPER_LAST(Bridge_Correct.get(Input_History.length()-1), Input_History.substring(Input_History.length()-1));
    }

    public boolean PRINT_MAP_LOWER_LAST(String Bridge_Correct_Last, String Str_Last){
        if(Bridge_Correct_Last.equals(Str_Last)){
            if(Str_Last.equals("U")){System.out.println("   ]");}
            if(Str_Last.equals("D")){System.out.println(" O ]");}
        }
        if(!Bridge_Correct_Last.equals(Str_Last)){
            if(Str_Last.equals("U")){System.out.println("   ]");}
            if(Str_Last.equals("D")){System.out.println(" X ]");}
            return false;
        }
        return true;
    }

    public boolean PRINT_MAP_LOWER_LINE(List<String> Bridge_Correct, String Input_History){
        System.out.print("[");
        for(int i = 0; i < Input_History.length()-1; i++){
            if(Bridge_Correct.get(i).equals("U")){System.out.print("   |");}
            if(Bridge_Correct.get(i).equals("D")){System.out.print(" O |");}
        }
        return PRINT_MAP_LOWER_LAST(Bridge_Correct.get(Input_History.length()-1), Input_History.substring(Input_History.length()-1));
    }

    public boolean printMap(List<String> Bridge_Correct, String Input_History) {
        boolean result = true;
        if(!PRINT_MAP_UPPER_LINE(Bridge_Correct, Input_History)){
            result = false;
        }
        if(!PRINT_MAP_LOWER_LINE(Bridge_Correct, Input_History)){
            result = false;
        }
        return result;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String> Bridge_Correct, String Input_History, int Retry_Cnt) {
        System.out.println("최종 게임 결과");
        boolean Game_Result = printMap(Bridge_Correct, Input_History);
        if(Game_Result){System.out.println("게임 성공 여부: 성공");}
        if(!Game_Result){System.out.println("게임 성공 여부: 실패");}
        System.out.println(String.format("총 시도한 횟수: %d", Retry_Cnt));
    }
}
