package com.kspichale.java8.lambdaexpression;

import java.io.File;

@FunctionalInterface
public interface MyFilenameFilter {
	/**
     * Tests if a specified file should be included in a file list.
     *
     * @param   dir    the directory in which the file was found.
     * @param   name   the name of the file.
     * @return  <code>true</code> if and only if the name should be
     * included in the file list; <code>false</code> otherwise.
     */
    boolean accept(File dir, String name);
    /**
     * Tests if a specified PDF file should be included in a file list.
     *
     * @param   name   the name of the file.
     * @return 
     * @return  <code>true</code> if and only if the name should be
     * included in the file list; <code>false</code> otherwise.
     */
    default boolean acceptPdf(String name) {
    	return name.toLowerCase().endsWith(".pdf");
    }
}