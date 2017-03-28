/**
  * @author NIM/Nama: 13515144 / William.
  * Nama file : Animal.java.
  */

package src.animal;

import java.util.*;
import src.color.Color;

public class Animal {
  private Species species;
  private String name;
  private double weight;
  private Sex sex;
  private int heartChamber;
  private char blood;
  private double vegRatio;
  private double meatRatio;
  private char id;
  private int row;
  private int col;
  private char habitat1;
  private char habitat2;
  private boolean wild;

  /**
   * Konstruktor.
   */
  public Animal() {
    species = Species.NONE;
    name = "unnamed";
    weight = 0;
    sex = Sex.FEMALE;
    heartChamber = 0;
    blood = '?';
    vegRatio = 0;
    meatRatio = 0;
    id = '?';
    row = 0;
    col = 0;
    habitat1 = '?';
    habitat2 = '?';
    wild = false;
  }

  /**
   * Konstruktor dengan parameter.
   * @param parSpecies species Animal
   * @param parName nama Animal
   * @param parWeight berat Animal
   * @param parSex jenis kelamin Animal (MALE/FEMALE)
   * @param parHc jumlah ruang jantung
   * @param parBlood jenis darah ('h'/'c')
   * @param parVeg rasio sayur
   * @param parMeat rasio daging
   * @param parId karakter id Animal
   * @param parRow posisi Animal (baris)
   * @param parCol posisi Animal (kolom)
   * @param parHabitat1 karakter yang merepresentasikan habitat
   * @param parWild liar/tidaknya Animal
   */
  public Animal(Species parSpecies, String parName, double parWeight, Sex parSex, int parHc, 
                char parBlood, double parVeg, double parMeat, char parId, int parRow, int parCol, 
                char parHabitat1, char parHabitat2, boolean parWild) {
    species = parSpecies;
    name = parName;
    weight = parWeight;
    sex = parSex;
    heartChamber = parHc;
    blood = parBlood;
    vegRatio = parVeg;
    meatRatio = parMeat;
    id = parId;
    row = parRow;
    col = parCol;
    habitat1 = parHabitat1;
    habitat2 = parHabitat2;
    wild = parWild;
  }

  /**
   * Melakukan duplikasi Animal.
   * @return Animal yang diduplikasi
   */
  public Animal clone() {
    return new Animal(species, name, weight, sex, heartChamber, blood,
                      vegRatio, meatRatio, id, row, col, habitat1, habitat2, wild);
  }
  
  /**
   * Mengembalikan species dari Animal.
   * @return nama Animal
   */
  public Species getSpecies() {
    return species;
  }
  
  /**
   * Mengembalikan nama dari Animal.
   * @return nama Animal
   */
  public String getName() {
    return name;
  }

  /**
   * Mengembalikan berat dari Animal.
   * @return berat Animal
   */
  public double getWeight() {
    return weight;
  }

  /**
   * Mengembalikan jenis kelamin dari Animal.
   * @return jenis kelamin Animal
   */
  public Sex getSex() {
    return sex;
  }

  /**
   * Mengembalikan ruang jantung dari Animal.
   * @return ruang jantung Animal
   */
  public int getHeartChamber() {
    return heartChamber;
  }

  /**
   * Mengembalikan jenis darah (panas/dingin) dari Animal.
   * @return jenis darah (panas/dingin)  Animal
   */
  public char getBlood() {
    return blood;
  }

  /**
   * Mengembalikan rasio konsumsi sayur dari Animal.
   * @return rasio konsumsi sayur Animal
   */
  public double getVegRatio() {
    return vegRatio;
  }

  /**
   * Mengembalikan rasio konsumsi daging dari Animal.
   * @return rasio konsumsi daging Animal
   */
  public double getMeatRatio() {
    return meatRatio;
  }

  /**
   * Mengembalikan id dari Animal.
   * @return id Animal
   */
  public char getId() {
    return id;
  }

  /**
   * Mengembalikan posisi baris dari Animal.
   * @return posisi baris Animal
   */
  public int getRow() {
    return row;
  }

