package com.shop.shopigobackend.dao;

import java.util.List;

import com.shop.shopigobackend.model.Cart;

public interface CartDAO 
{
	public boolean addToCart(Cart cart);
	public boolean deleteFromCart(Cart cart);
	public boolean updateCart(Cart cart);
	public Cart getCartItem(int cartId);
	public List<Cart> listCartItems(String username);
	
}