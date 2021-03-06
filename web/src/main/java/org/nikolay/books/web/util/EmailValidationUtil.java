/**
 * 
 */
package org.nikolay.books.web.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Nikolay Dagil
 * 
 */
public class EmailValidationUtil {

	public boolean isNormalEmail(String email) {
		Pattern pat;
		Matcher mat;
		boolean found;

		pat = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		mat = pat.matcher(email);
		found = mat.matches();
		if (found) {
			found = true;
		} else {
			found = false;
		}

		System.out.println("--------------------> " + found);
		return found;
	}

}