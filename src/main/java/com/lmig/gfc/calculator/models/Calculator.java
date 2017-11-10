package com.lmig.gfc.calculator.models;

import java.util.ArrayList;

public class Calculator {
	
	private ArrayList<String> previousAttempts;
	
	public Calculator () {
		previousAttempts = new ArrayList<String>();
	}

	public double doMath(String firstNumber, String secondNumber, String operator) {
		double result = 0;
		double reformattedFirstNumber = Double.parseDouble(firstNumber);
		double reformattedSecondNumber = Double.parseDouble(secondNumber);
		

		if (operator.equals("+")) {
			result = reformattedFirstNumber + reformattedSecondNumber;
		}

		if (operator.equals("-")) {
			result = reformattedFirstNumber - reformattedSecondNumber;
		}

		if (operator.equals("*")) {
			result = reformattedFirstNumber * reformattedSecondNumber;
		}

		if (operator.equals("/")) {
			result = reformattedFirstNumber / reformattedSecondNumber;
		}

		if (operator.equals("^")) {
			result = java.lang.Math.pow(reformattedFirstNumber, reformattedSecondNumber);
		}

		return result;
	}
	
	public void addPreviousAttempt(String firstNumber, String secondNumber, String operator, double calcResult) {
		String resultString = String.valueOf(calcResult);
		String fullStringToBeAdded = firstNumber + " " + operator + " " + secondNumber + " = " + resultString;
		previousAttempts.add(0, fullStringToBeAdded);
	}

	public ArrayList<String> getPreviousAttempts() {
		return previousAttempts;
	}
	
}
