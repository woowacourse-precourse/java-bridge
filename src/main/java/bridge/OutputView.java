package bridge;
import java.util.List;
/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void printMap(List<List<String>> result) {
        for(int i=0; i<result.size(); i++){
            printUpOrDownMap(result.get(i));
        }
    }
    public void printUpOrDownMap(List<String> result){
        System.out.println("[");
        for(int i=0; i<result.size(); i++){
            System.out.printf(" %s ", result.get(i));
            if(i+1!=result.size()){
                System.out.print("|");
            }
        }
        System.out.println("]");
    }

    public void printResult(List<List<String>> result, boolean success, int tryCount) {
        System.out.println("최종 게임 결과");
        for(int i=0; i<result.size(); i++){
            printUpOrDownMap(result.get(i));
        }
        System.out.printf("게임 성공 여부: ", printSuccessOrNot(success));
        System.out.printf("총 시도한 횟수:", tryCount);;
        return;
    }

    public String printSuccessOrNot(boolean success){
        if(success) return "SUCCESS";
        return "FAIL";
    }
}
