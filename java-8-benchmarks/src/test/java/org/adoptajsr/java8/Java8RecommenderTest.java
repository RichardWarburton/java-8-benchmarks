package org.adoptajsr.java8;

import org.adoptajsr.java8.Purchases.Purchase;
import org.junit.Assert;
import org.junit.Test;

public class Java8RecommenderTest {
    
    public static void main(String[] args) {
        new Java8RecommenderTest().example();
    }
    
    // products: 3 .. 10
    // users: 1,2
    @Test
    public void example() {
        Purchases purchases = new Purchases();
        buy(purchases, 4, 5, 2);
        buy(purchases, 3, 10, 1);
        
        Java8Recommender recommender = new Java8Recommender();
        recommender.inject(purchases);
        recommender.preprocess();
        
        Assert.assertTrue(recommender.alsoBought(4, 1).contains(5));
        Assert.assertTrue(recommender.alsoBought(5, 1).contains(4));
    }

    private void buy(Purchases purchases, int firstProduct, int lastProduct, int user) {
        for (int i = firstProduct; i <= lastProduct; i++) {
            purchases.addPurchase(new Purchase(user, i));
        }
    }

}
