package org.example;

import java.util.Scanner;
import java.util.Random;

public class SimpleImperfect {
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

        // Remplacer les points sur les bords par des murs
        replaceBorderDotsWithWalls(mazeMatrix);

        // Ajouter l'entrée et la sortie
        addEntranceAndExit(mazeMatrix);

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

    public static void replaceBorderDotsWithWalls(char[][] maze) {
        int mazeHeight = maze.length;
        int mazeWidth = maze[0].length;

        for (int i = 0; i < mazeHeight; i++) {
            for (int j = 0; j < mazeWidth; j++) {
                // Si le point est sur le bord, remplacez-le par un mur
                if (i == 0 || i == mazeHeight - 1 || j == 0 || j == mazeWidth - 1) {
                    if (maze[i][j] == '.') {
                        maze[i][j] = '#';
                    }
                }
            }
        }
    }

    public static void addEntranceAndExit(char[][] maze) {
        // Obtenez les dimensions du labyrinthe
        int mazeHeight = maze.length;
        int mazeWidth = maze[0].length;
        Random random = new Random();

        // Déterminez si l'entrée sera sur le bord supérieur (0) ou le bord gauche (1)
        int entranceSide = random.nextInt(2); // 0 pour le bord supérieur, 1 pour le bord gauche

        if (entranceSide == 0) {
            // L'entrée est sur le bord supérieur
            int entranceY = random.nextInt(mazeWidth); // Coordonnée en Y aléatoire
            maze[0][entranceY] = '.';

            // Déterminez une sortie aléatoire sur le bord inférieur (hauteur du labyrinthe - 1)
            int exitY = random.nextInt(mazeWidth);
            maze[mazeHeight - 1][exitY] = '.';
        } else {
            // L'entrée est sur le bord gauche
            int entranceX = random.nextInt(mazeHeight); // Coordonnée en X aléatoire
            maze[entranceX][0] = '.';

            // Déterminez une sortie aléatoire sur le bord droit (largeur du labyrinthe - 1)
            int exitX = random.nextInt(mazeHeight);
            maze[exitX][mazeWidth - 1] = '.';
        }
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
