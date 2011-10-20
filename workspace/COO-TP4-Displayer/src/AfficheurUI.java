import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;



public class AfficheurUI implements Observer {

	
	protected JButton setMessageButton;
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		label.setText(model.toString());
	}

	/**
	 * @uml.property  name="frame"
	 */
	private JFrame frame;

	/**
	 * Getter of the property <tt>frame</tt>
	 * @return  Returns the frame.
	 * @uml.property  name="frame"
	 */
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * Setter of the property <tt>frame</tt>
	 * @param frame  The frame to set.
	 * @uml.property  name="frame"
	 */
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	/**
	 * @uml.property  name="label"
	 */
	private JLabel label;

	/**
	 * Getter of the property <tt>label</tt>
	 * @return  Returns the label.
	 * @uml.property  name="label"
	 */
	public JLabel getLabel() {
		return label;
	}

	/**
	 * Setter of the property <tt>label</tt>
	 * @param label  The label to set.
	 * @uml.property  name="label"
	 */
	public void setLabel(JLabel label) {
		this.label = label;
	}

	/**
	 * @uml.property  name="button"
	 */
	private JButton decaleButton;

	/**
	 * Getter of the property <tt>button</tt>
	 * @return  Returns the button.
	 * @uml.property  name="button"
	 */
	public JButton getButton() {
		return decaleButton;
	}

	/**
	 * Setter of the property <tt>button</tt>
	 * @param button  The button to set.
	 * @uml.property  name="button"
	 */
	public void setButton(JButton button) {
		this.decaleButton = button;
	}

	/**
	 * @uml.property  name="textField"
	 */
	private JTextField textField;

	/**
	 * Getter of the property <tt>textField</tt>
	 * @return  Returns the textField.
	 * @uml.property  name="textField"
	 */
	public JTextField getTextField() {
		return textField;
	}

	/**
	 * Setter of the property <tt>textField</tt>
	 * @param textField  The textField to set.
	 * @uml.property  name="textField"
	 */
	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	/**
	 * @uml.property  name="model"
	 */
	private Afficheur model;

	/**
	 * Getter of the property <tt>model</tt>
	 * @return  Returns the model.
	 * @uml.property  name="model"
	 */
	public Afficheur getModel() {
		return model;
	}

	/**
	 * Setter of the property <tt>model</tt>
	 * @param model  The model to set.
	 * @uml.property  name="model"
	 */
	public void setModel(Afficheur model) {
		this.model = model;
	}

		
		/**
		 */
		public AfficheurUI(Afficheur model){
			this.setModel(model); 
			model.addObserver(this);
			frame = new JFrame("Toc ?");
			label = new JLabel(model+"");
			textField = new JTextField();
			decaleButton = new JButton("top");
			setMessageButton = new JButton("set message");
			
			decaleButton.addMouseListener(new MouseAdapter(){ public void mouseClicked(MouseEvent e){ AfficheurUI.this.model.decale(); }});
			
			setMessageButton.addMouseListener(new MouseAdapter(){ public void mouseClicked(MouseEvent e){ AfficheurUI.this.model.setMessage(AfficheurUI.this.textField.getText()); }});
			
			Container container = frame.getContentPane();
			container.setLayout(new GridLayout(5,1));
			
			container.add(textField);
			container.add(setMessageButton);
			container.add(label);
			container.add(decaleButton);
			
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.pack();
			frame.setVisible(true);
		}
		
		public static void main(String[] args) {
			Afficheur model = new Afficheur(5, "Benjamin", " ");
			AfficheurUI ui = new AfficheurUI(model);
		}
		

}

