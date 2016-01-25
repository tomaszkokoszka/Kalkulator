import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Kalkulator extends JFrame implements ActionListener
{
	private JButton jbPrzelicz;
	private JLabel jlWiek, jlWzrost, jlWaga, jlAktywnoscFizyczna, jlWynik;
	private JComboBox jcbAktywnoscFizyczna;
	private JTextField jtWiek, jtWzrost, jtWaga;
	private ButtonGroup bgPlec; 
	private JRadioButton jrbKobieta, jrbMezczyzna;
	double tempWzrost, tempWaga, tempWiek, tempWynikK1, tempWynikK2, tempWynikM1, tempWynikM2;
	
	public Kalkulator()
	{
					
		setSize(450,450);
		setTitle("Kalkulator dietetyczny");
		setLayout(null);
		
		
		bgPlec = new ButtonGroup();
		jrbKobieta = new JRadioButton("Kobieta", true);
		jrbKobieta.setBounds(20,25,150,20);
		bgPlec.add(jrbKobieta);
		add(jrbKobieta);
		jrbKobieta.addActionListener(this);
		
		jrbMezczyzna = new JRadioButton("Mê¿czyzna", false);
		jrbMezczyzna.setBounds(180,25,150,20);
		bgPlec.add(jrbMezczyzna);
		add(jrbMezczyzna);
		jrbMezczyzna.addActionListener(this);
				
		jlWiek = new JLabel("Wiek [lat]:");
		jlWiek.setBounds(20,50,150,20);
		add(jlWiek);
		
		jlWzrost = new JLabel ("Wzrost [cm]:");
		jlWzrost.setBounds(20,75,150,20);
		add(jlWzrost);
		
		jlWaga = new JLabel("Waga [kg]");
		jlWaga.setBounds(20,100,150,20);
		add(jlWaga);
		
		jlAktywnoscFizyczna = new JLabel("Aktywnoœæ fizyczna:");
		jlAktywnoscFizyczna.setBounds(20,125,150,20);
		add(jlAktywnoscFizyczna);
		
		jtWiek = new JTextField("");
		jtWiek.setBounds(180,50,175,20);
		add(jtWiek);
		
		jtWzrost = new JTextField("");
		jtWzrost.setBounds(180,75,175,20);
		add(jtWzrost);
		
		jtWaga = new JTextField("");
		jtWaga.setBounds(180,100,175,20);
		add(jtWaga);
		
		jcbAktywnoscFizyczna = new JComboBox();
		jcbAktywnoscFizyczna.setBounds(180,125,175,20);
		add(jcbAktywnoscFizyczna);
		jcbAktywnoscFizyczna.addItem("Praca lekka");
		jcbAktywnoscFizyczna.addItem("Praca umiarkowana");
		jcbAktywnoscFizyczna.addItem("Praca ciê¿ka");
		jcbAktywnoscFizyczna.addActionListener(this);
		
		jbPrzelicz = new JButton("Przelicz");
		jbPrzelicz.setBounds(115,190,100,20);
		add(jbPrzelicz);
		jbPrzelicz.addActionListener(this);
		
		jlWynik = new JLabel("Wynik");
		jlWynik.setBounds(180,220,100,20);
		add(jlWynik);
		
	}

	public static void main(String[] args) 
	{
		Kalkulator calc = new Kalkulator();
		calc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		calc.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		Object a = e.getSource();
		if (a==jbPrzelicz)
		{
				
			if (jrbKobieta.isSelected()==true)
			{
				tempWaga = Double.parseDouble(jtWaga.getText());
				tempWiek = Double.parseDouble(jtWiek.getText());
				tempWzrost = Double.parseDouble(jtWzrost.getText());
				
				tempWynikK1 = 66.47 + (13.75 + tempWaga)+(5 * tempWzrost)-(6.75 * tempWiek);
				
					String akcja = jcbAktywnoscFizyczna.getSelectedItem().toString();
					if (akcja.equals("Praca lekka"))
							{
						tempWynikK2 = tempWynikK1 * 1.4;
						jlWynik.setText(String.valueOf(tempWynikK2));
							}
					else if (akcja.equals("Praca umiarkowana"))
					{
						tempWynikK2 = tempWynikK1 * 1.7;
						jlWynik.setText(String.valueOf(tempWynikK2));
					}
					else if (akcja.equals("Praca ciê¿ka"))
					{
						tempWynikK2 = tempWynikK1 * 2;
						jlWynik.setText(String.valueOf(tempWynikK2));
					}
			}
			
			else if (jrbMezczyzna.isSelected()==true)
			{
				tempWaga = Double.parseDouble(jtWaga.getText());
				tempWiek = Double.parseDouble(jtWiek.getText());
				tempWzrost = Double.parseDouble(jtWzrost.getText());
				
				tempWynikM1 = 665.1 + (9.56 * tempWaga) + (1.85 * tempWzrost)- (4.68 * tempWiek);
				
					String akcja = jcbAktywnoscFizyczna.getSelectedItem().toString();
					if (akcja.equals("Praca lekka"))
							{
						tempWynikM2 = tempWynikM1 * 1.4;
						jlWynik.setText(String.valueOf(tempWynikM2));
							}
					else if (akcja.equals("Praca umiarkowana"))
					{
						tempWynikM2 = tempWynikM1 * 1.7;
						jlWynik.setText(String.valueOf(tempWynikM2));
					}
					else if (akcja.equals("Praca ciê¿ka"))
					{
						tempWynikM2 = tempWynikM1 * 2;
						jlWynik.setText(String.valueOf(tempWynikM2));
					}
			}
				
			
		}
	
	}

}
