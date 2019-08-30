package com.nigel.high.datatransfer;

import static org.junit.Assert.*;

import org.junit.Test;

public class ExcelReaderOldFormatTest {

	@Test
	public void testReaderExcelSheet() {
		ExcelReaderOldFormat excelReader = new ExcelReaderOldFormat();
		excelReader.readerExcelSheet("/home/a152119/share/", "SOURCE.xls");
	}

}
