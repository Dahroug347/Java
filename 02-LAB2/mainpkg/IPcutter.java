/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpkg;

/**
 *
 * @author mahmoud
 */
public class IPcutter 
                                                    
{  
    public static void parseIP ( String aRgs)
    {
         String str = aRgs;
         String[] res = str.split("\\.");  //regular expression
         
           for(String myStr: res) {
           System.out.println(myStr);
       }
    }
}