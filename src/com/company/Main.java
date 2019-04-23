package com.company;

import java.util.Scanner;
import java.io.*;

public class Main
{
    public static char p[]  = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
            'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
            'w', 'x', 'y', 'z', '*' };

    public static char ch[] = new char[26];

   // public static char ch[] = { 'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O',
     //       'P', 'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'Z', 'X', 'C',
       //     'V', 'B', 'N', 'M'};

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

        Scanner sc = new Scanner(System.in);
        System.out.println("Ввод сообщения: ");
        String en = Encryption(sc.nextLine().toLowerCase());
        System.out.println("Криптограмма: " + en);
        System.out.println("Расшифровка: " + Decryption(en));
        sc.close();
    }
}