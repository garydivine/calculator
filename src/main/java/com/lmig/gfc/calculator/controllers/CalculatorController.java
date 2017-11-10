package com.lmig.gfc.calculator.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lmig.gfc.calculator.models.Calculator;

@Controller
public class CalculatorController {

	private Calculator calc;
	private Calculator calc2;

	public CalculatorController() {
		calc = new Calculator();
		calc2 = new Calculator();
	}

	@RequestMapping("/")
	public ModelAndView showCalculator(String firstNumber, String secondNumber, String operator, String expression) {
		ModelAndView mv = new ModelAndView();
		if (firstNumber != null && secondNumber != null) {
			calc.doMath(firstNumber, secondNumber, operator);
			calc.addPreviousAttempt(firstNumber, secondNumber, operator);
		}
		
		if (expression != null) {
			calc2.evaluateExpression(expression);
		}

		mv.setViewName("calculator");
		mv.addObject("result", calc.getResult() );
		mv.addObject("previousAttempts", calc.getPreviousAttempts());
		mv.addObject("resultOfExpression", calc2.getResult());
		return mv;
	}
}