  /**
   * Mengembalikan posisi kolom dari Animal.
   * @return posisi kolom Animal
   */
  public int getCol() {
    return col;
  }
  
  /**
   * Mengembalikan habitat pertama dari Animal.
   * @return id Animal
   */
  public char getFirstHabitat() {
    return habitat1;
  }
  
  /**
   * Mengembalikan habitat pertama dari Animal.
   * @return id Animal
   */
  public char getSecondHabitat() {
    return habitat2;
  }
  
  /**
   * Memeriksa liar/tidaknya Animal.
   * @return id Animal
   */
  public boolean isWild() {
    return wild;
  }
  
  /**
   * Mengubah spesies dari Animal.
   * @param sp spesies Animal
   */
  public void setSpecies(Species sp) {
    species = sp;
  }
  
  /**
   * Mengubah nama dari Animal.
   * @param n nama Animal
   */
  public void setName(String n) {
    name = n;
  }
  
  /**
   * Mengubah berat dari Animal.
   * @param w berat Animal
   */
  public void setWeight(double w) {
    weight = w;
  }
  
  /**
   * Mengubah jenis kelamin dari Animal.
   * @param ns jenis kelamin Animal
   */
  public void setSex(Sex ns) {
    sex = ns;
  }
  
  /**
   * Mengubah jumlah ruang jantung dari Animal.
   * @param hc jumlah ruang jantung Animal
   */
  public void setHeartChamber(int hc) {
    heartChamber = hc;
  }
  
  /**
   * Mengubah temperatur darah dari Animal.
   * @param bl temperatur darah('h'/'c') Animal
   */
  public void setBlood(char bl) {
    blood = bl;
  }
  
  /**
   * Mengubah rasio konsumsi sayur Animal.
   * @param vr rasio konsumsi sayur
   */
  public void setVegRatio(double vr) {
    vegRatio = vr;
  }
  
  /**
   * Mengubah rasio konsumsi daging Animal.
   * @param mr rasio konsumsi daging
   */
  public void setMeatRatio(double mr) {
    meatRatio = mr;
  }
  
  /**
   * Mengubah posisi baris dari Animal.
   * @param r posisi baris Animal
   */
  public void setRow(int r) {
    row = r;
  }
  
  /**
   * Mengubah posisi kolom dari Animal.
   * @param c posisi kolom Animal
   */
  public void setCol(int c) {
    col = c;
  }
  
  /**
   * Mengubah id dari Animal.
   * @param idChar id Animal
   */
  public void setId(char idChar) {
    id = idChar; 
  }
  
  /**
   * Mengubah habitat (1) dari Animal.
   * @param hab1 habitat Animal
   */
  public void setFirstHabitat(char hab1) {
    habitat1 = hab1;
  }
  
  /**
   * Mengubah habitat (2) dari Animal.
   * @param hab2 habitat Animal
   */
  public void setSecondHabitat(char hab2) {
    habitat2 = hab2;
  }
  
  /**
   * Mengubah liar/tidaknya dari Animal.
   * @param w true jika liar, false jika tidak
   */
  public void setWild(boolean w) {
    wild = w;
  }
  
  /**
   * Mengubah seluruh atribut Animal.
   * @param parSpecies species Animal
   * @param parName nama Animal
   * @param parWeight berat Animal
   * @param parSex jenis kelamin Animal (MALE/FEMALE)
   * @param parHc jumlah ruang jantung
   * @param parBlood jenis darah ('h'/'c')
   * @param parVeg rasio sayur
   * @param parMeat rasio daging
   * @param parId karakter id Animal
   * @param parRow posisi Animal (baris)
   * @param parCol posisi Animal (kolom)
   * @param parHabitat1 karakter yang merepresentasikan habitat
   * @param parWild liar/tidaknya Animal
   */
  public void setAll(Species parSpecies, String parName, double parWeight, Sex parSex, int parHc, 
                      char parBlood, double parVeg, double parMeat, char parId, int parRow, 
                      int parCol, char parHabitat1, char parHabitat2, boolean parWild) {
    species = parSpecies;
    name = parName;
    weight = parWeight;
    sex = parSex;
    heartChamber = parHc;
    blood = parBlood;
    vegRatio = parVeg;
    meatRatio = parMeat;
    id = parId;
    row = parRow;
    col = parCol;
    habitat1 = parHabitat1;
    habitat2 = parHabitat2;
    wild = parWild;
  }
  
