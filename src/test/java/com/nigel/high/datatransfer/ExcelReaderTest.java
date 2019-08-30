package com.nigel.high.datatransfer;

import static org.junit.Assert.*;

import org.junit.Test;

public class ExcelReaderTest {

	@Test
	public void testReaderExcelSheet() {
		ExcelReader excelReader = new ExcelReader();
		excelReader.readerExcelSheet();
	}

}
