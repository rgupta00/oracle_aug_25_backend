package com.productapp.proxy;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.productapp.dto.Coupon;

@Component
public class CouponServiceProxyFallback implements CouponServiceProxy {

	@Override
	public Coupon getCouponByCode(String couponCode) {
		return new Coupon("SUP05", 5, LocalDateTime.now());
	}

}
