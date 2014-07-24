package com.ricketysplit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * User: mpmenne
 * Date: 6/18/14
 * Time: 3:05 AM
 */
public class Greedy {

    private CoinCalculator coinCalculator;

    public static void main(String[] varArgs) {

        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

        Greedy obj = (Greedy) context.getBean("greedy");
        System.out.println(obj.coinCalculator.calculateChange());

    }

    public Greedy(CoinCalculator coinCalculator){
        this.coinCalculator = coinCalculator;
    }
}
