package com.itwill.sns.naver;

import java.math.BigInteger;

public class ProductBuilderMain {

	public static void main(String[] args) {
		Product product1 = Product.builder().no(1).name("COMPUTER").price(BigInteger.valueOf(103913013)).build();

	}

}
