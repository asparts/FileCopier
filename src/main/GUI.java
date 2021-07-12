package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import org.apache.commons.io.FileUtils;

public class GUI{

	private JFrame frame;
	
	
	private JTextField sourceTextField;
	private JTextField destinationTextField;
	private JTextArea foldersTextArea = new JTextArea();
	
	private JLabel foldersLabel = new JLabel("Folders:");
	
	private JScrollPane scrollPane_1 = new JScrollPane();
	private JPanel panel_1 = new JPanel();
	
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
	private String L32 = "035;295;304;400;445;529;736;833;895;918;941;";
	private String L33 = "202;322;423;445;480;529;577;680;704;734;738;853;";
	private String L34 = "019;050;202;284;400;423;430;480;481;503;529;538;561;577;636;680;704;734;783;833;853;895;918;";
	private String L41 = "049;091;092;106;149;224;235;257;444;543;710;734;755;761;927;";
	private String L42 = "061;086;106;109;165;224;433;444;543;694;761;834;858;927;";
	private String L43 = "098;142;286;316;398;407;504;505;560;616;";
	private String L44 = "018;091;092;106;186;245;285;286;407;434;504;505;611;616;624;638;753;858;";
	private String M31 = "684;051;631;";
	private String M32 = "051;609;747;484;";
	private String M33 = "050;051;079;102;103;271;400;430;531;561;619;636;684;783;790;886;";
	private String M34 = "609;747;484;214;143;108;790;886;";
	private String M41 = "020;061;082;109;165;211;418;635;834;887;908;922;";
	private String M42 = "108;143;177;182;211;291;418;536;562;576;604;635;702;837;922;980;";
	private String M43 = "016;081;098;109;111;142;286;398;507;576;588;781;";
	private String M44 = "081;097;111;172;179;182;213;291;435;491;507;576;588;781;";
	private String M52 = "097;178;491;507;623;700;740;768;";
	private String N31 = "287;484;";
	private String N32 = "231;525;287;";
	private String N33 = "143;151;181;214;230;232;250;581;608;747;";
	private String N34 = "010;145;151;218;230;232;250;287;301;581;743;846;936;";
	private String N41 = "177;182;249;508;592;702;936;980;";
	private String N42 = "005;010;226;249;250;300;301;408;495;592;729;743;759;892;936;989;";
	private String N43 = "077;097;172;179;182;213;410;435;491;500;592;593;850;";
	private String N44 = "077;179;213;275;297;410;593;686;729;778;844;892;921;992;";
	private String N51 = "046;090;171;178;213;420;491;593;681;740;768;915;";
	private String N52 = "090;171;297;309;420;426;593;740;778;857;915;";
	private String P31 = "280;475;";
	private String P32 = "499;905;946;";
	private String P33 = "052;152;233;399;408;475;499;599;743;893;905;946;";
	private String P34 = "005;010;145;152;233;300;301;399;403;408;499;743;759;846;905;934;946;";
	private String P41 = "005;010;216;226;233;265;300;312;403;408;495;584;729;743;759;934;989;";
	private String P42 = "005;052;074;216;226;233;236;256;265;272;288;312;403;408;421;440;584;599;601;626;691;924;931;934;";
	private String P43 = "216;226;239;265;275;297;595;686;729;778;844;921;931;992;";
	private String P44 = "069;140;239;256;263;265;297;421;595;601;626;691;925;931;";
	private String Q33 = "440;499;598;599;893;946;";
	private String Q41 = "052;074;217;236;272;288;421;440;535;599;691;746;849;924;";
	private String Q42 = "009;071;208;217;272;440;483;535;563;625;678;746;977;";
	private String Q43 = "069;071;263;317;535;601;626;630;691;925;";
	private String Q44 = "069;071;205;263;317;425;494;535;563;625;626;630;678;748;785;791;925;";
	private String R41 = "436;625;678;748;";
	private String R42 = "072;139;436;564;748;";
	private String R43 = "244;425;436;494;564;748;785;791;859;889;";
	private String R44 = "244;425;436;494;564;615;859;889;";
	private String R51 = "105;578;620;697;777;785;889;";
	private String R52 = "564;615;620;889;";
	private String R53 = "105;290;777;";
	private String R54 = "777;";
	private String S41 = "139;240;751;851;";
	private String S42 = "240;241;683;751;845;851;";
	private String S43 = "139;240;241;564;615;683;751;";
	private String S44 = "139;240;241;614;615;683;698;751;845;";
	private String S51 = "305;614;615;683;777;832;";
	private String S52 = "305;614;615;683;832;";
	private String S53 = "305;614;615;683;777;832;";
	private String S54 = "305;614;615;683;832;";
	private String T41 = "698;845;851;854;976;";
	private String T42 = "261;273;698;758;854;";
	private String T43 = "320;583;698;732;758;";
	private String T44 = "320;583;698;732;758;";
	private String T51 = "305;320;614;698;732;";
	private String U41 = "261;273;498;758;";
	private String U42 = "261;273;498;758;";
	private String U43 = "261;273;498;758;";
	private String U44 = "261;273;498;758;";




	
	private JCheckBox shortcut_L31 = new JCheckBox("L31");
	private JCheckBox shortcut_L34 = new JCheckBox("L34");
	private JCheckBox shortcut_L32 = new JCheckBox("L32");
	private JCheckBox shortcut_L33 = new JCheckBox("L33");
	
