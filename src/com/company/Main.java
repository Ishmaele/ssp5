package com.company;

import java.util.Scanner;
import java.io.*;
import java.util.*;

public class Main
{
    static Dictionary myDictionary = new Hashtable();

    public static char p[]  = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
            'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
            'w', 'x', 'y', 'z', ' ' };

    public static char ch[] = new char[27];

    //public static char chp[] = { 'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O',
      //      'P', 'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'Z', 'X', 'C',
      //      'V', 'B', 'N', 'M'};

    public static String Encryption(String s)
    {
        char c[] = new char[(s.length())];
        for (int i = 0; i < s.length(); i++)
        {
            for (int j = 0; j < 26; j++)
            {
                if (p[j] == s.charAt(i))
                {
                    c[i] = ch[j];
                    break;
                }
                else if (' ' == s.charAt(i))
                {
                    c[i] = ' ';
                    break;
                }
            }
        }
        return (new String(c));
    }

    public static String NewEncryption(String xx)
    {

        String x = new String();
        for (int i = 0; i < xx.length(); i++)
        {
            x=x+ myDictionary.get(xx.charAt(i)).toString();
        }
        return x;
    }


    public static String Decryption(String s)
    {
        char p1[] = new char[(s.length())];
        for (int i = 0; i < s.length(); i++)
        {
            for (int j = 0; j < 26; j++)
            {
                if (ch[j] == s.charAt(i))
                {
                    p1[i] = p[j];
                    break;
                }
                else if (' ' == s.charAt(i))
                {
                    p1[i] = ' ';
                    break;
                }
            }
        }
        return (new String(p1));
    }

    public static void main(String args[]) throws IOException
    {
        FileReader fr = new FileReader("key.txt");
        BufferedReader br = new BufferedReader(fr);
        br.read(ch);

        for (int i=0; i<27;i++)
            myDictionary.put(p[i],ch[i] );

        Scanner sc = new Scanner(System.in);
        System.out.println("Ввод сообщения: ");

        String en = NewEncryption(sc.nextLine().toLowerCase());
        System.out.println("Криптограмма: " + en);

       // String en = Encryption(sc.nextLine().toLowerCase());
       // System.out.println("Расшифровка: " + Decryption(en));
        sc.close();
    }
}