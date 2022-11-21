package bridge.helper;

import java.util.ArrayList;
import java.util.List;

public class TestData {

    public static List<String> generateExceptionData(int excludeNum1, int excludeNum2) {
        List<String> data = new ArrayList<>();
        for (int i = 33; i < 127; i++) {
            if (i == excludeNum1 || i == excludeNum2) {
                continue;
            }
            char letter = (char) i;
            data.add(String.valueOf(letter));
        }
        return data;
    }
}
