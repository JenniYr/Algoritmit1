package algoritmeja2;

/**
*
* @author jenni yrjänä
* @version 11 Feb 2021
*/
public class Knapsack {

        /**
         * @param args ei käytössä
         */
        public static void main(String args[]) {
          
/*
          int[] w = {0,1,2,3};
          int[] p = {0,2,3,5};
          int c= 3;

          int W = w.length-1;
          int n = p.length-1;
          int[][] s = new int[p.length][p.length];
*/


          // Esimerkkitehtävä, jonka ratkaisu on 56
          int n = 4;  // tavaroiden lukumäärä
          int W = 10; // painoraja
          int[] w = {0, 4, 7, 5, 3};    // paikkaa 0 ei käytetä, koska tehtävänannossa
          int[] p = {0, 36, 35, 20, 9}; // p ja w indeksoitu 1:stä alkaen

          int[][] s = new int[n+1][W+1]; // huomaa kokomääritykset!
          
          for (int r = 0; r <= W; r++){
              s[0][r] = 0;
            }
          for (int k = 0; k <= n; k++){
              s[k][0] = 0;
            }
         for (int k = 1; k <= n; k++){
              for (int r = 1; r <= W; r++){
                // if (w[k] > c) // tässä pitää olla silmukkaindeksi r, ei c
                if (w[k] > r)
                  s[k][r] = s[k-1][r];
                else
                  // s[k][r] = Math.max(s[k-1][r], p[k] + s[k-1][c-w[k]]); // samoin                
                  s[k][r] = Math.max(s[k-1][r], p[k] + s[k-1][r-w[k]]);                 
              }
            }
          System.out.println( s[n][W]);
        }
    }