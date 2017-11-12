package com.lmig.gfc.calculator.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lmig.gfc.calculator.models.Calculator;

@Controller
public class CalculatorController {

	private Calculator regularCalc;
	private Calculator trigCalc;
	private Calculator manualCalc;

	public CalculatorController() {
		regularCalc = new Calculator();
		trigCalc = new Calculator();
		manualCalc = new Calculator();
	}

	@RequestMapping("/")
	public ModelAndView showCalculator(String firstNumber, String secondNumber, String operator, String trigOperator,
			String trigNumber, String expression) {
		ModelAndView mv = new ModelAndView();
		if (firstNumber != null && secondNumber != null) {
			regularCalc.doMath(firstNumber, secondNumber, operator);
			regularCalc.addPreviousAttempt(firstNumber, secondNumber, operator);
		}

		if (trigNumber != null) {
			trigCalc.doTrigMath(trigOperator, trigNumber);
			trigCalc.addPreviousAttempt(trigNumber, trigOperator);
		}

		if (expression != null) {
			manualCalc.evaluateExpression(expression);
			manualCalc.addPreviousAttempt(expression);
		}

		mv.setViewName("calculator");
		mv.addObject("regularCalculator", regularCalc);
		mv.addObject("trigCalculator", trigCalc);
		mv.addObject("manualCalculator", manualCalc);
		return mv;
	}
}
