package bridge;

public class CompareBridge {
    public String validateBridge(String userData, String comData) {
        String data = "X";
        if (userData.equals(comData)) {
            data = "O";
        }return data;
    }
}
