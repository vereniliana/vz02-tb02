/**
  * @author NIM/Nama : 13515057 / Erick Wijaya
  * File     : Driver.java
  */

import java.util.*;
import java.lang.*;
import java.io.*;
import cell.*;
import cage.*;
import animal.*;
import zoo.*;

public class Driver {
  /**
    * Deklarasi objek myZoo
    */
  public static Zoo myZoo;
  /**
    * Membuat sebuah kebun binatang
    */
  public static void CreateZoo(){
    try{
      Scanner inZoo = new Scanner(new File("zoo.txt"));
      Scanner inCage = new Scanner(new File("cage.txt"));
      Scanner inAnimal = new Scanner(new File("animal.txt"));
      Scanner in = new Scanner(System.in);
      myZoo = new Zoo();
      // Read Zoo from file
      myZoo.Read(inZoo);
      // Read Cage from file and add to Zoo
      int n_cage = inCage.nextInt();
      for(int i=0; i<n_cage; i++){
        Cage myCage = new Cage();
        myCage.Read(inCage);
        myZoo.AddCage(myCage);
      }
      // Read Animal from file and add to Zoo
      int n_animal = inAnimal.nextInt();
      for(int i=0; i<n_animal; i++){
        Animal myAnimal = new Animal();
        myAnimal.Read(inAnimal);
        myZoo.AddAnimal(myAnimal);
      }
      //inZoo.close();
      //inCage.close();
      //inAnimal.close();
      //in.close();
    }
    catch(FileNotFoundException e){
      System.out.println(e);
    }
  }
  /**
    * Menampilkan daftar pilihan menu utama
    */
  public static void ShowMenu(){
    System.out.println("Selamat datang di Kebun Binatang Virtual Zoo!");
    System.out.println("1. Menampilkan peta Kebun Binatang");
    System.out.println("2. Menampilkan seluruh peta pada Kebun Binatang");
    System.out.println("3. Menampilkan total makanan yang dimakan seluruh hewan");
    System.out.println("4. Tour Kebun Binatang!");
    System.out.println("5. Real Time Tour!");
    System.out.println("6. Quit");
    System.out.println("Pilih angka 1..6 :");
  }
  /**
    * main program
    */
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    CreateZoo();
    int n;
    do{
      ShowMenu();
      n = in.nextInt();
      switch (n) {
        case 1:
          System.out.print("Input angka x1 y1 x2 y2 : ");
          int x1 = in.nextInt(), y1 = in.nextInt(), x2 = in.nextInt(), y2 = in.nextInt();
          myZoo.Display(x1, y1, x2, y2);
          break;
        case 2:
          myZoo.Display();
          break;
        case 3:
          myZoo.PrintConsumedFood();
          break;
        case 4:
          myZoo.Tour();
          break;
        case 5:
          myZoo.RealTimeTour();
          break;
        case 6:
          System.out.print("Thank You For Visiting Our Zoo");
          break;
        default:
          break;
      }
      System.out.println();
    }while(n != 6);
    //in.close();
  }
}
