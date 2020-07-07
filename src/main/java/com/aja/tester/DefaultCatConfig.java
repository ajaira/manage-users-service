/**
 * 
 */
package com.aja.tester;


/**
 * @author user
 *
 */
public class DefaultCatConfig {

	static private ICatPrinter printer;

	public static ICatPrinter getConcernedPrinter() {
		if (printer == null) {
			printer = new DefaultCatPrinter();
		}
		return printer;
	}

}
