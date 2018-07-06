package com.dd.DenZieNium.html;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;

/**
 * Generates Table object and methods for its functioning
 * 
 */
public class Table extends AbstractElement {
	
	/**
	 * Table Construction method<br>
	 * <b>Usage:</b> <br>
	 * {@code Table tblTransactionTable = new Table( "//TABLE[@id='transactionTable']"}
	 * 
	 * @param locator
	 *            the element locator
	 * 
	 */
	public Table(By locator) {
		super(locator);
	}
	public Table(By locator, String controlName) {
		super(locator, controlName);
	}
	/**
	 * Returns the number of rows in a table.
	 * 
	 * @return int number of rows
	 */
	public int getNumberOfRows() {
		return getElement().findElements(By.tagName("tr")).size();
	}

	/**
	 * Returns the number of columns in a table.
	 * 
	 * @return int number of columns
	 */
	public int getNumberOfColumns() {
		return getElement().findElement(By.tagName("tr")).findElements(By.id("td")).size();
	}

	/**
	 * Finds value of a cell in a table indicated by row and column indices.
	 * 
	 * @param row
	 *            int number of row for cell
	 * @param column
	 *            int number of column for cell
	 * @return String value of cell with row and column
	 */
	public String getCellValue(int row, int column) {
		List<WebElement> elements =getElement().findElements(By.tagName("tr"));
		List<WebElement> cells = elements.get(row).findElements(By.xpath("td"));
		if (cells.size() > 0)
			return cells.get(column).getText();

		return null;
	}

	/**
	 * Goes to the cell addressed by row and column indices and clicks link in
	 * that cell. Performs wait until page would be loaded
	 * 
	 * @param row
	 *            int number of row for cell
	 * @param column
	 *            int number of column for cell
	 */
	public void clickLinkInCell(int row, int column) {
		getElement().findElement(By.xpath("tr[" + row + "]/td[" + column + "]/a")).click();
	}

}
