package cn.sepiggy.leetcode.hashtable.p36;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class Solution {

    HashMap<String, Set<Character>> rowMap = new HashMap<>();
    HashMap<String, Set<Character>> columnMap = new HashMap<>();
    HashMap<String, Set<Character>> gridMap = new HashMap<>();

    public boolean isValidSudoku(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                Character c = board[row][column];
                if (c == '.') {
                    continue;
                }

                if (!checkRow(row, c)) {
                    return false;
                }

                if (!checkColumn(column, c)) {
                    return false;
                }

                if (!checkGrid(row, column, c)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean checkGrid(int row, int column, Character c) {
        String key = (row / 3) + "-" + (column / 3);
        Set<Character> set = gridMap.getOrDefault(key, new HashSet<>());
        if (!set.add(c)) {
            return false;
        }
        gridMap.put(key, set);
        return true;
    }

    private boolean checkColumn(int column, Character c) {
        String key = String.valueOf(column);
        Set<Character> set = columnMap.getOrDefault(key, new HashSet<>());
        if (!set.add(c)) {
            return false;
        }
        columnMap.put(key, set);
        return true;
    }

    private boolean checkRow(int row, Character c) {
        String key = String.valueOf(row);
        Set<Character> set = rowMap.getOrDefault(key, new HashSet<>());
        if (!set.add(c)) {
            return false;
        }
        rowMap.put(key, set);
        return true;
    }
}