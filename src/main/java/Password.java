public class Password {
    private static  String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static  String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public Password(String password) {
        int uppercase = 0, lowercase = 0, number = 0;

        for (int i = 0; i < password.length(); i++) {
            for (char c = 'A'; c <= 'Z'; c++) {
                if (password.charAt(i) == c) {
                    uppercase++;

                    if (uppercase >= 1) {

                        for (char t = 'a'; t <= 'z'; t++) {
                            if (password.charAt(i) == t) {
                                lowercase++;
                                if (lowercase >= 1) {

                                }
                            }
                        }
                    }
                }
            }
        }
    }
    private static boolean oneUpper(String str) {
        for (char ch : str.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                return true;
            }
        }
        return false;
    }
    private static boolean tenCharacters(String str) {
        return str.length() > 9;
    }

    @Override
    public String toString(){
        return toString();
    }


}
