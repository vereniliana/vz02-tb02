/** @author NIM/Nama : 13515057 / Erick Wijaya
  *	File     : Cage.java
  */

package cage;

import java.util.*;
import animal.*;
import color.*;

public class Cage {
  private int size; // size of cage
  private int used; // space used in cage
  private int n_animal; // total animals in cage
  private int[] row; // row position cell
  private int[] col; // column position of cell
  private Animal[] animal;
  private char habitat;

  /**
	 * Konstruktor
	 */
  public Cage(){
    size = 10;
    used = 0;
    n_animal = 0;
    row = new int[size];
    col = new int[size];
    animal = new Animal[size];
    habitat = '?';
  }

	/**
	 * Konstruktor dengan parameter
	 * @param s ukuran kandang
	 */
  public Cage(int s){
    size = s;
    used = 0;
    n_animal = 0;
    row = new int[size];
    col = new int[size];
    animal = new Animal[size];
    habitat = '?';
  }

  /**
	 * Mengembalikan ukuran kandang
	 * @return ukuran kandang
	 */
  public int GetSize() {
    return size;
  }

	/**
	 * Mengembalikan jumlah binatang yang ada pada kandang
	 * @return jumlah binatang
	 */
  public int GetTotalAnimal() {
    return n_animal;
  }

	/**
	 * Mengembalikan posisi (baris) sel kandang ke-i
	 * @return posisi(baris) sel kandang ke-i
	 */
  public int GetRow(int i) {
    return row[i];
  }

	/**
	 * Mengembalikan posisi (kolom) sel kandang ke-i
	 * @return posisi(kolom) sel kandang ke-i
	 */
  public int GetCol(int i) {
    return col[i];
  }

	/**
	 * Mengembalikan binatang pada sel kandang ke-i
	 * @return binatang pada sel kandang ke-i
	 */
  public Animal GetAnimal(int i) {
    return animal[i];
  }

	/**
	 * Mengembalikan jenis habitat dari kandang ('l'/'w'/'a')
	 * @return jenis habitat dari kandang ('l'/'w'/'a')
	 */
  public char GetHabitat() {
    return habitat;
  }

  /**
	 * Mengatur jenis habitat dari kandang ('l'/'w'/'a')
	 * @param _habitat dari kandang ('l'/'w'/'a')
	 */
  public void SetHabitat(char _habitat) {
    habitat = _habitat;
  }

	/**
	 * Mengatur ukuran dari kandang, isi kandang sebelumnya akan terhapus dan terbentuk kandang kosong berukuran baru
	 * @param s ukuran kandang
	 */
  // only use this if you want to recreate the cage i.e. input cage
  // WARNING all existing cage data will be lost
  // f.s. cage is empty with new size s
  public void SetNewCage(int s) {
    size = s;
    used = 0;
    row = new int[size];
    col = new int[size];
    animal = new Animal[size];
  }

  /**
	 * Memeriksa apakah kandang penuh/tidak
	 * @return true jika penuh, false jika tidak penuh
	 */
  public boolean IsFull() {
    return (double)n_animal >= (double)size*0.3;
  }

	/**
	 * Memeriksa apakah terdapat hewan liar di kandang
	 * @return true jika ada hewan liar, false jika tidak ada
	 */
  public boolean IsWild() {
    int i = 0;
    boolean found = false;

    while ((i<n_animal) && (!found)){
      if (animal[i].IsWild())
        found = true;
      else
        i++;
    }

    return found;
  }

	/**
	 * Memeriksa apakah terdapat posisi (r,c) pada kandang
	 * @return true jika ada posisi (r,c) pada kandang, false jika tidak
	 */
  public boolean SearchPosition(int r, int c) {
    int i = 0;
    boolean found = false;

    while ((i<size) && (!found)){
      if ((row[i] == r) && (col[i] == c))
        found = true;
      else
        i++;
    }

    return found;
  }

	/**
	 * Memeriksa apakah ada binatang pada sel (r,c)
	 * @return true jika ada binatang, false jika tidak ada
	 */
  public boolean SearchAnimal(int r, int c) {
    int i = 0;
    boolean found = false;

    while ((i<n_animal) && (!found)){
      if ((animal[i].GetRow() == r) && (animal[i].GetCol() == c))
        found = true;
      else
        i++;
    }

    return found;
  }

  /**
   * Memeriksa apakah ada binatang dengan species _species
   * @return true jika ada binatang dengan species _species, false jika tidak ada
   */
  public boolean SearchAnimal(Species _species) {
    int i = 0;
    boolean found = false;

    while ((i<n_animal) && (!found)){
      if (animal[i].GetSpecies() == _species)
        found = true;
      else
        i++;
    }

    return found;
  }

	/**
	 * Menambahkan suatu sel dengan koordinat (r,c) pada kandang
	 * @param r koordinat baris
	 * @param c koordinat kolom
	 */
  public void AddPosition(int r, int c) {
    if (used <= size){
      row[used] = r;
      col[used] = c;
      used++;
    }
  }

