package com.warframe.tmall.sso.service;


import com.warframe.tmall.domain.dto.front.CartProduct;

import java.util.List;

public interface CartService {

    int addCart(long userId, long itemId, int num);

    List<CartProduct> getCartList(long userId);

    int updateCartNum(long userId, long itemId, int num, String checked);

    int deleteCartItem(long userId, long itemId);

    int checkAll(long userId, String checked);

}
