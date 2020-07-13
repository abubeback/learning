package com.abu.jdk.primitive;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * == 为堆内存地址比较, Integer维持1个数值在[-128,127]的cache，这些cache引用对Integer对象地址是不变的
 * 但是不在这个范围内的数字，则new Integer(i) 这个地址是新的地址，内存地址不可能
 */
public class IntegerTest {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        Integer f1 = 100;
        Integer f2 = 100;
        Integer f3 = 150;
        Integer f4 = 150;
        // inside cache
        System.out.println(f1 == f2);//output true
        // outside cache
        System.out.println(f3 == f4);//output false
        //Integer 与 int == 比较, Integer会被拆箱
        System.out.println(f4 == 150);//output true

        Date date1 = new Date(1588605961000L);
        Date date2 = new Date(1588868764000L);

        System.out.println(sdf.format(date1));
        System.out.println(sdf.format(date2));


        String d = "14.00";
        BigDecimal b = new BigDecimal(4.0);
        b.setScale(2, BigDecimal.ROUND_HALF_UP);
        System.out.println(b);

        NumberFormat formatter = new DecimalFormat("#0.00");
        BigDecimal formattedOutput = new BigDecimal(formatter.format(4.0));
        System.out.println(formattedOutput);

        String result = String.format("%.10f", 14.0d);
        System.out.println(new BigDecimal(result));
    }
}
