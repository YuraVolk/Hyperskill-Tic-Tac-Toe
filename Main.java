package tictactoe;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    private static String[][] cells = new String[][]{};
    private static Scanner scanner = new Scanner(System.in);

    private static boolean areCellsTheSame(String cell1, String cell2, String cell3) {
        return Objects.equals(cell1,cell2) && Objects.equals(cell2,cell3);
    }

    private static String analyzeField() {
        int xStrokes = 0;
        int oStrokes = 0;

        if (areCellsTheSame(cells[0][0], cells[0][1], cells[0][2])) {
            if (cells[0][0].equals("X")) {
                xStrokes++;
            } else if (cells[0][0].equals("O")) {
                oStrokes++;
            }
        }

        if (areCellsTheSame(cells[0][0], cells[1][0], cells[2][0])) {
            if (cells[0][0].equals("X")) {
                xStrokes++;
            } else if (cells[0][0].equals("O")) {
                oStrokes++;
            }
        }

        if (areCellsTheSame(cells[0][0], cells[1][1], cells[2][2])) {
            if (cells[0][0].equals("X")) {
                xStrokes++;
            } else if (cells[0][0].equals("O")) {
                oStrokes++;
            }
        }

        if (areCellsTheSame(cells[0][1], cells[1][1], cells[2][1])) {
            if (cells[0][1].equals("X")) {
                xStrokes++;
            } else if (cells[0][1].equals("O")) {
                oStrokes++;
            }
        }

        if (areCellsTheSame(cells[0][2], cells[1][1], cells[2][0])) {
            if (cells[0][2].equals("X")) {
                xStrokes++;
            } else if (cells[0][2].equals("O")) {
                oStrokes++;
            }
        }

        if (areCellsTheSame(cells[2][0], cells[2][1], cells[2][2])) {
            if (cells[2][1].equals("X")) {
                xStrokes++;
            } else if (cells[2][1].equals("O")) {
                oStrokes++;
            }
        }

        if (areCellsTheSame(cells[2][0], cells[2][1], cells[2][2])) {
            if (cells[2][0].equals("X")) {
                xStrokes++;
            } else if (cells[2][0].equals("O")) {
                oStrokes++;
            }
        }

        if (areCellsTheSame(cells[1][0], cells[1][1], cells[1][2])) {
            if (cells[1][0].equals("X")) {
                xStrokes++;
            } else if (cells[1][0].equals("O")) {
                oStrokes++;
            }
        }

        if (areCellsTheSame(cells[0][2], cells[1][2], cells[2][2])) {
            if (cells[0][2].equals("X")) {
                xStrokes++;
            } else if (cells[0][2].equals("O")) {
                oStrokes++;
            }
        }

        int xNum = 0;
        int oNum = 0;
        int blankCount = 0;

        for(int i = 0; i < cells.length; i++) {
            for(int j = 0; j < cells[i].length; j++) {
                if (cells[i][j].equals("X")) {
                    xNum++;
                } else if (cells[i][j].equals("O")) {
                    oNum++;
                } else {
                    blankCount++;
                }
            }
        }



        if (xNum > oNum + 1 || oNum > xNum + 1) {
            System.out.print("Impossible");
        } else if (xStrokes > 0 && oStrokes > 0) {
            System.out.print("Impossible");
        } else if (xStrokes == 0 && oStrokes == 0 && blankCount == 0) {
            return "-";
        } else if (xStrokes == 0 && oStrokes == 0) {
            return "_";
        } else if (xStrokes > 0) {
            return "x";
        } else if (oStrokes > 0) {
            return "o";
        }

        return "";
    }

    private static void printCells() {
        System.out.printf("---------\n" +
                        "| %s %s %s |\n" +
                        "| %s %s %s |\n" +
                        "| %s %s %s |\n" +
                        "---------\n",
                cells[0][0], cells[0][1], cells[0][2],
                cells[1][0], cells[1][1], cells[1][2],
                cells[2][0], cells[2][1], cells[2][2]);
    }

    private static int mapRange(int a1, int a2, int b1, int b2, int s){
        return b1 + ((s - a1) * (b2 - b1)) / (a2 - a1);
    }

    private static void makeMove(String current) {
        //scanner.nextLine();

        while (true) {

            System.out.print("Enter the coordinates: ");
            String c1 = scanner.nextLine();

            if (!c1.matches("\\d\\s\\d")) {
                System.out.println("You should enter numbers!");
                continue;
            }


            if (true) {
                int a1 = Integer.parseInt(c1.split(" ")[0], 10);
                int a2 = Integer.parseInt(c1.split(" ")[1], 10);

                if (a1 > 3 || a1 < 1 || a2 > 3 || a1 < 1) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    continue;
                } else {
                    int b2 = mapRange(3, 1, 0, 2, a2);
                    int b1 = a1 - 1;

                    if (!cells[b2][b1].equals("_")) {
                        System.out.println("This cell is occupied! Choose another one!");
                        continue;
                    } else {
                        cells[b2][b1] = current;
                    }
                }
            } else {
                System.out.println("You should enter numbers!");
                continue;
            }


            break;
        }

    }

    public static void main(String[] args) {


        cells = new String[][]{
                new String[]{"_", "_", "_"},
                new String[]{"_", "_", "_"},
                new String[]{"_", "_", "_"}};
        printCells();

        String currentMove = "X";

        while (true) {
            String result = analyzeField();

            System.out.println(result);

            if (result.equals("_")) {
                makeMove(currentMove);

                if (currentMove.equals("X")) {
                    currentMove = "O";
                } else {
                    currentMove = "X";
                }

                printCells();
            } else {
                if (result.equals("o")) {
                    System.out.println("O wins");
                    break;
                } else if (result.equals("x")) {
                    System.out.println("X wins");
                    break;
                } else if (result.equals("-")) {
                    System.out.println("Draw");
                    break;
                } else {
                    System.out.println("Error!");
                    break;
                }
            }


        }

        //    analyzeField();


    }
}
