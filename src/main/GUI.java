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
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.apache.commons.io.FileUtils;

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

}
