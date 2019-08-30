package com.nigel.high.datatransfer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	private static final String FILE_NAME = "/home/a152119/share/SOURCE.xls";

	public void readerExcelSheet() {

		try {

			FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
			Workbook workbook = new XSSFWorkbook(excelFile);
			Sheet datatypeSheet = workbook.getSheetAt(0);
			Iterator<Row> iterator = datatypeSheet.iterator();

			boolean startToRead = false;
			ReaderPOJO readerPOJO = new ReaderPOJO();
			while (iterator.hasNext()) {

				Row currentRow = iterator.next();
				if (currentRow.getCell(3).getStringCellValue().trim()
						.equalsIgnoreCase("Surnames and Names of Learners in Alphabetical Order")) {
					startToRead = true;
					continue;
				}

				if (startToRead) {
					// Iterator<Cell> cellIterator = currentRow.iterator();
					Cell c = currentRow.getCell(2, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
					if (c == null) {
						// The cell is empty
					} else {
						List<String> items = Arrays.asList(c.getStringCellValue().split("\\s*,\\s*"));
						readerPOJO.setSurname(items.get(0));
						List<String> names = Arrays.asList(items.get(1).split("\\s* \\s*"));
						readerPOJO.setName(names.get(0));
						if (names.size() > 1) {
							readerPOJO.setSecondName(names.get(1));
						} else {
							readerPOJO.setSecondName("");
						}
					}

					c = currentRow.getCell(10, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
					if (c == null) {
						// The cell is empty
					} else {
						readerPOJO.setFirstLanguage(c.getStringCellValue());
					}
					/*
					 * while (cellIterator.hasNext()) {
					 * 
					 * Cell currentCell = cellIterator.next();
					 * 
					 * //getCellTypeEnum shown as deprecated for version 3.15 //getCellTypeEnum ill
					 * be renamed to getCellType starting from version 4.0 if
					 * (currentCell.getCellType() == CellType.STRING) {
					 * System.out.print(currentCell.getStringCellValue() + "--"); } else if
					 * (currentCell.getCellType() == CellType.NUMERIC) {
					 * System.out.print(currentCell.getNumericCellValue() + "--"); }
					 * 
					 * }
					 */
				}
				System.out.println();
				// Closing the workbook
				workbook.close();

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
