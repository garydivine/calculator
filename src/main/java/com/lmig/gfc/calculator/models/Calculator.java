package com.lmig.gfc.calculator.models;

import java.util.ArrayList;

public class Calculator {
	
	private ArrayList<String> previousAttempts;
	private double result;
	
	public Calculator () {
		previousAttempts = new ArrayList<String>();
	}

	public void doMath(String firstNumber, String secondNumber, String operator) {
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
			result = Math.pow(reformattedFirstNumber, reformattedSecondNumber);
		}
		
		if (operator.equals("√")) {
			result = Math.pow(reformattedSecondNumber, 1/reformattedFirstNumber);
		}
		
		if (operator.equals("log")) {
			// reformattedFirstNumber is the base
			// reformattedSecondNumber is the argument
			result = Math.log(reformattedSecondNumber) / Math.log(reformattedFirstNumber);
		}
		
		if (operator.equals("sin")) {
			result = Math.sin(reformattedSecondNumber);
		}
		
		if (operator.equals("cos")) {
			result = Math.cos(reformattedSecondNumber);
			}
		
		if (operator.equals("tan")) {
			result = Math.tan(reformattedSecondNumber);
		}
		
		if (operator.equals("sinh")) {
			result = Math.sinh(reformattedSecondNumber);
		}
		
		if (operator.equals("cosh")) {
			result = Math.cosh(reformattedSecondNumber);
		}
		
		if (operator.equals("cosh")) {
			result = Math.tanh(reformattedSecondNumber);
		}

	}
	
	public void addPreviousAttempt(String firstNumber, String secondNumber, String operator) {
		String resultString = String.valueOf(result);
		String fullStringToBeAdded = firstNumber + " " + operator + " " + secondNumber + " = " + resultString;
		previousAttempts.add(0, fullStringToBeAdded);
	}
	
	public void evaluateExpression(String expression) {
		result = 4;
	}

	public ArrayList<String> getPreviousAttempts() {
		return previousAttempts;
	}

	public double getResult() {
		return result;
	}
	
}
