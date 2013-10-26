package com.kspichale.java8.lambdaexpression;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

public class IterableExample {

	public static class UnmodifiableFileList implements Iterable<File> {

		private List<File> files;

		public UnmodifiableFileList(List<File> files) {
			this.files = Collections.unmodifiableList(files);
		}

		@Override
		public Iterator<File> iterator() {
			return files.iterator();
		}
	}

	@Test
	public void testFileNameFilterJava() {

		File basedir = new File(System.getProperty("user.home"));

		FilenameFilter filter = (dir, name) -> name.toLowerCase().endsWith(
				".pdf");

		File[] pdfFiles = basedir.listFiles(filter);

		UnmodifiableFileList fileList = new UnmodifiableFileList(
				Arrays.asList(pdfFiles));

		for (File file : fileList) {
			System.out.println(file.getName());
		}

		fileList.forEach((file) -> System.out.println(file.getName()));
	}
}
