package com.zp.lr.test;

public class DigitUtil {

    final static char[] digits = {
            '0' , '1' , '2' , '3' , '4' , '5' ,
            '6' , '7' , '8' , '9' , 'a' , 'b' ,
            'c' , 'd' , 'e' , 'f' , 'g' , 'h' ,
            'i' , 'j' , 'k' , 'l' , 'm' , 'n' ,
            'o' , 'p' , 'q' , 'r' , 's' , 't' ,
            'u' , 'v' , 'w' , 'x' , 'y' , 'z' ,
            'A' , 'B' , 'C' , 'D' , 'E' , 'F' ,
            'G' , 'H' , 'I' , 'J' , 'K' , 'L' ,
            'M' , 'N' , 'O' , 'P' , 'Q' , 'R' ,
            'S' , 'T' , 'U' , 'V' , 'W' , 'X' ,
            'Y' , 'Z' , '@' , '#'
    };
    public void test()throws Exception{
        for(int i=0;i<100;i++){

        }




    }
    public static String pr(int i,int shift){
        return toUnsignedString(i, shift);
    }
    private static String toUnsignedString(int i, int shift) {
        char[] buf = new char[32];
        int charPos = 32;
        int radix = 1 << shift;
        int mask = radix - 1;
        do {
            buf[--charPos] = digits[i & mask];
            i >>>= shift;
        } while (i != 0);


        return new String(buf, charPos, (32 - charPos));
//			return new String(buf, 28, 4);
    }
}
