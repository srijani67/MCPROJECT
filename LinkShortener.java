import java.util.HashMap;
import java.util.Map;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class LinkShortener {
    private final Map<String, String> shortToLongMap;
    private final Map<String, String> longToShortMap;

    public LinkShortener() {
        this.shortToLongMap = new HashMap<>();
        this.longToShortMap = new HashMap<>();
    }

    // Basic hash function for generating short URLs
    private String generateShortURL(String longURL) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hash = md.digest(longURL.getBytes());
            StringBuilder shortURL = new StringBuilder();
            for (byte b : hash) {
                shortURL.append(String.format("%02x", b));
            }
            return shortURL.toString().substring(0, 8); 
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Shorten a long URL
    public String shortenURL(String longURL) {
        if (!longToShortMap.containsKey(longURL)) {
            String shortURL = generateShortURL(longURL);
            shortToLongMap.put(shortURL, longURL);
            longToShortMap.put(longURL, shortURL);
            return shortURL;
        } else {
            System.out.println("Error: URL already shortened.");
            return longToShortMap.get(longURL);
        }
    }

    // Expand a short URL to its original form
    public String expandURL(String shortURL) {
        if (shortToLongMap.containsKey(shortURL)) {
            return shortToLongMap.get(shortURL);
        } else {
            System.out.println("Error: Invalid short URL.");
            return null;
        }
    }

    public static void main(String[] args) {
        LinkShortener linkShortener = new LinkShortener();

        // Example usage
        String longURL = "https://www.example.com";
        String shortURL = linkShortener.shortenURL(longURL);
        System.out.println("Shortened URL: " + shortURL);

        String expandedURL = linkShortener.expandURL(shortURL);
        System.out.println("Expanded URL: " + expandedURL);

        // Attempting to shorten the same URL again (should print an error)
        String duplicateShortURL = linkShortener.shortenURL(longURL);

        // Attempting to expand an invalid short URL (should print an error)
        String invalidShortURL = linkShortener.expandURL("invalid_short_url");
    }
}

