package net.messi.early.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class NumberUtils {


    /**
     * 到店取单 凭证
     *
     * @return
     */
    public static synchronized String singleProof() {
        Random random = new Random();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            int num = random.nextInt(9);
            builder.append(num);
        }
        return builder.toString();
    }


    /**
     * 随机生成六位数
     *
     * @return
     */
    public static synchronized String randomNumber() {
        Random random = new Random();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            int num = random.nextInt(9);
            builder.append(num);
        }
        return builder.toString();
    }

    public static Integer randomTenToTwenty() {
        int max = 20;
        int min = 10;
        Random random = new Random();

        int s = random.nextInt(max) % (min) + min;

        return s;
    }

    public static void main(String[] args) {

        System.out.println(randomTenToTwenty());
    }
}