	private final JCheckBox shortcut_L41 = new JCheckBox("L41");
	private final JCheckBox shortcut_L42 = new JCheckBox("L42");
	private final JCheckBox shortcut_L43 = new JCheckBox("L43");
	private final JCheckBox shortcut_L44 = new JCheckBox("L44");
	
	private final JCheckBox shortcut_M31 = new JCheckBox("M31");
	private final JCheckBox shortcut_M32 = new JCheckBox("M32");
	private final JCheckBox shortcut_M33 = new JCheckBox("M33");
	private final JCheckBox shortcut_M34 = new JCheckBox("M34");
	
	private final JCheckBox shortcut_M41 = new JCheckBox("M41");
	private final JCheckBox shortcut_M42 = new JCheckBox("M42");
	private final JCheckBox shortcut_M43 = new JCheckBox("M43");
	private final JCheckBox shortcut_M44 = new JCheckBox("M44");
	
	private final JCheckBox shortcut_N31 = new JCheckBox("N31");
	private final JCheckBox shortcut_N32 = new JCheckBox("N32");
	private final JCheckBox shortcut_N33 = new JCheckBox("N33");
	private final JCheckBox shortcut_N34 = new JCheckBox("N34");
	
	private final JCheckBox shortcut_N41 = new JCheckBox("N41");
	private final JCheckBox shortcut_N42 = new JCheckBox("N42");
	private final JCheckBox shortcut_N43 = new JCheckBox("N43");
	private final JCheckBox shortcut_N44 = new JCheckBox("N44");
	
	private final JCheckBox shortcut_N51 = new JCheckBox("N51");
	private final JCheckBox shortcut_N52 = new JCheckBox("N52");
	
	private final JCheckBox shortcut_P31 = new JCheckBox("P31");
	private final JCheckBox shortcut_P32 = new JCheckBox("P32");
	private final JCheckBox shortcut_P33 = new JCheckBox("P33");
	private final JCheckBox shortcut_P34 = new JCheckBox("P34");
	
	private final JCheckBox shortcut_P41 = new JCheckBox("P41");
	private final JCheckBox shortcut_P42 = new JCheckBox("P42");
	private final JCheckBox shortcut_P43 = new JCheckBox("P43");
	private final JCheckBox shortcut_P44 = new JCheckBox("P44");
	
	private final JCheckBox shortcut_Q33 = new JCheckBox("Q33");
	
	private final JCheckBox shortcut_Q41 = new JCheckBox("Q41");
	private final JCheckBox shortcut_Q42 = new JCheckBox("Q42");
	private final JCheckBox shortcut_Q43 = new JCheckBox("Q43");
	private final JCheckBox shortcut_Q44 = new JCheckBox("Q44");
	
	private final JCheckBox shortcut_R41 = new JCheckBox("R41");
	private final JCheckBox shortcut_R42 = new JCheckBox("R42");
	private final JCheckBox shortcut_R43 = new JCheckBox("R43");
	private final JCheckBox shortcut_R44 = new JCheckBox("R44");
	
	private final JCheckBox shortcut_R51 = new JCheckBox("R51");
	private final JCheckBox shortcut_R52 = new JCheckBox("R52");
	private final JCheckBox shortcut_R53 = new JCheckBox("R53");
	private final JCheckBox shortcut_R54 = new JCheckBox("R54");
	
	private final JCheckBox shortcut_S41 = new JCheckBox("S41");
	private final JCheckBox shortcut_S42 = new JCheckBox("S42");
	private final JCheckBox shortcut_S43 = new JCheckBox("S43");
	private final JCheckBox shortcut_S44 = new JCheckBox("S44");
	
	private final JCheckBox shortcut_S51 = new JCheckBox("S51");
	private final JCheckBox shortcut_S52 = new JCheckBox("S52");
	private final JCheckBox shortcut_S53 = new JCheckBox("S53");
	private final JCheckBox shortcut_S54 = new JCheckBox("S54");
	
	private final JCheckBox shortcut_T41 = new JCheckBox("T41");
	private final JCheckBox shortcut_T42 = new JCheckBox("T42");
	private final JCheckBox shortcut_T43 = new JCheckBox("T43");
	private final JCheckBox shortcut_T44 = new JCheckBox("T44");
	
	private final JCheckBox shortcut_T51 = new JCheckBox("T51");
	
