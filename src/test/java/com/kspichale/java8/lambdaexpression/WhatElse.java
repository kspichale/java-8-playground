package com.kspichale.java8.lambdaexpression;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

import org.junit.Test;

import com.kspichale.java8.lambdaexpression.IterableExample.UnmodifiableFileList;

public class WhatElse {

	@Test
	public void testFileNameFilterJava() {

		File basedir = new File(System.getProperty("user.home"));

		String fileEnding = ".pdf";

		FilenameFilter filter = (dir, name) -> name.toLowerCase().endsWith(
				fileEnding);

		File[] pdfFiles = basedir.listFiles(filter);

		UnmodifiableFileList fileList = new UnmodifiableFileList(
				Arrays.asList(pdfFiles));

		for (File file : fileList) {
			System.out.println(file.getName());
		}

		int i = 0;

		fileList.forEach((file) -> System.out.println(i + file.getName()));

		// fileList.forEach((file) -> System.out.println(i++ + file.getName()));
	}
}
