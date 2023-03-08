package com.example;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ProductTest {

	@Nested
	public class nameがnull {
		private Product product;
		@BeforeEach
		public void setup() {
			this.product = new Product();
		}

		@Test
		public void nameがnullかどうか() {
			String actual = product.getName();
			assertThat(actual).isNull();
		}
	}

	@Nested
	public class nameがABC {
		private Product product;
		@BeforeEach
		public void setup() {
			this.product = new Product();
		}

		@Test
		public void nameがABCである() {
			product.setName("ABC");
			 String expected = "ABC";
	         assertThat(product.getName()).isEqualTo(expected);
		}

	}
	


}
