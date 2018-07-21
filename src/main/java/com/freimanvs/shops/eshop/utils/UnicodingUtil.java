package com.freimanvs.shops.eshop.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class UnicodingUtil {

    private static final String PATH = "src/main/resources/MessageResources_ruru.properties";

    public static void main(String[] args) {
        try (java.util.Scanner sc = new java.util.Scanner(System.in)) {
            System.out.println("Key is ");
            String key = sc.nextLine();
            System.out.println("Value is ");
            String value = sc.nextLine();
            value = unicodeString(value);
            appendText("\r\n".concat(key).concat("=").concat(value), PATH);
        }
    }

    private static String unicodeString(String input) {
        return input.chars().mapToObj(x -> "\\u" + Integer.toHexString(x | 0x10000).substring(1)).
                reduce((s1, s2) -> s1 + s2).orElse("");
    }

    private static void appendText(String what, String where) {
        writeToFile(what, where, true);
    }

    private static void writeToFile(String what, String where, boolean append) {
        try(FileWriter fw = new FileWriter(new File(where), append)) {
            fw.write(what);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
