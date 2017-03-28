/** @author NIM/Nama : 13515057 / Erick Wijaya
  * File     : Cage.java
  */

package src.cage;

import java.util.*;
import src.animal.Animal;
import src.animal.Species;
import src.color.Color;

public class Cage {
  private int size; // size of cage
  private int used; // space used in cage
  private int numAnimal; // total animals in cage
  private int[] row; // row position cell
  private int[] col; // column position of cell
  private Animal[] animal;
  private char habitat;

  /**
  * Konstruktor.
  */
  public Cage() {
    size = 10;
    used = 0;
    numAnimal = 0;
    row = new int[size];
    col = new int[size];
    animal = new Animal[size];
    habitat = '?';
  }

  /**
  * Konstruktor dengan parameter.
  * @param s ukuran kandang
  */
  public Cage(int s) {
    size = s;
    used = 0;
    numAnimal = 0;
    row = new int[size];
    col = new int[size];
    animal = new Animal[size];
    habitat = '?';
  }

  /**
  * Mengembalikan ukuran kandang.
  * @return ukuran kandang
  */
  public int getSize() {
    return size;
  }

  /**
  * Mengembalikan jumlah binatang yang ada pada kandang.
  * @return jumlah binatang
  */
  public int getTotalAnimal() {
    return numAnimal;
  }

  /**
  * Mengembalikan posisi (baris) sel kandang ke-i.
  * @return posisi(baris) sel kandang ke-i
  */
  public int getRow(int i) {
    return row[i];
  }

  /**
  * Mengembalikan posisi (kolom) sel kandang ke-i.
  * @return posisi(kolom) sel kandang ke-i
  */
  public int getCol(int i) {
    return col[i];
  }

  /**
  * Mengembalikan binatang pada sel kandang ke-i.
  * @return binatang pada sel kandang ke-i
  */
  public Animal getAnimal(int i) {
    return animal[i];
  }

  /**
  * Mengembalikan jenis habitat dari kandang ('l'/'w'/'a').
  * @return jenis habitat dari kandang ('l'/'w'/'a')
  */
  public char getHabitat() {
    return habitat;
  }

  /**
  * Mengatur jenis habitat dari kandang ('l'/'w'/'a').
  * @param  parHabitat dari kandang ('l'/'w'/'a')
  */
  public void setHabitat(char parHabitat) {
    habitat =  parHabitat;
  }

  /**
  * Mengatur ukuran dari kandang, isi kandang sebelumnya akan terhapus dan terbentuk kandang kosong
  * berukuran baru.
  * @param s ukuran kandang
  */
  // only use this if you want to recreate the cage i.e. input cage
  // WARNING all existing cage data will be lost
  // f.s. cage is empty with new size s
  public void setNewCage(int s) {
    size = s;
    used = 0;
    row = new int[size];
    col = new int[size];
    animal = new Animal[size];
  }

  /**
  * Memeriksa apakah kandang penuh/tidak.
  * @return true jika penuh, false jika tidak penuh
  */
  public boolean isFull() {
    return (double)numAnimal >= (double)size * 0.3;
  }
 
  /**
  * Memeriksa apakah terdapat hewan liar di kandang.
  * @return true jika ada hewan liar, false jika tidak ada
  */
  public boolean isWild() {
    int i = 0;
    boolean found = false;

    while ((i < numAnimal) && (!found)) {
      if (animal[i].isWild()) {
        found = true;
      } else {
        i++;
      }
    }

    return found;
  }

  /**
  * Memeriksa apakah terdapat posisi (r,c) pada kandang.
  * @return true jika ada posisi (r,c) pada kandang, false jika tidak
  */
  public boolean searchPosition(int r, int c) {
    int i = 0;
    boolean found = false;

    while ((i < size) && (!found)) {
      if ((row[i] == r) && (col[i] == c)) {
        found = true;
      } else {
        i++;
      }
    }

    return found;
  }

  /**
  * Memeriksa apakah ada binatang pada sel (r,c).
  * @return true jika ada binatang, false jika tidak ada
  */
  public boolean searchAnimal(int r, int c) {
    int i = 0;
    boolean found = false;

    while ((i < numAnimal) && (!found)) {
      if ((animal[i].getRow() == r) && (animal[i].getCol() == c)) {
        found = true;
      } else {
        i++;
      }
    }

    return found;
  }

  /**
   * Memeriksa apakah ada binatang dengan species _species.
   * @return true jika ada binatang dengan species _species, false jika tidak ada
   */
  public boolean searchAnimal(Species parSpecies) {
    int i = 0;
    boolean found = false;

    while ((i < numAnimal) && (!found)) {
      if (animal[i].getSpecies() == parSpecies) {
        found = true;
      } else {
        i++;
      }
    }
    return found;
  }

  /**
  * Menambahkan suatu sel dengan koordinat (r,c) pada kandang.
  * @param r koordinat baris
  * @param c koordinat kolom
  */
  public void addPosition(int r, int c) {
    if (used <= size) {
      row[used] = r;
      col[used] = c;
      used++;
    }
  }

