package com.nigel.high.datatransfer;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ExcelUpdaterOldFormatTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testUpdateExcelSheet() {
		ExcelReaderOldFormat excelReaderOldFormat = new ExcelReaderOldFormat();
		HashMap<String, ReaderPOJO> dataFromSpreadsheet = excelReaderOldFormat.readerExcelSheet();
		ExcelUpdaterOldFormat excelUpdaterOldFormat = new ExcelUpdaterOldFormat();
		excelUpdaterOldFormat.updateExcelSheet(dataFromSpreadsheet, "Term 3  2019");
	}

}
