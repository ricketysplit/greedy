package com.ricketysplit;

import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Created by r.harkins on 7/24/2014.
 */
@Component
public class CoinFactory {

    private Coin[] coins;

    public CoinFactory(){

    }

    public CoinFactory(Coin[] coins){
        this.coins = coins;
        Arrays.sort(coins);
    }

    public Coin[] getCoins(){
        return coins;
    }

}
