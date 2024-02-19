package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// BEGIN
class Validator {
    public static List<String> validate(Address adr) {
        var list = new ArrayList<String>();
        Field[] fields = adr.getClass().getDeclaredFields();
        for (Field field : fields) {
            //System.out.println(field);
            NotNull checkField = field.getAnnotation(NotNull.class);
            String textField = null;
            try {
                field.setAccessible(true);
                textField = (String)field.get(adr);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
            if (checkField != null && textField == null) {
                list.add(field.getName());
            }
        }
        return list;
    }
    public static Map<String, List<String>> advancedValidate(Address adr) {
        //var list = new ArrayList<String>();
        //boolean bNull = false;
        //boolean bLength = false;
        var map = new HashMap<String, List<String>>();
        Field[] fields = adr.getClass().getDeclaredFields();
        for (Field field : fields) {
            //System.out.println(field);
            var list = new ArrayList<String>();
            NotNull checkField = field.getAnnotation(NotNull.class);
            MinLength checkFieldLength = field.getAnnotation(MinLength.class);
            String textField = null;
            int lengthText = 0;
            try {
                field.setAccessible(true);
                textField = (String)field.get(adr);
                if (textField != textField) {
                    lengthText = textField.length();
                }

            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
            if (checkFieldLength != null && lengthText < checkFieldLength.minLength()) {

                list.add("length less than " + checkFieldLength.minLength());
            }
            if (checkField != null && textField == null) {
                list.add("can not be null");
            }
            if (list.isEmpty() == false) {
                map.put(field.getName(), list);
            }
        }
        return map;
    }
}
// END
