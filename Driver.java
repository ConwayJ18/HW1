import java.io.*;
import java.util.*;

class Driver {

/*    static  long MAX = Long.MAX_VALUE;
    static long factor[];

    // function to generate all prime
    // factors of numbers from 1 to 10^6
    static void generatePrimeFactors()
    {
        factor[1] = 1;

        // Initializes all the positions with
        // their value.
        for (long i = 2; i < MAX; i++)
            factor[i] = i;

        // Initializes all multiples of 2 with 2
        for (long i = 4; i < MAX; i += 2)
            factor[i] = 2;

        // A modified version of Sieve of
        // Eratosthenes to store the
        // smallest prime factor that
        // divides every number.
        for (long i = 3; i * i < MAX; i++)
        {
            // check if it has no prime factor.
            if (factor[i] == i)
            {
                // Initializes of j starting from i*i
                for (long j = i * i; j < MAX; j += i)
                {
                    // if it has no prime factor
                    // before, then stores the
                    // smallest prime divisor
                    if (factor[j] == j)
                        factor[j] = i;
                }
            }
        }
    }

    // function to calculate number of factors
    static long calculateFactorCount(long n)
    {
        if (n == 1)
            return 1;

        long ans = 1;

        // stores the smallest prime number
        // that divides n
        long dup = factor[n];

        // stores the count of number of times
        // a prime number divides n.
        long c = 1;

        // reduces to the next number after prime
        // factorization of n
        long j = n / factor[n];

        // false when prime factorization is done
        while (j != 1)
        {
            // if the same prime number is dividing n,
            // then we increase the count
            if (factor[j] == dup)
                c += 1;

            // if its a new prime factor that is
            // factorizing n, then we again set c=1
            // and change dup to the new prime factor,
            // and apply the formula explained
            // above.
            else
            {
                dup = factor[j];
                ans = ans * (c + 1);
                c = 1;
            }

            // prime factorizes a number
            j = j / factor[j];
        }

        // for the last prime factor
        ans = ans * (c + 1);

        return ans;
    }

    // Driver program to test above function
    public static void main(String[] args)
    {
        // array to store prime factors
        ArrayList<Long> factor = new ArrayList<Long>();
        factor.add(0, 0);

        // generate prime factors of number
        // upto 10^6
        generatePrimeFactors();

        ArrayList<Long> a = new ArrayList<Long>();
        a.addAll(Arrays.asList(735, 30, 100, 450, 987));

        long q = a.length;

        for (long i = 0; i < q; i++)
            System.out.print(calculateFactorCount(a.get(i)) + " ");

    }
*/
    public static void main(String[] args)
    {
        Random randomGenerator = new Random();
        double sum;
        double avg;

        for(int i=12; i<=18; i++)
        {
          sum = 0;
          for(int j=0; j<=10; j++)
          {
            long lowerBound = (long)Math.pow(10,i-1);
            long upperBound = (long)Math.pow(10,i-1) + (long)Math.pow(10,i-1)-1;
            long testNumber = lowerBound + (long)(randomGenerator.nextDouble()*(upperBound-lowerBound));
            int counter = 0;


    		    //Start clock
            long startTime = System.nanoTime();

            //Start calculation
            for(int k = 2; k <= Math.sqrt(testNumber); k++)
            {
                if(testNumber%k == 0)
                  counter += 2;
            }

            //Stop clock
            long endTime = System.nanoTime();

            //Calculate time elapsed
            long timeElapsedInMilliseconds = (endTime - startTime) / 1000000;

            //Print results
            System.out.println("The number of factors of the number " + testNumber + " is " + counter + ".");
            System.out.println("That calculation took " + timeElapsedInMilliseconds + " milliseconds.");
            sum += timeElapsedInMilliseconds;
          }
          avg = sum/10;
          System.out.println("The average time taken for a " + i + " digit number is " + avg + " ms.");
        }
    }

}
