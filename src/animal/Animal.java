/**
  * @author NIM/Nama: 13515144 / William
  * Nama file : Animal.java
  */

package animal;

import java.util.*;
import color.*;

public class Animal {
  private Species species;
  private String name;
  private double weight;
  private Sex sex;
  private int heart_chamber;
  private char blood;
  private double veg_ratio;
  private double meat_ratio;
  private char id;
  private int row;
  private int col;
  private char habitat_1;
  private char habitat_2;
  private boolean wild;

  /**
   * Konstruktor
   */
  public Animal() {
    species = Species.NONE;
    name = "unnamed";
    weight = 0;
    sex = Sex.FEMALE;
    heart_chamber = 0;
    blood = '?';
    veg_ratio = 0;
    meat_ratio = 0;
    id = '?';
    row = 0;
    col = 0;
    habitat_1 = '?';
    habitat_2 = '?';
    wild = false;
  }

  /**
   * Konstruktor dengan parameter
   * @param _species species Animal
   * @param _name nama Animal
   * @param _weight berat Animal
   * @param _sex jenis kelamin Animal (MALE/FEMALE)
   * @param _hc jumlah ruang jantung
   * @param _blood jenis darah ('h'/'c')
   * @param _veg rasio sayur
   * @param _meat rasio daging
   * @param _id karakter id Animal
   * @param _row posisi Animal (baris)
   * @param _col posisi Animal (kolom)
   * @param _habitat karakter yang merepresentasikan habitat
   * @param _wild liar/tidaknya Animal
   */
  public Animal(Species _species, String _name, double _weight, Sex _sex, int _hc, char _blood,
                double _veg, double _meat, char _id, int _row, int _col, char _habitat_1, char _habitat_2, boolean _wild) {
    species = _species;
    name = _name;
    weight = _weight;
    sex = _sex;
    heart_chamber = _hc;
    blood = _blood;
    veg_ratio = _veg;
    meat_ratio = _meat;
    id = _id;
    row = _row;
    col =_col;
    habitat_1 = _habitat_1;
    habitat_2 = _habitat_2;
    wild = _wild;
  }

  /**
   * Melakukan duplikasi Animal
   * @return Animal yang diduplikasi
   */
  public Animal Clone() {
    return new Animal(species, name, weight, sex, heart_chamber, blood,
                      veg_ratio, meat_ratio, id, row, col, habitat_1, habitat_2, wild);
  }
  /**
   * Mengembalikan species dari Animal
   * @return nama Animal
   */
  public Species GetSpecies() {
    return species;
  }
  /**
   * Mengembalikan nama dari Animal
   * @return nama Animal
   */
  public String GetName() {
    return name;
  }

  /**
   * Mengembalikan berat dari Animal
   * @return berat Animal
   */
  public double GetWeight() {
    return weight;
  }

  /**
   * Mengembalikan jenis kelamin dari Animal
   * @return jenis kelamin Animal
   */
  public Sex GetSex() {
    return sex;
  }

  /**
   * Mengembalikan ruang jantung dari Animal
   * @return ruang jantung Animal
   */
  public int GetHeartChamber() {
    return heart_chamber;
  }

  /**
   * Mengembalikan jenis darah (panas/dingin) dari Animal
   * @return jenis darah (panas/dingin)  Animal
   */
  public char GetBlood() {
    return blood;
  }

  /**
   * Mengembalikan rasio konsumsi sayur dari Animal
   * @return rasio konsumsi sayur Animal
   */
  public double GetVegRatio() {
    return veg_ratio;
  }

  /**
   * Mengembalikan rasio konsumsi daging dari Animal
   * @return rasio konsumsi daging Animal
   */
  public double GetMeatRatio() {
    return meat_ratio;
  }

  /**
   * Mengembalikan id dari Animal
   * @return id Animal
   */
  public char GetId() {
    return id;
  }

  /**
   * Mengembalikan posisi baris dari Animal
   * @return posisi baris Animal
   */
  public int GetRow() {
    return row;
  }