	/**
	 * Menambahkan binatang pada kandang
	 * @param in binatang yang ingin dimasukkan ke kandang
	 */
  public void AddAnimal(Animal in) {
    if (!IsFull() && ((in.GetFirstHabitat() == GetHabitat()) || (in.GetSecondHabitat() == GetHabitat()))){
      boolean valid = false;

      if (!SearchAnimal(in.GetRow(), in.GetCol())){ // if there is no other animal in the target coordinate
        if (IsWild()){
          if (in.IsWild())
            valid = !SearchAnimal(in.GetSpecies()); // wild animal only live with the same species
          else
            valid = false;
        }else{
          if (in.IsWild()){
            valid = n_animal == 0; // wild animal cannot live with unwild animal unless there's no other animal
          }
          else{
            valid = true;
          }
        }
      }

      if (valid){
        animal[n_animal] = in.Clone();
        ++n_animal;
      }
    }
  }

	/**
	 * Mengembalikan jenis habitat kandang (format lower case) untuk ditampilkan pada layar
	 * @return karakter jenis habitat kandang
	 */
  public char Render() {
    return Character.toLowerCase(habitat);
  }

	/**
	 * Mengembalikan jenis habitat kandang (format lower case) dengan kode warna untuk ditampilkan pada layar
	 * @return kode warna beserta kode habutat
	 */
  public String RenderWithColor() {
    return Color.ANSI_WHITE + Render() + Color.ANSI_RESET;
  }

	/**
	 * Menampilkan data kandang pada layar
	 */
  public void Print(){
    System.out.println("Total size: " + size);
    for(int i=0; i<used; i++){
      System.out.println(row[i] + " " + col[i]);
    }
    for(int i=0; i<n_animal; i++){
      animal[i].DisplayAnimalData();
    }
  }

	/**
	 * Menampilkan seluruh interaksi binatang yang terdapat pada kandang
	 */
  public void Interact(){
    int i = 0;
    while (i < n_animal){
      animal[i].Interact();
      i++;
    }
  }

	/**
	 * Mengubah posisi binatang-binatang pada kandang
	 */
  public void MoveAnimal(){
    int i = 0;

    while (i<n_animal){
      Random rand = new Random();
      int rd = rand.nextInt(4) + 1;
      switch (rd){ // 1-up, 2-right, 3-down, 4-left
        case 1:
        if (SearchPosition(animal[i].GetRow()-1, animal[i].GetCol()) && !SearchAnimal(animal[i].GetRow()-1, animal[i].GetCol()))
          animal[i].SetRow(animal[i].GetRow()-1);
        break;

        case 2:
        if (SearchPosition(animal[i].GetRow(), animal[i].GetCol()+1) && !SearchAnimal(animal[i].GetRow(), animal[i].GetCol()+1))
          animal[i].SetCol(animal[i].GetCol()+1);
        break;

        case 3:
        if (SearchPosition(animal[i].GetRow()+1, animal[i].GetCol()) && !SearchAnimal(animal[i].GetRow()+1, animal[i].GetCol()))
          animal[i].SetRow(animal[i].GetRow()+1);
        break;

        case 4:
        if (SearchPosition(animal[i].GetRow(), animal[i].GetCol()-1) && !SearchAnimal(animal[i].GetRow(), animal[i].GetCol()-1))
          animal[i].SetCol(animal[i].GetCol()-1);
        break;
      }

      i++;
    }
  }

	/**
	 * Mengembalikan jumlah total daging yang dikonsumsi seluruh binatang pada kandang
	 * @return jumlah daging
	 */
  public double CountConsumedMeat(){
    double sum = 0;
    for(int i=0; i<n_animal; i++){
      sum += animal[i].CountConsumedMeat();
    }
    return sum;
  }

	/**
	 * Mengembalikan jumlah total sayur yang dikonsumsi seluruh binatang pada kandang
	 * @return jumlah daging
	 */
  public double CountConsumedVeggie(){
    double sum = 0;
    for(int i=0; i<n_animal; i++){
      sum += animal[i].CountConsumedVeggie();
    }
    return sum;
  }

	/**
	 * Menduplikasi suatu kandang
	 * @param kandang yang ingin diduplikasi
	 */
  public Cage Clone(){
    Cage out = new Cage(size);

    out.SetHabitat(habitat);

    for(int i=0; i<out.GetSize(); i++){
      out.AddPosition(row[i], col[i]);
    }
    for(int i=0; i<GetTotalAnimal(); i++){
      out.AddAnimal(animal[i]);
    }

    return out;
  }

	/**
	 * Membaca dan mengisi kandang dari scanner
	 * @param in scanner yang akan dibaca
	 */
  public void Read(Scanner in){
    int s = in.nextInt();
    SetNewCage(s);
    for(int i=0; i<s; i++){
      int x = in.nextInt();
      int y = in.nextInt();
      AddPosition(x, y);
    }
  }


}
