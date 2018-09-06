package com.shop.shopigobackend.dao;

import com.shop.shopigobackend.model.Orders;

public interface OrdersDAO
{
	public boolean receiptGenerate(Orders order);
	public boolean updateCartItemStatus(String username);
}