  /**
   * Mengembalikan posisi kolom dari Animal
   * @return posisi kolom Animal
   */
  public int GetCol() {
    return col;
  }
  /**
   * Mengembalikan habitat pertama dari Animal
   * @return id Animal
   */
  public char GetFirstHabitat() {
    return habitat_1;
  }
  /**
   * Mengembalikan habitat pertama dari Animal
   * @return id Animal
   */
  public char GetSecondHabitat() {
    return habitat_2;
  }
  /**
   * Memeriksa liar/tidaknya Animal
   * @return id Animal
   */
  public boolean IsWild() {
    return wild;
  }
  /**
   * Mengubah nama dari Animal
   * @param nama Animal
   */
  public void SetName(String n) {
    name = n;
  }
  /**
   * Mengubah berat dari Animal
   * @param berat Animal
   */
  public void SetWeight(double w) {
    weight = w;
  }
  /**
   * Mengubah jenis kelamin dari Animal
   * @param jenis kelamin Animal
   */
  public void SetSex(Sex ns) {
    sex = ns;
  }
  /**
   * Mengubah posisi baris dari Animal
   * @param posisi baris Animal
   */
  public void SetRow(int r) {
    row = r;
  }
  /**
   * Mengubah posisi kolom dari Animal
   * @param posisi kolom Animal
   */
  public void SetCol(int c) {
    col = c;
  }
  /**
   * Mengubah seluruh atribut Animal
   * @param _species species Animal
   * @param _name nama Animal
   * @param _weight berat Animal
   * @param _sex jenis kelamin Animal (MALE/FEMALE)
   * @param _hc jumlah ruang jantung
   * @param _blood jenis darah ('h'/'c')
   * @param _veg rasio sayur
   * @param _meat rasio daging
   * @param _id karakter id Animal
   * @param _row posisi Animal (baris)
   * @param _col posisi Animal (kolom)
   * @param _habitat_1 karakter yang merepresentasikan habitat
   * @param _habitat_2 karakter yang merepresentasikan habitat kedua (sama dengan habitat_1 bila bukan amfibi)
   * @param _wild liar/tidaknya Animal
   */
  public void SetAll(Species _species, String _name, double _weight, Sex _sex,
                      int _hc, char _blood, double _veg, double _meat, char _id,
                      int _row, int _col, char _habitat_1, char _habitat_2, boolean _wild) {
    species = _species;
    name = _name;
    weight = _weight;
    sex = _sex;
    heart_chamber = _hc;
    blood = _blood;
    veg_ratio = _veg;
    meat_ratio = _meat;
    id = _id;
    row = _row;
    col =_col;
    habitat_1 = _habitat_1;
    habitat_2 = _habitat_2;
    wild = _wild;
  }
  /**
   * Menampilkan data atribut dari Animal ke layar
   */
  public void DisplayAnimalData() {
    System.out.println("Species: " + species);
    System.out.println("Name: " + name);
    System.out.println("Weight: "+ weight);
    System.out.println("Sex: "+ sex);
    System.out.println("HeartChamber: " + heart_chamber);
    System.out.println("Blood: " + blood);
    System.out.println("VegRatio: " + veg_ratio);
    System.out.println("MeatRatio: " + meat_ratio);
    System.out.println("Id: " + id);
    System.out.println("RowPosition: "+ row);
    System.out.println("ColPosition: "+ col);
    System.out.println("Habitat 1: "+ habitat_1);
    System.out.println("Habitat 2: "+ habitat_2);
    if (IsWild())
      System.out.println("Wild: true");
    else
      System.out.println("Wild: false");
  }

  /**
   * Menampilkan interaksi dari Animal
   */
  public void Interact() {
    if (species == Species.ELEPHANT)
      System.out.println("This elephant is trumpeting!!");
    else if (species == Species.GIRAFFE)
      System.out.println("This girrafe is eating high tree leaves");
    else if (species == Species.LION)
      System.out.println("Roarrrr..!!");
    else if (species == Species.TIGER)
      System.out.println("Grrrr...!! Grrr...!!");
    else if (species == Species.ORANGUTAN)
      System.out.println("This orangutan is playing on a tree!");
    else if (species == Species.CHIMPANZEE)
      System.out.println("U u a a ... U u a a");
    else if (species == Species.KOMODO)
      System.out.println("So amazing komodo!!");
    else if (species == Species.BEAR)
      System.out.println("Growl.. Growl..");
    else if (species == Species.WHALE)
      System.out.println("This whale created a huge splash!");
    else if (species == Species.DOLPHIN)
      System.out.println("This dolphin loves to jump!");
    else if (species == Species.CLOWNFISH)
      System.out.println("This clownfish lives among the anemone");
    else if (species == Species.BLUETANG)
      System.out.println("This blue tang just keeps swimmming!");
    else if (species == Species.PIRANHA)
      System.out.println("This piranha eats voraciously!");
    else if (species == Species.PUFFFISH)
      System.out.println("This puff fish is fat!");
    else if (species == Species.EAGLE)
      System.out.println("This eagle is soaring in the sky!");
    else if (species == Species.CENDRAWASIH)
      System.out.println("This cendrawasih is resting gracefully!");
    else if (species == Species.OWL)
      System.out.println("Hooo... Hooo...");
    else if (species == Species.BAT)
      System.out.println("This bat is sleeping upside down!");
    else if (species == Species.MACAU)
      System.out.println("This macau is very pretty!");
    else if (species == Species.COCKATOO)
      System.out.println("This cockatoo is repeating what you're saying!");
    else if (species == Species.FROG)
      System.out.println("Croag.... Croag.... Ribbet... Ribbet...");
    else if (species == Species.ALLIGATOR)
      System.out.println("Hiss.....");
    else if (species == Species.HIPPOPOTAMUS)
      System.out.println("This hippo is so big");
    else if (species == Species.TURTLE)
      System.out.println("This turtle is walking slowly");
    else
      System.out.println("ERROR: Nama spesies salah");
  }
  /**
   * Mengembalikan jumlah daging yang dikonsumsi
   * @return jumlah daging yang dikonsumsi
   */
  public double CountConsumedMeat() {
    return meat_ratio*weight;
  }

