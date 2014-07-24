package com.ricketysplit;

import java.util.Arrays;

/**
 * Created by r.harkins on 7/24/2014.
 */
public class CoinFactory {

    private Coin[] coins;

    public CoinFactory(Coin[] coins){
        this.coins = coins;
        Arrays.sort(coins);
    }

    public Coin[] getCoins(){
        return coins;
    }

}
