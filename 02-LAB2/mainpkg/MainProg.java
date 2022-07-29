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

public class MainProg
{
    public static void main(String[] args)
            
    {
       float x = Float.parseFloat(args[0]);
       float y = Float.parseFloat(args[2]);
       float res = 0; 
      
       switch (args[1])
       {
           case "+":
             res = x+y;
             System.out.println(" x + y = " + res);
            break;
            
           case "-":
               res = x-y;
               System.out.println(" x - y = " + res);
               break;
               
           case "/":
           res = x/y;
           System.out.println(" x / y = " + res);
           break;
           
           case ".":
               res = x*y;
               System.out.println(" x * y = " + res);
           break;  
           
           default:
               System.out.println(" undefined  operator !");
            break;   
                    
       }
       
//        IPcutter.parseIP(args[0]); 
        
        String star = "*";
        for (int i = 0; i<6; i++)
        {
            System.out.println(star);
            star += "*";
        }
        
              
 
        for (int i=0; i<6; i++)   
        {      
            for (int j=6-i; j>1; j--)   
            {   
                System.out.print(" ");   
            }    
            for (int j=0; j<=i; j++ )   
            {       
                System.out.print("* ");   
            }   

            System.out.println();       
        }   
      
    }
       
}
