package test.zoo;

import static org.junit.Assert.*;
import org.junit.*;
import java.io.*;
import src.animal.Animal;
import src.zoo.Zoo;

public class ZooTest {
  Zoo z = new Zoo(12,15);
  @Test
  public void test_getRow() {
  System.out.println("Test if getRow returns row correctly...");
    assertTrue(z.getRow() == 12);
  }
  @Test
  public void test_getCol() {
  System.out.println("Test if getCol returns col correctly...");
    assertTrue(z.getCol() == 15);
  }
  @Test
  public void test_getTotalCage() {
  	System.out.println("Test if getTotalCage returns total cage correctly...");
    assertTrue(z.getTotalCage() == 0);
  }
  @Test
  public void test_setNewZoo() {
    System.out.println("Test if setNewZoo is correct ...");
    z.setNewZoo(15,16);
    assertTrue(z.getRow() == 15 && z.getCol() == 16);
  }
  @Test
  public void test_printConsumedFood() {
    System.out.println("Test if printConsumedFood is correct");
    
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    String expectedOutput = "";
    z.printConsumedFood();
    assertEquals(outContent.toString(), expectedOutput);
  }
}
