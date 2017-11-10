package com.lmig.gfc.calculator.models;

import java.util.ArrayList;

public class Calculator {

	private ArrayList<String> previousAttempts;
	private double result;

	public Calculator() {
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
			result = Math.pow(reformattedSecondNumber, 1 / reformattedFirstNumber);
		}

		if (operator.equals("log")) {
			// reformattedFirstNumber is the base
			// reformattedSecondNumber is the argument
			result = Math.log(reformattedSecondNumber) / Math.log(reformattedFirstNumber);
		}

	}

	public void doTrigMath(String trigOperator, String trigNumber) {
		double reformattedTrigNumber = Double.parseDouble(trigNumber);

		if (trigOperator.equals("sin")) {
			result = Math.sin(reformattedTrigNumber);
		}

		if (trigOperator.equals("cos")) {
			result = Math.cos(reformattedTrigNumber);
		}

		if (trigOperator.equals("tan")) {
			result = Math.tan(reformattedTrigNumber);
		}

		if (trigOperator.equals("sinh")) {
			result = Math.sinh(reformattedTrigNumber);
		}

		if (trigOperator.equals("cosh")) {
			result = Math.cosh(reformattedTrigNumber);
		}

		if (trigOperator.equals("cosh")) {
			result = Math.tanh(reformattedTrigNumber);
		}
	}

	public void addPreviousAttempt(String firstNumber, String secondNumber, String operator) {
		String resultString = String.valueOf(result);
		String fullStringToBeAdded = firstNumber + " " + operator + " " + secondNumber + " = " + resultString;
		previousAttempts.add(0, fullStringToBeAdded);
	}

	public void addPreviousAttempt(String trigNumber, String trigOperator) {
		String resultString = String.valueOf(result);
		String fullStringToBeAdded = trigOperator + " " + trigNumber + " = " + resultString;
		previousAttempts.add(0, fullStringToBeAdded);
	}

	public void evaluateExpression(String expression) {
		ArrayList<Integer> numbersArray = new ArrayList<Integer>();
		for (int i = 0; i <= expression.length(); i++) {
			 char c = expression.charAt(i);
			 if (Character.isDigit(c)) {
				 numbersArray.add(0, (int)c);
			 } 
		}
		result = 4;
	}

	public ArrayList<String> getPreviousAttempts() {
		return previousAttempts;
	}

	public double getResult() {
		return result;
	}

}
