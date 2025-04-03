import java.awt.Color;
import java.awt.Font;

import javax.swing .*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PasswordGeneratorGUI extends JFrame {
	private PasswordGenerator passwordGenerator;
	
	public PasswordGeneratorGUI(){
		
		super ("Password Generator");
		
		setSize(540,570);
		
		setResizable(false);
		
		setLayout(null);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setLocationRelativeTo(null) ;
		
		passwordGenerator = new PasswordGenerator();
		
		addGuiComponents();
		
		}

	private void addGuiComponents(){
		JLabel titleLabel = new JLabel("Password Generator");
	
		titleLabel.setFont(new Font("Dialog",Font.BOLD,32));
	
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
	
		titleLabel.setBounds(0,10,540,39);
	
		add(titleLabel);
		
		final JTextArea passwordOutput = new JTextArea();

		passwordOutput.setEditable(false);
		passwordOutput.setFont(new Font("Dialog", Font.BOLD,32));

		JScrollPane passwordOutputPane = new JScrollPane(passwordOutput);
		passwordOutputPane.setBounds(25,97,479,70);

		passwordOutputPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		add(passwordOutputPane);
		
		// password length label
		JLabel passwordLengthLabel = new JLabel("Password Length: ");
		passwordLengthLabel.setFont(new Font("Dialog", Font.PLAIN,32));
		passwordLengthLabel.setBounds(25,215,272,39);
		add(passwordLengthLabel);
		
		// password length input
		final JTextArea passwordLengthInputArea = new JTextArea();
		passwordLengthInputArea.setFont(new Font("Dialog", Font.PLAIN,32));
		passwordLengthInputArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		passwordLengthInputArea.setBounds(310,215,192,39);
		add(passwordLengthInputArea);

		// toggle buttons
		// uppercase letter toggle
		final JToggleButton uppercaseToggle = new JToggleButton("Uppercase");
		uppercaseToggle.setFont(new Font("Dialog", Font.PLAIN,32));
		uppercaseToggle.setBounds(25,302,225,56);
		add(uppercaseToggle);

		// Lowercase letter toggle
		final JToggleButton lowercaseToggle = new JToggleButton("Lowercase");
		lowercaseToggle.setFont(new Font("Dialog", Font.PLAIN,32));
		lowercaseToggle.setBounds(282,302,225,56);
		add(lowercaseToggle);

		// numbers toggle
		final JToggleButton numbersToggle = new JToggleButton("Numbers");
		numbersToggle.setFont(new Font("Dialog", Font.PLAIN,32));
		numbersToggle.setBounds(25,373,225,56);
		add(numbersToggle);

		// symbols toggle
		final JToggleButton symbolsToggle = new JToggleButton("Symbols");
		symbolsToggle.setFont(new Font("Dialog", Font.PLAIN,32));
		symbolsToggle.setBounds(282,373,225,56);
		add(symbolsToggle);
		
		// generate button
		final JButton generateButton = new JButton("Generate");
		generateButton.setFont(new Font("Dialog", Font.PLAIN,32));
		generateButton.setBounds(155,477,222,41);
		generateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//generate a password only when length > 0 and one of the toggled buttons is pressed
				if(passwordLengthInputArea.getText().length() <= 0) return;
				boolean anyToggleSelected = lowercaseToggle.isSelected()|| uppercaseToggle.isSelected() ||
					numbersToggle.isSelected() || symbolsToggle.isSelected();
	
				
				int passwordLength = Integer.parseInt(passwordLengthInputArea.getText());
				if(anyToggleSelected){
					String generatedPassword = passwordGenerator.generatePassword(passwordLength,uppercaseToggle.isSelected(),
							lowercaseToggle.isSelected(),numbersToggle.isSelected(),symbolsToggle.isSelected());
					passwordOutput.setText(generatedPassword);
				}
			}
		});
		
		add(generateButton);
	}
	
}
	