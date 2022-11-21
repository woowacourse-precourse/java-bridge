package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    public void PrintText(String Text) {
        System.out.println(Text);
    }

    private String MakeMap(List<String> NowBorad,int NowValue,String CheckC) {
        String vstr = "[";
        for (int i=0; i<NowBorad.size();i++) {
            String tmpstr = "   ";
            if (NowBorad.get(i).contains(CheckC)) tmpstr = " O ";
            if (i==NowBorad.size()-1 && NowValue==0 && NowBorad.get(i).contains(CheckC)) tmpstr = " X ";
            vstr = vstr.concat(tmpstr);
            if (i<NowBorad.size()-1) vstr = vstr.concat("|");
        }
        return vstr.concat("]");
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> NowBoard,int NowValue) {
        PrintText(MakeMap(NowBoard,NowValue,"U"));
        PrintText(MakeMap(NowBoard,NowValue,"D"));
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(String Result,int TryNumber) {
        PrintText("게임 성공 여부: "+Result);
        PrintText("총 시도한 횟수: "+TryNumber);
    }
}
