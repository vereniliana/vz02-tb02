/**
  * @author NIM/Nama : 13515057 / Erick Wijaya
  * Nama File        : Zoo.java
  */

package zoo;

import java.util.*;
import cage.*;
import cell.*;
import color.*;
import animal.*;

public class Zoo {
  private static final int DEFROW = 50;
  private static final int DEFCOL = 50;
  private int row;
  private int col;
  private int n_cage;
  private Cell[][] cell;
  private Cage[] cage;
  /**
    * Konstruktor
    */
  public Zoo(){
    row = DEFROW;
    col = DEFCOL;
    cell = new Cell[row][col];
    cage = new Cage[row*col];
    n_cage = 0;
  }
  /**
    * Konstruktor dengan parameter
    * @param r jumlah baris
    * @param c jumlah kolom
    */
  public Zoo(int r, int c){
    row = r;
    col = c;
    cell = new Cell[row][col];
    cage = new Cage[row*col];
    n_cage = 0;
  }
  /**
    * Mengembalikan jumlah baris
    * @return jumlah baris
    */
  public int GetRow(){
    return row;
  }
  /**
    * Mengembalikan jumlah kolom
    * @return jumlah kolom
    */
  public int GetCol(){
    return col;
  }
  /**
    * Mengembalikan jumlah kandang yang ada pada kebun binatang
    * @return jumlah kandang
    */
  public int GetTotalCage(){
    return n_cage;
  }
  /**
    * Mengembalikan sel ke (i,j)
    * @return sel ke (i,j)
    */
  public Cell GetCell(int i, int j){
    return cell[i][j];
  }
  /**
    * Mengembalikan kandang ke-i
    * @return kandang ke-i
    */
  public Cage GetCage(int i){
    return cage[i];
  }
  /**
    * Mengatur jumlah baris dan kolom dari kebun binatang
    * Isi kebun binatang yang lama akan hilang, terbentuk kebun binatang baru
    * dengan jumlah baris dan kolom sesuai parameter
    * @param r jumlah baris
    * @param c jumlah kolom
    */
  // only use this if you want to recreate the zoo i.e. input zoo
  // WARNING all existing zoo data (cells and animals) will be lost
  // f.s. zoo is empty with new size rxc with
  public void SetNewZoo(int r, int c){
    row = r;
    col = c;
    cell = new Cell[row][col];
    cage = new Cage[row*col];
    n_cage = 0;
  }

