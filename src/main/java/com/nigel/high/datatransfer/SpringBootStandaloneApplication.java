package com.nigel.high.datatransfer;

import java.util.HashMap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author a152119
 *
 */
@SpringBootApplication
public class SpringBootStandaloneApplication implements CommandLineRunner {
	
	
	/**
	 * @Method: main
	 * args[0] = path to source file eg. "/home/a152119/share/"
	 * args[1] = source file name eg. "SOURCE.xls"
	 * args[2] = path to target file eg. "/home/a152119/share/"
	 * args[3] = target file name eg. "Target.xls"
	 * args[4] = column to update in target file eg. "Term 3  2019"
	 *
	 */
	public static void main(String[] args) {
		SpringApplication.run(SpringBootStandaloneApplication.class, args);
		ExcelReaderOldFormat excelReaderOldFormat = new ExcelReaderOldFormat();
		HashMap<String, ReaderPOJO> dataFromSpreadsheet = excelReaderOldFormat.readerExcelSheet(args[0], args[1]);
		ExcelUpdaterOldFormat excelUpdaterOldFormat =  new ExcelUpdaterOldFormat();
		excelUpdaterOldFormat.updateExcelSheet(dataFromSpreadsheet, args[4], args[2], args[3]);
	}

	@Bean
	public HelloService getHelloService(){
		return  new DefaultHelloService();
	}
	
	@Override
	public void run(String... args) throws Exception {
		getHelloService().hello();
	}

}
