package comparus.service.util;

public class StringUtil {
    public static int getFirstNumberBySeparator(String value, String separator) {
        try {
            String first = value.substring(0, value.indexOf(separator));
            return Integer.parseInt(first);
        } catch (Exception e) {
            return 0;
        }
    }

    public static int getSecondNumberBySeparator(String value, String separator) {
        try {
            String second = value.substring(value.indexOf(separator) + 1);
            return Integer.parseInt(second);
        } catch (Exception e) {
            return 0;
        }
    }

    public static String getFirstPartOfString(String value, String separator) {
        try {
            return value.substring(0, value.indexOf(separator));
        } catch (Exception e) {
            return value;
        }
    }

    public static String getSecondPartOfString(String value, String separator) {
        try {
            return value.substring(value.indexOf(separator) + 1);
        } catch (Exception e) {
            return value;
        }
    }
}
