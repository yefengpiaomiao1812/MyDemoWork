package com.example.cg.pattern.flywdight;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 享元模式
 * 出票口
 */
public class TicketFactory {
    private static Map<String ,Ticket> sTicketMap = new ConcurrentHashMap<String, Ticket>();

    public static Ticket getTicket(String from, String to){
        String key = from + "-" + to;
        if(sTicketMap.containsKey(key)){
            System.out.println("使用缓存==》" + key);
            return sTicketMap.get(key);
        }else{
            System.out.println("创建对象==》" + key);
            Ticket ticket = new TrainTicket(from, to);
            sTicketMap.put(key, ticket);
            return ticket;
        }
    }
}