  public void AddCage(Cage in){
    boolean valid = true;
    char first_habitat = '?';
    int i = 0;

    i = 0;
    if ((in.GetRow(i) < 0) || (in.GetCol(i) < 0) || (in.GetRow(i) >= row) || (in.GetCol(i) >= col))
      valid = false;
    else
      first_habitat = cell[in.GetRow(i)][in.GetCol(i)].Render();

    if (valid){
      valid = ((cell[in.GetRow(i)][in.GetCol(i)].Render() == 'L') ||
              (cell[in.GetRow(i)][in.GetCol(i)].Render() == 'W')  ||
              (cell[in.GetRow(i)][in.GetCol(i)].Render() == 'A'));
    }

    while ((i < in.GetSize()) && valid){
      if ((in.GetRow(i) < 0) || (in.GetCol(i) < 0) || (in.GetRow(i) >= row) || (in.GetCol(i) >= col))
        valid = false;
      else{
        // check if cage does not take more than one habitat
        valid = cell[in.GetRow(i)][in.GetCol(i)].Render() == first_habitat;

        // check if there's exist another cage
        int j = 0;
        while ((j < n_cage) && valid){
          int k = 0;
          while ((k < cage[j].GetSize()) && valid){
            if ((in.GetRow(i) == cage[j].GetRow(k)) && (in.GetCol(i) == cage[j].GetCol(k)))
              valid = false;
            else
              k++;
          }
          j++;
        }
      }
      i++;
    }

    if (valid){
      if (n_cage <= row*col){
        cage[n_cage] = in.Clone();
        cage[n_cage].SetHabitat(cell[cage[n_cage].GetRow(0)][cage[n_cage].GetCol(0)].Render());
        ++n_cage;
      }
    }
  }
  /**
    * Menambahkan binatang pada kebun binatang
    * @param Animal yang ingin ditambahkan
    */
  public void AddAnimal(Animal in){
    int i = 0;
    boolean found = false;
    while ((i < n_cage) && (cage[i].GetHabitat() != '?') && !found){
      int j = 0;
      while ((j < cage[i].GetSize()) && !found){
        if ((cage[i].GetRow(j) == in.GetRow()) &&
          (cage[i].GetCol(j) == in.GetCol()))
          found = true;
        else
          j++;
      }
      if (!found)
        i++;
    }
    if (found){
      cage[i].AddAnimal(in);
    }
  }
  /**
    * Menampilkan kebun binatang dengan batas-batas tertentu
    * @param x1 batas baris teratas
    * @param y1 batas kolom terkiri
    * @param x2 batas baris terbawah
    * @param y2 batas kolom terkanan
    */
  public void Display(int x1, int y1, int x2, int y2){
    if ((x1 < 0) || (x2 >= row) || (y1 < 0) || (y2 >= col) || (x1 > x2)
       || (y1 > y2)){
      System.out.println("Indeks posisi zoo tidak boleh negatif atau lebih besar dari ukuran sebenarnya.");
    }
    else{
      for(int i=x1; i<=x2; i++){
        for(int j=y1; j<=y2; j++){
          int k = 0;
          boolean found = false;

          // search cage
          while ((k < n_cage) && !found){
            int l = 0;
            while ((l < cage[k].GetSize()) && !found){
              if ((cage[k].GetRow(l) == i) && (cage[k].GetCol(l) == j)){
                found = true;

                // search animal
                int i2 = 0;
                boolean found2 = false;
                while ((i2 < cage[k].GetTotalAnimal()) && !found2){
                  if ((cage[k].GetAnimal(i2).GetRow() == i) &&
                      (cage[k].GetAnimal(i2).GetCol() == j))
                    found2 = true;
                  else
                    i2++;
                }

                if (found2){
                  System.out.print(cage[k].GetAnimal(i2).RenderWithColor());
                }else{
                  System.out.print(cage[k].RenderWithColor());
                }

              }
              ++l;
            }
            ++k;
          }
          if (!found){
            System.out.print(cell[i][j].Render());
          }
          System.out.print(" ");
        }
        System.out.println();
      }
    }
  }

  public void Display(int r, int c){
    for(int i=0; i<row; i++){
      for(int j=0; j<col; j++){
        int k = 0;
        boolean found = false;
        // search cage
        while ((k < n_cage) && !found){
          int l = 0;
          while ((l < cage[k].GetSize()) && !found){
            if ((cage[k].GetRow(l) == i) && (cage[k].GetCol(l) == j)){
              found = true;
              // search animal
              int i2 = 0;
              boolean found2 = false;
              while ((i2 < cage[k].GetTotalAnimal()) && !found2){
                if ((cage[k].GetAnimal(i2).GetRow() == i) &&
                    (cage[k].GetAnimal(i2).GetCol() == j))
                  found2 = true;
                else
                  i2++;
              }
              if (found2){
                System.out.print(cage[k].GetAnimal(i2).RenderWithColor());
              }else{
                System.out.print(cage[k].RenderWithColor());
              }
            }
            ++l;
          }
          ++k;
        }
        if (!found){
          if ((i == r) && (j == c))
            System.out.print(Color.ANSI_YELLOW_BACKGROUND + cell[i][j].Render() + Color.ANSI_RESET);
          else
            System.out.print(cell[i][j].Render());
        }
        System.out.print(" ");
      }
      System.out.println();
    }
  }


