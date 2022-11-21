package bridge;

import java.util.List;
import java.util.ArrayList;
import java.lang.StringBuilder;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        ArrayList<Integer> randomnumbers = new ArrayList<>();
        StringBuilder sb = new StringBuilder("[");

        for (int loaction = 1; loaction <= size; loaction++) {
            int randomnumber = bridgeNumberGenerator.generate();
            randomnumbers.add(randomnumber);
        }

        sb = setFirstLine(randomnumbers, sb, size);
        sb = setMiddleLine(sb);
        sb = setSecondLine(randomnumbers, sb, size);
        sb = setLastLine(sb);

        List result =  List.of(sb);
        return result;
    }

    public StringBuilder setFirstLine(ArrayList<Integer> randomnumbers, StringBuilder sb, int size) {
        for (int location = 0; location < size; location++) {

            if (randomnumbers.get(location) == 1) {
                sb.append(" U ");
            }
            if (randomnumbers.get(location) == 0) {
                sb.append("   ");
            }
            sb.append("|");
        }
        return sb;
    }

    public StringBuilder setSecondLine(ArrayList<Integer> randomnumbers, StringBuilder sb, int size) {
        for (int location = 0; location < size; location++) {
            if (randomnumbers.get(location) == 0) {
                sb.append(" D ");
            }
            if (randomnumbers.get(location) == 1) {
                sb.append("   ");
            }
            sb.append("|");
        }
        return sb;
    }

    public StringBuilder setMiddleLine(StringBuilder sb) {
        sb.deleteCharAt(sb.length()-1);
        sb.append("]");
        sb.append(System.lineSeparator());
        sb.append("[");

        return sb;
    }

    public StringBuilder setLastLine(StringBuilder sb) {
        sb.deleteCharAt(sb.length()-1);
        sb.append("]");
        return sb;
    }
}
