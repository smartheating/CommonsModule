package de.smartheating.SmartHeatingCommons.services;

import org.springframework.stereotype.Service;

@Service
public class ValueChecker {

	public void checkValueFormat(String value, String valueType) throws IllegalArgumentException {
		switch (valueType) {
		case "int":
			try {
				Integer.valueOf(value);
			} catch (NumberFormatException n) {
				throw new IllegalArgumentException("Value and ValueType don't match");
			}
			break;
		case "float":
			try {
				Float.valueOf(value);
			} catch (NumberFormatException n) {
				throw new IllegalArgumentException("Value and ValueType don't match");
			}
			break;
		case "str":
			break;
		case "bool":
			if(!value.toLowerCase().equals("true") && !value.toLowerCase().equals("false")) {
				throw new IllegalArgumentException("Value and ValueType don't match");
			}
			break;
		}
	}
}
