import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConverterUI extends JFrame {
	private JPanel upperPart, lowerPart;
	private JButton convertButton, clearButton;
	private UnitConverter unitconverter;
	private JTextField inputField1, inputField2;
	private JLabel equalSymbol;
	private JComboBox<Unit> unit1ComboBox, unit2ComboBox;
	private ButtonGroup directionGroup;
	private JRadioButton direction1, direction2;

	public ConverterUI(UnitConverter uc) {
		unitconverter = uc;

		this.setTitle("Length Converter");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		initComponents();
	}

	private void initComponents() {
		upperPart = new JPanel();
		lowerPart = new JPanel();

		convertButton = new JButton("Convert!");
		ActionListener listener = new ConvertButtonListener();
		convertButton.addActionListener(listener);

		clearButton = new JButton("Clear");
		clearButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				clearField();
			}
		});

		inputField1 = new JTextField(10);
		inputField1.addActionListener(new ConvertButtonListener());

		inputField2 = new JTextField(10);
		inputField2.addActionListener(new ConvertButtonListener());
		inputField2.setEditable(false);

		equalSymbol = new JLabel("=");

		Unit[] lengths = unitconverter.getUnits();
		unit1ComboBox = new JComboBox<Unit>(lengths);
		unit2ComboBox = new JComboBox<Unit>(lengths);

		direction1 = new JRadioButton("Left->Right");
		direction1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				changeDirectionLeftToRight();
			}
		});

		direction2 = new JRadioButton("Right->Left");
		direction2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				changeDirectionRightToLeft();
			}
		});

		directionGroup = new ButtonGroup();
		directionGroup.add(direction1);
		directionGroup.add(direction2);

		this.setLayout(new BorderLayout());
		this.add(upperPart, BorderLayout.NORTH);
		this.add(lowerPart, BorderLayout.SOUTH);
		upperPart.add(inputField1);
		upperPart.add(unit1ComboBox);
		upperPart.add(equalSymbol);
		upperPart.add(inputField2);
		upperPart.add(unit2ComboBox);
		upperPart.add(convertButton);
		upperPart.add(clearButton);
		lowerPart.add(direction1);
		lowerPart.add(direction2);

	}

	private void changeDirectionLeftToRight() {
		inputField2.setEditable(false);
		inputField1.setEditable(true);
	}

	private void changeDirectionRightToLeft() {
		inputField2.setEditable(true);
		inputField1.setEditable(false);
	}

	private void clearField() {
		inputField2.setText("");
		inputField1.setText("");
	}
	
	public void run() {
		setVisible(true);
		pack();
	}

	class ConvertButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent evt) {
			String s;
			if (direction2.isSelected() || evt.getSource() == inputField2)
				s = inputField2.getText().trim();
			else
				s = inputField1.getText().trim();

			if (s.length() > 0) {
				try {
					double resultValue;
					double value = Double.valueOf(s);
					Unit unit1 = (Unit) unit1ComboBox.getSelectedItem();
					Unit unit2 = (Unit) unit2ComboBox.getSelectedItem();
					if (direction2.isSelected()|| evt.getSource() == inputField2) {
						resultValue = unitconverter.convert(value, unit2, unit1);
						inputField1.setText(String.format("%.6f", resultValue));
						inputField1.setEditable(false);
					} else {
						resultValue = unitconverter.convert(value, unit1, unit2);
						inputField2.setText(String.format("%.6f", resultValue));
						inputField2.setEditable(false);
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Please input the number");
				}
			}
		}
	}
}