package com.myfirstproject;

import org.junit.*;

public class day03_Annotations {
/*
    *** There are 6 junit annotations
    1. @Test : is used to create test case. All test cases must be void.
    * Because test cases are created to do assertions
    2. @Before
 */
    @Before
    public void setUp(){
        System.out.println("This is BEFORE method>>>>>RUNS BEFORE EACH TEST METHOD");
        /*
        Pre conditions are put in this  @Before Metho
         */
    }

    @After
    public void tearDown(){
        System.out.println("This is AFTER method>>>>>RUNS AFTER EACH TEST METHOD");
    }

    @BeforeClass
    public static void setUpClass(){
        System.out.println("This is BEFORE CLASS>>>>>RUNS BEFORE EACH CLASS ONCE");
    }
    @AfterClass
    public static void tearDownClass(){
        System.out.println("This is AFTER CLASS>>>>>RUNS AFTER EACH CLASS ONCE");
    }


    @Test
    public void test01(){
        System.out.println("This is test case 1");
    }

    @Test
    public void test02(){
        System.out.println("This is test case 2");
    }

    @Test
    public void test03(){
        System.out.println("This is test case 3");
    }

    @Test @Ignore
    public void test04(){
        System.out.println("This is test case 4");
    }

    @Test
    public void test05(){
        System.out.println("This is test case 5");
    }
    @Test
    public void test06(){
        System.out.println("This is test case 6");
    }
}
