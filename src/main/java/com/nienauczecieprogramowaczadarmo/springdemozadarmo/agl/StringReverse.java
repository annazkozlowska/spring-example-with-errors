package com.nienauczecieprogramowaczadarmo.springdemozadarmo.agl;

public class StringReverse {

    public static String reverse(String toReverse, String forbiddenChars){

        int indexStart = 0;
        int indexEnd = toReverse.length() -1;
        StringBuilder builder = new StringBuilder(toReverse);

        char tmp;

        while (indexStart < indexEnd) {

            char startChar = builder.charAt(indexStart);
            if (forbiddenChars.indexOf(startChar) > -1) {
                indexStart++;
            } else if (forbiddenChars.indexOf(builder.charAt(indexEnd)) > -1 ){
                indexEnd--;
            } else {

                tmp = builder.charAt(indexStart);
                builder.setCharAt(indexStart, builder.charAt(indexEnd));
                builder.setCharAt(indexEnd, tmp);

                indexStart++;
                indexEnd--;
            }
        }

        return builder.toString();
    }

}

// Stringa nie mozna zmodyfikowac, StringBuildera mozna