package projeto.redesocial;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tela_Principal {

	private JFrame frame;
	protected JTextPane txt_Dados;
	private JLabel lbl_Id_User;
	private JLabel lbl_User;
	private static int Id_UsuarioLogado; // variavel para armazenar o id do usuario logado
		
	
	   public Tela_Principal(int id_UsuarioLogado) {
	        Id_UsuarioLogado = id_UsuarioLogado;
	        initialize();
	    }
	
	//retornando o ID do usuario logado
	public int getId_UsuarioLogado() {
	    return this.Id_UsuarioLogado;
	}

	public void setId_UsuarioLogado(int id_UsuarioLogado) {
		Id_UsuarioLogado = id_UsuarioLogado;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_Principal window = new Tela_Principal();
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
	public Tela_Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Rede Social");
		frame.setBounds(100, 100, 503, 672);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lbl_User = new JLabel("[nome do usuario]");
		lbl_User.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_User.setFont(new Font("Comic Sans MS", Font.BOLD, 19));
		lbl_User.setBounds(128, 109, 233, 24);
		frame.getContentPane().add(lbl_User);
		
		JLabel lbl_Id = new JLabel("ID:");
		lbl_Id.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lbl_Id.setBounds(380, 26, 45, 13);
		frame.getContentPane().add(lbl_Id);
		
		lbl_Id_User = new JLabel("");
		lbl_Id_User.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lbl_Id_User.setBounds(413, 26, 66, 13);
		frame.getContentPane().add(lbl_Id_User);
		
		JLabel lbl_RedeSocial = new JLabel("Rede Social");
		lbl_RedeSocial.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 27));
		lbl_RedeSocial.setBounds(160, 49, 162, 43);
		frame.getContentPane().add(lbl_RedeSocial);
		
		txt_Dados = new JTextPane();
		txt_Dados.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		txt_Dados.setEditable(false);
		txt_Dados.setBounds(66, 199, 359, 161);
		frame.getContentPane().add(txt_Dados);
		
		JLabel lbl_Dados = new JLabel("Seus dados:");
		lbl_Dados.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_Dados.setFont(new Font("Comic Sans MS", Font.BOLD, 19));
		lbl_Dados.setBounds(66, 165, 233, 24);
		frame.getContentPane().add(lbl_Dados);
		
		JButton btn_Amigos = new JButton("AMIGOS");
		btn_Amigos.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        Tela_Amigos telaAmigos = new Tela_Amigos(getId_UsuarioLogado());//Passando por parametro o id do usuario logado
		        telaAmigos.setVisible(true);
		    }
		});
		btn_Amigos.setFont(new Font("Comic Sans MS", Font.BOLD, 19));
		btn_Amigos.setBounds(52, 384, 181, 50);
		frame.getContentPane().add(btn_Amigos);
		
		JButton btn_Adicionar = new JButton("<html>ADICIONAR <br>   AMIGOS</html>");//quebrando linha dentro do botao
		btn_Adicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela_AdicionarAmigo telaAdicionarAmigo = new Tela_AdicionarAmigo();
				telaAdicionarAmigo.setIdUsuario(getId_UsuarioLogado()); // passando por parametro o id do usuario logado
				telaAdicionarAmigo.setVisible(true);
			}
		});
		btn_Adicionar.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		btn_Adicionar.setBounds(244, 384, 181, 50);
		frame.getContentPane().add(btn_Adicionar);
		
		JButton btn_Mensagem = new JButton("MENSAGENS");
		btn_Mensagem.setFont(new Font("Comic Sans MS", Font.BOLD, 19));
		btn_Mensagem.setBounds(52, 455, 181, 50);
		frame.getContentPane().add(btn_Mensagem);
		
		JButton btn_Logoff = new JButton("SAIR");
		btn_Logoff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btn_Logoff.setFont(new Font("Comic Sans MS", Font.BOLD, 19));
		btn_Logoff.setBounds(244, 545, 181, 50);
		frame.getContentPane().add(btn_Logoff);
		
		JButton btn_EditarPerfil = new JButton("<html>EDITAR<br> PERFIL</html>");
		btn_EditarPerfil.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	Tela_EditarPerfil editarPerfil = new Tela_EditarPerfil(getId_UsuarioLogado());
                editarPerfil.setVisible(true);
            }
        });
		btn_EditarPerfil.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		btn_EditarPerfil.setBounds(244, 455, 181, 50);
		frame.getContentPane().add(btn_EditarPerfil);
	}
	
	/*
	 * Metodo para iniciar a tela principal
	 * Este metodo esta recebendo o objeto do usuario que logou e a tela principal
	 * Neste metodo estamos deixando a tela principal com os dados do usuario que esta logado
	 * 
	 */
	public void exibirTelaPrincipal(Perfil perfilUsuario, Tela_Principal telaPrincipal) {
		this.txt_Dados.setText("Usuário: " + perfilUsuario.getNome() + "\nE-mail:" + perfilUsuario.getEmail() + "\nEndereco:" + perfilUsuario.getEndereco() + "\nUsuario criado em: " + perfilUsuario.getDta_criacao());
		this.lbl_Id_User.setText(""+perfilUsuario.getId());
		Id_UsuarioLogado = perfilUsuario.getId(); //recebendo o valor do usuario logado
		this.lbl_User.setText(perfilUsuario.getNome());
		telaPrincipal.setId_UsuarioLogado(Id_UsuarioLogado);
		telaPrincipal.frame.setVisible(true);
	}

	void setVisible(boolean b) {
		frame.setVisible(true);
	}
}
