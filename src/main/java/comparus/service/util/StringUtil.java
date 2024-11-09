package comparus.service.util;

public class StringUtil {
    public static int getFirstNumberByString(String value, String separator){
        try {
            String first = value.substring(0, value.indexOf(separator));
            return Integer.parseInt(first);
        } catch (Exception e){
        }
        return 0;
    }
    public static int getSecondNumberByString(String value, String separator){
        try {
            String second = value.substring(value.indexOf(separator)+1);
            return Integer.parseInt(second);
        } catch (Exception e){
        }
        return 0;
    }
}
