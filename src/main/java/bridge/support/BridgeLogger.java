package bridge.support;

import static bridge.utils.command.MoveCommand.COMMAND_DOWN;
import static bridge.utils.command.MoveCommand.COMMAND_UP;

public class BridgeLogger {
    
    private final StringBuilder UpLog = new StringBuilder();
    private final StringBuilder DownLog = new StringBuilder();

    private final static String PREFIX = "[ ";
    private final static String DIVISION = " | ";
    private final static String SUFFIX = " ]";
    private final static String NONE = " ";
    private final static String SUCCESS = "O";
    private final static String FAILURE = "X";

    public BridgeLogger() {
        UpLog.append(PREFIX);
        DownLog.append(PREFIX);
    }

    public void log(String input, boolean live) {
        String status = getStatus(live);

        if (COMMAND_UP.equals(input)) {
            logUPAndDown(status, NONE);
        }

        if (COMMAND_DOWN.equals(input)) {
            logUPAndDown(NONE, status);
        }
    }

    public void clear() {
        this.UpLog.delete(PREFIX.length(), UpLog.length());
        this.DownLog.delete(PREFIX.length(), DownLog.length());
    }

    private String getStatus(boolean live) {
        if (live) {
            return SUCCESS;
        }
        return FAILURE;
    }

    private void logUPAndDown(String up, String down) {
        UpLog.append(up).append(DIVISION);
        DownLog.append(down).append(DIVISION);
    }

    private String convertToResult(String log) {
        String refined = removeLastDivision(log);
        return refined + SUFFIX;
    }

    private String removeLastDivision(String log) {
        if (isInit(log)) {
            return log;
        }

        return log.substring(0, log.length() - DIVISION.length());
    }

    private boolean isInit(String log) {
        return log.length() == PREFIX.length();
    }

    @Override
    public String toString() {
        String upResult = convertToResult(UpLog.toString());
        String downResult = convertToResult(DownLog.toString());

        return upResult + "\n" + downResult;
    }

}
