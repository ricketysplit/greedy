package com.ricketysplit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * User: mpmenne
 * Date: 6/18/14
 * Time: 3:06 AM
 */
@Component
public class CoinCalculator {
    @Autowired
    private CoinFactory coinFactory;

    public CoinCalculator(){

    }

    public CoinCalculator(CoinFactory coinFactory){
        this.coinFactory = coinFactory;
    }

    public String calculateChange(){
        System.out.println("What amount of change needs to be returned?");
        String amountOfChange = "";
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));){
            amountOfChange = br.readLine();
        } catch (IOException e) {
            System.out.println("Unable to read line, please try again");
        }
        return calculateChange(amountOfChange);
    }

    public String calculateChange(String amountOfChange) {
        char currencySign = amountOfChange.charAt(0);
        String[] parts = amountOfChange.split("\\.");
        amountOfChange = parts[0].substring((setCurrency(currencySign) ? 1 : 0),parts[0].length())+parts[1];
        Integer change = Integer.parseInt(amountOfChange);
        StringBuilder changeStr = new StringBuilder();
        if(change==0){
            changeStr.append("No coins returned");
            return changeStr.toString();
        } else {
            setCurrency(currencySign);
            int currentCoin = 0;
            Coin[] coin = coinFactory.getCoins();
            while(change!=0){
                int coins = change / coin[currentCoin].getValue();
                if(coins==0){
                    currentCoin++;
                    continue;
                } else {
                    change = change % coin[currentCoin].getValue();
                    changeStr.append(coins + " " + (coins > 1 ? coin[currentCoin].getPluralName() : coin[currentCoin].getName())
                        + (change > 0 ? "\n" : ""));
                    currentCoin++;
                }

            }
        }
        return changeStr.toString();
    }

    public boolean setCurrency(char currency){
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        if(currency=='$'){
            coinFactory = (CoinFactory) context.getBean("USCurrency");
            return true;
        } else if(currency=='€'){
            coinFactory = (CoinFactory) context.getBean("EUCurrency");
            return true;
        }
        coinFactory = (CoinFactory) context.getBean("USCurrency");
        return false;
    }
}
