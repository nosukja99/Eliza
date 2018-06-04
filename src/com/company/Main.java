package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        String input;
        String output = "";
        ArrayList<String> hedges = new ArrayList<>();
        ArrayList<String> qualifiers = new ArrayList<>();
        hedges.add("Please tell me more");
        hedges.add("Many of my patients tell me the same thing");
        hedges.add("It is getting late, maybe we had better quit");

        qualifiers.add("Why do you say that");
        qualifiers.add("You seem to think that");
        qualifiers.add("So, you are concerned that");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Geed day. What is your problem?");
        System.out.println("Enter your response here or Q to quit: ");
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        input=buf.readLine();


        while (!input.equalsIgnoreCase("q")) {
            String[] splited = input.split("\\s+");
            for (int i=0; i<splited.length; i++)
            {
                if(splited[i].equals("I"))
                {
                    splited[i]="you";
                }
                if(splited[i].equals("my"))
                {
                    splited[i]="your";
                    //System.out.println("should be your "+splited[i]);
                }
                if (splited[i].equals("me")) {
                    splited[i] = "you";
                }
                if (splited[i].equals("am")) {
                    splited[i] = "are";
                }
            }

            for (int i=0; i<splited.length; i++)
            {
                output = output+" "+ splited[i];
            }

            Random rand = new Random();
            int x = rand.nextInt(2);
            switch (x) {
                case 0:
                    int i = rand.nextInt(3);
                    System.out.println(hedges.get(i));
                    output="";
                    break;
                case 1:
                    int n= rand.nextInt(3);
                    System.out.println(qualifiers.get(n)+output);
                    output="";
                    break;
            }
            System.out.println("Enter your response here or Q to quit: ");
            buf = new BufferedReader(new InputStreamReader(System.in));
            input=buf.readLine();
        }
    }
}
