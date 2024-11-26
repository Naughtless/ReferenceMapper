package test;

public class Test {
    public static void main(String[] args) {
        String test = "A|B|C|D|E";
        String[] testArray = test.split("\\|");

        String testBlank = "A|B|C|D|";
        String[] testBlankArray = test.split("\\|");

        System.out.println(testArray.length);
        System.out.println(testBlankArray.length);
    }



}
