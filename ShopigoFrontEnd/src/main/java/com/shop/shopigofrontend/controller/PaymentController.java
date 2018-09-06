package com.shop.shopigofrontend.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shop.shopigobackend.dao.CartDAO;
import com.shop.shopigobackend.dao.OrdersDAO;
import com.shop.shopigobackend.dao.UserDAO;
import com.shop.shopigobackend.model.Cart;
import com.shop.shopigobackend.model.Orders;
import com.shop.shopigobackend.model.User;



@Controller
public class PaymentController 
{
	@Autowired
	CartDAO cartDAO;
	
	@Autowired
	OrdersDAO ordersDAO;
	
	@Autowired
	UserDAO userDAO;

	
	@RequestMapping(value="confirmOrder")
	public String showConfirmedOrder(HttpSession httpsession, Model m)
	{
		String username = (String) httpsession.getAttribute("username");
		List<Cart> listCartItems = cartDAO.listCartItems(username);
		m.addAttribute("listCartItems", listCartItems);
		m.addAttribute("totalCost", this.calculateTotalCost(listCartItems));
		httpsession.setAttribute("CartItems",listCartItems.size());
		
		return "ConfirmOrder";
	}
	

	
	@RequestMapping(value="paymentConfirmation")
	public String confirmPayment(HttpSession httpsession, Model m)
	{
		String username = (String) httpsession.getAttribute("username");
		User user = userDAO.getUser(username);
		List<Cart> listCartItems = cartDAO.listCartItems(username);
		m.addAttribute("listCartItems", listCartItems);
		m.addAttribute("totalCost", this.calculateTotalCost(listCartItems));
		m.addAttribute("user", user);
		httpsession.setAttribute("CartItems",0);
		
		if(ordersDAO.updateCartItemStatus(username))
		{
			Orders order = new Orders();
			
			order.setPurchaseValue(this.calculateTotalCost(listCartItems));
			order.setPaymentMode("Cash");
			order.setUsername(username);
			order.setOrderDate(new java.util.Date());
			ordersDAO.receiptGenerate(order);
			
			httpsession.setAttribute("orderId", order.getOrderId());
			httpsession.setAttribute("orderdate", order.getOrderDate());
			
		}
		
		return "Receipt";
	}
	
	public int calculateTotalCost(List<Cart> cart)
	{
		int totalcost=0;
		int count=0;
		
		while(count<cart.size())
		{
			totalcost = totalcost+(cart.get(count).getPrice()*cart.get(count).getQuantity());
			count++;
		}
		
		return totalcost;
	}
}
