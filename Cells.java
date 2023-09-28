package org.example;

import java.util.Random;
import java.util.ArrayList;

public class Cells {
    // Déclaration des cellules
    public static String[][] NorthToSouth = {
            {"#", ".", "#"},
            {"#", ".", "#"},
            {"#", ".", "#"}
    };

    public static String[][] WestToEast = {
            {"#", "#", "#"},
            {".", ".", "."},
            {"#", "#", "#"}
    };

    public static String[][] NorthToEast = {
            {"#", ".", "#"},
            {"#", ".", "."},
            {"#", "#", "#"}
    };

    public static String[][] NorthToWest = {
            {"#", ".", "#"},
            {".", ".", "#"},
            {"#", "#", "#"}
    };

    public static String[][] SouthToWest = {
            {"#", "#", "#"},
            {".", ".", "#"},
            {"#", ".", "#"}
    };

    public static String[][] SouthToEast = {
            {"#", "#", "#"},
            {"#", ".", "."},
            {"#", ".", "#"}
    };

    public static String[][] Cross = {
            {"#", ".", "#"},
            {".", ".", "."},
            {"#", ".", "#"}
    };

    public static String[][] WestT = {
            {"#", ".", "#"},
            {".", ".", "#"},
            {"#", ".", "#"}
    };

    public static String[][] NorthT = {
            {"#", ".", "#"},
            {".", ".", "."},
            {"#", "#", "#"}
    };

    public static String[][] SouthT = {
            {"#", "#", "#"},
            {".", ".", "."},
            {"#", ".", "#"}
    };

    public static String[][] EastT = {
            {"#", ".", "#"},
            {"#", ".", "."},
            {"#", ".", "#"}
    };

    // Créez une liste de configurations de cellules
    private static ArrayList<CellConfiguration> cellConfigurations = new ArrayList<>();

    static {
        // Ajoutez vos configurations de cellules à la liste
        cellConfigurations.add(new CellConfiguration(NorthToSouth, true, true, false, false));
        cellConfigurations.add(new CellConfiguration(WestToEast, false, false, true, true));
        cellConfigurations.add(new CellConfiguration(NorthToEast, true, false, true, false));
        cellConfigurations.add(new CellConfiguration(NorthToWest, true, false, false, true));
        cellConfigurations.add(new CellConfiguration(SouthToWest, false, true, false, true));
        cellConfigurations.add(new CellConfiguration(SouthToEast, false, true, true, false));
        cellConfigurations.add(new CellConfiguration(Cross, true, true, true, true));
        cellConfigurations.add(new CellConfiguration(WestT, true, false, true, false));
        cellConfigurations.add(new CellConfiguration(NorthT, true, true, false, true));
        cellConfigurations.add(new CellConfiguration(SouthT, false, true, true, true));
        cellConfigurations.add(new CellConfiguration(EastT, true, false, false, true));
    }

    // Ajoutez cette méthode pour obtenir une configuration de cellule aléatoire parmi celles configurées
    public static CellConfiguration getRandomCellConfiguration() {
        Random random = new Random();
        int randomIndex = random.nextInt(cellConfigurations.size());
        return cellConfigurations.get(randomIndex);
    }

    public static class CellConfiguration {
        public String[][] matrix;
        public boolean openNorth;
        public boolean openSouth;
        public boolean openEast;
        public boolean openWest;

        public CellConfiguration(String[][] matrix, boolean openNorth, boolean openSouth, boolean openEast, boolean openWest) {
            this.matrix = matrix;
            this.openNorth = openNorth;
            this.openSouth = openSouth;
            this.openEast = openEast;
            this.openWest = openWest;
        }
    }

    public static void main(String[] args) {
        // Imprimez les configurations de cellules
        for (CellConfiguration cell : cellConfigurations) {
            System.out.println("Matrix:");
            printMatrix(cell.matrix);
            System.out.println("openNorth: " + cell.openNorth);
            System.out.println("openSouth: " + cell.openSouth);
            System.out.println("openEast: " + cell.openEast);
            System.out.println("openWest: " + cell.openWest);
            System.out.println();
        }
    }

    public static void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
