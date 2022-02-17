package finalProject4;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

//implement ActionListener to handle the times the user clicks on a component
public class Test implements ActionListener {

	//created an array with all of the questions that are going to be asked
	String[] queries= 
		{"What has to be broken before you can use it?",
		"What is full of holes, but still holds water?",
		"I have a tail and a head, but no body.What am I?",
		"What can you catch, but not throw?",
		"Where does today come before yesterday?"
		};
	
	//2d array with all the possible choices to the questions
	String[][] choices = {
			{"Egg","water bottle", "ceramic","backpack"},
			{"An old roof", "Honeycomb","CD", "Sponge"},
			{"Lion","Zebra","Coin","Bird"},
			{"A cold", "A football", "Baseball", "Air"},
			{"The Dictionary","The mind","A different universe", "simply not possible"}
	
	};
	
	//character array with the correct answer choices 
	char[] answers= {
			'A','D','C','A', 'A'
	
	};
	
	//String array with the hints for each question 
	String[] Hints= {
			"Hint:Found in the kitchen",
			"Hint:This is often found near dishes",
			"Hint:You see this object most days",
			"Hint:Nobody wants to have this",
			"Hint: Think of spelling"
			
			
			
			};
	//the choice the user chooses
	char guess;
	char answer;
	int index;
	//the amount of correct answers the user gets
	int RightAnswers=0;  
	//total amount of queries in game is set to the length of the array
	int totalqueries=queries.length;
	int result;
	//setting seconds to 50
	int seconds=50;
	
	//building GUI components
	JFrame frame = new JFrame();
	//holds the current query at the time
	JTextField textfield= new JTextField();
	JTextArea textarea= new JTextArea();
	
	//building the buttons
	JButton buttonA= new JButton();
	JButton buttonB= new JButton();
	JButton buttonC= new JButton();
	JButton buttonD= new JButton();
	
	//label for the count down timer 
	JLabel time_label= new JLabel ();
	JLabel seconds_left= new JLabel();
	
	//displays the results at the end 
	JTextField number_right = new JTextField();
	//displays percentage of the test 
	JTextField percentage = new JTextField();
	
	//building the labels for the buttons
	JLabel answer_labelA= new JLabel();
	JLabel answer_labelB= new JLabel();
	JLabel answer_labelC= new JLabel();
	JLabel answer_labelD= new JLabel();
	
	
	JTextField funfacts= new JTextField();
	
	//sets up to display the right answers at the end of the game
	JTextField rightanswers = new JTextField();
	JTextField rightanswers2= new JTextField();

