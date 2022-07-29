/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complexpkg;

/**
 *
 * @author mahmoud
 */
public class Complex 
{
    private float real;
    private float imag;
    
    public Complex ()
    {
        real = imag = 0;
    }
    public Complex(float x, float y)
    {
        real = x;
        imag = y;
    }
    
    public Complex addComp (Complex c1)
    {
        Complex temp = new Complex();
        temp.real = real+c1.real;
        temp.imag = imag+c1.imag;
        return temp;
    }
    
    public Complex subComp (Complex c1)
    {
        Complex temp = new Complex();
        temp.real = real-c1.real;
        temp.imag = imag-c1.imag;
        return temp;
    }
    
    
    public void print ()
    {
        
	if (imag < 0)
	{
		System.out.println(real+" - "+imag+"i");
	}

	else
	{
		System.out.println(real+" + "+imag+"i");
	}

    }
       
}
