/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mygame.treasurehunt;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author vinh
 */
public class Algorithm {
    private final int GRID_SIZE = 15;
    private final int NODES = GRID_SIZE * GRID_SIZE;
    //private int[][] grid;
    private final int MAX_INT = 10000000;
    private final int SRC_NODE = 0;
    public int[][] grid = new int[GRID_SIZE][GRID_SIZE];
    public Algorithm(int n){
        initializeGrid(n);
        grid [0][0] = 0;
        grid [GRID_SIZE - 1][GRID_SIZE - 1] = 0;
    }
    /*KHởi tạo lưu đồ(15*15) và giá trị ngẫu nhiên: -1 -> -50 
     */
    private void initializeGrid(int n){
        Random random = new Random();
        for(int i = 0; i < GRID_SIZE; i++){
            for(int j = 0; j < GRID_SIZE; j++){
                grid[i][j] = -random.nextInt(50) - 1;
                if (grid[i][j] == -30 || grid[i][j] == -50 || grid[i][j] == -70)
                    grid[i][j]++;
            }
        }
        placeSpecialPoints(n, 30);
        placeSpecialPoints(n, 50);
        placeSpecialPoints(n, 70);
        placeSpecialPoints(n, 1000000);
    }
    /*Đặt các điểm đặc biệt vào lưới, đảm bảo chúng không bị trùng lắp và không nằm ở các vị trí biên of map*/
    private void placeSpecialPoints(int n, int value) {
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            int index = random.nextInt(NODES);
            while (grid[index / GRID_SIZE][index % GRID_SIZE] > 0 || isBoundary(index))
                index = random.nextInt(NODES);
            grid[index / GRID_SIZE][index % GRID_SIZE] = value;
        }
    }
    /*Xác định giá trị biên và các điểm có giá trị đặc biệt*/
    private boolean isBoundary(int index) {
        return (index == 0 || index == 1 || index == GRID_SIZE || index == GRID_SIZE + 1 || index == NODES - GRID_SIZE - 1 || index == NODES - GRID_SIZE || index == NODES -1);
    }
    /*Xây dựng đồ thị và tìm đường đi ngắn nhất : Áp dụng giải thuật dijkstra*/
    public int findShortestPath(){
        int [][] graph = new int[NODES][NODES];
        for(int i = 0; i < NODES; i++){
            Arrays.fill(graph[i], -MAX_INT);
        }
        for(int i = 0; i < GRID_SIZE; i++){
            for(int j = 0; j < GRID_SIZE; j++){
                int node = i * GRID_SIZE + j;
                if(j < GRID_SIZE - 1){
                   graph[node][node + 1] = grid[i][j+1]; 
                }
                if(i > 0){
                    graph[node][node - GRID_SIZE] = grid[i-1][j];
                }
                if(j > 0){
                    graph[node][node-1] = grid[i][j-1];
                }
                if(i < GRID_SIZE - 1){
                    graph[node][node + GRID_SIZE] = grid[i+1][j];
                }
            }
        }
        for(int i = 0; i < NODES; i++){
            for(int j = 0; j < NODES; j++){
                if(graph[i][j] < 0){
                    graph[i][j] = -graph[i][j];
                }
            }
        }
        int [] distance = new int[NODES];
        int [] visited = new int[NODES];
        int [] previous = new int[NODES];
        
        Arrays.fill(distance, MAX_INT);
        Arrays.fill(visited, 0);
        Arrays.fill(previous, SRC_NODE);
        distance[SRC_NODE] = 0;
        visited[SRC_NODE] = 0;
        
        int min, u;
        while(true){
            min = MAX_INT;
            u = -1;
            for(int j = 0; j < NODES; j++){
                if(min > distance[j] && visited[j] == 0){
                    min = distance[j];
                    u = j;
                }
            }
            if(u == - 1 || u == (NODES- 1)){
                break;
            }
            visited[u] = 1;
            for(int v = 0; v < NODES; v++){
                if(distance[v] > graph[u][v] + distance[u] && visited[v] == 0){
                    distance[v] = graph[u][v] + distance[u];
                    previous[v] = u;
                }
            }
        }
        
        return distance[NODES - 1];
    }
    public static void main(String []args){
        Algorithm algorithm = new Algorithm(5);
        System.out.print(algorithm.findShortestPath());
    }
}