	private final JCheckBox shortcut_U41 = new JCheckBox("U41");
	private final JCheckBox shortcut_U42 = new JCheckBox("U42");
	private final JCheckBox shortcut_U43 = new JCheckBox("U43");
	private final JCheckBox shortcut_U44 = new JCheckBox("U44");


	
	
	

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
		frame.setBounds(100, 100, 450, 317);
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
		
		
		foldersTextArea.setBounds(97, 115, 185, 79);
		foldersTextArea.setLineWrap(true); //TODO: check this more
		panel.add(foldersTextArea);
		foldersTextArea.setColumns(10);
		
		
		foldersLabel.setBounds(41, 129, 46, 14);
		panel.add(foldersLabel);
		
		
		
		this.addShortcutSection();
		panel.add(scrollPane_1);
		
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
			
			String tempString = foldersTextArea.getText().toString();
			
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
		optionsFrame.setBounds(100, 100, 600, 600);
		//optionsFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		optionsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		optionsFrame.setVisible(true);
		optionsFrame.requestFocus();
		optionsFrame.setResizable(false);
		
		JPanel optionsPanel = new JPanel();
		JPanel optionsViewPort = new JPanel();
		JScrollPane optionsScrollPane = new JScrollPane();
		
		JTextField L31_tfield = new JTextField();
		JLabel L31_label = new JLabel("L31");
		JTextField L32_tfield = new JTextField();
		JLabel L32_label = new JLabel("L32");
		JTextField L33_tfield = new JTextField();
		JLabel L33_label = new JLabel("L33");
		JTextField L34_tfield = new JTextField();
		JLabel L34_label = new JLabel("L34");
		
		JTextField L41_tfield = new JTextField();
		JLabel L41_label = new JLabel("L41");
		JTextField L42_tfield = new JTextField();
		JLabel L42_label = new JLabel("L42");
		JTextField L43_tfield = new JTextField();
		JLabel L43_label = new JLabel("L43");
		JTextField L44_tfield = new JTextField();
		JLabel L44_label = new JLabel("L44");
		
		JTextField M31_tfield = new JTextField();
		JLabel M31_label = new JLabel("M31");
		JTextField M32_tfield = new JTextField();
		JLabel M32_label = new JLabel("M32");
		JTextField M33_tfield = new JTextField();
		JLabel M33_label = new JLabel("M33");
		JTextField M34_tfield = new JTextField();
		JLabel M34_label = new JLabel("M34");
		
		JTextField M41_tfield = new JTextField();
		JLabel M41_label = new JLabel("M41");
		JTextField M42_tfield = new JTextField();
		JLabel M42_label = new JLabel("M42");
		JTextField M43_tfield = new JTextField();
		JLabel M43_label = new JLabel("M43");
		JTextField M44_tfield = new JTextField();
		JLabel M44_label = new JLabel("M44");
		
		JTextField N31_tfield = new JTextField();
		JLabel N31_label = new JLabel("N31");
		JTextField N32_tfield = new JTextField();
		JLabel N32_label = new JLabel("N32");
		JTextField N33_tfield = new JTextField();
		JLabel N33_label = new JLabel("N33");
		JTextField N34_tfield = new JTextField();
		JLabel N34_label = new JLabel("N34");
		
		JTextField N41_tfield = new JTextField();
		JLabel N41_label = new JLabel("N41");
		JTextField N42_tfield = new JTextField();
		JLabel N42_label = new JLabel("N42");
		JTextField N43_tfield = new JTextField();
		JLabel N43_label = new JLabel("N43");
		JTextField N44_tfield = new JTextField();
		JLabel N44_label = new JLabel("N44");
		
		JTextField N51_tfield = new JTextField();
		JLabel N51_label = new JLabel("N51");
		JTextField N52_tfield = new JTextField();
		JLabel N52_label = new JLabel("N52");
		
		JTextField P31_tfield = new JTextField();
		JLabel P31_label = new JLabel("P31");
		JTextField P32_tfield = new JTextField();
		JLabel P32_label = new JLabel("P32");
		JTextField P33_tfield = new JTextField();
		JLabel P33_label = new JLabel("P33");
		JTextField P34_tfield = new JTextField();
		JLabel P34_label = new JLabel("P34");
		
		optionsScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		optionsScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		optionsScrollPane.setPreferredSize(new Dimension(320, 220));
		optionsPanel.setLayout(null);
		
		optionsViewPort.setPreferredSize(new Dimension(300,800));
		optionsViewPort.setLayout(null);
		optionsScrollPane.setBounds(0, 0, 450, 450);
		
		optionsPanel.add(optionsScrollPane);
		
		
		//SETTING LABELS AND TEXTFIELDS --------------->
		L31_label.setBounds(20, 10, 40, 20);
		L31_tfield.setBounds(100, 10, 300, 20);
		
		optionsViewPort.add(L31_label);
		optionsViewPort.add(L31_tfield);
		
		L32_label.setBounds(20, 30, 40, 20);
		L32_tfield.setBounds(100, 30, 300, 20);
		
		optionsViewPort.add(L32_label);
		optionsViewPort.add(L32_tfield);
		
		L33_label.setBounds(20, 50, 40, 20);
		L33_tfield.setBounds(100, 50, 300, 20);
		
		optionsViewPort.add(L33_label);
		optionsViewPort.add(L33_tfield);
		
