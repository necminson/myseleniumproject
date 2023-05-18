package com.myfirstproject.day08;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.Cookie;

import java.util.Set;

import static com.myfirstproject.utilities.ReusableMethodsUtils.waitFor;

public class Day08_Cookies extends TestBase {

    @Test
    public void cookiesTest(){
        //-Go to amazon and automate the tasks:
        driver.get("http://www.amazon.com");
        //1. Find the total number of cookies
        Set<Cookie> setOfAllCookies = driver.manage().getCookies();
        waitFor(3000);
        int numOfAllCookies = setOfAllCookies.size();
        System.out.println("numOfAllCookies = " + numOfAllCookies);
        //2. Print all the cookies
        setOfAllCookies.stream().forEach(t-> System.out.println(t));// All Cookies
        System.out.println("----------------------------------------------");
        setOfAllCookies.stream().forEach(t-> System.out.println(t.getValue()));//All Cookies by vales
        System.out.println("----------------------------------------------");
        setOfAllCookies.stream().forEach(t-> System.out.println(t.getName()));// All Cookies by names
        System.out.println("----------------------------------------------");
        setOfAllCookies.stream().forEach(t-> System.out.println(t.getExpiry()));// All Cookies by names
        System.out.println("----------------------------------------------");
        setOfAllCookies.stream().forEach(t-> System.out.println(t.getDomain()));// All Cookies by names
        System.out.println("----------------------------------------------");

        //3. Get the cookies by their name
        driver.manage().getCookieNamed("i18n-prefs");// returns entire specific cookie with the given name
        //4. Add new cookie
        Cookie myFavoriteCookie = new Cookie("my-cookie","chocolate-chips");
        driver.manage().addCookie(myFavoriteCookie);
        waitFor(3000);
        System.out.println(driver.manage().getCookieNamed("my-cookie"));
        int totalNumOfAllCookies = driver.manage().getCookies().size();
        System.out.println("totalNumOfAllCookies = " + totalNumOfAllCookies);
        //5. Delete cookie by name
        driver.manage().deleteCookieNamed("session-id");
        waitFor(3000);
        System.out.println(driver.manage().getCookies().size());
        //6. Delete all of the cookies
        driver.manage().deleteAllCookies();
        waitFor(3000);
        System.out.println(driver.manage().getCookies().size());
    }
    @Test
    public void cookiesTest02()  { // Ahmet instructor's typing
        driver.get("https:www.amazon.com");
//        1. Find the total number of cookies
        Set<Cookie> allCookies = driver.manage().getCookies();
        int totalNumCookies = allCookies.size();
        System.out.println("Cookie Size : "+totalNumCookies);
//        2. Print all the cookies
        for (Cookie eachCookie : allCookies){
            System.out.println("Cookie --->>> "+eachCookie);
            System.out.println("Cookie Value --->>> "+eachCookie.getValue());
            System.out.println("Cookie Name --->>> "+eachCookie.getName());
            System.out.println("Cookie Expire --->>> "+eachCookie.getExpiry());
            System.out.println("Cookie Domain --->>> "+eachCookie.getDomain());
        }
//        3. Get the cookies by their name
//        entering cookie name, returning the entire cookie
        System.out.println("Cookie by Name : "+ driver.manage().getCookieNamed("i18n-prefs"));
//        4. Add new cookie
        Cookie myFavoriteCookie = new Cookie("my-cookie","chocolate-chips");
        driver.manage().addCookie(myFavoriteCookie);
        waitFor(3000);
        int newTotalNumberOfCookies = driver.manage().getCookies().size();
        System.out.println("New Total Number Of Cookies --->>> "+newTotalNumberOfCookies);
//        5. Delete cookie by name
//        passing the name of the cookie, and deleting that cookie
        driver.manage().deleteCookieNamed("session-id");
        waitFor(3000);
        System.out.println("After deletion 1 cookie : "+driver.manage().getCookies().size());
//        6. Delete all of the cookies
        driver.manage().deleteAllCookies();
        waitFor(3000);
        System.out.println("Final number of cookies --->>> "+driver.manage().getCookies().size());
    }
}