  /**
   * Menampilkan data atribut dari Animal ke layar.
   */
  public void displayAnimalData() {
    System.out.println("Species: " + species);
    System.out.println("Name: " + name);
    System.out.println("Weight: " + weight);
    System.out.println("Sex: " + sex);
    System.out.println("HeartChamber: " + heartChamber);
    System.out.println("Blood: " + blood);
    System.out.println("VegRatio: " + vegRatio);
    System.out.println("MeatRatio: " + meatRatio);
    System.out.println("Id: " + id);
    System.out.println("RowPosition: " + row);
    System.out.println("ColPosition: " + col);
    System.out.println("Habitat 1: " + habitat1);
    System.out.println("Habitat 2: " + habitat2);
    if (isWild()) {
      System.out.println("Wild: true");
    } else {
      System.out.println("Wild: false");
    }
  }

  /**
   * Menampilkan interaksi dari Animal.
   */
  public void interact() {
    if (species == Species.ELEPHANT) {
      System.out.println("This elephant is trumpeting!!");
    } else if (species == Species.GIRAFFE) {
      System.out.println("This girrafe is eating high tree leaves");
    } else if (species == Species.LION) {
      System.out.println("Roarrrr..!!");
    } else if (species == Species.TIGER) {
      System.out.println("Grrrr...!! Grrr...!!");
    } else if (species == Species.ORANGUTAN) {
      System.out.println("This orangutan is playing on a tree!");
    } else if (species == Species.CHIMPANZEE) {
      System.out.println("U u a a ... U u a a");
    } else if (species == Species.KOMODO) {
      System.out.println("So amazing komodo!!");
    } else if (species == Species.BEAR) {
      System.out.println("Growl.. Growl..");
    } else if (species == Species.WHALE) {
      System.out.println("This whale created a huge splash!");
    } else if (species == Species.DOLPHIN) {
      System.out.println("This dolphin loves to jump!");
    } else if (species == Species.CLOWNFISH) {
      System.out.println("This clownfish lives among the anemone");
    } else if (species == Species.BLUETANG) {
      System.out.println("This blue tang just keeps swimmming!");
    } else if (species == Species.PIRANHA) {
      System.out.println("This piranha eats voraciously!");
    } else if (species == Species.PUFFFISH) {
      System.out.println("This puff fish is fat!");
    } else if (species == Species.EAGLE) {
      System.out.println("This eagle is soaring in the sky!");
    } else if (species == Species.CENDRAWASIH) {
      System.out.println("This cendrawasih is resting gracefully!");
    } else if (species == Species.OWL) {
      System.out.println("Hooo... Hooo...");
    } else if (species == Species.BAT) {
      System.out.println("This bat is sleeping upside down!");
    } else if (species == Species.MACAU) {
      System.out.println("This macau is very pretty!");
    } else if (species == Species.COCKATOO) {
      System.out.println("This cockatoo is repeating what you're saying!");
    } else if (species == Species.FROG) {
      System.out.println("Croag.... Croag.... Ribbet... Ribbet...");
    } else if (species == Species.ALLIGATOR) {
      System.out.println("Hiss.....");
    } else if (species == Species.HIPPOPOTAMUS) {
      System.out.println("This hippo is so big");
    } else if (species == Species.TURTLE) {
      System.out.println("This turtle is walking slowly");
    } else {
      System.out.println("ERROR: Nama spesies salah");
    }
  }
  
  /**
   * Mengembalikan jumlah daging yang dikonsumsi.
   * @return jumlah daging yang dikonsumsi
   */
  public double countConsumedMeat() {
    return meatRatio * weight;
  }

  /**
   * Mengembalikan jumlah makanan tumbuhan yang dikonsumsi.
   * @return jumlah makanan tumbuhan yang dikonsumsi
   */
  public double countConsumedVeggie() {
    return vegRatio * weight;
  }