		L34_label.setBounds(20, 70, 40, 20);
		L34_tfield.setBounds(100, 70, 300, 20);
		
		optionsViewPort.add(L34_label);
		optionsViewPort.add(L34_tfield);
		//--
		L41_label.setBounds(20, 90, 40, 20);
		L41_tfield.setBounds(100, 90, 300, 20);
		
		optionsViewPort.add(L41_label);
		optionsViewPort.add(L41_tfield);
		
		L42_label.setBounds(20, 110, 40, 20);
		L42_tfield.setBounds(100, 110, 300, 20);
		
		optionsViewPort.add(L42_label);
		optionsViewPort.add(L42_tfield);
		
		L43_label.setBounds(20, 130, 40, 20);
		L43_tfield.setBounds(100, 130, 300, 20);
		
		optionsViewPort.add(L43_label);
		optionsViewPort.add(L43_tfield);
		
		L44_label.setBounds(20, 150, 40, 20);
		L44_tfield.setBounds(100, 150, 300, 20);
		
		optionsViewPort.add(L44_label);
		optionsViewPort.add(L44_tfield);
		
		
		//------------------
		
		M31_label.setBounds(20, 170, 40, 20);
		M31_tfield.setBounds(100, 170, 300, 20);
		
		optionsViewPort.add(M31_label);
		optionsViewPort.add(M31_tfield);
		
		M32_label.setBounds(20, 190, 40, 20);
		M32_tfield.setBounds(100, 190, 300, 20);
		
		optionsViewPort.add(M32_label);
		optionsViewPort.add(M32_tfield);
		
		M33_label.setBounds(20, 210, 40, 20);
		M33_tfield.setBounds(100, 210, 300, 20);
		
		optionsViewPort.add(M33_label);
		optionsViewPort.add(M33_tfield);
		
		M34_label.setBounds(20, 230, 40, 20);
		M34_tfield.setBounds(100, 230, 300, 20);
		
		optionsViewPort.add(M34_label);
		optionsViewPort.add(M34_tfield);

		//------------
		
		M41_label.setBounds(20, 250, 40, 20);
		M41_tfield.setBounds(100, 250, 300, 20);
		
		optionsViewPort.add(M41_label);
		optionsViewPort.add(M41_tfield);
		
		M42_label.setBounds(20, 270, 40, 20);
		M42_tfield.setBounds(100, 270, 300, 20);
		
		optionsViewPort.add(M42_label);
		optionsViewPort.add(M42_tfield);
		
		M43_label.setBounds(20, 290, 40, 20);
		M43_tfield.setBounds(100, 290, 300, 20);
		
		optionsViewPort.add(M43_label);
		optionsViewPort.add(M43_tfield);
		
		M44_label.setBounds(20, 310, 40, 20);
		M44_tfield.setBounds(100, 310, 300, 20);
		
		optionsViewPort.add(M44_label);
		optionsViewPort.add(M44_tfield);
		
		//------------------
		
				N31_label.setBounds(20, 330, 40, 20);
				N31_tfield.setBounds(100, 330, 300, 20);
				
				optionsViewPort.add(N31_label);
				optionsViewPort.add(N31_tfield);
				
				N32_label.setBounds(20, 350, 40, 20);
				N32_tfield.setBounds(100, 350, 300, 20);
				
				optionsViewPort.add(N32_label);
				optionsViewPort.add(N32_tfield);
				
				N33_label.setBounds(20, 370, 40, 20);
				N33_tfield.setBounds(100, 370, 300, 20);
				
				optionsViewPort.add(N33_label);
				optionsViewPort.add(N33_tfield);
				
				N34_label.setBounds(20, 390, 40, 20);
				N34_tfield.setBounds(100, 390, 300, 20);
				
				optionsViewPort.add(N34_label);
				optionsViewPort.add(N34_tfield);

				//------------
				
				N41_label.setBounds(20, 410, 40, 20);
				N41_tfield.setBounds(100, 410, 300, 20);
				
				optionsViewPort.add(N41_label);
				optionsViewPort.add(N41_tfield);
				
				N42_label.setBounds(20, 430, 40, 20);
				N42_tfield.setBounds(100, 430, 300, 20);
				
				optionsViewPort.add(N42_label);
				optionsViewPort.add(N42_tfield);
				
				N43_label.setBounds(20, 450, 40, 20);
				N43_tfield.setBounds(100, 450, 300, 20);
				
				optionsViewPort.add(N43_label);
				optionsViewPort.add(N43_tfield);
				
				N44_label.setBounds(20, 470, 40, 20);
				N44_tfield.setBounds(100, 470, 300, 20);
				
				optionsViewPort.add(N44_label);
				optionsViewPort.add(N44_tfield);
				
//------------
				
				N51_label.setBounds(20, 490, 40, 20);
				N51_tfield.setBounds(100, 490, 300, 20);
				
				optionsViewPort.add(N51_label);
				optionsViewPort.add(N51_tfield);
				
				N52_label.setBounds(20, 510, 40, 20);
				N52_tfield.setBounds(100, 510, 300, 20);
				
