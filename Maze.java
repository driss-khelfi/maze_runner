package org.example;

import java.util.Scanner;

public class Maze {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Sélectionner la longueur du labyrinthe :");
        int x = scanner.nextInt();

        System.out.println("Sélectionner la largeur du labyrinthe :");
        int y = scanner.nextInt();

        // Obtenir une configuration de cellule aléatoire depuis la classe Cells
        Cells.CellConfiguration randomCellConfiguration = Cells.getRandomCellConfiguration();

        // Générer une matrice pour le labyrinthe en utilisant les dimensions spécifiées
        char[][] mazeMatrix = generateMaze(x * 3, y * 3, randomCellConfiguration);

        // Convertir la matrice en une chaîne de caractères et l'afficher
        String mazeString = mazeToString(mazeMatrix);
        System.out.println("Labyrinthe généré :");
        System.out.println(mazeString);
    }

    public static char[][] generateMaze(int x, int y, Cells.CellConfiguration randomCellConfiguration) {
        char[][] maze = new char[x][y];
        int cellWidth = 3; // Largeur d'une cellule (chiffre arbitraire, vous pouvez ajuster)
        int cellHeight = 3; // Hauteur d'une cellule (chiffre arbitraire, vous pouvez ajuster)

        for (int i = 0; i < x; i += cellHeight) {
            for (int j = 0; j < y; j += cellWidth) {
                // Obtenir une nouvelle configuration de cellule aléatoire avant de remplir la cellule
                Cells.CellConfiguration randomCellConfiguration2 = Cells.getRandomCellConfiguration();

                // Remplir la matrice du labyrinthe en utilisant la configuration de cellule aléatoire
                for (int row = 0; row < cellHeight; row++) {
                    for (int col = 0; col < cellWidth; col++) {
                        maze[i + row][j + col] = randomCellConfiguration2.matrix[row][col].charAt(0);
                    }
                }
            }
        }

        return maze;
    }


    public static String mazeToString(char[][] maze) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                result.append(maze[i][j]).append(" ");
            }
            result.append("\n");
        }
        return result.toString();
    }
}
