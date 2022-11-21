package bridge;

public class VisualizeController {
    public VisualizeController(int idx) { // 지금 몇번째 판떼기에 있는지 받아와서 갱신하는 방식으로 바꾸기
        StringBuilder upperSubstring = new StringBuilder(Model.upperResult.replaceFirst("]", ""));
        StringBuilder lowerSubstring = new StringBuilder(Model.lowerResult.replaceFirst("]", ""));
        String currUser = Model.user.get(idx);
        String currBridge = Model.bridge.get(idx);
        if (idx > 0) { // 2칸 이상째 진행이면
            if (currUser.equals(currBridge)) {
                if (currUser.equals("U")) {
                    upperSubstring.append("| O ]");
                    lowerSubstring.append("|   ]");
                } else {
                    upperSubstring.append("|   ]");
                    lowerSubstring.append("| O ]");
                }
            } else {
                if (currUser.equals("U")) {
                    upperSubstring.append("| X ]");
                    lowerSubstring.append("|   ]");
                } else {
                    upperSubstring.append("|   ]");
                    lowerSubstring.append("| X ]");
                }
            }
        } else if (idx == 0) { // 첫 번째 진행이면
            if (currUser.equals(currBridge)) {
                if (currUser.equals("U")) {
                    upperSubstring.append(" O ]");
                    lowerSubstring.append("   ]");
                } else {
                    upperSubstring.append("   ]");
                    lowerSubstring.append(" O ]");
                }
            } else {
                if (currUser.equals("U")) {
                    upperSubstring.append(" X ]");
                    lowerSubstring.append("   ]");
                } else {
                    upperSubstring.append("   ]");
                    lowerSubstring.append(" X ]");
                }
            }
        }
        Model.upperResult = upperSubstring.toString();
        Model.lowerResult = lowerSubstring.toString();
    }
}
