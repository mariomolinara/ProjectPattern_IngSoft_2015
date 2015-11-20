package it.uniclam.projectpattern.gui;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import it.uniclam.projectpattern.ClientMainGUI;
import it.uniclam.projectpattern.ServerMain;

public class NavigationPanel extends JPanel {
	
	private JButton cercaAmici = new JButton(ClientMainGUI.CERCA_AMICI_PANEL);
	private JButton inserisciAmici = new JButton(ClientMainGUI.INSERISCI_AMICI_PANEL);
	private JButton settings = new JButton(ClientMainGUI.SETTINGS_PANEL);
	private ClientMainGUI clientGUI = null;
	
	public NavigationPanel(ClientMainGUI clientGUI){
		setLayout(new FlowLayout());
		add(cercaAmici);
		add(inserisciAmici);
		add(settings);
		this.clientGUI = clientGUI;
		
		cercaAmici.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clientGUI.changePanel(ClientMainGUI.CERCA_AMICI_PANEL);
			}
		});
		inserisciAmici.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clientGUI.changePanel(ClientMainGUI.INSERISCI_AMICI_PANEL);
				
			}
		});
		
		settings.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clientGUI.changePanel(ClientMainGUI.SETTINGS_PANEL);
			}
		});
		
	}
}
