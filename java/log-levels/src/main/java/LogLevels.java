import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class LogLevels {

    public static String[] processString(String logLine) {
        Pattern pattern = Pattern.compile("^\\[(?<level>\\w+)\\]:\\s*(?<message>.+?)\\s*$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(logLine);
        if (matcher.matches()) {
            String[] logInfo = new String[] {
                    matcher.group("level").trim(),
                    matcher.group("message").trim()
            };
            return logInfo;
        } else {
            return new String[]{"", ""};
        }
    }

    public static String message(String logLine) {
        return processString(logLine)[1];
    }

    public static String logLevel(String logLine) {
        return processString(logLine)[0].toLowerCase();
    }

    public static String reformat(String logLine) {
        String message = message(logLine);
        String logLevel = logLevel(logLine);


        return message + " (" + logLevel + ")";
    }
}
