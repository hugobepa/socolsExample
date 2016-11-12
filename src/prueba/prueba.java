/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author hugo
 */
public class prueba 
{
    private static final String REGEX = "\\bcat\\b";
   private static final String INPUT = "cat cat cat cattie cat";
    public static void main(String[] args) 
    {
       Pattern p = Pattern.compile(REGEX);
      Matcher m = p.matcher(INPUT);
        boolean b = m.matches(); 
        System.out.println(b);
    }
}