	JLabel Hints1 = new JLabel();
	
	
	
	
	//instantiate timer class that will decrement the number of seconds the user has for each question 
	Timer timer = new Timer(1000, new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			seconds--;
			seconds_left.setText(String.valueOf(seconds));
			if(seconds<=0) {
				Correct();
			}
		}
	
	
	
		});
	
	//constructor for the class
	public Test() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//set size for the frame
		frame.setSize(650,650);
	
		
		
		
		//sets the  background color of the frame 
		frame.getContentPane().setBackground(new Color(153,102,0));
		frame.setLayout(null);
		//user can resize frame
		frame.setResizable(true);
	
		//sets where the text field is going to show up 
		textfield.setBounds(0,0,650,50);
		textfield.setBackground(new Color(25,25,25));
		textfield.setForeground(new Color(25,255,0));
		//sets font
		textfield.setFont(new Font("Ink Free",Font.BOLD,30));
		textfield.setBorder(BorderFactory.createBevelBorder(1));
		textfield.setHorizontalAlignment(JTextField.CENTER);
		
		
		//user is not able to edit 
		textfield.setEditable(false);
		
		textarea.setBounds(0,50,650,50);
		
		//in the case the text goes off the text area, it will wrap around to the next line
		textarea.setLineWrap(true);
		textarea.setWrapStyleWord(true);
		
		textarea.setBackground(new Color(25,25,25));
		textarea.setForeground(new Color(25,255,0));
		textarea.setFont(new Font("Ink Free",Font.ITALIC,25));
		textarea.setBorder(BorderFactory.createBevelBorder(1));
		textarea.setEditable(false);
		
		textarea.setText("Riddles");
		
	//next 4 blocks sets up the format for the answer choices 	
	buttonA.setBounds(0,100,100,100);
	buttonA.setFont(new Font("Ink Free",Font.BOLD,35));
	buttonA.setFocusable(false);
	buttonA.addActionListener(this);
	buttonA.setText("A");
	
	buttonB.setBounds(0,200,100,100);
	buttonB.setFont(new Font("Ink Free",Font.BOLD,35));
	buttonB.setFocusable(false);
	buttonB.addActionListener(this);
	buttonB.setText("B");
	
	buttonC.setBounds(0,300,100,100);
	buttonC.setFont(new Font("Ink Free",Font.BOLD,35));
	buttonC.setFocusable(false);
	buttonC.addActionListener(this);
	buttonC.setText("C");
	
	buttonD.setBounds(0,400,100,100);
	buttonD.setFont(new Font("Ink Free",Font.BOLD,35));
	buttonD.setFocusable(false);
	buttonD.addActionListener(this);
	buttonD.setText("D");
	
	
	
	
	//the next four blocks of code sets up the design for the appearance of the answers(answer labels) beside their associated buttons 
	answer_labelA.setBounds(125,100,500,100);
	answer_labelA.setBackground(new Color(50,50,50));
	answer_labelA.setBackground(new Color(25,255,0));
	answer_labelA.setFont(new Font("Ink Free",Font.BOLD,30));
	
	
	answer_labelB.setBounds(125,200,500,100);
	answer_labelB.setBackground(new Color(50,50,50));
	answer_labelB.setBackground(new Color(25,255,0));
	answer_labelB.setFont(new Font("Ink Free",Font.BOLD,30));
	
	
	answer_labelC.setBounds(125,300,500,100);
	answer_labelC.setBackground(new Color(50,50,50));
	answer_labelC.setBackground(new Color(25,255,0));
	answer_labelC.setFont(new Font("Ink Free",Font.BOLD,30));
	
	
	answer_labelD.setBounds(125,400,500,100);
	answer_labelD.setBackground(new Color(50,50,50));
	answer_labelD.setBackground(new Color(25,255,0));
	answer_labelD.setFont(new Font("Ink Free",Font.BOLD,30));
	
	
	
	//design elements for the hints 
	Hints1.setBounds(100,500,500,100);
	Hints1.setBackground(new Color(50,50,50));
	Hints1.setBackground(new Color(25,255,0));
	Hints1.setFont(new Font("Ink Free",Font.BOLD,20));

	
	//setting the bounds and design of the timer that displays the seconds remaining 
	seconds_left.setBounds(525,505,100,100);
	seconds_left.setBackground(new Color(25,25,25));
	seconds_left.setForeground(new Color(102,102,102));
	seconds_left.setFont(new Font("Ink Free",Font.BOLD,60));
	seconds_left.setBorder(BorderFactory.createBevelBorder(1));
	seconds_left.setOpaque(true);
	seconds_left.setHorizontalAlignment(JTextField.CENTER);
	//converts the integer seconds into a string 
	seconds_left.setText(String.valueOf(seconds));
	
	
	
	funfacts.setBounds(225,125,400,100);
	funfacts.setBackground(new Color(25,25,25));
	funfacts.setForeground(new Color(25,255,0));
	funfacts.setFont(new Font("Ink Free", Font.BOLD,10));
	funfacts.setBorder(BorderFactory.createBevelBorder(1));
	funfacts.setHorizontalAlignment(JTextField.CENTER);
	
	
	
	//displays the amount of questions counted correct at the end of the game 
	number_right.setBounds(225,225,200,100);
	number_right.setBackground(new Color(25,25,25));
	number_right.setForeground(new Color(25,255,0));
	number_right.setFont(new Font("Ink Free", Font.BOLD,20));
	number_right.setBorder(BorderFactory.createBevelBorder(1));
	number_right.setHorizontalAlignment(JTextField.CENTER);
	
	//user cannot alter the amount of queries they got correct 
	number_right.setEditable(false);
	
	//sets up the design for the appearance of the percentage at the end
	percentage.setBounds(225,325,200,100);
	percentage.setBackground(new Color(25,25,25));
	percentage.setForeground(new Color(25,255,0));
	percentage.setFont(new Font("Ink Free", Font.BOLD,20));
	percentage.setBorder(BorderFactory.createBevelBorder(1));
	percentage.setHorizontalAlignment(JTextField.CENTER);
	
	
	//the next 2 blocks are the correct answers' display that show up at the results 
	rightanswers.setBounds(225,425,200,100);
	rightanswers.setBackground(new Color(25,25,25));
	rightanswers.setForeground(new Color(25,255,0));
	rightanswers.setFont(new Font("Ink Free", Font.BOLD,20));
	rightanswers.setBorder(BorderFactory.createBevelBorder(1));
	rightanswers.setHorizontalAlignment(JTextField.CENTER);
	
	
	rightanswers2.setBounds(225,525,200,100);
	rightanswers2.setBackground(new Color(25,25,25));
	rightanswers2.setForeground(new Color(25,255,0));
	rightanswers2.setFont(new Font("Ink Free", Font.BOLD,20));
	rightanswers2.setBorder(BorderFactory.createBevelBorder(1));
	rightanswers2.setHorizontalAlignment(JTextField.CENTER);
	
	
	
		//these design elements are added to the frame 
		frame.add(Hints1);
		frame.add(time_label);
		frame.add(seconds_left);
		frame.add(answer_labelA);
		frame.add(answer_labelB);
		frame.add(answer_labelC);
		frame.add(answer_labelD);
		frame.add(buttonD);
		frame.add(buttonC);
		frame.add(buttonB);
		frame.add(buttonA);
		frame.add(textarea);
		frame.add(textfield);
		frame.setVisible(true);
		
		
		//calling the next query 
		nextquery();
		
		
		
	}
	
	
	//a method that displays the next question 
	public void nextquery() {
		//if the place that the user is in is equal to or greater to the number of questions, the game will display the results
		if (index>=totalqueries) {
			Results();
		}
		else {
			//or else the game will display the next question with the answer choices  and hints
			textfield.setText("Question"+ (index+1));
			textarea.setText(queries[index]);
			
			Hints1.setText(Hints[index]);
			answer_labelA.setText(choices[index][0]);
			answer_labelB.setText(choices[index][1]);
			answer_labelC.setText(choices[index][2]);
			answer_labelD.setText(choices[index][3]);
			//the timer will start here
			timer.start();
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		//disables buttons temporarily
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		buttonD.setEnabled(false);
		
		// next block determines which button is being pressed and if it matches to one of the values in the choices array
		
		if(e.getSource()==buttonA) {
			answer='A';
		if(answer==answers[index]) {
			RightAnswers++;
			
		}
		}
			if(e.getSource()==buttonB) {
				answer='B';
			if(answer==answers[index]) {
				RightAnswers++;
			}
			}
			
			if(e.getSource()==buttonC) {
				answer='C';
			if(answer==answers[index]) {
				RightAnswers++;
			}
			}
		
			if(e.getSource()==buttonD) {
				answer='D';
			if(answer==answers[index]) {
				RightAnswers++;
			}
			}
			
			
		//method that displays the correct answer gets called	
		Correct();
		
		
		
					
	}
		
	
	
	//a method that displays the correct answers
	public void Correct() {
		//the timer will stop here 
		timer.stop();
		//disable buttons again 
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		buttonD.setEnabled(false);
		
		//if the particular question index we are on receives an incorrect answer the answer choice will turn red 
		if(answers[index]!='A')
			answer_labelA.setForeground(new Color(255,0,0));
		if(answers[index]!='B')
			answer_labelB.setForeground(new Color(255,0,0));
		if(answers[index]!='C')
			answer_labelC.setForeground(new Color(255,0,0));
		if(answers[index]!='D')
			answer_labelD.setForeground(new Color(255,0,0));
	
	
	//instantiates the Timer Class 
		//There will be a 1.5 second delay before the red colors go away 
	Timer delay = new Timer(1500, new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
	answer_labelA.setForeground(new Color(0,0,0));
	answer_labelB.setForeground(new Color(0,0,0));
	answer_labelC.setForeground(new Color(0,0,0));
	answer_labelD.setForeground(new Color(0,0,0));
		
		//reset answer
	answer=' ';
	seconds=50;
	seconds_left.setText(String.valueOf(seconds));
	buttonA.setEnabled(true);
	buttonB.setEnabled(true);
	buttonC.setEnabled(true);
	buttonD.setEnabled(true);
	index++;
	nextquery();
	
		}
	}); 
	//method works, so that the timer will only execute once
	delay.setRepeats(false);
	delay.start();
	
	}
//a method that displays the results
public void Results() {
	//buttons are disabled
	buttonA.setEnabled(false);
	buttonB.setEnabled(false);
	buttonC.setEnabled(false);
	buttonD.setEnabled(false);
	
	//displays the results percentage
	result= (int)((RightAnswers/(double)totalqueries)*100);
	
	//when the game gets to the results section, this  will clear out the answer choices 
	textfield.setText("Thanks for Playing!");
	textarea.setText("Your Results and Correct Answers");
	answer_labelA.setText("");
	answer_labelB.setText("");
	answer_labelC.setText("");
	answer_labelD.setText("");
	
	Hints1.setText("");
	
	//displays the amount of correct answers out of the total questions 
	number_right.setText("("+RightAnswers+"/" +totalqueries+")");
	//displays percentage results
	percentage.setText(result+ "%");
	
	//shows the the right answers 
			rightanswers.setText("1.A  2.D");
			rightanswers2.setText("3.C 4.A 5.A");
			
	funfacts.setText("Fun fact: Solving riddles helps improve critical thinking" );		
			
	
	//design elements are added to the frame 
	frame.add(funfacts);
	frame.add(rightanswers);
	frame.add(rightanswers2);
	frame.add(percentage);
	frame.add(number_right);
	
}
}


