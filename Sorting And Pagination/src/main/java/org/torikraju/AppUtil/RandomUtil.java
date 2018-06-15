package org.torikraju.AppUtil;

import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;

import java.util.Random;

public class RandomUtil {

    public static int getAge(int min, int max) {
        return new Random().nextInt((max - min) + 1) + min;
    }

    public static int getAge() {
        return getAge(18, 60);
    }

    public static String getName() {
        Lorem lorem = LoremIpsum.getInstance();
        return lorem.getName();
    }


}
