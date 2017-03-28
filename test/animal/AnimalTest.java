package test.animal;

import static org.junit.Assert.*;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import src.animal.*;

public class AnimalTest {

  @Test
  public void test_getSpecies() {
		System.out.println("Test if return correct Species ...");
		Animal A = new Animal(Species.ELEPHANT, "elephant1", 2000, Sex.MALE, 4, 'h', 0.05, 0, 'E', 2, 2, 'l', 'l', false);
		assertTrue(A.getSpecies()==Species.ELEPHANT);
	}
	
  @Test
  public void test_getName() {
    System.out.println("Test if return correct animal name ...");
    Animal A = new Animal(Species.ELEPHANT, "elephant1", 2000, Sex.MALE, 4, 'h', 0.05, 0, 'E', 2, 2, 'l', 'l', false);
    assertTrue(A.getName()=="elephant1");
  }
  
  @Test
  public void test_getWeight() {
    System.out.println("Test if return correct animal weight ...");
    Animal A = new Animal(Species.ELEPHANT, "elephant1", 2000, Sex.MALE, 4, 'h', 0.05, 0, 'E', 2, 2, 'l', 'l', false);
    assertTrue(A.getName()=="elephant1");
  }
  
  @Test
  public void test_getSex() {
    System.out.println("Test if return correct animal sex ...");
    Animal A = new Animal(Species.ELEPHANT, "elephant1", 2000, Sex.MALE, 4, 'h', 0.05, 0, 'E', 2, 2, 'l', 'l', false);
    assertTrue(A.getSex()==Sex.MALE);
  }
  
  @Test
  public void test_getHeartChamber() {
    System.out.println("Test if return correct animal heart chamber ...");
    Animal A = new Animal(Species.ELEPHANT, "elephant1", 2000, Sex.MALE, 4, 'h', 0.05, 0, 'E', 2, 2, 'l', 'l', false);
    assertTrue(A.getHeartChamber()==4);
  }
  
  @Test
  public void test_getBlood() {
    System.out.println("Test if return correct animal blood temperature ...");
    Animal A = new Animal(Species.ELEPHANT, "elephant1", 2000, Sex.MALE, 4, 'h', 0.05, 0, 'E', 2, 2, 'l', 'l', false);
    assertTrue(A.getBlood()=='h');
  }
  
  @Test
  public void test_getVegRatio() {
    System.out.println("Test if return correct animal vegetable ratio ...");
    Animal A = new Animal(Species.ELEPHANT, "elephant1", 2000, Sex.MALE, 4, 'h', 0.05, 0, 'E', 2, 2, 'l', 'l', false);
    assertTrue(A.getVegRatio()==0.05);
  }
  
  @Test
  public void test_getMeatRatio() {
    System.out.println("Test if return correct animal meat ratio ...");
    Animal A = new Animal(Species.ELEPHANT, "elephant1", 2000, Sex.MALE, 4, 'h', 0.05, 0, 'E', 2, 2, 'l', 'l', false);
    assertTrue(A.getMeatRatio()==0);
  }
  
  @Test
  public void test_getRow() {
    System.out.println("Test if return correct animal row position ...");
    Animal A = new Animal(Species.ELEPHANT, "elephant1", 2000, Sex.MALE, 4, 'h', 0.05, 0, 'E', 2, 2, 'l', 'l', false);
    assertTrue(A.getRow()==2);
  }
  
  @Test
  public void test_getCol() {
    System.out.println("Test if return correct animal column position ...");
    Animal A = new Animal(Species.ELEPHANT, "elephant1", 2000, Sex.MALE, 4, 'h', 0.05, 0, 'E', 2, 2, 'l', 'l', false);
    assertTrue(A.getCol()==2);
  }
	
  @Test
  public void test_getFirstHabitat() {
    System.out.println("Test if return correct animal habitat(1) ...");
    Animal A = new Animal(Species.ELEPHANT, "elephant1", 2000, Sex.MALE, 4, 'h', 0.05, 0, 'E', 2, 2, 'l', 'l', false);
    assertTrue(A.getFirstHabitat()=='l');
  }
  
  @Test
  public void test_getSecondHabitat() {
    System.out.println("Test if return correct animal habitat(2) ...");
    Animal A = new Animal(Species.ELEPHANT, "elephant1", 2000, Sex.MALE, 4, 'h', 0.05, 0, 'E', 2, 2, 'l', 'l', false);
    assertTrue(A.getSecondHabitat()=='l');
  }
  
  @Test 
  public void test_isWild() {
    System.out.println("Test if return correct animal wild/not ...");
    Animal A = new Animal(Species.ELEPHANT, "elephant1", 2000, Sex.MALE, 4, 'h', 0.05, 0, 'E', 2, 2, 'l', 'l', false);
    assertTrue(A.isWild()==false);
  }
  
  @Test
  public void test_Setter() {
    System.out.println("Test if animal setter is correct ...");
    Animal A = new Animal();
    A.setSpecies(Species.EAGLE);
    A.setName("eagle1");
    A.setWeight(90);
    A.setSex(Sex.FEMALE);
    A.setHeartChamber(3);
    A.setBlood('h');
    A.setVegRatio(0);
    A.setMeatRatio(0.04);
    A.setId('E');
    A.setRow(5);
    A.setCol(8);
    A.setFirstHabitat('a');
    A.setSecondHabitat('a');
    A.setWild(true);
    assertTrue((A.getSpecies()==Species.EAGLE) && (A.getName()=="eagle1") && (A.getWeight()==90) && (A.getSex()==Sex.FEMALE) &&
        (A.getHeartChamber()==3)&& (A.getBlood()=='h') && (A.getVegRatio()==0) && (A.getMeatRatio()==0.04) && 
        (A.getId()=='E') && (A.getRow()==5) && (A.getCol()==8) && (A.getFirstHabitat()=='a') && (A.getSecondHabitat()=='a') &&
        (A.isWild()==true));
  }
  
