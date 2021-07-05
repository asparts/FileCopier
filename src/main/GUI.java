package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.apache.commons.io.FileUtils;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.BoxLayout;

public class GUI{

	private JFrame frame;
	
	
	private JTextField sourceTextField;
	private JTextField destinationTextField;
	private JTextField foldersTextField = new JTextField();
	
	private JLabel foldersLabel = new JLabel("Folders:");
	
	private JButton destinationBrowseButton = new JButton("...");
	private JButton sourceBrowseButton = new JButton("...");
	private JButton cancelButton = new JButton("Cancel");
	private JButton copyButton = new JButton("Copy");
	
	private String sourcePath = "";
	private String destinationPath = "";
	private String[] folders;
	
	private String separator = ";";
	
	private final JFileChooser fileChooser = new JFileChooser();
	
	private final JMenuBar menuBar = new JMenuBar();
	
	
	
	/**
	 * BELOW CODED VALUES FOR FOLDERS.. YOU SHOULD BE ABLE TO CHANGE THESE ON OPTIONS
	 * 
	 * **/
	
	//TODO: Options, finish these shortcuts and implement way to save values to a file
	//TODO: Think about the method to remove duplicate values.. is it needed?
	
	private String L31;
	private String L32 = "035;295;304;400;445;529;736;833;895;918;941";
	private String L33 = "202;322;423;445;480;529;577;680;704;734;738;853";
	private String L34 = "019;050;202;284;400;423;430;480;481;503;529;538;561;577;636;680;704;734;783;833;853;895;918";
	private String L41 = "049;091;092;106;149;224;235;257;444;543;710;734;755;761;927";
	private String L42 = "061;086;106;109;165;224;433;444;543;694;761;834;858;927";
	private String L43 = "098;142;286;316;398;407;504;505;560;616";
	private String L44 = "018;091;092;106;186;245;285;286;407;434;504;505;611;616;624;638;753;858";
	private String M31 = "684;051;631";
	private String M32 = "051;609;747;484";
	private String M33 = "050;051;079;102;103;271;400;430;531;561;619;636;684;783;790;886";
	private String M34 = "609;747;484;214;143;108;790;886";
	private String M41 = "020;061;082;109;165;211;418;635;834;887;908;922";
	private String M42 = "108;143;177;182;211;291;418;536;562;576;604;635;702;837;922;980";
	private String M43 = "016;081;098;109;111;142;286;398;507;576;588;781";
	private String M44 = "081;097;111;172;179;182;213;291;435;491;507;576;588;781";
	private String M52 = "097;178;491;507;623;700;740;768";
	private String N31 = "287;484";
	private String N32 = "231;525;287";
	private String N33 = "143;151;181;214;230;232;250;581;608;747";
	private String N34 = "010;145;151;218;230;232;250;287;301;581;743;846;936";
	private String N41 = "177;182;249;508;592;702;936;980";
	private String N42 = "005;010;226;249;250;300;301;408;495;592;729;743;759;892;936;989";
	private String N43 = "077;097;172;179;182;213;410;435;491;500;592;593;850";
	private String N44 = "077;179;213;275;297;410;593;686;729;778;844;892;921;992";
	private String N51 = "046;090;171;178;213;420;491;593;681;740;768;915";
	private String N52 = "090;171;297;309;420;426;593;740;778;857;915";
	private String P31 = "280;475";
	private String P32 = "499;905;946";
	private String P33 = "052;152;233;399;408;475;499;599;743;893;905;946";
	private String P34 = "005;010;145;152;233;300;301;399;403;408;499;743;759;846;905;934;946";
	private String P41 = "005;010;216;226;233;265;300;312;403;408;495;584;729;743;759;934;989";
	private String P42 = "005;052;074;216;226;233;236;256;265;272;288;312;403;408;421;440;584;599;601;626;691;924;931;934";
	private String P43 = "216;226;239;265;275;297;595;686;729;778;844;921;931;992";
	private String P44 = "069;140;239;256;263;265;297;421;595;601;626;691;925;931";
	private String Q33 = "440;499;598;599;893;946";
	private String Q41 = "052;074;217;236;272;288;421;440;535;599;691;746;849;924";
	private String Q42 = "009;071;208;217;272;440;483;535;563;625;678;746;977";
	private String Q43 = "069;071;263;317;535;601;626;630;691;925";
	private String Q44 = "069;071;205;263;317;425;494;535;563;625;626;630;678;748;785;791;925";
	private String R41 = "436;625;678;748";
	private String R42 = "072;139;436;564;748";
	private String R43 = "244;425;436;494;564;748;785;791;859;889";
	private String R44 = "244;425;436;494;564;615;859;889";
	


















	
	
	
	




	

			
	
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
		
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		
		setActionListeners();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel sourceLabel = new JLabel("Source:");
		sourceLabel.setBounds(41, 59, 46, 14);
		panel.add(sourceLabel);
		
