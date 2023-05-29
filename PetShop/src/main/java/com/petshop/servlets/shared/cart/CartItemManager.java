package com.petshop.servlets.shared.cart;

import java.util.ArrayList;
import java.util.List;
import com.petshop.servlets.shared.*;

public class CartItemManager {
	private final List<CartItem> cartItems;
	
	public CartItemManager() {
		this.cartItems = new ArrayList<>();
	}
	
	public CartItemManager(String cookieValue) {
		this.cartItems = new ArrayList<>();
		String[] temps = cookieValue.split("\\|");
		for (String token : temps) {
			String[] productSplited = token.split(":");
			if (productSplited.length == 2) {
				CartItem cartItem = new CartItem();
				
				cartItem.setProductId(Integer.parseInt(productSplited[0]));
				cartItem.setNum(Integer.parseInt(productSplited[1]));
				
				this.cartItems.add(cartItem);
			}
		}
	}
	
	public List<CartItem> toListCartsItems() {
		return this.cartItems;
	}
	
	public void addProduct(int productId) {
		CartItem cartItem = null;
		
		for (CartItem item : this.cartItems) {
			if (item.getProductId() == productId) {
				cartItem = item;
			}
		}
		
		if (cartItem == null) {
			CartItem newItem = new CartItem();
			
			newItem.setProductId(productId);
			newItem.setNum(1);
			
			this.cartItems.add(newItem);
		} else {
			cartItem.increaseNum();
		}
	}
	
	public void removeProduct(int productId) {
		CartItem cartItem = null;
		
		for (CartItem item : this.cartItems) {
			if (item.getProductId() == productId) {
				cartItem = item;
			}
		}
		
		if (cartItem != null) {
			this.cartItems.remove(cartItem);
		}
	}
	
	public String toCookieValue() {
		String result = "";
		for (CartItem cartItem : this.cartItems) {
			if (result.length() > 0)
				result += "|";
			result += cartItem.getProductId() + ":" + cartItem.getNum();
		}
		return result;
	}
}
