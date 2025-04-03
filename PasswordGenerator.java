import java.security.SecureRandom;

// this class works as the backend and will generate the password
public class PasswordGenerator {
	// character pools
	// these strings will hold the characters/numbers/symbols that we are going to randomly pick to generate our password
	public static final String LOWERCASE_CHARACTERS = "abcdefghijklmnopqrstuvwxyz";
	public static final String UPPERCASE_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static final String NUMBERS = "012345679";
	public static final String SPECIAL_SYMBOLS = "!@#$%^&*()-_=+[]);:,.<>/?";
	
	// randomly choose the characters
    private final SecureRandom secureRandom;
	
	// constructor
	public PasswordGenerator(){
		secureRandom = new SecureRandom();
		}
	
	public String generatePassword(int length, boolean includeUppercase, boolean includeLowercase,
			boolean includeNumbers,boolean includeSpecialSymbols){
				StringBuilder passwordBuilder = new StringBuilder();
	
	// toggle states
	String validCharacters = "";
	if(includeUppercase) validCharacters += UPPERCASE_CHARACTERS;
	if(includeLowercase) validCharacters += LOWERCASE_CHARACTERS;
	if(includeNumbers) validCharacters += NUMBERS;
	if(includeSpecialSymbols) validCharacters += SPECIAL_SYMBOLS;

	// build password
	for(int i = 0; i < length; i++){
		
		// generate a random index
		int secureRandomIndex = secureRandom.nextInt(validCharacters.length());
	
		// get the char based on the random index
		char randomChar = validCharacters.charAt(secureRandomIndex);
	
		// store char into password builder
		passwordBuilder.append(randomChar);
		}
	
		return passwordBuilder.toString();
		}
}