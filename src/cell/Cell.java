/**
 * @author NIM/Nama : 13515078 / Veren Iliana Kurniadi
 * File : Cell.java
 */

package cell;

import color.Color;

public class Cell {
  private char id;

  /**
   * Constructor.
   */
  public Cell() {
    id = '?';
  }

  /**
   * Consructor dengan parameter.
   * @param idCell karakter id sel.
   */
  public Cell(char idCell) {
    id = idCell;
  }

  /**
   * Mengembalikan karakter id untuk di render.
   * @return karakter current cell.
   */
  public char getId() {
    return id;
  }

  /**
   * Mengembalikan karakter id dari current cell.
   * @return karakter current cell.
   */
  public char render() {
    return getId();
  }

  /**
   * Mengembalikan warna dari hewan.
   * @return warna cetak hewan.
   */
  public String renderWithColor() {
    return Color.ANSI_WHITE + render() + Color.ANSI_RESET;
  }
}
