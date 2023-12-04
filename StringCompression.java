public class StringCompression {

    public static String compressString(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }

        StringBuilder compressed = new StringBuilder();
        int count = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                compressed.append(s.charAt(i - 1)).append(count);
                count = 1;
            }
        }

        compressed.append(s.charAt(s.length() - 1)).append(count);

        // Check if the compressed string is shorter than the original
        return compressed.length() < s.length() ? compressed.toString() : s;
    }

    public static String compressTwice(String s) {
        String firstCompression = compressString(s);
        return compressString(firstCompression);
    }

    public static String decompress(String s) {
        StringBuilder decompressed = new StringBuilder();
        int i = 0;

        while (i < s.length()) {
            char currentChar = s.charAt(i);
            i++;

            StringBuilder countStr = new StringBuilder();

            while (i < s.length() && Character.isDigit(s.charAt(i))) {
                countStr.append(s.charAt(i));
                i++;
            }

            int count = countStr.length() > 0 ? Integer.parseInt(countStr.toString()) : 1;
            for (int j = 0; j < count; j++) {
                decompressed.append(currentChar);
            }
        }

        return decompressed.toString();
    }

    public static void main(String[] args) {
        String originalStr = "aabcccccaaa";
        String firstCompressedStr = compressString(originalStr);
        String secondCompressedStr = compressTwice(originalStr);

        System.out.println("Original: " + originalStr);
        System.out.println("Compressed: " + firstCompressedStr);
        System.out.println("Double Compressed: " + secondCompressedStr);

        // Decompression
        String decompressedStr = decompress(secondCompressedStr);
        System.out.println("Decompressed: " + decompressedStr);
    }
}
