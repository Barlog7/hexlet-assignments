package org.example;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;


import static java.util.stream.Collectors.toMap;
import static org.apache.commons.lang3.math.NumberUtils.isCreatable;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class App {

    public static boolean isBracketsBalanced(String strElemets) {
        String[] arr = strElemets.split("");
        LinkedList list = new LinkedList<String>();
        //String sPoll = "";
        for (String s: arr) {

            if (s.equals("(")) {
                list.add(s);
            } else {
                //String set = list.pollLast();
                if (list.pollLast() == null) {
                    return false;
                }

            }

        }
        return list.size() == 0 ? true : false;
        /*if (list.size() == 0) {
            return true;
        } else {
            return false;
        }*/

    }

    public static void main(String[] args) {

        /*assertThat(App.isBracketsBalanced("")).isEqualTo(true);
        assertThat(App.isBracketsBalanced("()")).isEqualTo(true);
        assertThat(App.isBracketsBalanced("()()()")).isEqualTo(true);
        assertThat(App.isBracketsBalanced("(())")).isEqualTo(true);
        assertThat(App.isBracketsBalanced("(()()())")).isEqualTo(true);
        assertThat(App.isBracketsBalanced("(()")).isEqualTo(false);
        assertThat(App.isBracketsBalanced("())")).isEqualTo(false);
        assertThat(App.isBracketsBalanced(")(")).isEqualTo(false);
        assertThat(App.isBracketsBalanced("(()()")).isEqualTo(false);
*/
        boolean asr = true;
        asr = App.isBracketsBalanced("");
        asr = App.isBracketsBalanced("()");
        asr =App.isBracketsBalanced("()()()");
        asr = App.isBracketsBalanced("(())");
        asr =App.isBracketsBalanced("(()()())");
        asr =App.isBracketsBalanced("(()");
        asr =App.isBracketsBalanced("())");
        asr =App.isBracketsBalanced(")(");
        asr =App.isBracketsBalanced("(()()");

        var items = new ArrayList<String>();
        items.add("123");
        items.add("234");

        var itemsCopy = new ArrayList<>(items);
        items.add("333");
        items.set(0, "udemy");
        String s11 = itemsCopy.get(0);
        itemsCopy.add("444");
        String s12 = itemsCopy.get(2);

        var itemsU = new ArrayList<UserTest>();
        UserTest p1 = new UserTest(1, "aaaa");
        UserTest p2 = new UserTest(2, "bbbb");

        itemsU.add(p1);
        itemsU.add(p2);
        var itemsCopyU = new ArrayList<>(itemsU);
        p1.setName("cccc");
        String s20 = itemsU.get(0).getName();
        String s21 = itemsCopyU.get(0).getName();
        p1.setName("cccc");

        var list = new ArrayList<String>(List.of("Vasia", "Anton", "Srgey", "nik", "avram", "vakamba"));
        Collections.sort(list);
        Collections.sort(list, String.CASE_INSENSITIVE_ORDER);
        Collections.sort(list);
        //items.get(0).setFirstName("Another Name");
        //items.add(/* пользователь */);
        //items.add(/* пользователь */);
// Изменение имени пользователя в одном списке
// Отражается на пользователе в другом,
// так как это один и тот же объект
        // Изменение имени пользователя в одном списке//items.get(0);
        // Отражается на пользователе в другом,
        // так как это один и тот же объект/*  boolean b1 = true;
        /*String strcheck = "10:d3:2d06:24:400c:5ee0:be:3d";
        boolean b1 = isValidIPv6("10:d3:2d06:24:400c:5ee0:be:3d");
        System.out.println(b1);*//*
        b1 = App.isValidIPv6("10:d3:2d06:24:400c:5ee0:be:3d"); // true
        System.out.println(b1);
        b1 = App.isValidIPv6("0B0:0F09:7f05:e2F3:0D:0:e0:7000"); // true
        System.out.println(b1);
        b1 = App.isValidIPv6("000::B36:3C:00F0:7:937"); // true
        System.out.println(b1);
        b1 = App.isValidIPv6("::1"); // true
        System.out.println(b1);

        b1 = App.isValidIPv6("2607:G8B0:4010:801::1004"); // false
        System.out.println(b1);
        b1 = App.isValidIPv6("1001:208:67:4f00:e3::2c6:0"); // false
        System.out.println(b1);
        b1 = App.isValidIPv6("2.001::"); // false
        System.out.println(b1);
        b1 = App.isValidIPv6("9f8:0:69S0:9:9:d9a:672:f90d"); // false
        System.out.println(b1);
        System.out.println("  ");

        b1 = App.isValidIPv6("2001:::"); // false
        System.out.println(b1);*/
        long s1 = ipToDec("128.32.10.1");
        System.out.println(s1);
        long l3 = 2149583361L;
        //long l3 = 21495833L;
        String s2 = decToIp(l3);
        System.out.println(s2);

    }
public static boolean isValidIPv6(String sIPv6) {
    List<String> list = Stream.of(sIPv6.split("::"))
            .toList();
    int nCountDoubleDot = list.size();
    if (nCountDoubleDot > 2 ) {
        return false;
    }
    int nCountOther = (int) Stream.of(sIPv6.split(":"))
            .filter(x -> !x.isEmpty())
            .count();
    if ((nCountOther !=8 && nCountDoubleDot == 1) || (nCountOther >6 && nCountDoubleDot == 2)) {
        return false;
    }
    String strWithOutDot = sIPv6.replaceAll("::", "");
    if (strWithOutDot.length() !=0 && (strWithOutDot.charAt(0) == ':' || strWithOutDot.charAt(strWithOutDot.length() - 1) == ':')) {
        return false;
    }
    /*int dot = (int) Stream.of(strWithOutDot
            .split(":"))
            .filter(x -> x.isEmpty())
            .count();
    if (dot > 0) {
        return false;
    }*/

    //list.stream().filter(x -> !x.isEmpty()).forEach(x -> {});

    //int nCountOther = (int) Stream.of(sIPv6.split(":")).filter(x -> !x.isEmpty()).count();
    //int nCount0 = (int) Stream.of(sIPv6.split(":")).filter(x -> x.isEmpty()).count();
    //int nCount0 = (int) Stream.of(sIPv6.split(":")).filter(x -> !x.isEmpty()).count();
    /*if ((nCountOther !=8 && nCountDoubleDot == 1) || (nCountOther >6 && nCountDoubleDot == 2)) {
        return false;
    }*/
    int falseNumbers = (int) Stream.of(sIPv6.split(":"))
            .filter(x -> !x.isEmpty())
            .filter(x -> !isCheck(x)).count();
    if (falseNumbers !=0) {
        return false;
    }

    return true;
}
public static boolean isCheck(String str) {
    return NumberUtils.isCreatable("0x" + str) && (str.length() < 5);
}

 public static long ipToDec(String ip4) {

        String sHex = (Stream.of(ip4.split("\\."))
                .map(x -> Integer.parseInt(x))
                .map(y -> Integer.toHexString(y))
                .map(z -> add0(z))
                .collect(Collectors.joining()));
   //  sHex="80200a01";
        //long result = Integer.parseInt(sHex, 16);
        long result = Long.parseLong(sHex,16);
        return result;
 }
 public static String decToIp(Long number) {
        String sHex = Long.toHexString(number);
        sHex =  StringUtils.leftPad(sHex, 8, "0");
        sHex = Stream.of(Util.chunk(sHex, 2))
                .map(x -> Integer.parseInt(x, 16))
                .map(y -> String.valueOf(y))
                .collect(Collectors.joining("."));
        return sHex;
 }
 public static String add0 (String s1) {
     return s1.length() < 2 ? "0" + s1 : s1;
 }

}