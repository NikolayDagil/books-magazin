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
public class PasswordValidationUtil {
	public boolean isNormalPassword(String password) {
		Pattern pat;
		Matcher mat;
		boolean found;

		pat = Pattern
				.compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})");
		mat = pat.matcher(password);
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