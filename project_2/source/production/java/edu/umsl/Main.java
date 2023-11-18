package edu.umsl;

import java.util.*;
import java.math.BigInteger;
class Main
{
    static BigInteger fibLinear(long n)
    {
        BigInteger first = new BigInteger("0");
        BigInteger second = new BigInteger("1");
        if(n==1)
            return first;
        if(n==2)
            return second;
        BigInteger third = new BigInteger("0");
        for(int i=1;i<=n;i++)
        {
            third = first.add(second);
            first = second;
            second = third;
        }
        return third;
    }

    static BigInteger fibLog(long n)
    {
        if(n==1)
            return new BigInteger("0");
        BigInteger[] matrix = new BigInteger[4];
        matrix[0] = new BigInteger("0");
        matrix[1] = new BigInteger("1");
        matrix[2] = new BigInteger("1");
        matrix[3] = new BigInteger("1");
        matrix = matrixExponentiation(matrix,n);
        BigInteger curr = matrix[3];
        return curr;
    }
    static BigInteger[] matrixExponentiation(BigInteger[] arr,long n)
    {
        if(n==1)
            return arr;
        BigInteger temp[] = matrixExponentiation(arr,n/2);
        if(n%2==0)
            return matrixMultiply(temp,temp);
        else
            return matrixMultiply(matrixMultiply(temp,temp),arr);
    }
    static BigInteger[] matrixMultiply(BigInteger[] arr1,BigInteger[] arr2)
    {
        BigInteger temp[] = new BigInteger[4];
        temp[0] = arr1[0].multiply(arr2[0]).add(arr1[1].multiply(arr2[2]));
        temp[1] = arr1[0].multiply(arr2[1]).add(arr1[1].multiply(arr2[3]));
        temp[2] = arr1[2].multiply(arr2[0]).add(arr1[3].multiply(arr2[2]));
        temp[3] = arr1[2].multiply(arr2[1]).add(arr1[3].multiply(arr2[3]));
        return temp;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n: ");
        long n;
        n = sc.nextLong();
        n--;
        long start = System.currentTimeMillis();
        System.out.println(fibLinear(n));
        long end = System.currentTimeMillis();
        long elapsedTime = end - start;
        System.out.println("The time take by our Linear algorithm is: "+elapsedTime+" milliseconds");
        start = System.currentTimeMillis();
        System.out.println(fibLog(n));
        end = System.currentTimeMillis();
        elapsedTime = end - start;
        System.out.println("The time take by our Logarithmic algorithm is: "+elapsedTime+" milliseconds");
    }
}