		JLabel destinationLabel = new JLabel("Destination");
		destinationLabel.setBounds(41, 87, 46, 14);
		panel.add(destinationLabel);
		
		sourceTextField = new JTextField();
		sourceTextField.setBounds(97, 56, 155, 20);
		panel.add(sourceTextField);
		sourceTextField.setColumns(10);
		
		destinationTextField = new JTextField();
		destinationTextField.setBounds(97, 84, 155, 20);
		panel.add(destinationTextField);
		destinationTextField.setColumns(10);
		
		
		copyButton.setBounds(94, 205, 89, 23);
		panel.add(copyButton);
		
		
		cancelButton.setBounds(193, 205, 89, 23);
		panel.add(cancelButton);
		
		
		sourceBrowseButton.setBounds(262, 55, 20, 23);
		panel.add(sourceBrowseButton);
		
		destinationBrowseButton.setBounds(262, 83, 20, 23);
		panel.add(destinationBrowseButton);
		
		
		foldersTextField.setBounds(97, 115, 185, 79);
		panel.add(foldersTextField);
		foldersTextField.setColumns(10);
		
		
		foldersLabel.setBounds(41, 129, 46, 14);
		panel.add(foldersLabel);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setBounds(292, 11, 132, 217);
		panel.add(scrollPane_1);
		
		JPanel panel_1 = new JPanel();
		scrollPane_1.setViewportView(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("L1");
		btnNewButton.setBounds(0, 0, 43, 23);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(0, 23, 43, 23);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(42, 0, 36, 23);
		panel_1.add(btnNewButton_2);
		
		populateMenuBar(menuBar);
		frame.setJMenuBar(menuBar);
		
	}
	
private void setActionListeners() {
	
	sourceBrowseButton.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			System.out.println("sourceBrowse");
			
			int returnValue = fileChooser.showOpenDialog(null);
			
			if(returnValue == JFileChooser.APPROVE_OPTION) {
				sourcePath = fileChooser.getSelectedFile().getAbsolutePath().toString();
				sourceTextField.setText(sourcePath);
				System.out.println(sourcePath);
			}
			
		}
		
	});
	
	destinationBrowseButton.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			System.out.println("destBrowse");
			
			int returnValue = fileChooser.showOpenDialog(null);
			
			if(returnValue == JFileChooser.APPROVE_OPTION) {
				destinationPath = fileChooser.getSelectedFile().getAbsolutePath().toString();
				destinationTextField.setText(destinationPath);
				System.out.println(sourcePath);
			}
			
		}
		
	});
	
	copyButton.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			System.out.println("Copy");
			
			String tempString = foldersTextField.getText().toString();
			
			folders = tempString.split(separator);
			
			for(int i = 0; i < folders.length; i++) {
			//System.out.println(folders[i]);
				copyFolders(folders[i].toString());
					
			}
			
		}
		
	});
	cancelButton.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			System.out.println("Cancel");
			
		}
		
	});
	
	
}



	
	private void copyFolders(String folderName) {
		try {
			FileUtils.copyDirectoryToDirectory(new File(sourcePath + "\\" + folderName), new File(destinationPath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void populateMenuBar(JMenuBar menuBar) {
		
		menuBar.add(createFileMenu());
		menuBar.add(createPreferencesMenu());
	}
	
	private JMenu createFileMenu() {
		
		final JMenu fileMenu = new JMenu("File");
		
		final JMenuItem exitMenuItem = new JMenuItem("Exit");
		
		exitMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		final JMenuItem helpMenuItem = new JMenuItem("Help");
		fileMenu.add(helpMenuItem);
		fileMenu.add(exitMenuItem);
		
		return fileMenu;
	}
	
	private JMenu createPreferencesMenu() {
		
		final JMenu preferencesMenu = new JMenu("Preferences");
		
		
		final JMenuItem separatorMenuItem = new JMenuItem("Change folder separator");
		
		separatorMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				String tempSeparator = JOptionPane.showInputDialog("Enter new separator");
				
				if(!tempSeparator.isEmpty()) {
					separator = tempSeparator;
				}
				
			}
			
			
			
		});
		
		final JMenuItem shortcuts = new JMenuItem("Shortcuts");
		
		shortcuts.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				showOptions();
			}
			
			
			
		});
		
		preferencesMenu.add(separatorMenuItem);
		preferencesMenu.add(shortcuts);
		
		return preferencesMenu;
		
	}
	
	private void showOptions() {
		JFrame optionsFrame = new JFrame("Options");
		optionsFrame.setBounds(100, 100, 300, 300);
		//optionsFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		optionsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		optionsFrame.setVisible(true);
		optionsFrame.requestFocus();
		
		JPanel optionsPanel = new JPanel();
		
		optionsFrame.getContentPane().add(optionsPanel);
	}
}
