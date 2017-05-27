package com.licc.trade.util;

import com.google.common.collect.Lists;
import com.licc.btc.chbtcapi.enums.ETradeOrderStatus;
import com.licc.btc.chbtcapi.enums.ETradeOrderType;
import com.licc.trade.domain.OrderNumber;
import com.licc.trade.domain.TradeOrder;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author 李长超
 * @version 1.0.0
 * @date 2017/5/22 16:23
 * @see
 */
public class TradeUtil {

    /**
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

    public static String getSellPrice(String sell) {
        BigDecimal price = new BigDecimal(sell);
        return price.subtract(new BigDecimal("0.01")).toString();

    }


    public static String getSellPriceByBuy(String buyPrice, String orderSellDiff) {
        BigDecimal buyPriceBD = new BigDecimal(buyPrice);
        BigDecimal orderSellBD = new BigDecimal(orderSellDiff);
        return buyPriceBD.add(orderSellBD).toString();

    }

    public static String getBuyPrice(String sell) {
        BigDecimal price = new BigDecimal(sell);
        return price.add(new BigDecimal("0.11")).toString();

    }

    public static OrderNumber getBuyNumber(String hight, String curreyBuyPrice, List<OrderNumber> list) {
        BigDecimal hightD = new BigDecimal(hight);
        BigDecimal curreyBuyPriceD = new BigDecimal(curreyBuyPrice);
        BigDecimal diff = hightD.subtract(curreyBuyPriceD);
          OrderNumber orderNumberRes = null;
        for(OrderNumber orderNumber:list) {
            String start = orderNumber.getHightBuyStart();
            String end = orderNumber.getHightBuyEnd();
            BigDecimal startD = new BigDecimal(start);
            BigDecimal endD = new BigDecimal(end);
            if (diff.compareTo(startD)>0&& endD.compareTo(diff) >= 0) {
              orderNumberRes = orderNumber;
              break;
            }
        }
        return orderNumberRes;

    }

    public static void main(String arge[]) {
   OrderNumber orderNumber1 =  new OrderNumber();
        orderNumber1.setHightBuyStart("0");
        orderNumber1.setHightBuyEnd("10");
        orderNumber1.setOrderNumber(10);
        OrderNumber orderNumber2 =  new OrderNumber();
        orderNumber2.setHightBuyStart("10");
        orderNumber2.setHightBuyEnd("15");
        orderNumber2.setOrderNumber(15);
        OrderNumber orderNumber3 =  new OrderNumber();
        orderNumber3.setHightBuyStart("16");
        orderNumber3.setHightBuyEnd("999");
        orderNumber3.setOrderNumber(16);

        List<OrderNumber> list = Lists.newArrayList(orderNumber1,orderNumber2,orderNumber3);
        System.out.println(TradeUtil.getBuyNumber("143.09","133.08",list));

    }
}
