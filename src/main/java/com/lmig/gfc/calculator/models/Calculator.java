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
			result = Math.sin(Math.toRadians(reformattedTrigNumber));
		}

		if (trigOperator.equals("cos")) {
			result = Math.cos(Math.toRadians(reformattedTrigNumber));
		}

		if (trigOperator.equals("tan")) {
			result = Math.tan(Math.toRadians(reformattedTrigNumber));
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
	
	public void addPreviousAttempt(String expression) {
		String resultString = String.valueOf(result);
		String fullStringToBeAdded = expression + " = " + resultString;
		previousAttempts.add(0, fullStringToBeAdded);
	}

	public void evaluateExpression(String expression) {
		ArrayList<Integer> numbersArray = new ArrayList<Integer>();
		ArrayList<String> operatorArray = new ArrayList<String>();

		// pull out all the numbers and operators and add them into arraylists in the
		// order they are entered
		for (int i = 0; i < expression.length(); i++) {
			char c = expression.charAt(i);
			if (c >= '0' && c <= '9') {
				numbersArray.add(0, Character.getNumericValue(c));
			}
			if (c == '*' || c == '/' || c == '+' || c == '-') {
				operatorArray.add(Character.toString(c));
			}
		}

		// multiplication loop
		for (int i = 0; i < operatorArray.size(); i++) {
			if (operatorArray.get(i).equals("*")) {
				int interimResult = (numbersArray.get(i)) * (numbersArray.get(i + 1));
				numbersArray.remove(i);
				numbersArray.remove(i);
				numbersArray.add(interimResult);
			}
		}

		// division loop
		for (int i = 0; i < operatorArray.size(); i++) {
			if (operatorArray.get(i).equals("/")) {
				int interimResult = (numbersArray.get(i)) / (numbersArray.get(i + 1));
				numbersArray.remove(i);
				numbersArray.remove(i);
				numbersArray.add(interimResult);
			}
		}

		// addition loop
		for (int i = 0; i < operatorArray.size(); i++) {
			if (operatorArray.get(i).equals("+")) {
				int interimResult = (numbersArray.get(i)) + (numbersArray.get(i + 1));
				numbersArray.remove(i);
				numbersArray.remove(i);
				numbersArray.add(interimResult);
			}
		}

		// subtraction loop
		for (int i = 0; i < operatorArray.size(); i++) {
			if (operatorArray.get(i).equals("-")) {
				int interimResult = (numbersArray.get(i)) - (numbersArray.get(i + 1));
				numbersArray.remove(i);
				numbersArray.remove(i);
				numbersArray.add(interimResult);
			}
		}

		result = numbersArray.get(0);
	}

	public ArrayList<String> getPreviousAttempts() {
		return previousAttempts;
	}

	public double getResult() {
		return result;
	}

}



