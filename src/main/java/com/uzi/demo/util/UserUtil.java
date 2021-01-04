package com.uzi.demo.util;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserUtil {
    public static Boolean checkEmail(String email) {
        String check = "^([a-z0-9A-Z]+[-|.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        Pattern regex = Pattern.compile(check);
        Matcher matcher = regex.matcher(email);
        return matcher.matches();
    }

    public static String encodePassword(String psw) {
        return DigestUtils.sha1Hex(psw);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String s = scanner.next();
            System.out.println(encodePassword(s));
        }
    }
}