  /**
   * Mengembalikan karakter id Animal untuk nantinya ditampilkan.
   * @return karakter id Animal
   */
  public char render() {
    return getId();
  }
  
  /**
   * Mengembalikan true bila Animal herbivore, yaitu memiliki rasio sayur > 0 dan rasio daging = 0.
   * @return true bila rasio sayur > 0 dan rasio daging = 0
   */
  public boolean isHerbivore() {
    return (vegRatio > 0) && (meatRatio == 0);
  }
  
  /**
   * Mengembalikan true bila Animal carnivore, yaitu memiliki rasio sayur = 0 dan rasio daging > 0.
   * @return true bila rasio sayur = 0 dan rasio daging > 0
   */
  public boolean isCarnivore() {
    return (vegRatio == 0) && (meatRatio > 0);
  }
  
  /**
   * Mengembalikan true bila Animal omnivore, yaitu memiliki rasio sayur > 0 dan rasio daging > 0.
   * @return true bila rasio sayur > 0 dan rasio daging > 0
   */
  public boolean isOmnivore() {
    return (vegRatio > 0) && (meatRatio > 0);
  }

  /**
   * Mengembalikan string berisi kode warna dan karakter dari Animal untuk ditampilkan.
   * @return kode warna dan karakter Animal
   */
  public String renderWithColor() {
    if ((habitat1 == 'L') && (habitat2 == habitat1)) {
      return Color.ANSI_YELLOW + render() + Color.ANSI_RESET;
    } else if ((habitat1 == 'W') && (habitat2 == habitat1)) {
      return Color.ANSI_CYAN + render() + Color.ANSI_RESET;
    } else if ((habitat1 == 'A') && (habitat2 == habitat1)) {
      return Color.ANSI_RED + render() + Color.ANSI_RESET;
    } else { // Amphibious
      return Color.ANSI_GREEN + render() + Color.ANSI_RESET;
    }
  }
  
