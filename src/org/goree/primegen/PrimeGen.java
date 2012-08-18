/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.goree.primegen;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JG
 */
public class PrimeGen {
    
    
    private static void addNextPrime(List<Integer> primes) {
        if (primes.isEmpty()) {
            primes.add(2);
            return;
        } 
        int nextCandidate = primes.get(primes.size() - 1) + 1;
        while (true) {
            if (isPrime(nextCandidate, primes)) {
                primes.add(nextCandidate);
                return;
            } else {
                nextCandidate++;
            }
        }
    }
    
    
    public static boolean isPrime(int x, List<Integer> primes) {
        for (int prime : primes) {
            if (prime * prime > x) {
                return true;
            }
            if (x % prime == 0) {
                return false;
            }
        }
        return true;
    }
    
    
    public static void main(String[] args) throws Exception {
        if (args.length < 1) {
            throw new IllegalArgumentException("USAGE: PrimeGen <number of primes>");
        }
        int count = Integer.valueOf(args[0]);
        List<Integer> primes = new ArrayList<Integer>();
        while (primes.size() < count) {
            addNextPrime(primes);
        }
        System.out.println(primes);
    }

}
