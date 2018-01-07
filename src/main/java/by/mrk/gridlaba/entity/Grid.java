package by.mrk.gridlaba.entity;

public class Grid {
    private int height;
    private int width;
    private int[][] grid;

    public Grid(int height, int width) {
        this.height = height;
        this.width = width;
        grid = new int[height][width];
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void setCellValue(int heightPosition, int widthPosition, int value) {
        grid[heightPosition][widthPosition] = value;
    }

    public int getCellValue(int heightPosition, int widthPosition) {
        return grid[heightPosition][widthPosition];
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Width: ").append(width).append("; ")
                .append("Height: ").append(height).append(";\n");

        for (int j = 0; j < getWidth(); j++) {
            builder.append("- - ");
        }
        builder.append("\n");

        for (int i = 0; i < getHeight(); i++) {
            for (int j = 0; j < getWidth(); j++) {
                builder.append(getCellValue(i, j) + " | ");
            }
            builder.append("\n");

            for (int j = 0; j < getWidth(); j++) {
                builder.append("- - ");
            }
            builder.append("\n");
        }

        return builder.toString();
    }
}
