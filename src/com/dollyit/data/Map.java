package com.dollyit.data;

import org.jetbrains.annotations.NotNull;

import java.util.Random;

import static java.lang.Math.abs;

public class Map {

    public final int MAP_SIZE;
    private static final char DEFAULT_CHANGE_CELL_VALUE = 'A';

    private final Block[][] matrix;

    public Map(int size) {
        assert size > 0;
        MAP_SIZE = size;
        matrix = new Block[MAP_SIZE][MAP_SIZE];
        initializeMatrix();
    }

    /**
     * Initialize matrix with blocks
     */
    private void initializeMatrix() {
        for (int col = 0; col < MAP_SIZE; col++)
            for (int row = 0; row < MAP_SIZE; row++)
                matrix[col][row] = new Block();
    }

    /**
     * Print map on console
     */
    public void display() {
        System.out.print("  ");
        for (int col = 0; col < MAP_SIZE; col++)
            System.out.print(col + " ");
        System.out.println();
        for (int col = 0; col < MAP_SIZE; col++) {
            System.out.print(col + " ");
            for (int row = 0; row < MAP_SIZE; row++)
                System.out.print(matrix[row][col].display() + " ");
            System.out.println();
        }
    }

    /**
     * @param col: column of block
     * @param row: row of block
     */
    public void changeCell(int col, int row) {
        assert col >= 0 && col < MAP_SIZE;
        assert row >= 0 && row < MAP_SIZE;
        matrix[col][row] = new Block(DEFAULT_CHANGE_CELL_VALUE);
    }

    /**
     * Swaps the block with the
     * @param col: column of block
     * @param row: row of block
     */
    private void swap(int col, int row) {
        assert col >= 0 && col < MAP_SIZE;
        assert row >= 0 && row < MAP_SIZE - 1;

        Block tmp = matrix[col][row];
        matrix[col][row] = matrix[col][row+1];
        matrix[col][row+1] = tmp;
    }

    /**
     * This method set gravity to the block, that will fall
     * @param col: column of block
     * @param row: row of block
     */
    public void insertAtCoords(int col, int row) {
        assert col >= 0 && col < MAP_SIZE;
        assert row >= 0 && row < MAP_SIZE;

        changeCell(col, row);

        // Block will fall
        while (row < MAP_SIZE - 1 && matrix[col][row+1].isFallsThrough()) {
            swap(col, row);
            row++;
        }
    }

    /**
     * It will generate Map object with random obstacles.
     * @param size: size of table
     * @param obstaclesCount count of random obstacles
     * @return the generated map
     */
    public static @NotNull Map randomMap(int size, int obstaclesCount) {
        assert size >= 0;
        assert obstaclesCount >= 0 && obstaclesCount <= size * size;

        Random random = new Random();
        Map map = new Map(size);
        int row, col, i = 0;

        while (i < obstaclesCount) {
            row = abs(random.nextInt()) % size;
            col = abs(random.nextInt()) % size;

            if (!map.matrix[col][row].isFallsWithGravity() && map.matrix[col][row].isFallsThrough()) {
                map.changeCell(col, row);
                i++;
            }
        }

        return map;
    }


    /**
     * It will generate Map object with random obstacles.
     * The max count of obstacles is size^2 / 4
     * @param size: size of table
     * @return the generated map
     */
    public static @NotNull Map randomMap(int size) {
        assert size >= 0;
        Random random = new Random();
        return randomMap(size, abs(random.nextInt()) % (size * size / 4));
    }
}
