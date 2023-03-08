package com.example;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class JudgementTest {
	private Judgement judgement;

	@BeforeEach
	public void setup() {
		this.judgement = new Judgement();
	}

	 @Test
	    void 得点が80の場合の結果を取得する() {
	        String expected = "合格";
	        String actual = judgement.judge(80);

	        assertThat(actual).isEqualTo(expected);
	    }

	    @Test
	    void 得点が30の場合の結果を取得する() {
	        String expected = "不合格";
	        String actual = judgement.judge(30);

	        assertThat(actual).isEqualTo(expected);
	    }

	    @Test
	    void 得点が30の時null出ない() {
	    	assertThat( judgement.judge(30) ).isNotNull();
	    }

	    @Test
	    void 特典が101の場合() {
	    	boolean actual = judgement.isValid(101);

	    	assertThat(actual).isFalse();
	    }

	    @Test
	    void 得点が不適の場合の例外(){
	    	assertThatThrownBy(()->{
	    		judgement.judge(-1);
	    	})
	    	.isInstanceOf(IllegalArgumentException.class)
	    	.hasMessage("正常な得点ではありません。");
	    }


		@ParameterizedTest
		@ValueSource(ints = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100})
		void 正常な得点の場合に判定結果がNULLではないことを検証する(int param) {
			String actual = this.judgement.judge(param);
			//System.out.println(actual);
			assertThat(actual).isNotNull();
		}


	   @AfterEach
	   public void tearDown() {
		   this.judgement = null;
	   }
}