  /**
   * Mengembalikan jumlah makanan tumbuhan yang dikonsumsi
   * @return jumlah makanan tumbuhan yang dikonsumsi
   */
  public double CountConsumedVeggie() {
    return veg_ratio*weight;
  }

  /**
   * Mengembalikan karakter id Animal untuk nantinya ditampilkan
   * @return karakter id Animal
   */
  public char Render() {
    return GetId();
  }
  /**
   * Mengembalikan true bila Animal herbivore, yaitu memiliki rasio sayur > 0 dan rasio daging = 0
   * @return true bila rasio sayur > 0 dan rasio daging = 0
   */
  public boolean IsHerbivore(){
    return (veg_ratio > 0) && (meat_ratio == 0);
  }
  /**
   * Mengembalikan true bila Animal carnivore, yaitu memiliki rasio sayur = 0 dan rasio daging > 0
   * @return true bila rasio sayur = 0 dan rasio daging > 0
   */
  public boolean IsCarnivore(){
    return (veg_ratio == 0) && (meat_ratio > 0);
  }
  /**
   * Mengembalikan true bila Animal omnivore, yaitu memiliki rasio sayur > 0 dan rasio daging > 0
   * @return true bila rasio sayur > 0 dan rasio daging > 0
   */
  public boolean IsOmnivore(){
    return (veg_ratio > 0) && (meat_ratio > 0);
  }

