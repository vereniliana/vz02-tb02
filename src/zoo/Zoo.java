/**
  * @author NIM/Nama : 13515057 / Erick Wijaya
  * Nama File        : Zoo.java
  */

package src.zoo;

import java.util.*;
import src.animal.Animal;
import src.cage.Cage;
import src.cell.Cell;
import src.color.Color;

public class Zoo {
  private static final int DEFROW = 50;
  private static final int DEFCOL = 50;
  private int row;
  private int col;
  private int numCage;
  private Cell[][] cell;
  private Cage[] cage;

  /**
    * Konstruktor.
    */
  public Zoo() {
    row = DEFROW;
    col = DEFCOL;
    cell = new Cell[row][col];
    cage = new Cage[row * col];
    numCage = 0;
  }

  /**
    * Konstruktor dengan parameter.
    * @param r jumlah baris
    * @param c jumlah kolom
    */
  public Zoo(int r, int c) {
    row = r;
    col = c;
    cell = new Cell[row][col];
    cage = new Cage[row * col];
    numCage = 0;
  }

  /**
    * Mengembalikan jumlah baris.
    * @return jumlah baris
    */
  public int getRow() {
    return row;
  }

  /**
    * Mengembalikan jumlah kolom.
    * @return jumlah kolom
    */
  public int getCol() {
    return col;
  }

  /**
    * Mengembalikan jumlah kandang yang ada pada kebun binatang.
    * @return jumlah kandang
    */
  public int getTotalCage() {
    return numCage;
  }

  /**
    * Mengembalikan sel ke (i,j).
    * @return sel ke (i,j)
    */
  public Cell getCell(int i, int j) {
    return cell[i][j];
  }

  /**
    * Mengembalikan kandang ke-i.
    * @return kandang ke-i
    */
  public Cage getCage(int i) {
    return cage[i];
  }

  /**
    * Mengatur jumlah baris dan kolom dari kebun binatang.
    * Isi kebun binatang yang lama akan hilang, terbentuk kebun binatang baru.
    * dengan jumlah baris dan kolom sesuai parameter.
    * @param r jumlah baris
    * @param c jumlah kolom
    */
  // only use this if you want to recreate the zoo i.e. input zoo
  // WARNING all existing zoo data (cells and animals) will be lost
  // f.s. zoo is empty with new size rxc with
  public void setNewZoo(int r, int c) {
    row = r;
    col = c;
    cell = new Cell[row][col];
    cage = new Cage[row * col];
    numCage = 0;
  }

  /**
    * Menambah kandang ke dalam kebun binatang.
    * @param in kandang yang ingin ditambahkan
    */
  public void addCage(Cage in) {
    boolean valid = true;
    char firstHabitat = '?';
    int i = 0;

    i = 0;
    if ((in.getRow(i) < 0) || (in.getCol(i) < 0) || (in.getRow(i) >= row) 
        || (in.getCol(i) >= col)) {
      valid = false;
    } else {
      firstHabitat = cell[in.getRow(i)][in.getCol(i)].render();
    }

    if (valid) {
      valid = ((cell[in.getRow(i)][in.getCol(i)].render() == 'L') 
               || (cell[in.getRow(i)][in.getCol(i)].render() == 'W')
               || (cell[in.getRow(i)][in.getCol(i)].render() == 'A'));
    }

    while ((i < in.getSize()) && valid) {
      if ((in.getRow(i) < 0) || (in.getCol(i) < 0) || (in.getRow(i) >= row) 
          || (in.getCol(i) >= col)) {
        valid = false;
      } else {
        // check if cage does not take more than one habitat
        valid = cell[in.getRow(i)][in.getCol(i)].render() == firstHabitat;

        // check if there's exist another cage
        int j = 0;
        while ((j < numCage) && valid) {
          int k = 0;
          while ((k < cage[j].getSize()) && valid) {
            if ((in.getRow(i) == cage[j].getRow(k)) && (in.getCol(i) == cage[j].getCol(k))) {
              valid = false;
            } else {
              k++;
            }
          }
          j++;
        }
      }
      i++;
    }

    if (valid) {
      if (numCage <= row * col) {
        cage[numCage] = in.clone();
        cage[numCage].setHabitat(cell[cage[numCage].getRow(0)][cage[numCage].getCol(0)].render());
        ++numCage;
      }
    }
  }

