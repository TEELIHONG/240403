/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uum.hello;

import com.uum.HelloWorld;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author master lab
 */
public class TestHelloWorld {
    
    @Test
    public void testHello(){ //test means every single method you need to test
        HelloWorld hw = new HelloWorld();
        hw.sayHello("John");
        Assert.assertEquals("HeLl0 John","HeLl0 John");
    }
}
