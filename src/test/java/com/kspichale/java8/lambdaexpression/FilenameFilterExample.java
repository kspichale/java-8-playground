package com.kspichale.java8.lambdaexpression;

import java.io.File;
import java.io.FilenameFilter;

import org.junit.Test;

public class FilenameFilterExample {

	@Test
	public void testFileNameFilter() {

		File basedir = new File(System.getProperty("user.home"));

		FilenameFilter filter = new FilenameFilter() {
			public boolean accept(File f, String s) {
				return s.toLowerCase().endsWith(".pdf");
			}
		};

		File[] pdfFiles = basedir.listFiles(filter);
		for (File f : pdfFiles)
			System.out.println(f.getName());

	}

	@Test
	public void testLambdaExpression() {

		File basedir = new File(System.getProperty("user.home"));

		FilenameFilter filter = (dir, name) -> name.toLowerCase().endsWith(
				".pdf");

		File[] pdfFiles = basedir.listFiles(filter);
		for (File f : pdfFiles)
			System.out.println(f.getName());
	}

}
