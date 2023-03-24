package com.itwill.sns.naver;

import java.math.BigInteger;

@lombok.Builder
@lombok.Data
@lombok.Getter
public class Product {
	int no;
	String name;
	BigInteger price;
}
