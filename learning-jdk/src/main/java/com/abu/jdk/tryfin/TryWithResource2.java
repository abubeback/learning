package com.abu.jdk.tryfin;

public class TryWithResource2 {
    public static void main(String[] args) {
        try (Connection conn = new Connection()) {
            conn.sendData();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("finally part");
        }
    }
}