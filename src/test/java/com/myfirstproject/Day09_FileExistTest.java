package com.myfirstproject;

import org.junit.Assert;
import org.junit.Test;

import java.awt.*;
import java.nio.file.Files;
import java.nio.file.Paths;

import static java.awt.SystemColor.desktop;
//Class: FileExistTest

public class Day09_FileExistTest {
            //Method: isExist

    @Test
    public void isExist(){

        //Pick a file on your desktop
                // Get the path of home directory
       String userHome = System.getProperty("user.home");
        System.out.println("userHome = " + userHome);
       String pathOfFile = userHome+"\\OneDrive\\Desktop\\Ödeme Tablosu.xlsx";
       //String pathOfFile = "C:\Users\necme\OneDrive\Desktop\mentor2.png\";
        System.out.println("pathOfFile = " + pathOfFile);

        //And verify if that file exist on your computer or not
        Assert.assertTrue(Files.exists(Paths.get(pathOfFile)));
    }
}