  /**
  * Menambahkan binatang pada kandang.
  * @param in binatang yang ingin dimasukkan ke kandang
  */
  public void addAnimal(Animal in) {
    if (!isFull() && ((in.getFirstHabitat() == getHabitat()) 
        || (in.getSecondHabitat() == getHabitat()))) {
      boolean valid = false;

      if (!searchAnimal(in.getRow(), in.getCol())) { // theres no other animal in target coordinate
        if (isWild()) {
          if (in.isWild()) {
            valid = !searchAnimal(in.getSpecies()); // wild animal only live with the same species
          } else {
            valid = false;
          }
        } else {
          if (in.isWild()) {
            valid = numAnimal == 0; // wild cannot live with unwild unless there's no other animal
          } else {
            valid = true;
          }
        }
      }

      if (valid) {
        animal[numAnimal] = in.clone();
        ++numAnimal;
      }
    }
  }

  /**
  * Mengembalikan jenis habitat kandang (format lower case) untuk ditampilkan pada layar.
  * @return karakter jenis habitat kandang
  */
  public char render() {
    return Character.toLowerCase(habitat);
  }

  /**
  * Mengembalikan jenis habitat kandang (format lower case) dengan kode warna untuk ditampilkan.
  * @return kode warna beserta kode habutat
  */
  public String renderWithColor() {
    return Color.ANSI_WHITE + render() + Color.ANSI_RESET;
  }

  /**
  * Menampilkan data kandang pada layar.
  */
  public void print() {
    System.out.println("Total size: " + size);
    for (int i = 0; i < used; i++) {
      System.out.println(row[i] + " " + col[i]);
    }
    for (int i = 0; i < numAnimal; i++) {
      animal[i].displayAnimalData();
    }
  }

  /**
  * Menampilkan seluruh interaksi binatang yang terdapat pada kandang.
  */
  public void interact() {
    int i = 0;
    while (i < numAnimal) {
      animal[i].interact();
      i++;
    }
  }

  /**
  * Mengubah posisi binatang-binatang pada kandang.
  */
  public void moveAnimal() {
    int i = 0;

    while (i < numAnimal) {
      Random rand = new Random();
      int rd = rand.nextInt(4) + 1;
      switch (rd) { // 1-up, 2-right, 3-down, 4-left
        case 1:
          if (searchPosition(animal[i].getRow() - 1, animal[i].getCol()) 
              && !searchAnimal(animal[i].getRow() - 1, animal[i].getCol())) {
            animal[i].setRow(animal[i].getRow() - 1);
          }
          break;

        case 2:
          if (searchPosition(animal[i].getRow(), animal[i].getCol() + 1) 
              && !searchAnimal(animal[i].getRow(), animal[i].getCol() + 1)) {
            animal[i].setCol(animal[i].getCol() + 1);
          }
          break;

        case 3:
          if (searchPosition(animal[i].getRow() + 1, animal[i].getCol()) 
              && !searchAnimal(animal[i].getRow() + 1, animal[i].getCol())) {
            animal[i].setRow(animal[i].getRow() + 1);
          }
          break;

        case 4:
          if (searchPosition(animal[i].getRow(), animal[i].getCol() - 1) 
              && !searchAnimal(animal[i].getRow(), animal[i].getCol() - 1)) {
            animal[i].setCol(animal[i].getCol() - 1);
          }
          break;
        default:
          break;   
      }

      i++;
    }
  }

  /**
  * Mengembalikan jumlah total daging yang dikonsumsi seluruh binatang pada kandang.
  * @return jumlah daging
  */
  public double countConsumedMeat() {
    double sum = 0;
    for (int i = 0; i < numAnimal; i++) {
      sum += animal[i].countConsumedMeat();
    }
    return sum;
  }

  /**
  * Mengembalikan jumlah total sayur yang dikonsumsi seluruh binatang pada kandang.
  * @return jumlah daging
  */
  public double countConsumedVeggie() {
    double sum = 0;
    for (int i = 0; i < numAnimal; i++) {
      sum += animal[i].countConsumedVeggie();
    }
    return sum;
  }

  /**
  * Menduplikasi suatu kandang.
  */
  public Cage clone() {
    Cage out = new Cage(size);

    out.setHabitat(habitat);

    for (int i = 0; i < out.getSize(); i++) {
      out.addPosition(row[i], col[i]);
    }
    for (int i = 0; i < getTotalAnimal(); i++) {
      out.addAnimal(animal[i]);
    }

    return out;
  }

  /**
  * Membaca dan mengisi kandang dari scanner.
  * @param in scanner yang akan dibaca
  */
  public void read(Scanner in) {
    int s = in.nextInt();
    setNewCage(s);
    for (int i = 0; i < s; i++) {
      int x = in.nextInt();
      int y = in.nextInt();
      addPosition(x, y);
    }
  }


}
