package com.demo;

import org.springframework.stereotype.Component;


@Component(value = "m")
 public class Magician {
	public void doMagic() {
		System.out.println("abra ka dabra");
//		if(1==1)
//			throw new MagicianFall("chakkar aa gaya call the dr now");
	}
}