  /**
    * Menampilkan keseluruhan kebun binatang
    */
  public void Display(){
    Display(0, 0, row-1, col-1);
  }
  /**
    * Melakukan tour pada kebun binatang
    */
  public void Tour(){
    boolean found = false;
    int xen = 0, yen = 0, xex = 0, yex = 0;
    Random rand = new Random();

    // Get Random Entrance n Exit
    while (!found){
      int x = rand.nextInt(row);
      int y = rand.nextInt(col);
      int choice = rand.nextInt(4);
      if (choice == 0){
        if (cell[x][0].Render() == 'i'){
          found = true;
          xen = x;
          yen = 0;
        }
      }else if (choice == 1){
        if (cell[x][col-1].Render() == 'i'){
          found = true;
          xen = x;
          yen = col-1;
        }
      }else if (choice == 2){
        if (cell[0][y].Render() == 'i'){
          found = true;
          xen = 0;
          yen = y;
        }
      }else{
        if (cell[row-1][y].Render() == 'i'){
          found = true;
          xen = row-1;
          yen = y;
        }
      }
    }

    // Get Exit
    found = false;
    while (!found){
      int x = rand.nextInt(row);
      int y = rand.nextInt(col);
      int choice = rand.nextInt(4);
      if (choice == 0){
        if (cell[x][0].Render() == 'o'){
          found = true;
          xex = x;
          yex = 0;
        }
      }else if (choice == 1){
        if (cell[x][col-1].Render() == 'o'){
          found = true;
          xex = x;
          yex = col-1;
        }
      }else if (choice == 2){
        if (cell[0][y].Render() == 'o'){
          found = true;
          xex = 0;
          yex = y;
        }
      }else{
        if (cell[row-1][y].Render() == 'o'){
          found = true;
          xex = row-1;
          yex = y;
        }
      }
    }

    boolean[][] path = new boolean[row][col];
    for(int i=0; i<row; i++){
      for(int j=0; j<col; j++){
        if ((cell[i][j].Render() == 'o') || (cell[i][j].Render() == '-') ||
                                            (cell[i][j].Render() == 'i'))
          path[i][j] = true;
        else
          path[i][j] = false;
      }
    }

    int i = xen;
    int j = yen;
    while ((i != xex) || (j != yex)){
      path[i][j] = false;
      System.out.println("(" + i + "," + j + ") :");

      boolean fcage = false;
      int icage = 0;
      while ((icage < n_cage) && !fcage){
        if (cage[icage].SearchPosition(i+1, j)){
          cage[icage].Interact();
          fcage = true;
        }else{
          icage++;
        }
      }

      fcage = false;
      icage = 0;
      while ((icage < n_cage) && !fcage){
        if (cage[icage].SearchPosition(i-1, j)){
          cage[icage].Interact();
          fcage = true;
        }else{
          icage++;
        }
      }

      fcage = false;
      icage = 0;
      while ((icage < n_cage) && !fcage){
        if (cage[icage].SearchPosition(i, j+1)){
          cage[icage].Interact();
          fcage = true;
        }else{
          icage++;
        }
      }

      fcage = false;
      icage = 0;
      while ((icage < n_cage) && !fcage){
        if (cage[icage].SearchPosition(i, j-1)){
          cage[icage].Interact();
          fcage = true;
        }else{
          icage++;
        }
      }

      if ((i+1<row) && path[i+1][j])
        i++;
      else if ((i-1>=0) && path[i-1][j])
        i--;
      else if ((j+1<col) && path[i][j+1])
        j++;
      else if ((j-1>=0) && path[i][j-1])
        j--;
      else
        break;
    }
  }

