package test;

import static org.junit.Assert.*;

import org.junit.Test;

import cell.*;

public class CellTest {

  @Test
  public void test_getId() {
    System.out.println("Test if return correct cell id  ...");
    Cell c = new Cell('R');
    assertTrue(c.getId()=='R');
  }

  @Test
  public void test_render() {
    System.out.println("Test if return correct cell id  ...");
    Cell c = new Cell('R');
    assertTrue(c.render()=='R');
  }
  
  @Test
  public void test_renderWithColor() {
    System.out.println("Test if return correct cell id  ...");
    Cell c = new Cell('R');
    assertTrue(c.renderWithColor()=="\u001B[37m"+"R"+"\u001B[0m");
  }

}
