package com.zeyferes;

public class Main {
    public static void main(String[] args) {

    }

    public static String calculateCRC(String input) {
        int crc = 0xFFFF;
        int polynomial = 0x1021;
        for (int c = 0; c < input.length(); c++) {
            crc ^= input.charAt(c) << 8;
            for (int i = 0; i < 8; i++) {
                crc = (crc & 0x8000) != 0 ? (crc << 1) ^ polynomial : crc << 1;
            }
        }
        crc &= 0xFFFF;
        return String.format("%04x", crc).toUpperCase();
    }
}