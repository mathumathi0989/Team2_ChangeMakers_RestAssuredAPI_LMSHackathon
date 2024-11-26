package generics;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

import apiConfig.EnvConstants;

public class DataBuilder {
	private static final String NUMBERS = "0123456789";
	private static final String SPECIAL_CHARS = "!@#$%^&*()-_=+[]{}|;:'\",.<>?/`~";
	private static final String MIXED_CHARS = NUMBERS + SPECIAL_CHARS;
	private static final SecureRandom random = new SecureRandom();

	private static final Map<String, String> characterSets = new HashMap<>();

	static {
		characterSets.put("numbers", NUMBERS);
		characterSets.put("special", SPECIAL_CHARS);
		characterSets.put("mixed", MIXED_CHARS);
		characterSets.put("numbers_with_space", NUMBERS + " "); // Include space
	}

	public String buildString(String type, int length) {
		String characters = characterSets.get(type.toLowerCase());

		if (characters == null) {
			throw new IllegalArgumentException(
					"Invalid type specified. Use 'numbers', 'special', 'mixed', or 'numbers_with_space'.");
		}

		StringBuilder result = new StringBuilder(length);
		for (int i = 0; i < length; i++) {
			int index = random.nextInt(characters.length());
			result.append(characters.charAt(index));
		}

		return result.toString();
	}
	
/*================Method to generate programName at runTime ====Starts Here========> */
	
	public String currentStringFilePath = EnvConstants.file_Path_currentString;
	public String namePrefix = "TeamChangeMakers-APIPhaseTwo-";
	private String currentString; // = "aaaaa"; // Starting string

	public DataBuilder() {
		// Load the last generated string from a file
		this.currentString = loadCurrentString(currentStringFilePath);
		if (this.currentString == null) {
			this.currentString = "aaaaaaa"; // Default starting string
		}
	}

	private String loadCurrentString(String filename) {
		try {
			Path path = Paths.get(filename);
			if (Files.exists(path)) {
				return new String(Files.readAllBytes(path)).trim();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private void saveCurrentString(String filename, String str) {
		try (FileWriter writer = new FileWriter(filename)) {
			writer.write(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getProgramName() {
		StringBuilder newStr = new StringBuilder(namePrefix);
		currentString = incrementString(currentString);
		saveCurrentString(currentStringFilePath, currentString); // Save the updated string
		newStr.append(currentString);
		return newStr.toString().trim();
	}

	private String incrementString(String str) {
		char[] chars = str.toCharArray();
		int index = chars.length - 1;

		while (index >= 0) {
			if (chars[index] == 'z') {
				chars[index] = 'a'; // Reset to 'a' and carry over
				index--;
			} else {
				chars[index]++;
				break;
			}
		}

		// If we have carried over past the first character, we need to handle that
		if (index < 0) {
			// This means we have overflowed, so we can prepend 'a' (or handle as needed)
			return "a" + new String(chars);
		}

		return new String(chars);
	}
	/*================Method to generate programName at runTime ====Ends Here========> */
}
