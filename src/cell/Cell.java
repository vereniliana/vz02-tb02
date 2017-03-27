/**
 * @author NIM/Nama : 13515078 / Veren Iliana Kurniadi
 * File : Cell.java
 */

package cell;

import color.*;

public class Cell {
  private char id;

  /**
   * Constructor
   */
  public Cell() {
	  id = '?';
  }
  /**
   * Consructor dengan parameter
   * @param _id karakter id sel
   */
  public Cell(char _id) {
    id =_id;
  }
  /**
   * Mengembalikan karakter id untuk di render
   * @return karakter current cell
   */
  public char GetId() {
  	return id;
  }
  /**
   * Mengembalikan karakter id dari current cell
   * @return karakter current cell
   */
  public char Render() {
    return GetId();
  }
  /**
   * Mengembalikan warna dari hewan
   * @return warna cetak hewan
   */
  public String RenderWithColor() {
    return Color.ANSI_WHITE + Render() + Color.ANSI_RESET;
  }
}