  @Test
  public void test_interact() throws Exception {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    Animal A = new Animal(Species.ELEPHANT, "elephant1", 2000, Sex.MALE, 4, 'h', 0.05, 0, 'E', 2, 2, 'l', 'l', false);
    A.interact();
    String expectedOutput  = "This elephant is trumpeting!!\n"; // Notice the \n for new line.
    assertEquals(outContent.toString(), expectedOutput);
  }
  
  @Test
  public void test_setAll() {
    System.out.println("Test if method setAll is correct ...");
    Animal A = new Animal(Species.ELEPHANT, "elephant1", 2000, Sex.MALE, 4, 'h', 0.05, 0, 'E', 2, 2, 'l', 'l', false);
    A.setAll(Species.DOLPHIN,"dolphin1",80,Sex.FEMALE,4,'h',0,0.04,'D',3,4,'w','w',false);
    assertTrue((A.getSpecies()==Species.DOLPHIN) && (A.getName()=="dolphin1") && (A.getWeight()==80) && (A.getSex()==Sex.FEMALE) &&
        (A.getHeartChamber()==4)&& (A.getBlood()=='h') && (A.getVegRatio()==0) && (A.getMeatRatio()==0.04) && 
        (A.getId()=='D') && (A.getRow()==3) && (A.getCol()==4) && (A.getFirstHabitat()=='w') && (A.getSecondHabitat()=='w') && 
        (A.isWild()==false));
  }
  
  @Test
  public void test_displayAnimalData() {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    Animal A = new Animal(Species.ELEPHANT, "elephant1", 2000, Sex.MALE, 4, 'h', 0.05, 0, 'E', 2, 2, 'l', 'l', false);
    A.displayAnimalData();
     // Notice the \n for new line.
    String expectedOutput  = "Species: ELEPHANT\n"+
                             "Name: elephant1\n"+
                              "Weight: 2000\n"+
                              "Sex: MALE\n"+
                              "HeartChamber: 4\n"+
                              "Blood: h\n"+
                              "VegRatio: 0.05\n"+
                              "MeatRatio: 0\n"+
                              "Id: E\n"+
                              "RowPosition: 2\n"+
                              "ColPosition: 2\n"+
                              "Habitat 1: l\n"+
                              "Habitat 2: l\n"+
                              "Wild: false\n";
    assertEquals(outContent.toString(), expectedOutput);
  }
  
  @Test
  public void test_countConsumedVeggie() {
    System.out.println("Test if return correct consumed veggie ...");
    Animal A = new Animal(Species.ELEPHANT, "elephant1", 2000, Sex.MALE, 4, 'h', 0.05, 0, 'E', 2, 2, 'l', 'l', false);
    assertTrue(A.countConsumedVeggie()==100);
  }
  
  @Test
  public void test_countConsumedMeat() {
    System.out.println("Test if return correct consumed meat ...");
    Animal A = new Animal(Species.ELEPHANT, "elephant1", 2000, Sex.MALE, 4, 'h', 0.05, 0, 'E', 2, 2, 'l', 'l', false);
    assertTrue(A.countConsumedMeat()==0);
  }
  
  @Test
  public void test_render() {
    System.out.println("Test if return correct animal id for render ...");
    Animal A = new Animal(Species.ELEPHANT, "elephant1", 2000, Sex.MALE, 4, 'h', 0.05, 0, 'E', 2, 2, 'l', 'l', false);
    assertTrue(A.render()=='E');
  }
  
  @Test
  public void test_isHerbivore() {
    System.out.println("Test if return correct herbivore status  ...");
    Animal A = new Animal(Species.ELEPHANT, "elephant1", 2000, Sex.MALE, 4, 'h', 0.05, 0, 'E', 2, 2, 'l', 'l', false);
    assertTrue(A.isHerbivore()==true);
  }
  
  @Test
  public void test_isCarnivore() {
    System.out.println("Test if return correct carnivore status  ...");
    Animal A = new Animal(Species.ELEPHANT, "elephant1", 2000, Sex.MALE, 4, 'h', 0.05, 0, 'E', 2, 2, 'l', 'l', false);
    assertTrue(A.isCarnivore()==false);
  }
  
  @Test
  public void test_isOmnivore() {
    System.out.println("Test if return correct omnivore status  ...");
    Animal A = new Animal(Species.ELEPHANT, "elephant1", 2000, Sex.MALE, 4, 'h', 0.05, 0, 'E', 2, 2, 'l', 'l', false);
    assertTrue(A.isOmnivore()==false);
  }
  
  /*
  @Test
  public void test_renderWithColor() {
    System.out.println("Test if return correct animal id with color code  ...");
    Animal A = new Animal(Species.ELEPHANT, "elephant1", 2000, Sex.MALE, 4, 'h', 0.05, 0, 'E', 2, 2, 'l', 'l', false);
    assertTrue(A.renderWithColor()==(Color.ANSI_YELLOW+A.render()+Color.ANSI_RESET));
  }*/
  
  

}
