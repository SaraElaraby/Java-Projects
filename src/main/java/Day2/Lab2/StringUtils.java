package Day2.Lab2;

public class StringUtils {
    
    public String betterString(String s1, String s2 , Boolean x) {
        return (x) ? s1 : s2;
    }
    public static void main(String[] args) {
        
        StringUtils stringUtils = new StringUtils();
        String s1 = "ABCD";
        String s2 = "ABCDEFG";
    
        StringTest longerTest = (string1,string2) -> s1.length() > s2.length();
        StringTest FirstTest = (string1,string2) -> true;

        String longer = stringUtils.betterString(s1, s2, longerTest.test(s1,s2));
        String first = stringUtils.betterString(s1, s2, FirstTest.test(s1,s2));
    
        System.out.println("Better String (longer) is : " + longer);
        System.out.println("Better String (first)  is : " + first);
    }

}