package net.messi.early.utils;

public class IDUtils {

    public static void main(String[] args) {
        System.out.println(IDUtils.createID());
    }

    private static byte[] lock = new byte[0];


    private final static long w = 100000000;

    public static String createID() {
        long r = 0;
        synchronized (lock) {
            r = (long) ((Math.random() + 1) * w);
        }

        return System.currentTimeMillis() + String.valueOf(r).substring(1);
    }

}
