package sistema;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.GridLayout;
import java.util.LinkedList;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import conexaoBanco.GestaoDeConexao;
import conexaoBanco.ManipularGenero;
import conexaoBanco.ManipularJogo;
import dados.Genero;
import dados.Jogos;

import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.awt.event.ActionEvent;

public class CadastroJogo extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroJogo frame = new CadastroJogo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CadastroJogo() {
		setBounds(100, 100, 450, 152);
		getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(new MigLayout("", "[][grow][]", "[][][][]"));
		
		JLabel lblNewLabel = new JLabel("Nome:");
		panel.add(lblNewLabel, "cell 0 0,alignx trailing");
		
		textField = new JTextField();
		panel.add(textField, "cell 1 0 2 1,growx");
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Pre\u00E7o:");
		panel.add(lblNewLabel_1, "cell 0 1,alignx trailing");
		
		//NumberFormat ffield = NumberFormat.getNumberInstance();
		JFormattedTextField formattedTextField = new JFormattedTextField();		
		panel.add(formattedTextField, "cell 1 1 2 1,growx");
		
		JLabel lblNewLabel_2 = new JLabel("Genero:");
		panel.add(lblNewLabel_2, "cell 0 2,alignx trailing");
		
		JComboBox<Genero> comboBox = new JComboBox<>();
		this.populateComboBox(comboBox);
		panel.add(comboBox, "cell 1 2 2 1,growx");
		
		JButton btnNewButton = new JButton("Salvar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Jogos j = new Jogos(textField.getText(), Float.parseFloat(formattedTextField.getText()), comboBox.getItemAt(comboBox.getSelectedIndex()));
				ManipularJogo mj = new ManipularJogo(GestaoDeConexao.constuirConexao(), j);
				if (mj.salvar()) {
					JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
				}else {
					JOptionPane.showMessageDialog(null, "Erro ao salvar!");
				}
			}
		});
		panel.add(btnNewButton, "cell 1 3,alignx right");
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		panel.add(btnNewButton_1, "cell 2 3");

	}
	
	private void populateComboBox(JComboBox<Genero> jcb) {
		LinkedList<Genero> llg = ManipularGenero.getAll();
		for (Genero genero : llg) {
			jcb.addItem(genero);
		}
	}

}
