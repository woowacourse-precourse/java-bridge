package bridge;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker{
    public static List<String> bridgeUpDown = new ArrayList<String>();
    public static List<Integer> bridgeUp = new ArrayList<Integer>();
    public static List<Integer> bridgeDown = new ArrayList<Integer>();

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public String changeGenerateNumUpDown(int generateNum){
        if(generateNum == 1){
            return "U";
        }if(generateNum == 0){
            return "D";
        }
        return " ";
    }
    /**
     * @param bridgelength 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */

    public List<String> makeBridge(int bridgelength) {
        for (int i = 0; i < bridgelength; i++) {
            bridgeUpDown.add(changeGenerateNumUpDown(bridgeNumberGenerator.generate()));
        }
        generateUpbridge();
        generateDownbridge();
        return bridgeUpDown;
    }


    public void generateUpbridge(){
        bridgeUp = new ArrayList<Integer>();
        for(int i = 0; i < bridgeUpDown.size(); i++){
            if(bridgeUpDown.get(i).equals("U")){
                bridgeUp.add(1);
            }if(bridgeUpDown.get(i).equals("D")){
                bridgeUp.add(0);
            }
        }
    }

    public void generateDownbridge(){
        bridgeDown =  new ArrayList<Integer>();
        for(int i = 0; i < bridgeUpDown.size(); i++){
            if(bridgeUpDown.get(i).equals("U")){
                bridgeDown.add(0);
            }if(bridgeUpDown.get(i).equals("D")){
                bridgeDown.add(1);
            }
        }
    }

}