  /**
  * Mengembalikan objek Animal dari suatu input "Scanner".
  * @param in scanner input
  */
  public void read(Scanner in) {
    String s = in.next();
    String parName = in.next();
    double parWeight = in.nextDouble();
    String parS = in.next();
    Sex parSex = parS.equalsIgnoreCase("MALE") ? Sex.MALE : Sex.FEMALE;
    int parRow = in.nextInt();
    int parCol = in.nextInt();

    if (s.equalsIgnoreCase("Elephant")) {
      setAll(Species.ELEPHANT, 
              parName, parWeight, parSex, 4, 'h', 0.05, 0, 'E', parRow, parCol, 'L', 'L', false);
    } else if (s.equalsIgnoreCase("Giraffe")) {
      setAll(Species.GIRAFFE,
              parName, parWeight, parSex, 4, 'h', 0.05, 0, 'G', parRow, parCol, 'L', 'L', false);
    } else if (s.equalsIgnoreCase("Lion")) {
      setAll(Species.LION, 
              parName, parWeight, parSex, 4, 'h', 0, 0.05, 'L', parRow, parCol, 'L', 'L', true);
    } else if (s.equalsIgnoreCase("Tiger")) {
      setAll(Species.TIGER, 
              parName, parWeight, parSex, 4, 'h', 0, 0.05, 'T', parRow, parCol, 'L', 'L', true);
    } else if (s.equalsIgnoreCase("Orangutan")) {
      setAll(Species.ORANGUTAN, 
              parName, parWeight, parSex, 4, 'h', 0.03, 0.03, 'O', parRow, parCol, 'L', 'L', false);
    } else if (s.equalsIgnoreCase("Chimpanzee")) {
      setAll(Species.CHIMPANZEE, 
              parName, parWeight, parSex, 4, 'h', 0.03, 0.03, 'C', parRow, parCol, 'L', 'L', false);
    } else if (s.equalsIgnoreCase("Komodo")) {
      setAll(Species.KOMODO, 
              parName, parWeight, parSex, 4, 'h', 0, 0.05, 'K', parRow, parCol, 'L', 'L', false);
    } else if (s.equalsIgnoreCase("Bear")) {
      setAll(Species.BEAR, 
              parName, parWeight, parSex, 4, 'h', 0, 0.05, 'B', parRow, parCol, 'L', 'L', false);
    } else if (s.equalsIgnoreCase("Whale")) {
      setAll(Species.WHALE, 
              parName, parWeight, parSex, 4, 'h', 0, 0.05, 'W', parRow, parCol, 'W', 'W', false);
    } else if (s.equalsIgnoreCase("Dolphin")) {
      setAll(Species.DOLPHIN, 
              parName, parWeight, parSex, 4, 'h', 0, 0.05, 'D', parRow, parCol, 'W', 'W', false);
    } else if (s.equalsIgnoreCase("Clownfish")) {
      setAll(Species.CLOWNFISH, 
              parName, parWeight, parSex, 4, 'h', 0.03, 0.03, 'C', parRow, parCol, 'W', 'W', false);
    } else if (s.equalsIgnoreCase("BlueTang")) {
      setAll(Species.BLUETANG, 
              parName, parWeight, parSex, 4, 'h', 0.05, 0, 'B', parRow, parCol, 'W', 'W', false);
    } else if (s.equalsIgnoreCase("Piranha")) {
      setAll(Species.PIRANHA, 
              parName, parWeight, parSex, 4, 'h', 0, 0.05, 'P', parRow, parCol, 'W', 'W', false);
    } else if (s.equalsIgnoreCase("PuffFish")) {
      setAll(Species.PUFFFISH, 
              parName, parWeight, parSex, 4, 'h', 0.05, 0, 'P', parRow, parCol, 'W', 'W', false);
    } else if (s.equalsIgnoreCase("Eagle")) {
      setAll(Species.ELEPHANT, 
              parName, parWeight, parSex, 4, 'h', 0, 0.05, 'E', parRow, parCol, 'A', 'A', false);
    } else if (s.equalsIgnoreCase("Cendrawasih")) {
      setAll(Species.CENDRAWASIH, 
              parName, parWeight, parSex, 4, 'h', 0, 0.05, 'C', parRow, parCol, 'A', 'A', false);
    } else if (s.equalsIgnoreCase("Owl")) {
      setAll(Species.OWL, 
              parName, parWeight, parSex, 4, 'h', 0, 0.05, 'O', parRow, parCol, 'A', 'A', false);
    } else if (s.equalsIgnoreCase("Bat")) {
      setAll(Species.BAT, 
              parName, parWeight, parSex, 4, 'h', 0.03, 0.03, 'B', parRow, parCol, 'A', 'A', false);
    } else if (s.equalsIgnoreCase("Macau")) {
      setAll(Species.MACAU, parName, 
              parWeight, parSex, 4, 'h', 0.05, 0, 'M', parRow, parCol, 'A', 'A', false);
    } else if (s.equalsIgnoreCase("Cockatoo")) {
      setAll(Species.COCKATOO, 
              parName, parWeight, parSex, 4, 'h', 0.05, 0, 'C', parRow, parCol, 'A', 'A', false);
    } else if (s.equalsIgnoreCase("Frog")) {
      setAll(Species.FROG, 
              parName, parWeight, parSex, 4, 'h', 0, 0.05, 'F', parRow, parCol, 'L', 'W', false);
    } else if (s.equalsIgnoreCase("Alligator")) {
      setAll(Species.ALLIGATOR, 
              parName, parWeight, parSex, 4, 'h', 0, 0.05, 'A', parRow, parCol, 'L', 'W', false);
    } else if (s.equalsIgnoreCase("Hippopotamus")) {
      setAll(Species.HIPPOPOTAMUS, 
              parName, parWeight, parSex, 4, 'h', 0, 0.05, 'H', parRow, parCol, 'L', 'W', false);
    } else if (s.equalsIgnoreCase("Turtle")) {
      setAll(Species.TURTLE, 
              parName, parWeight, parSex, 4, 'h', 0.05, 0, 'T', parRow, parCol, 'L', 'W', false);
    } else {
      new Animal();
    }
  }
}
