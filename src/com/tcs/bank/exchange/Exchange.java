package com.tcs.bank.exchange;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Exchange extends HttpServlet{
	private double showConvertedAmount;
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	resp.setContentType("text/html");
	PrintWriter out=resp.getWriter();
	String amount=req.getParameter("amount").toString();
	String currencyFrom=req.getParameter("curremcyFrom").toString();
	String currencyTo=req.getParameter("currencyTo").toString();
	double exchangeAmount=Double.parseDouble(amount);
	System.out.println(exchangeAmount);
	System.out.println(currencyFrom);
	System.out.println(currencyTo);
	//Rupees to any other currency
	if(currencyFrom.equals("Indian Rupee(RS)")){
		if(currencyTo.equals("Indian Rupee(RS)")){
			this.showConvertedAmount=exchangeAmount;
		}else if (currencyTo.equals("US Dollar (USD)")) {
			this.showConvertedAmount=0.016 *exchangeAmount;
		}else if (currencyTo.equals("British Pound Sterling (GBP)")) {
			this.showConvertedAmount=0.012 *exchangeAmount;
		}else if (currencyTo.equals("Euro (EUR)")) {
			this.showConvertedAmount=0.015 *exchangeAmount;
		}else if (currencyTo.equals("Australian Dollar (AUD)")) {
			this.showConvertedAmount=0.020 *exchangeAmount;
		}
		
	}
	
	//US Dollar to any other currency
		if(currencyFrom.equals("US Dollar (USD)")){
			if(currencyTo.equals("US Dollar (USD)")){
				this.showConvertedAmount=exchangeAmount;
			}else if (currencyTo.equals("Indian Rupee(RS)")) {
				this.showConvertedAmount=64.47  *exchangeAmount;
			}else if (currencyTo.equals("British Pound Sterling (GBP)")) {
				this.showConvertedAmount=0.80  *exchangeAmount;
			}else if (currencyTo.equals("Euro (EUR)")) {
				this.showConvertedAmount=0.94 *exchangeAmount;
			}else if (currencyTo.equals("Australian Dollar (AUD)")) {
				this.showConvertedAmount=1.32 *exchangeAmount;
			}
			
		}
	
		//British Pound Sterling (GBP) to any other currency
				if(currencyFrom.equals("British Pound Sterling (GBP)")){
					if(currencyTo.equals("British Pound Sterling (GBP)")){
						this.showConvertedAmount=exchangeAmount;
					}else if (currencyTo.equals("Indian Rupee(RS)")) {
						this.showConvertedAmount=80.73  *exchangeAmount;
					}else if (currencyTo.equals("US Dollar (USD)")) {
						this.showConvertedAmount=1.25  *exchangeAmount;
					}else if (currencyTo.equals("Euro (EUR)")) {
						this.showConvertedAmount=1.18 *exchangeAmount;
					}else if (currencyTo.equals("Australian Dollar (AUD)")) {
						this.showConvertedAmount=1.65 *exchangeAmount;
					}
					
				}
			
				//Euro (EUR) to any other currency
				if(currencyFrom.equals("Euro (EUR)")){
					if(currencyTo.equals("Euro (EUR)")){
						this.showConvertedAmount=exchangeAmount;
					}else if (currencyTo.equals("Indian Rupee(RS)")) {
						this.showConvertedAmount=68.42  *exchangeAmount;
					}else if (currencyTo.equals("US Dollar (USD)")) {
						this.showConvertedAmount=1.06  *exchangeAmount;
					}else if (currencyTo.equals("British Pound Sterling (GBP)")) {
						this.showConvertedAmount=0.85 *exchangeAmount;
					}else if (currencyTo.equals("Australian Dollar (AUD)")) {
						this.showConvertedAmount=1.40 *exchangeAmount;
					}
					
				}
				
				//Australian Dollar (AUD) to any other currency
				if(currencyFrom.equals("Australian Dollar (AUD)")){
					if(currencyTo.equals("Australian Dollar (AUD)")){
						this.showConvertedAmount=exchangeAmount;
					}else if (currencyTo.equals("Indian Rupee(RS)")) {
						this.showConvertedAmount=68.42  *exchangeAmount;
					}else if (currencyTo.equals("US Dollar (USD)")) {
						this.showConvertedAmount=1.06  *exchangeAmount;
					}else if (currencyTo.equals("British Pound Sterling (GBP)")) {
						this.showConvertedAmount=0.85 *exchangeAmount;
					}else if (currencyTo.equals("Euro (EUR)")) {
						this.showConvertedAmount=1.40 *exchangeAmount;
					}
					
				}
				System.out.println(showConvertedAmount);
				RequestDispatcher rdDispatcher=req.getRequestDispatcher("ExchangeRate.jsp");
				rdDispatcher.include(req, resp);
				 out.println("<script type=\"text/javascript\">");
			       out.println("result('"+showConvertedAmount+"');");
			       out.println("</script>");
				
}
}
