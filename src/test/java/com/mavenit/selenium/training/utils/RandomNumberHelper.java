package com.mavenit.selenium.training.utils;

import java.util.Random;

public class RandomNumberHelper {


    public int generateRandomNumber(int size){
        return new Random().nextInt(size-1);
    }
}
