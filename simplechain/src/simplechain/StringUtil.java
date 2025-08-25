package simplechain;

import java.security.MessageDigest;

public class StringUtil {
    // applies Sha256 to a string and returns the result
    public static String applySha256(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            // applies sha256 to input
            byte[] hash = digest.digest(input.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer(); // contain hash as hex

            for (int i = 0; i < hash.length; i++) {
                // & with 0xff to get the last 8 bits because Java bytes are signed
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return hexString.toString();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
