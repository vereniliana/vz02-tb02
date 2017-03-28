package test.cage;

import static org.junit.Assert.*;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import src.cage.*;
import src.animal.*;

public class CageTest {

  @Test
  public void test_getSize() {
    System.out.println("Test if return correct size ...");
    Cage c = new Cage(4);
    assertTrue(c.getSize()==4);
  }

  @Test
  public void test_getTotalAnimal() {
    System.out.println("Test if return correct number of animal ...");
    Cage c = new Cage();
    assertTrue(c.getTotalAnimal()==0);
  }

  //also test addPosition
  @Test
  public void test_getRow() {
    System.out.println("Test if return correct row of cage 1 ...");
    Cage c = new Cage(4);
    c.addPosition(0,0);
    c.addPosition(2,1);
    assertTrue(c.getRow(1)==2);
  }

  @Test
    public void test_getCol() {
      System.out.println("Test if return correct col of cage 0 ...");
      Cage c = new Cage(4);
      c.addPosition(0,0);
      c.addPosition(2,1);
      assertTrue(c.getCol(0)==0);
    }

  //also test addAnimal
  @Test
  public void test_getAnimal() {
    System.out.println("Test if return correct animal species of cage i ...");
    Cage c = new Cage(4);
    c.addPosition(0,0);
    c.setHabitat('l');
    Animal A = new Animal(Species.ELEPHANT, "elephant1", 2000, Sex.MALE, 4, 'h', 0.05, 0, 'E', 0, 0, 'l', 'l', false);
    c.addAnimal(A);
    assertTrue(c.getAnimal(0).getSpecies()==Species.ELEPHANT);
  }

  //also test setHabitat
  @Test
  public void test_getHabitat() {
    System.out.println("Test if return correct habitat ...");
    Cage c = new Cage(4);
    c.setHabitat('w');
    assertTrue(c.getHabitat()=='w');
  }

  @Test
  public void test_isFull() {
    System.out.println("Test if return full or not correctly ...");
    Cage c = new Cage(4);
    assertTrue(c.isFull()==false);
  }

  @Test
  public void test_isWild() {
    System.out.println("Test if return wild or not correctly ...");
    Cage c = new Cage(4);
    c.addPosition(0,0);
    c.setHabitat('l');
    Animal A = new Animal(Species.ELEPHANT, "elephant1", 2000, Sex.MALE, 4, 'h', 0.05, 0, 'E', 0, 0, 'l', 'l', false);
    c.addAnimal(A);
    assertTrue(c.isWild()==false);
  }

  @Test
  public void test_searchPosition() {
    System.out.println("Test if return position included or not correctly ...");
    Cage c = new Cage(4);
    c.addPosition(0,0);
    c.addPosition(2,1);
    
    assertTrue(c.searchPosition(2,1)==true);
  }

  @Test
    public void test_searchAnimal1() {
      System.out.println("Test if return animal included or not by position ...");
      Cage c = new Cage(4);
      c.addPosition(0,0);
      c.setHabitat('l');
      Animal A = new Animal(Species.ELEPHANT, "elephant1", 2000, Sex.MALE, 4, 'h', 0.05, 0, 'E', 0, 0, 'l', 'l', false);
      c.addAnimal(A);
      assertTrue(c.searchAnimal(0,0)==true);
    }

  @Test
    public void test_searchAnimal2() {
      System.out.println("Test if return animal included or not by species ...");
      Cage c = new Cage(4);
      c.addPosition(0,0);
      c.setHabitat('l');
      Animal A = new Animal(Species.ELEPHANT, "elephant1", 2000, Sex.MALE, 4, 'h', 0.05, 0, 'E', 0, 0, 'l', 'l', false);
      c.addAnimal(A);
      assertTrue(c.searchAnimal(Species.LION)==false);
    }

  @Test
    public void test_render() {
      System.out.println("Test if return correct character ...");
      Cage c = new Cage(4);
      c.setHabitat('w');
      assertTrue(c.render()=='w');
    }

  @Test
      public void test_countConsumedMeat() {
        System.out.println("Test if return correct consumed meat ...");
        Cage c = new Cage(4);
        c.addPosition(0,0);
        c.setHabitat('l');
        Animal A = new Animal(Species.ELEPHANT, "elephant1", 2000, Sex.MALE, 4, 'h', 0.05, 0, 'E', 0, 0, 'l', 'l', false);
        c.addAnimal(A);
        assertTrue(c.countConsumedMeat()== 0);
      }

  @Test
    public void test_countConsumedVeggie() {
      System.out.println("Test if return correct consumed veggie ...");
      Cage c = new Cage(4);
      c.addPosition(0,0);
      c.setHabitat('l');
      Animal A = new Animal(Species.ELEPHANT, "elephant1", 2000, Sex.MALE, 4, 'h', 0.05, 0, 'E', 0, 0, 'l', 'l', false);
      c.addAnimal(A);
      assertTrue(c.countConsumedVeggie()== (2000 * 0.05));
    }
}
