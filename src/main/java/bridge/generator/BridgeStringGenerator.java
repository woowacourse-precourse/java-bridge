package bridge;

import java.util.List;
import java.util.function.Function;

public class BridgeStringGenerator {
    public static String generateFailString(List<String> footprints) {
        String result = getUpString(footprints, s -> {
            if (s.equals("U")) {
                return "X";
            }
            return " ";
        });

        return result + getDownString(footprints, s -> {
            if (s.equals("D")) {
                return "X";
            }
            return " ";
        });
    }

    public static String generateSuccessString(List<String> footprints) {
        String result = getUpString(footprints, s -> {
            if (s.equals("U")) {
                return "O";
            }
            return " ";
        });

        return result + getDownString(footprints, s -> {
            if (s.equals("D")) {
                return "O";
            }
            return " ";
        });
    }

    private static String getUpString(List<String> footprints, Function<String, String> function) {
        StringBuilder sb = new StringBuilder();

        sb.append("[ ");
        sb.append(appendSuccessString(footprints, s -> {
            if (s.equals("U")) {
                return "O";
            }
            return " ";
        }));

        sb.append(function.apply(footprints.get(footprints.size() - 1)));
        sb.append(" ]\n");
        return sb.toString();
    }

    private static String getDownString(List<String> footprints, Function<String, String> function) {
        StringBuilder sb = new StringBuilder();

        sb.append("[ ");
        sb.append(appendSuccessString(footprints, s -> {
            if (s.equals("D")) {
                return "O";
            }
            return " ";
        }));

        sb.append(function.apply(footprints.get(footprints.size() - 1)));
        sb.append(" ]\n");
        return sb.toString();
    }

    private static String appendSuccessString(List<String> footprints, Function<String, String> function) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < footprints.size() - 1; j++) {
            sb.append(function.apply(footprints.get(j)));
            sb.append(" | ");
        }
        return sb.toString();
    }
}
