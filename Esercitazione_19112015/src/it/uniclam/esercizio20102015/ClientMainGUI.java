package it.uniclam.esercizio20102015;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.channels.SelectableChannel;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import it.uniclam.esercizio20102015.gui.CercaAmiciPanel;
import it.uniclam.esercizio20102015.gui.InserisciAmiciPanel;
import it.uniclam.esercizio20102015.gui.NavigationPanel;
import it.uniclam.esercizio20102015.gui.SettingsPanel;

public class ClientMainGUI extends JFrame {
	
	JPanel lastPanel = null;
	
	public static String CERCA_AMICI_PANEL = "Cerca Amici";
	public static String INSERISCI_AMICI_PANEL = "Inserisci Amici";
	public static String SETTINGS_PANEL = "Settings";
	
	private CercaAmiciPanel cercaAmiciPanel;
	private InserisciAmiciPanel inserisciAmiciPanel;
	private NavigationPanel navigationPanel;
	private SettingsPanel settingsPanel;
	
	
	public ClientMainGUI(){
		super("Client GUI for db Amici");
	
		cercaAmiciPanel = new CercaAmiciPanel(this);
		inserisciAmiciPanel = new InserisciAmiciPanel(this);
		navigationPanel = new NavigationPanel(this);
		settingsPanel = new SettingsPanel(this);
		
		changePanel(ClientMainGUI.CERCA_AMICI_PANEL);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		pack();
		setVisible(true);

	}

	public void changePanel(String panelName){

		getContentPane().removeAll();
		
		if (panelName.equals(ClientMainGUI.CERCA_AMICI_PANEL)){
			cercaAmiciPanel = new CercaAmiciPanel(this);
			lastPanel = cercaAmiciPanel;
		} else if (panelName.equals(ClientMainGUI.INSERISCI_AMICI_PANEL)){
			inserisciAmiciPanel = new InserisciAmiciPanel(this);
			lastPanel = inserisciAmiciPanel;
		} else if (panelName.equals(ClientMainGUI.SETTINGS_PANEL)){
			settingsPanel = new SettingsPanel(this);
			lastPanel = settingsPanel;
		}

		navigationPanel = new NavigationPanel(this);
		
		getContentPane().add(lastPanel, BorderLayout.CENTER);
		getContentPane().add(navigationPanel, BorderLayout.SOUTH);
		
		getContentPane().revalidate();
	
	}
	
	
	
    public static void main(String[] args) {
        /* Use an appropriate Look and Feel */
        try {
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        /* Turn off metal's use of bold fonts */
        UIManager.put("swing.boldMetal", Boolean.FALSE);
         
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	ClientMainGUI frame = new ClientMainGUI();
            }
        });
    }
    

}
