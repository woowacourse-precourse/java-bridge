package bridge.model.ScreenGenerator;

import java.util.List;

public class WrongCaseGenerator implements ScreenGenerator{

    @Override
    public String generatedTable(List<String> answer, int current) {

        StringBuilder sb1 = new StringBuilder("[");
        StringBuilder sb2 = new StringBuilder("[");

        for (int i = 0; i < current; i++) {
            if (answer.get(i).equals("U")) {
                sb1.append(" O ");
                sb2.append("   ");
            } else if (answer.get(i).equals("D")) {
                sb1.append("   ");
                sb2.append(" O ");
            }
            sb1.append("|");
            sb2.append("|");
        }
        if (answer.get(current).equals("U")) {
            sb1.append("   ]");
            sb2.append(" X ]");
        } else if (answer.get(current).equals("D")) {
            sb1.append(" X ]");
            sb2.append("   ]");
        }
        sb1.append("\n");
        sb1.append(sb2);
        return sb1.toString();
    }
}
