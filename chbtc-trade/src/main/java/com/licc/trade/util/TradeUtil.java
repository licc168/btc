package com.licc.trade.util;

import java.math.BigDecimal;

/**
 *
 * @author 李长超
 * @version 1.0.0
 * @date 2017/5/22 16:23
 * @see
 */
public class TradeUtil {

    /**
     *
     * @param s1
     * @param s2
     * @param diff 设定的差值
     * @return
     */
    public static boolean diffString(String s1, String s2, String diff) {
        BigDecimal bd1 = new BigDecimal(s1);
        BigDecimal bd2 = new BigDecimal(s2);
        BigDecimal diffB = new BigDecimal(diff);
        BigDecimal diffBd = bd1.subtract(bd2);
        if (diffBd.compareTo(diffB) <= 0) {
            return false;
        }
        return true;
    }

    public static  String getSellPrice(String sell){
      BigDecimal price = new BigDecimal(sell);
      return price.subtract(new BigDecimal("0.01")).toString();

    }
    public static  String getBuyPrice(String sell){
        BigDecimal price = new BigDecimal(sell);
        return price.add(new BigDecimal("0.01")).toString();

    }
    public static void main(String arge[]){

        if(TradeUtil.diffString("65.5","65.15","0.1")){
            System.out.println(111);
        }
    }
}