  /**
    * Menambahkan binatang pada kebun binatang.
    * @param in Animal yang ingin ditambahkan
    */
  public void addAnimal(Animal in) {
    int i = 0;
    boolean found = false;
    while ((i < numCage) && (cage[i].getHabitat() != '?') && !found) {
      int j = 0;
      while ((j < cage[i].getSize()) && !found) {
        if ((cage[i].getRow(j) == in.getRow())
            && (cage[i].getCol(j) == in.getCol())) {
          found = true;
        } else {
          j++;
        }
      }
      if (!found) {
        i++;
      }
    }
    if (found) {
      cage[i].addAnimal(in);
    }
  }

  /**
    * Menampilkan kebun binatang dengan batas-batas tertentu.
    * @param x1 batas baris teratas
    * @param y1 batas kolom terkiri
    * @param x2 batas baris terbawah
    * @param y2 batas kolom terkanan
    */
  public void display(int x1, int y1, int x2, int y2) {
    if ((x1 < 0) || (x2 >= row) || (y1 < 0) || (y2 >= col) || (x1 > x2)
        || (y1 > y2)) {
      System.out.println(
          "Indeks posisi zoo tidak boleh negatif atau lebih besar dari ukuran sebenarnya.");
    } else {
      for (int i = x1; i <= x2; i++) {
        for (int j = y1; j <= y2; j++) {
          int k = 0;
          boolean found = false;

          // search cage
          while ((k < numCage) && !found) {
            int l = 0;
            while ((l < cage[k].getSize()) && !found) {
              if ((cage[k].getRow(l) == i) && (cage[k].getCol(l) == j)) {
                found = true;

                // search animal
                int i2 = 0;
                boolean found2 = false;
                while ((i2 < cage[k].getTotalAnimal()) && !found2) {
                  if ((cage[k].getAnimal(i2).getRow() == i) 
                      && (cage[k].getAnimal(i2).getCol() == j)) {
                    found2 = true;
                  } else {
                    i2++;
                  }
                }

                if (found2) {
                  System.out.print(cage[k].getAnimal(i2).renderWithColor());
                } else {
                  System.out.print(cage[k].renderWithColor());
                }

              }
              ++l;
            }
            ++k;
          }
          if (!found) {
            System.out.print(cell[i][j].render());
          }
          System.out.print(" ");
        }
        System.out.println();
      }
    }
  }

