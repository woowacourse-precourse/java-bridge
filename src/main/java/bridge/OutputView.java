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
    public static void printMap(List<Integer> list, List<String> list2,int currentsize) {

        String upper="[";
        String lower="[";
        for(int i=0;i<currentsize;i++){;
            if(list.get(i)==1 && list2.get(i).equals("U")){
                upper+=" O ";
                lower+="   ";
            }
            if(list.get(i)==1 && list2.get(i).equals("D")){
                lower+=" O ";
                upper+="   ";
            }
            if(list.get(i)==0 && list2.get(i).equals("U")){
                upper+=" X ";
                lower+="   ";
            }
            if(list.get(i)==0 && list2.get(i).equals("D")){
                lower+=" X ";
                upper+="   ";
            }
            if (i==currentsize-1){
                break;
            }
            upper+="|";
            lower+="|";
        }
        upper+="]";
        lower+="]";
        System.out.println(upper);
        System.out.println(lower);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult() {
        System.out.println("최종 게임 결과");
        System.out.println("게임 성공 여부:");
        System.out.println("총 시도한 횟수");
    }
}
