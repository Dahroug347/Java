/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;


import complexpkg.*;
/**
 *
 * @author mahmoud
 */
public class MainClass
{
    public static void main(String[] args)
    {
        System.out.println("Hello Java");
        
        for (int i = 0; i<args.length; i++)     
        System.out.println(args[i]);
        
        Complex sumresult = new Complex();
        Complex subresult = new Complex();
        Complex c1 = new Complex(10,11);
        Complex c2 = new Complex(7,8);
        
        sumresult = c1.addComp(c2);
        sumresult.print();
        
        subresult = c1.subComp(c2);
        subresult.print();
        
    }    
}
