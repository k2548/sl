package com.example;


import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class CalculatorTest {
	private Calculator sut;
	@BeforeEach
	public void setup() {
		this.sut = new Calculator();
	}

    @Test
    void multiplyで3と4の乗算結果を取得する() {
        int expected = 12;
        int actual = sut.multiply(3, 4);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void devideで3と2の除算結果を取得する() {
        double expected = 1.5;
        double actual = sut.devide(3, 2);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void calcTriangleAreaで底辺が3で高さが5の三角形の面積を取得する() {
        double expected = 7.5;
        double actual = sut.calcTriangleArea(3, 5);
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, -3, -9, Integer.MAX_VALUE})
    public void 複数のパラメータが奇数であるかを検証する(int param){
        boolean actual = sut.isOdd(param);
        boolean expected = true;
        assertThat(actual).isEqualTo(expected);
    }


    @ParameterizedTest
    @CsvSource({
    	"6,3,2.0",
    	"5,3,1.6666666666666667",
    	"0,5,0.0"})
    public void 一度に複数のパラメータを扱う(int x, int y, double expected ) {
    	double actual = sut.devide(x, y);
    	assertThat(actual).isEqualTo(expected);
    }
}