				optionsViewPort.add(N52_label);
				optionsViewPort.add(N52_tfield);
		
			//--------------------
				
				P31_label.setBounds(20, 530, 40, 20);
				P31_tfield.setBounds(100, 530, 300, 20);
				
				optionsViewPort.add(P31_label);
				optionsViewPort.add(P31_tfield);
				
				P32_label.setBounds(20, 550, 40, 20);
				P32_tfield.setBounds(100, 550, 300, 20);
				
				optionsViewPort.add(P32_label);
				optionsViewPort.add(P32_tfield);
				
				P33_label.setBounds(20, 570, 40, 20);
				P33_tfield.setBounds(100, 570, 300, 20);
				
				optionsViewPort.add(P33_label);
				optionsViewPort.add(P33_tfield);
				
				P34_label.setBounds(20, 590, 40, 20);
				P34_tfield.setBounds(100, 590, 300, 20);
				
				optionsViewPort.add(P34_label);
				optionsViewPort.add(P34_tfield);
			
		//ENDING HERE ------------------>
		
		optionsScrollPane.setViewportView(optionsViewPort);
		
		optionsFrame.getContentPane().add(optionsPanel);
	}
	
	private void addShortcutSection() {
		
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		scrollPane_1.setBounds(292, 11, 132, 234);
		
		panel_1.setPreferredSize(new Dimension(800, 1600));
		
		scrollPane_1.setViewportView(panel_1);
		panel_1.setLayout(null);
		
		System.out.println(scrollPane_1.getViewport().getSize());
		
		shortcut_L31.setBounds(0, 0, 55, 23);
		shortcut_L31.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(L31 != null) {
					foldersTextArea.setText(foldersTextArea.getText() + L31);	
					removeDuplicates();
				}
				
			}
		});
		panel_1.add(shortcut_L31);
		
		
		shortcut_L32.setBounds(58, 0, 55, 23);
		shortcut_L32.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(L32 != null) {
					foldersTextArea.setText(foldersTextArea.getText() + L32);	
					removeDuplicates();
				}
				
			}
		});
		panel_1.add(shortcut_L32);
		
		shortcut_L33.setBounds(0, 21, 55, 23);
		shortcut_L33.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(L33 != null) {
					foldersTextArea.setText(foldersTextArea.getText() + L33);	
					removeDuplicates();
				}
				
			}
		});
		panel_1.add(shortcut_L33);
		
		
		shortcut_L34.setBounds(58, 21, 55, 23);
		shortcut_L34.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(L34 != null) {
					foldersTextArea.setText(foldersTextArea.getText() + L34);	
					removeDuplicates();
				}
				
			}
		});
		panel_1.add(shortcut_L34);
		
		shortcut_L41.setBounds(0, 47, 49, 23);
		shortcut_L41.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(L41 != null) {
				foldersTextArea.setText(foldersTextArea.getText() + L41);
				removeDuplicates();
				
				}
			}
		});
		panel_1.add(shortcut_L41);
		
		shortcut_L42.setBounds(58, 47, 45, 23);
		panel_1.add(shortcut_L42);
		shortcut_L42.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(L42 != null) {
				foldersTextArea.setText(foldersTextArea.getText() + L42);
				removeDuplicates();
				}
			}
		});
		
		shortcut_L43.setBounds(0, 77, 49, 23);
		shortcut_L43.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
				if(L43 != null) {
				foldersTextArea.setText(foldersTextArea.getText() + L43);
				removeDuplicates();
				}
			}
		});
		panel_1.add(shortcut_L43);
		
		shortcut_L44.setBounds(58, 77, 45, 23);
		shortcut_L44.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(L44 != null) {
					foldersTextArea.setText(foldersTextArea.getText() + L44);
					removeDuplicates();
					}
			}
		});
		panel_1.add(shortcut_L44);
		
		shortcut_M31.setBounds(0, 103, 49, 23);
		shortcut_M31.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(M31 != null) {
				foldersTextArea.setText(foldersTextArea.getText() + M31);
				removeDuplicates();
				}
			}
		});
		panel_1.add(shortcut_M31);
		
		shortcut_M32.setBounds(58, 103, 49, 23);
		shortcut_M32.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(M32 != null) {
				foldersTextArea.setText(foldersTextArea.getText() + M32);
				removeDuplicates();
			}}
		});
		panel_1.add(shortcut_M32);
		
		shortcut_M33.setBounds(0, 129, 45, 23);
		shortcut_M33.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(M33 != null) {
				foldersTextArea.setText(foldersTextArea.getText() + M33);
				removeDuplicates();
			}}
		});
		panel_1.add(shortcut_M33);
		
		
		shortcut_M34.setBounds(58, 129, 49, 23);
		shortcut_M34.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(M34 != null) {
				foldersTextArea.setText(foldersTextArea.getText() + M34);
				removeDuplicates();
			}}
		});
		panel_1.add(shortcut_M34);
		
		
		
		shortcut_M41.setBounds(0, 159, 45, 23);
		shortcut_M41.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(M41 != null) {
				foldersTextArea.setText(foldersTextArea.getText() + M41);
				removeDuplicates();
			}}
		});
		panel_1.add(shortcut_M41);
		
		
		shortcut_M42.setBounds(58, 159, 49, 23);
		shortcut_M42.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(M42 != null) {
				foldersTextArea.setText(foldersTextArea.getText() + M42);
				removeDuplicates();
			}}
		});
		panel_1.add(shortcut_M42);
		
		
		shortcut_M43.setBounds(0, 185, 45, 23);
		shortcut_M43.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(M43 != null) {
				foldersTextArea.setText(foldersTextArea.getText() + M43);
				removeDuplicates();
			}}
		});
		panel_1.add(shortcut_M43);
		
		
		shortcut_M44.setBounds(58, 185, 49, 23);
		shortcut_M44.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(M44 != null) { //TODO: do the if -clause and add  && isselected
				foldersTextArea.setText(foldersTextArea.getText() + M44);
				removeDuplicates();
			}}
		});
		panel_1.add(shortcut_M44);
		
		shortcut_N31.setBounds(0, 211, 45, 23);
		shortcut_N31.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(N31 != null) {
				foldersTextArea.setText(foldersTextArea.getText() + N31);
				removeDuplicates();
			}}
		});
		panel_1.add(shortcut_N31);
		
		
		
		shortcut_N32.setBounds(58, 211, 49, 23);
		shortcut_N32.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(N32 != null) {
				foldersTextArea.setText(foldersTextArea.getText() + N32);
				removeDuplicates();
			}}
		});
		panel_1.add(shortcut_N32);
		
		shortcut_N33.setBounds(0, 237, 45, 23);
		shortcut_N33.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(N33 != null) {
				foldersTextArea.setText(foldersTextArea.getText() + N33);
				removeDuplicates();
			}}
		});
		panel_1.add(shortcut_N33);
		
		
		shortcut_N34.setBounds(58, 237, 49, 23);
		shortcut_N34.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(N34 != null) {
				foldersTextArea.setText(foldersTextArea.getText() + N34);
				removeDuplicates();
			}}
		});
		panel_1.add(shortcut_N34);
		
		
		shortcut_N41.setBounds(0, 271, 45, 23);
		shortcut_N41.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(N41 != null) {
				foldersTextArea.setText(foldersTextArea.getText() + N41);
				removeDuplicates();
			}}
		});
		panel_1.add(shortcut_N41);
		
		shortcut_N42.setBounds(58, 271, 49, 23);
		shortcut_N42.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(N42 != null) {
				foldersTextArea.setText(foldersTextArea.getText() + N42);
				removeDuplicates();
			}}
		});
		panel_1.add(shortcut_N42);
		
		
		shortcut_N43.setBounds(0, 297, 45, 23);
		shortcut_N43.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(N43 != null) {
				foldersTextArea.setText(foldersTextArea.getText() + N43);
				removeDuplicates();
			}}
		});
		panel_1.add(shortcut_N43);
		
		
		shortcut_N44.setBounds(58, 297, 49, 23);
		shortcut_N44.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(N44 != null) {
				foldersTextArea.setText(foldersTextArea.getText() + N44);
				removeDuplicates();
			}}
		});
		panel_1.add(shortcut_N44);
		
		
		shortcut_N51.setBounds(0, 323, 45, 23);
		shortcut_N51.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(N51 != null) {
				foldersTextArea.setText(foldersTextArea.getText() + N51);
				removeDuplicates();
			}}
		});
		
		panel_1.add(shortcut_N51);
		
		shortcut_N52.setBounds(58, 323, 49, 23);
		shortcut_N52.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(N52 != null) {
				foldersTextArea.setText(foldersTextArea.getText() + N52);
				removeDuplicates();
			}}
		});
		panel_1.add(shortcut_N52);
		
		shortcut_P31.setBounds(0, 349, 45, 23);
		shortcut_P31.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(P31 != null) {
				foldersTextArea.setText(foldersTextArea.getText() + P31);
				removeDuplicates();
			}}
		});
		
		panel_1.add(shortcut_P31);
		shortcut_P32.setBounds(58, 349, 49, 23);
		shortcut_P32.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(P32 != null) {
				foldersTextArea.setText(foldersTextArea.getText() + P32);
				removeDuplicates();
			}}
		});
		
		panel_1.add(shortcut_P32);
		
		shortcut_P33.setBounds(0, 375, 45, 23);
		shortcut_P33.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(P33 != null) {
				foldersTextArea.setText(foldersTextArea.getText() + P33);
				removeDuplicates();
			}}
		});
		panel_1.add(shortcut_P33);
		
		
		shortcut_P34.setBounds(58, 375, 49, 23);
		shortcut_P34.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(P34 != null) {
				foldersTextArea.setText(foldersTextArea.getText() + P34);
				removeDuplicates();
			}}
		});
		panel_1.add(shortcut_P34);
		
		
		shortcut_P41.setBounds(0, 401, 45, 23);
		shortcut_P41.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(P41 != null) {
				foldersTextArea.setText(foldersTextArea.getText() + P41);
				removeDuplicates();
			}}
		});
		panel_1.add(shortcut_P41);
		
		
		shortcut_P42.setBounds(58, 401, 49, 23);
		shortcut_P42.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(P42 != null) {
				foldersTextArea.setText(foldersTextArea.getText() + P42);
				removeDuplicates();
			}}
		});
		panel_1.add(shortcut_P42);
		
		
		shortcut_P43.setBounds(0, 427, 45, 23);
		shortcut_P43.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(P43 != null) {
				foldersTextArea.setText(foldersTextArea.getText() + P43);
				removeDuplicates();
			}}
		});
		panel_1.add(shortcut_P43);
		
		
		shortcut_P44.setBounds(58, 427, 49, 23);
		shortcut_P44.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(P44 != null) {
				foldersTextArea.setText(foldersTextArea.getText() + P44);
				removeDuplicates();
			}}
		});
		panel_1.add(shortcut_P44);
		
		
		shortcut_Q33.setBounds(0, 453, 45, 23);
		shortcut_Q33.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Q33 != null) {
				foldersTextArea.setText(foldersTextArea.getText() + Q33);
				removeDuplicates();
			}}
		});
		panel_1.add(shortcut_Q33);
		
		
		shortcut_Q41.setBounds(58, 453, 49, 23);
		shortcut_Q41.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Q41 != null) {
				foldersTextArea.setText(foldersTextArea.getText() + Q41);
				removeDuplicates();
			}}
		});
		panel_1.add(shortcut_Q41);
		
		shortcut_Q42.setBounds(0, 479, 45, 23);
		shortcut_Q42.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Q42 != null) {
				foldersTextArea.setText(foldersTextArea.getText() + Q42);
				removeDuplicates();
			}}
		});
		panel_1.add(shortcut_Q42);
		
		shortcut_Q43.setBounds(58, 479, 45, 23);
		shortcut_Q43.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Q43 != null) {
				foldersTextArea.setText(foldersTextArea.getText() + Q43);
				removeDuplicates();
			}}
		});
		panel_1.add(shortcut_Q43);
		
		shortcut_Q44.setBounds(0, 505, 45, 23);
		shortcut_Q44.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Q44 != null) {
				foldersTextArea.setText(foldersTextArea.getText() + Q44);
				removeDuplicates();
			}}
		});
		panel_1.add(shortcut_Q44);
		
		shortcut_R41.setBounds(58, 505, 49, 23);
		shortcut_R41.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(R41 != null) {
				foldersTextArea.setText(foldersTextArea.getText() + R41);
				removeDuplicates();
			}}
		});
		panel_1.add(shortcut_R41);
		
		shortcut_R42.setBounds(0, 531, 45, 23);
		shortcut_R42.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(R41 != null) {
				foldersTextArea.setText(foldersTextArea.getText() + R42);
				removeDuplicates();
			}}
		});
		panel_1.add(shortcut_R42);
		
		shortcut_R43.setBounds(58, 531, 45, 23);
		shortcut_R43.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(R43 != null) {
				foldersTextArea.setText(foldersTextArea.getText() + R43);
				removeDuplicates();
			}}
		});
		panel_1.add(shortcut_R43);
		
		shortcut_R44.setBounds(0, 556, 45, 23);
		shortcut_R44.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(R44 != null) {
				foldersTextArea.setText(foldersTextArea.getText() + R44);
				removeDuplicates();
			}}
		});
		panel_1.add(shortcut_R44);
		
		
		shortcut_R51.setBounds(58, 556, 45, 23);
		shortcut_R51.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(R51 != null) {
				foldersTextArea.setText(foldersTextArea.getText() + R51);
				removeDuplicates();
			}}
		});
		panel_1.add(shortcut_R51);
		
		shortcut_R52.setBounds(0, 582, 45, 23);
		shortcut_R52.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(R52 != null) {
				foldersTextArea.setText(foldersTextArea.getText() + R52);
				removeDuplicates();
			}}
		});
		panel_1.add(shortcut_R52);
		
		shortcut_R53.setBounds(58, 582, 45, 23);
		shortcut_R53.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(R53 != null) {
				foldersTextArea.setText(foldersTextArea.getText() + R53);
				removeDuplicates();
			}}
		});
		panel_1.add(shortcut_R53);
		
		shortcut_R54.setBounds(0, 608, 45, 23);
		shortcut_R54.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(R54 != null) {
				foldersTextArea.setText(foldersTextArea.getText() + R54);
				removeDuplicates();
			}}
		});
		panel_1.add(shortcut_R54);
		
		shortcut_S41.setBounds(58, 608, 45, 23);
		shortcut_S41.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(S41 != null) {
				foldersTextArea.setText(foldersTextArea.getText() + S41);
				removeDuplicates();
			}}
		});
		panel_1.add(shortcut_S41);
		
		shortcut_S42.setBounds(0, 634, 45, 23);
		shortcut_S42.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(S42 != null) {
				foldersTextArea.setText(foldersTextArea.getText() + S42);
				removeDuplicates();
			}}
		});
		panel_1.add(shortcut_S42);
		
		shortcut_S43.setBounds(58, 634, 45, 23);
		shortcut_S43.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(S43 != null) {
				foldersTextArea.setText(foldersTextArea.getText() + S43);
				removeDuplicates();
			}}
		});
		panel_1.add(shortcut_S43);
		
		shortcut_S44.setBounds(0, 650, 45, 23);
		shortcut_S44.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(S44 != null) {
				foldersTextArea.setText(foldersTextArea.getText() + S44);
				removeDuplicates();
			}}
		});
		panel_1.add(shortcut_S44);
		
		shortcut_S51.setBounds(58, 650, 45, 23);
		shortcut_S51.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(S51 != null) {
				foldersTextArea.setText(foldersTextArea.getText() + S51);
				removeDuplicates();
			}}
		});
		panel_1.add(shortcut_S51);
		
		shortcut_S52.setBounds(0, 676, 45, 23);
		shortcut_S52.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(S52 != null) {
				foldersTextArea.setText(foldersTextArea.getText() + S52);
				removeDuplicates();
			}}
		});
		panel_1.add(shortcut_S52);
		
		shortcut_S53.setBounds(58, 676, 45, 23);
		shortcut_S53.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(S53 != null) {
				foldersTextArea.setText(foldersTextArea.getText() + S53);
				removeDuplicates();
			}}
		});
		panel_1.add(shortcut_S53);
		
		shortcut_S54.setBounds(0, 702, 45, 23);
		shortcut_S54.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(S54 != null) {
				foldersTextArea.setText(foldersTextArea.getText() + S54);
				removeDuplicates();
			}}
		});
		panel_1.add(shortcut_S54);
		
		shortcut_T41.setBounds(58, 628, 45, 23);
		shortcut_T41.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(T41 != null) {
				foldersTextArea.setText(foldersTextArea.getText() + T41);
				removeDuplicates();
			}}
		});
		panel_1.add(shortcut_T41);
		
		shortcut_T42.setBounds(0, 654, 45, 23);
		shortcut_T42.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(T42 != null) {
				foldersTextArea.setText(foldersTextArea.getText() + T42);
				removeDuplicates();
			}}
		});
		panel_1.add(shortcut_T42);
		
		shortcut_T43.setBounds(58, 654, 45, 23);
		shortcut_T43.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(T43 != null) {
				foldersTextArea.setText(foldersTextArea.getText() + T43);
				removeDuplicates();
			}}
		});
		panel_1.add(shortcut_T43);
		
		shortcut_T44.setBounds(0, 680, 45, 23);
		shortcut_T44.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(T44 != null) {
				foldersTextArea.setText(foldersTextArea.getText() + T44);
				removeDuplicates();
			}}
		});
		panel_1.add(shortcut_T44);
		
		shortcut_T51.setBounds(58, 680, 45, 23);
		shortcut_T51.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(T51 != null) {
				foldersTextArea.setText(foldersTextArea.getText() + T51);
				removeDuplicates();
			}}
		});
		panel_1.add(shortcut_T51);
		
		shortcut_U41.setBounds(0, 706, 45, 23);
		shortcut_U41.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(U41 != null) {
				foldersTextArea.setText(foldersTextArea.getText() + U41);
				removeDuplicates();
			}}
		});
		panel_1.add(shortcut_U41);
		
		shortcut_U42.setBounds(58, 706, 45, 23);
		shortcut_U42.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(U42 != null) {
				foldersTextArea.setText(foldersTextArea.getText() + U42);
				removeDuplicates();
			}}
		});
		panel_1.add(shortcut_U42);
		
		shortcut_U43.setBounds(0, 732, 45, 23);
		shortcut_U43.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(U43 != null) {
				foldersTextArea.setText(foldersTextArea.getText() + U43);
				removeDuplicates();
			}}
		});
		panel_1.add(shortcut_U43);
		
		shortcut_U44.setBounds(58, 732, 45, 23);
		shortcut_U44.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(U44 != null) {
				foldersTextArea.setText(foldersTextArea.getText() + U44);
				removeDuplicates();
			}}
		});
		panel_1.add(shortcut_U44);
		
		
	}
	private void removeDuplicates() { //TODO: Make this to work and remove them after every click... Also comment more wtf this shit does :D
		
		String foldersString = foldersTextArea.getText().toString();
		foldersTextArea.setText("");
		String[] foldersArray = foldersString.split(this.separator);
		
		Set<String> stringArray = new TreeSet<String>();
		stringArray.addAll(Arrays.asList(foldersArray));
		
		foldersArray = stringArray.toArray(new String[stringArray.size()]);
		foldersString = "";
		for(int i = 0; i < foldersArray.length; i++) {
			foldersString += foldersArray[i] + "" + this.separator;
		}
		foldersTextArea.setText(foldersString);
	}
}
