package com.riolite.leetcode.medium;

//https://leetcode.com/problems/number-of-islands/
public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[y].length; x++) {
                if (grid[y][x] == '1') {
                    vistIsland(x, y, grid);
                    count++;
                }
            }
        }
        return count;
    }

    private void vistIsland(int x, int y, char[][] grid) {
        if (y >= grid.length || y < 0 || x >= grid[0].length || x < 0 || grid[y][x] != '1') return;

        if (grid[y][x] == '1') {
            grid[y][x] = '2';
        }

        vistIsland(x - 1, y, grid);
        vistIsland(x + 1, y, grid);
        vistIsland(x, y - 1, grid);
        vistIsland(x, y + 1, grid);
    }

    public static void main(String[] args) {
        System.out.println("Islands count: " + new NumberOfIslands()
                .numIslands(new char[][]{
                        {'1','1','1','1','0'},
                        {'1','1','0','1','0'},
                        {'1','1','0','0','0'},
                        {'0','0','0','0','1'}
                }
        ));
    }

}
