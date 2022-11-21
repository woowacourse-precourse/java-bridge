package bridge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static List<String> mapUp = new ArrayList<>(Arrays.asList(new String[]{"[ ", " ]"}));
    private static List<String> mapDown = new ArrayList<>(Arrays.asList(new String[]{"[ ", " ]"}));
    private static final String CONTOUR = " | ";
    private static String str;
    String addOxContour;
    String emptyContour;

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(String map) {
        // X가 틀린 곳에 있어야함..
        System.out.println(map);
    }
private enum sf{
        SUCCESS(true, "성공"),
    FAIL(false, "실패");

        boolean tf;
        String sungsil;

    sf(boolean tf, String sungsil) {
        this.tf = tf;
        this.sungsil=sungsil;

    }
    public boolean getTf(){
        return this.tf;
    }
    public String getsungsil(){
        return this.sungsil;
    }

}

public sf originFromsf(boolean successFail){
        if (successFail == true){
            return sf.SUCCESS;
        }
    return sf.FAIL;
}

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(int tryNumber, boolean successFail) {
        System.out.println("최종 게임 결과");
        System.out.println(this.str);
        sf origin = originFromsf(successFail);

        System.out.println("게임 성공 여부: "+origin.getsungsil()+"\n"
                + "총 시도한 횟수: "+tryNumber);
    }
}
