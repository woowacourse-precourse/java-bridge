package bridge.log;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogFormatter {

    public String format(Throwable e) {
        StringBuilder sb = new StringBuilder();
        setDate(sb);
        setMessage(e, sb);
        setStackTrace(e, sb);

        return sb.toString();
    }

    private StringBuilder setDate(StringBuilder sb) {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String date = LocalDateTime.now().format(dateFormat);
        sb.append(date);

        return sb;
    }

    private StringBuilder setMessage(Throwable e, StringBuilder sb) {
        sb.append(" [ERROR] ");
        sb.append(e.getMessage());
        sb.append("\n");

        return sb;
    }

    private StringBuilder setStackTrace(Throwable e, StringBuilder sb) {
        for (StackTraceElement element : e.getStackTrace()) {
            sb.append(element.toString());
            sb.append("\n");
        }

        return sb;
    }
}
