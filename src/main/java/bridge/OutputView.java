package bridge;

import java.sql.SQLOutput;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String start="[";
    private static final String end="]";
    private static final String rightSpaceWithWall=" 0 |";
    private static final String wrongSpaceWithWall=" X |";
    private static final String emptySpaceWithWall="   |";
    private static final String rightSpaceWithoutWall=" 0 ";
    private static final String wrongSpaceWithoutWall=" X ";
    private static final String emptySpaceWithoutWall="   ";


    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(Bridge bridge,Player player,String inputSpace) {
        List<String> spaces = bridge.getSpaces();
        int curSpace = player.getCurrentSpace();

        System.out.print(start);
        for(int i =0; i<curSpace-1;i++){
            //up 먼저 출력
            if(spaces.get(i)=="U"){
                System.out.print(" O |");
            }
            else{
                System.out.print("   |");
            }
        }

        if(inputSpace.equals("U")){
            if(bridge.isSuccess(curSpace,inputSpace)){
                System.out.println(" O ");
            }
            else{
                System.out.print(" X ");
            }
        }
        else{
            System.out.print("   ");
        }
        System.out.println(end);
        System.out.print(start);
        for(int i =0; i<curSpace-1;i++){
            //up 먼저 출력
            if(spaces.get(i)=="D"){
                System.out.print(" O |");
            }
            else{
                System.out.print("   |");
            }
        }

        if(inputSpace.equals("D")){
            if(bridge.isSuccess(curSpace,inputSpace)){
                System.out.println(" O ");
            }
            else{
                System.out.print(" X ");
            }
        }
        else{
            System.out.print("   ");
        }
        System.out.println(end);


    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
