
package com.tikjuti.mathutil.core;

import static com.tikjuti.mathutil.core.MathUtil.*;
// import static là dành riêng cho những hàm stattic 
// gọi hàm mà bỏ qua tên class
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;


public class MathUtilTest {
    
//    Xài theo kiểu DDT (Data Driven Testing)
      public static Object[][] initData() {
        return new Integer[][] {
            {0, 1},
            {1, 1},
            {2, 2},
            {3, 6},
            {4, 24},
            {5, 120},
        };
    }
    @ParameterizedTest
    @MethodSource(value = "initData")
    public void testGetFactorialGivenRightArgReturnWell(int input, long expected) {
        assertEquals(expected, getFactorial(input));
    }
      
    @Test
    public void testGetFactorialGivenRightArgReturnWell() {
        assertEquals(24, getFactorial(4));
    }
    
    //      xài theo kiểu anonymous
    @Test 
    public void testGetFactorialGivenWrongArgumentThrowsException() {
        
        Executable exObject = new Executable() {
            @Override
            public void execute() throws Throwable {
                getFactorial(-5);
            }
        };
        assertThrows(IllegalArgumentException.class, exObject);
    }
    
    //      xài theo biểu thức Lambda
    @Test
    public void testGetFactorialGivenWrongArgumentThrowsExceptionLambda() {
        
        Executable exObject1 = () -> {getFactorial(-5);};
        assertThrows(IllegalArgumentException.class, exObject1);
    }
    
    @Test
    public void testGetFactorialGivenWrongArgumentThrowsExceptionLambda1() {
        
//        Executable exObject1 = () -> {getFactorial(-5);};
        assertThrows(IllegalArgumentException.class, 
                    () -> getFactorial(-5)
                );
    }
}
