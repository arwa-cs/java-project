package com.arwasa.trying1;

public class Trying1 { 

    public static void main(String[] args) {
        Graph23 amg = new Graph23(8);
        amg.addedge(0, 1);
        amg.addedge(0, 2);
        amg.addedge(2, 3);
        amg.addedge(2, 4);
        amg.addedge(4, 6);
        amg.addedge(4, 5);
        amg.addedge(6, 7);

        amg.printAdjMtrx();
        System.out.println("");
        System.out.println("topological source removal :: ");
        amg.TopologicalSourceRemoval();

    }
}

class Graph23 {
    private int numOfvertix;

    private int[][] adjmtrx;

    Graph23(int x) {
        this.numOfvertix = x;
        adjmtrx = new int[x+1][x+1];
    }

    public void printAdjMtrx() {
        System.out.print("\n\n adjacency matrix:");
        for (int i = 0; i < numOfvertix; ++i) {
            System.out.println();
            for (int j = 0; j < numOfvertix; ++j) {
                System.out.print(" " + adjmtrx[i][j]);
            }
        }
    }
    public void addedge(int a, int b) {
        if ((a >= numOfvertix) || (b > numOfvertix)) {
            System.out.println("out of adjacency matrix !!");
        } else {
            adjmtrx[a][b] = 1;
        }
    }
    public void removevertex(int a) {
        if (a > numOfvertix) {
            System.out.println("out of adjacency matrix !!");
            return;
        } else {
            while (a < numOfvertix) {
                for (int i = 0; i < numOfvertix; ++i) {
                    adjmtrx[i][a] = adjmtrx[i][a + 1];
                }

                for (int i = 0; i < numOfvertix; ++i) {
                    adjmtrx[a][i] = adjmtrx[a + 1][i];
                }
                a++;
            }
//            System.out.println("");
//            System.out.println("after remove ");
//            
//            for (int k = 0; k < numOfvertix; ++k) {
//                System.out.println();
//                for (int j = 0; j < numOfvertix; ++j) {
//                    System.out.print(" " + adjmtrx[k][j]);
//                }
//            }      
            numOfvertix--;
        }
    }

    void TopologicalSourceRemoval() {
        for (int i = 0; i <adjmtrx.length-1; i++) {
             //for (int j = 0; j <= numOfvertix*numOfvertix; j++) {
            if (adjmtrx[i][0] == 0) {
                System.out.print(i + "->");
                removevertex(adjmtrx[i][0]);
                //}
            }
        }
    }
}