  /**
   * Mengembalikan string berisi kode warna dan karakter dari Animal untuk ditampilkan
   * @return kode warna dan karakter Animal
   */
  public String RenderWithColor() {
    if ((habitat_1 == 'L') && (habitat_2 == habitat_1))
      return Color.ANSI_YELLOW + Render() + Color.ANSI_RESET;
    else if ((habitat_1 == 'W') && (habitat_2 == habitat_1))
      return Color.ANSI_CYAN + Render() + Color.ANSI_RESET;
    else if ((habitat_1 == 'A') && (habitat_2 == habitat_1))
      return Color.ANSI_RED + Render() + Color.ANSI_RESET;
    else // Amphibious
      return Color.ANSI_GREEN + Render() + Color.ANSI_RESET;
  }
  /**
  * Mengembalikan objek Animal dari suatu input "Scanner"
  * @param in scanner input
  * @return Animal yang diciptakan
  */
  public void Read(Scanner in){
    String s = in.next();
    String _name = in.next();
    double _weight = in.nextDouble();
    String _sex_s = in.next();
    Sex _sex = _sex_s.equalsIgnoreCase("MALE") ? Sex.MALE : Sex.FEMALE;
    int _row = in.nextInt();
    int _col = in.nextInt();

    if (s.equalsIgnoreCase("Elephant")){
      SetAll(Species.ELEPHANT, _name, _weight, _sex, 4, 'h', 0.05, 0, 'E', _row, _col, 'L', 'L', false);
    }
    else if (s.equalsIgnoreCase("Giraffe")){
      SetAll(Species.GIRAFFE, _name, _weight, _sex, 4, 'h', 0.05, 0, 'G', _row, _col, 'L', 'L', false); //TODO: Lengkapin darah, jantung, dn makanan
    }
    else if (s.equalsIgnoreCase("Lion")){
      SetAll(Species.LION, _name, _weight, _sex, 4, 'h', 0, 0.05, 'L', _row, _col, 'L', 'L', true);
    }
    else if (s.equalsIgnoreCase("Tiger")){
      SetAll(Species.TIGER, _name, _weight, _sex, 4, 'h', 0, 0.05, 'T', _row, _col, 'L', 'L', true);
    }
    else if (s.equalsIgnoreCase("Orangutan")){
      SetAll(Species.ORANGUTAN, _name, _weight, _sex, 4, 'h', 0.03, 0.03, 'O', _row, _col, 'L', 'L', false);
    }
    else if (s.equalsIgnoreCase("Chimpanzee")){
      SetAll(Species.CHIMPANZEE, _name, _weight, _sex, 4, 'h', 0.03, 0.03, 'C', _row, _col, 'L', 'L', false);
    }
    else if (s.equalsIgnoreCase("Komodo")){
      SetAll(Species.KOMODO, _name, _weight, _sex, 4, 'h', 0, 0.05, 'K', _row, _col, 'L', 'L', false);
    }
    else if (s.equalsIgnoreCase("Bear")){
      SetAll(Species.BEAR, _name, _weight, _sex, 4, 'h', 0, 0.05, 'B', _row, _col, 'L', 'L', false);
    }
    else if (s.equalsIgnoreCase("Whale")){
      SetAll(Species.WHALE, _name, _weight, _sex, 4, 'h', 0, 0.05, 'W', _row, _col, 'W', 'W', false);
    }
    else if (s.equalsIgnoreCase("Dolphin")){
      SetAll(Species.DOLPHIN, _name, _weight, _sex, 4, 'h', 0, 0.05, 'D', _row, _col, 'W', 'W', false);
    }
    else if (s.equalsIgnoreCase("Clownfish")){
      SetAll(Species.CLOWNFISH, _name, _weight, _sex, 4, 'h', 0.03, 0.03, 'C', _row, _col, 'W', 'W', false);
    }
    else if (s.equalsIgnoreCase("BlueTang")){
      SetAll(Species.BLUETANG, _name, _weight, _sex, 4, 'h', 0.05, 0, 'B', _row, _col, 'W', 'W', false);
    }
    else if (s.equalsIgnoreCase("Piranha")){
      SetAll(Species.PIRANHA, _name, _weight, _sex, 4, 'h', 0, 0.05, 'P', _row, _col, 'W', 'W', false);
    }
    else if (s.equalsIgnoreCase("PuffFish")){
      SetAll(Species.PUFFFISH, _name, _weight, _sex, 4, 'h', 0.05, 0, 'P', _row, _col, 'W', 'W', false);
    }
    else if (s.equalsIgnoreCase("Eagle")){
      SetAll(Species.ELEPHANT, _name, _weight, _sex, 4, 'h', 0, 0.05, 'E', _row, _col, 'A', 'A', false);
    }
    else if (s.equalsIgnoreCase("Cendrawasih")){
      SetAll(Species.CENDRAWASIH, _name, _weight, _sex, 4, 'h', 0, 0.05, 'C', _row, _col, 'A', 'A', false);
    }
    else if (s.equalsIgnoreCase("Owl")){
      SetAll(Species.OWL, _name, _weight, _sex, 4, 'h', 0, 0.05, 'O', _row, _col, 'A', 'A', false);
    }
    else if (s.equalsIgnoreCase("Bat")){
      SetAll(Species.BAT, _name, _weight, _sex, 4, 'h', 0.03, 0.03, 'B', _row, _col, 'A', 'A', false);
    }
    else if (s.equalsIgnoreCase("Macau")){
      SetAll(Species.MACAU, _name, _weight, _sex, 4, 'h', 0.05, 0, 'M', _row, _col, 'A', 'A', false);
    }
    else if (s.equalsIgnoreCase("Cockatoo")){
      SetAll(Species.COCKATOO, _name, _weight, _sex, 4, 'h', 0.05, 0, 'C', _row, _col, 'A', 'A', false);
    }
    else if (s.equalsIgnoreCase("Frog")){
      SetAll(Species.FROG, _name, _weight, _sex, 4, 'h', 0, 0.05, 'F', _row, _col, 'L', 'W', false);
    }
    else if (s.equalsIgnoreCase("Alligator")){
      SetAll(Species.ALLIGATOR, _name, _weight, _sex, 4, 'h', 0, 0.05, 'A', _row, _col, 'L', 'W', false);
    }
    else if (s.equalsIgnoreCase("Hippopotamus")){
      SetAll(Species.HIPPOPOTAMUS, _name, _weight, _sex, 4, 'h', 0, 0.05, 'H', _row, _col, 'L', 'W', false);
    }
    else if (s.equalsIgnoreCase("Turtle")){
      SetAll(Species.TURTLE, _name, _weight, _sex, 4, 'h', 0.05, 0, 'T', _row, _col, 'L', 'W', false);
    }
    else{
      new Animal();
    }
  }
}
