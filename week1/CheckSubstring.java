public class CheckSubstring {
    public static void main(String[] args) {
        String str1 = "Hello World";
        String str2 = "World";
        
        if(str1.contains(str2)) {
            System.out.println(str2 + " is a substring of " + str1);
        } else {
            System.out.println(str2 + " is not a substring of " + str1);
        }
    }
}