  public void RealTimeTour(){
    boolean found = false;
    int xen = 0, yen = 0, xex = 0, yex = 0;
    Random rand = new Random();

    // Get Random Entrance n Exit
    while (!found){
      int x = rand.nextInt(row);
      int y = rand.nextInt(col);
      int choice = rand.nextInt(4);
      if (choice == 0){
        if (cell[x][0].Render() == 'i'){
          found = true;
          xen = x;
          yen = 0;
        }
      }else if (choice == 1){
        if (cell[x][col-1].Render() == 'i'){
          found = true;
          xen = x;
          yen = col-1;
        }
      }else if (choice == 2){
        if (cell[0][y].Render() == 'i'){
          found = true;
          xen = 0;
          yen = y;
        }
      }else{
        if (cell[row-1][y].Render() == 'i'){
          found = true;
          xen = row-1;
          yen = y;
        }
      }
    }

    // Get Exit
    found = false;
    while (!found){
      int x = rand.nextInt(row);
      int y = rand.nextInt(col);
      int choice = rand.nextInt(4);
      if (choice == 0){
        if (cell[x][0].Render() == 'o'){
          found = true;
          xex = x;
          yex = 0;
        }
      }else if (choice == 1){
        if (cell[x][col-1].Render() == 'o'){
          found = true;
          xex = x;
          yex = col-1;
        }
      }else if (choice == 2){
        if (cell[0][y].Render() == 'o'){
          found = true;
          xex = 0;
          yex = y;
        }
      }else{
        if (cell[row-1][y].Render() == 'o'){
          found = true;
          xex = row-1;
          yex = y;
        }
      }
    }

    boolean[][] path = new boolean[row][col];
    for(int i=0; i<row; i++){
      for(int j=0; j<col; j++){
        if ((cell[i][j].Render() == 'o') || (cell[i][j].Render() == '-') ||
                                            (cell[i][j].Render() == 'i'))
          path[i][j] = true;
        else
          path[i][j] = false;
      }
    }

    int i = xen;
    int j = yen;
    while ((i != xex) || (j != yex)){
      System.out.print("\033[H\033[2J");
      System.out.flush();
      Display(i, j);

      path[i][j] = false;
      System.out.println("(" + i + "," + j + ") :");

      boolean fcage = false;
      int icage = 0;
      while ((icage < n_cage) && !fcage){
        if (cage[icage].SearchPosition(i+1, j)){
          cage[icage].Interact();
          fcage = true;
        }else{
          icage++;
        }
      }

      fcage = false;
      icage = 0;
      while ((icage < n_cage) && !fcage){
        if (cage[icage].SearchPosition(i-1, j)){
          cage[icage].Interact();
          fcage = true;
        }else{
          icage++;
        }
      }

      fcage = false;
      icage = 0;
      while ((icage < n_cage) && !fcage){
        if (cage[icage].SearchPosition(i, j+1)){
          cage[icage].Interact();
          fcage = true;
        }else{
          icage++;
        }
      }

      fcage = false;
      icage = 0;
      while ((icage < n_cage) && !fcage){
        if (cage[icage].SearchPosition(i, j-1)){
          cage[icage].Interact();
          fcage = true;
        }else{
          icage++;
        }
      }

      if ((i+1<row) && path[i+1][j])
        i++;
      else if ((i-1>=0) && path[i-1][j])
        i--;
      else if ((j+1<col) && path[i][j+1])
        j++;
      else if ((j-1>=0) && path[i][j-1])
        j--;
      else
        break;

      System.out.println("Press enter to continue... ");
      try{
        System.in.read();
      }catch(Exception e){}

      for(int k=0; k<n_cage; ++k)
        cage[k].MoveAnimal();
    }
  }
  /**
    * Membaca kebun binatang dari input suatu scanner
    * @param in scanner input
    */
  public void Read(Scanner in){
    int r = in.nextInt();
    int c = in.nextInt();

    SetNewZoo(r, c);
    for(int i=0; i<r; i++){
      for(int j=0; j<c; j++){
        char k = in.next().charAt(0);
        cell[i][j] = new Cell(k);
      }
    }
  }
  /**
    * Menampilkan total makanan yang dikonsumsi di kebun binatang
    */
  public void PrintConsumedFood(){
    double countm = 0, countv = 0;
    for(int i=0; i<n_cage; i++){
      countm += cage[i].CountConsumedMeat();
      countv += cage[i].CountConsumedVeggie();
    }
    System.out.printf("Total Daging yang dikonsumsi: %.2f daging\n", countm);
    System.out.printf("Total Sayur yang dikonsumsi: %.2f sayur\n", countv);
  }
}