  /**
    * Menampilkan kebun binatang.
    * @param r jumlah baris
    * @param c jumlah kolom
    */
  public void display(int r, int c) {
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        int k = 0;
        boolean found = false;
        // search cage
        while ((k < numCage) && !found) {
          int l = 0;
          while ((l < cage[k].getSize()) && !found) {
            if ((cage[k].getRow(l) == i) && (cage[k].getCol(l) == j)) {
              found = true;
              // search animal
              int i2 = 0;
              boolean found2 = false;
              while ((i2 < cage[k].getTotalAnimal()) && !found2) {
                if ((cage[k].getAnimal(i2).getRow() == i) 
                    && (cage[k].getAnimal(i2).getCol() == j)) {
                  found2 = true;
                } else {
                  i2++;
                }
              }
              if (found2) {
                System.out.print(cage[k].getAnimal(i2).renderWithColor());
              } else {
                System.out.print(cage[k].renderWithColor());
              }
            }
            ++l;
          }
          ++k;
        }
        if (!found) {
          if ((i == r) && (j == c)) {
            System.out.print(Color.ANSI_YELLOW_BACKGROUND + cell[i][j].render() + Color.ANSI_RESET);
          } else { 
            System.out.print(cell[i][j].render());
          }
        }
        System.out.print(" ");
      }
      System.out.println();
    }
  }

  /**
    * Menampilkan keseluruhan kebun binatang.
    */
  public void display() {
    display(0, 0, row - 1, col - 1);
  }

  /**
    * Melakukan tour pada kebun binatang.
    */
  public void tour() {
    boolean found = false;
    int xen = 0;
    int yen = 0;
    int xex = 0;
    int yex = 0;
    Random rand = new Random();

    // Get Random Entrance n Exit
    while (!found) {
      int x = rand.nextInt(row);
      int y = rand.nextInt(col);
      int choice = rand.nextInt(4);
      if (choice == 0) {
        if (cell[x][0].render() == 'i') {
          found = true;
          xen = x;
          yen = 0;
        }
      } else if (choice == 1) {
        if (cell[x][col - 1].render() == 'i') {
          found = true;
          xen = x;
          yen = col - 1;
        }
      } else if (choice == 2) {
        if (cell[0][y].render() == 'i') {
          found = true;
          xen = 0;
          yen = y;
        }
      } else {
        if (cell[row - 1][y].render() == 'i') {
          found = true;
          xen = row - 1;
          yen = y;
        }
      }
    }

    // Get Exit
    found = false;
    while (!found) {
      int x = rand.nextInt(row);
      int y = rand.nextInt(col);
      int choice = rand.nextInt(4);
      if (choice == 0) {
        if (cell[x][0].render() == 'o') {
          found = true;
          xex = x;
          yex = 0;
        }
      } else if (choice == 1) {
        if (cell[x][col - 1].render() == 'o') {
          found = true;
          xex = x;
          yex = col - 1;
        }
      } else if (choice == 2) {
        if (cell[0][y].render() == 'o') {
          found = true;
          xex = 0;
          yex = y;
        }
      } else {
        if (cell[row - 1][y].render() == 'o') {
          found = true;
          xex = row - 1;
          yex = y;
        }
      }
    }

    boolean[][] path = new boolean[row][col];
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if ((cell[i][j].render() == 'o') || (cell[i][j].render() == '-') 
            || (cell[i][j].render() == 'i')) {
          path[i][j] = true;
        } else {
          path[i][j] = false;
        }
      }
    }

    int i = xen;
    int j = yen;
    while ((i != xex) || (j != yex)) {
      path[i][j] = false;
      System.out.println("(" + i + "," + j + ") :");

      boolean fcage = false;
      int icage = 0;
      while ((icage < numCage) && !fcage) {
        if (cage[icage].searchPosition(i + 1, j)) {
          cage[icage].interact();
          fcage = true;
        } else {
          icage++;
        }
      }

      fcage = false;
      icage = 0;
      while ((icage < numCage) && !fcage) {
        if (cage[icage].searchPosition(i - 1, j)) {
          cage[icage].interact();
          fcage = true;
        } else {
          icage++;
        }
      }

      fcage = false;
      icage = 0;
      while ((icage < numCage) && !fcage) {
        if (cage[icage].searchPosition(i, j + 1)) {
          cage[icage].interact();
          fcage = true;
        } else {
          icage++;
        }
      }

      fcage = false;
      icage = 0;
      while ((icage < numCage) && !fcage) {
        if (cage[icage].searchPosition(i, j - 1)) {
          cage[icage].interact();
          fcage = true;
        } else {
          icage++;
        }
      }

      if ((i + 1 < row) && path[i + 1][j]) {
        i++;
      } else if ((i - 1 >= 0) && path[i - 1][j]) {
        i--;
      } else if ((j + 1 < col) && path[i][j + 1]) {
        j++;
      } else if ((j - 1 >= 0) && path[i][j - 1]) {
        j--;
      } else {
        break;
      }
    }
  }

  /**
    * Menjalankan tour secara real time pada kebun binatang.
    */
  public void realTimeTour() {
    boolean found = false;
    int xen = 0;
    int yen = 0;
    int xex = 0;
    int yex = 0;
    Random rand = new Random();

    // Get Random Entrance n Exit
    while (!found) {
      int x = rand.nextInt(row);
      int y = rand.nextInt(col);
      int choice = rand.nextInt(4);
      if (choice == 0) {
        if (cell[x][0].render() == 'i') {
          found = true;
          xen = x;
          yen = 0;
        }
      } else if (choice == 1) {
        if (cell[x][col - 1].render() == 'i') {
          found = true;
          xen = x;
          yen = col - 1;
        }
      } else if (choice == 2) {
        if (cell[0][y].render() == 'i') {
          found = true;
          xen = 0;
          yen = y;
        }
      } else {
        if (cell[row - 1][y].render() == 'i') {
          found = true;
          xen = row - 1;
          yen = y;
        }
      }
    }

    // Get Exit
    found = false;
    while (!found) {
      int x = rand.nextInt(row);
      int y = rand.nextInt(col);
      int choice = rand.nextInt(4);
      if (choice == 0) {
        if (cell[x][0].render() == 'o') {
          found = true;
          xex = x;
          yex = 0;
        }
      } else if (choice == 1) {
        if (cell[x][col - 1].render() == 'o') {
          found = true;
          xex = x;
          yex = col - 1;
        }
      } else if (choice == 2) {
        if (cell[0][y].render() == 'o') {
          found = true;
          xex = 0;
          yex = y;
        }
      } else {
        if (cell[row - 1][y].render() == 'o') {
          found = true;
          xex = row - 1;
          yex = y;
        }
      }
    }

    boolean[][] path = new boolean[row][col];
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if ((cell[i][j].render() == 'o') || (cell[i][j].render() == '-') 
            || (cell[i][j].render() == 'i')) {
          path[i][j] = true;
        } else {
          path[i][j] = false;
        }
      }
    }

    int i = xen;
    int j = yen;
    while ((i != xex) || (j != yex)) {
      System.out.print("\033[H\033[2J");
      System.out.flush();
      display(i, j);

      path[i][j] = false;
      System.out.println("(" + i + "," + j + ") :");

      boolean fcage = false;
      int icage = 0;
      while ((icage < numCage) && !fcage) {
        if (cage[icage].searchPosition(i + 1, j)) {
          cage[icage].interact();
          fcage = true;
        } else {
          icage++;
        }
      }

      fcage = false;
      icage = 0;
      while ((icage < numCage) && !fcage) {
        if (cage[icage].searchPosition(i - 1, j)) {
          cage[icage].interact();
          fcage = true;
        } else {
          icage++;
        }
      }

      fcage = false;
      icage = 0;
      while ((icage < numCage) && !fcage) {
        if (cage[icage].searchPosition(i, j + 1)) {
          cage[icage].interact();
          fcage = true;
        } else {
          icage++;
        }
      }

      fcage = false;
      icage = 0;
      while ((icage < numCage) && !fcage) {
        if (cage[icage].searchPosition(i, j - 1)) {
          cage[icage].interact();
          fcage = true;
        } else {
          icage++;
        }
      }

      if ((i + 1 < row) && path[i + 1][j]) {
        i++;
      } else if ((i - 1 >= 0) && path[i - 1][j]) {
        i--;
      } else if ((j + 1 < col) && path[i][j + 1]) {
        j++;
      } else if ((j - 1 >= 0) && path[i][j - 1]) {
        j--;
      } else {
        break;
      }

      System.out.println("Press enter to continue... ");
      try {
        System.in.read();
      } catch (Exception e) {
        System.out.println(e);
      }

      for (int k = 0; k < numCage; ++k) {
        cage[k].moveAnimal();
      }
    }
  }

  /**
    * Membaca kebun binatang dari input suatu scanner.
    * @param in scanner input
    */
  public void read(Scanner in) {
    int r = in.nextInt();
    int c = in.nextInt();

    setNewZoo(r, c);
    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        char k = in.next().charAt(0);
        cell[i][j] = new Cell(k);
      }
    }
  }

  /**
    * Menampilkan total makanan yang dikonsumsi di kebun binatang.
    */
  public void printConsumedFood() {
    double countm = 0;
    double countv = 0;
    for (int i = 0; i < numCage; i++) {
      countm += cage[i].countConsumedMeat();
      countv += cage[i].countConsumedVeggie();
    }
    System.out.printf("Total Daging yang dikonsumsi: %.2f daging\n", countm);
    System.out.printf("Total Sayur yang dikonsumsi: %.2f sayur\n", countv);
  }
}
