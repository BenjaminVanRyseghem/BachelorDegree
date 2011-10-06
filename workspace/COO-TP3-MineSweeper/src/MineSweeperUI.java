
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;


public class MineSweeperUI implements Observer {

	protected MineSweeper model;
	protected JFrame frame;
	protected JLabel label;
	protected JPanel panel;
	protected JDialog dialog;
	
	private String newGameString = "New Game";
	private String exitString = "Exit";
	private String configurationString = "Configuration";
	
	public MineSweeperUI(MineSweeper model){
		model.addObserver(this);
		label = new JLabel();
		label.setHorizontalAlignment(JLabel.CENTER);
		panel = new JPanel();
		dialog = new JDialog(frame, "Configuration", true);
		dialog.setLayout(new GridLayout(7,1));
		this.model = model;
		this.setFrame();
	}

	protected void resetUI(){
		Container container = frame.getContentPane();
		container.removeAll();
		container.add(label,BorderLayout.NORTH);
		container.add(panel,BorderLayout.CENTER);
		this.frame.pack();
	}
	
	protected void setFrame(){
		frame = new JFrame("Minesweeper");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		this.fillUpPanel();
		label.setText(model.currentBombs+"");
		this.resetUI();
		frame.setResizable(false);
		
		label.setSize(30,frame.getWidth());
		
		JMenuBar menu = this.buildMenu();
		frame.setJMenuBar(menu);
		frame.pack();
		frame.setVisible(true);
	}
	
	
	private class MenuActionListener implements ActionListener {
		
		private MineSweeper model;	
		
		private MenuActionListener(MineSweeper model){
			this.model = model;
		}
		
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals(newGameString)){
				model.newGame();
				return;
			}
			if(e.getActionCommand().equals(exitString)){
				System.exit(0);
			}
			if(e.getActionCommand().equals(configurationString)){
				MineSweeperUI.this.openConfigurationDialog();
				return;
			}
		}
	}
	
	protected void openConfigurationDialog(){
		Container container = dialog.getContentPane();
		container.removeAll();
		JButton buttonOK = new JButton("OK");
		final JTextField width = new JTextField(""+this.model.width);
		final JTextField height = new JTextField(""+this.model.height);
		final JTextField bombs = new JTextField(""+this.model.maxBombs);

		
		buttonOK.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
						try{
							int newWidth = Integer.parseInt(width.getText());
							MineSweeperUI.this.model.width = newWidth;
						}catch(Exception exc){}
						try{
							int newHeight = Integer.parseInt(height.getText());
							MineSweeperUI.this.model.height = newHeight;
						}catch(Exception exc){}
						try{
							int newBombs = Integer.parseInt(bombs.getText());
							MineSweeperUI.this.model.maxBombs = newBombs;
						}catch(Exception exc){}
						
						MineSweeperUI.this.dialog.setVisible(false);
					}
				});
		
		container.add(new JLabel("Width:"));
		container.add(width);
		container.add(new JLabel("Height:"));
		container.add(height);
		container.add(new JLabel("Number of Bombs:"));
		container.add(bombs);
		container.add(buttonOK);
		dialog.pack();
		dialog.setVisible(true);
		
		
	}
	
	
	protected JMenuBar buildMenu(){
		JMenuBar menu = new JMenuBar();
		JMenu game = new JMenu("Game");
		game.setMnemonic(KeyEvent.VK_G);
		
		JMenuItem newGame = new JMenuItem(newGameString,KeyEvent.VK_N);
		newGame.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.ALT_MASK));
		newGame.addActionListener(new MenuActionListener(this.model));
		
		JMenuItem exit = new JMenuItem(exitString,KeyEvent.VK_X);
		exit.addActionListener(new MenuActionListener(this.model));
		
		JMenuItem configuration = new JMenuItem(configurationString,KeyEvent.VK_C);
		configuration.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.ALT_MASK));
		configuration.addActionListener(new MenuActionListener(this.model));
		
		
		game.add(newGame);
		game.add(configuration);
		menu.add(game);
		menu.add(exit);
		
		
		
		return menu;
	}
	
	protected void clickFrom(int x, int y, boolean isLeftClick, CellButton sender){
		
		this.model.clickOn(x, y, isLeftClick, sender);
	}
	
	protected void fillUpPanel(){
		panel.removeAll();
		panel.setLayout(new GridLayout(model.getHeight(), model.getWidth(),0,0));
	//	Container container = frame.getContentPane();
		Cell[][] cells = model.getCells();
		int width = model.getWidth();
		int height = model.getHeight();
		
		for (int y = 0; y < height ; y++){
			for (int x = 0 ; x < width ; x++){
				Cell cell = cells[x][y];
				panel.add(new CellButton(this, cell));
			}
		}
	}
	 

	@Override
	public void update(Observable o, Object arg) {
		if(arg.equals(newGameString)){
			this.fillUpPanel();
			this.resetUI();
		}
		frame.repaint();
		if (model.gameIsFinished){
			if(model.win){
				label.setText("YOU WIN");
			}
			else{
				label.setText("YOU LOSE");
			}
		}
		else{
			label.setText(model.currentBombs+"");
		}
	}

	
}
