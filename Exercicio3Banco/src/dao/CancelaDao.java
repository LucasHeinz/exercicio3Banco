package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.*;

public class CancelaDao {

	private final Connection con;

	public CancelaDao(Connection con) {
		this.con = con;
	}

	public List<Cancela> lista() throws SQLException {
		List<Cancela> lCancela = new ArrayList<Cancela>();

		String sql = "SELECT * FROM CANCELA";

		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.execute();
			try (ResultSet rs = stmt.getResultSet()) {
				while (rs.next()) {
					 int id = rs.getInt("codigo");
					 String nome = rs.getString("nome");
					 Boolean posicao = rs.getBoolean("status");

					Cancela cancela = new Cancela(id, nome, posicao);
					lCancela.add(cancela);
				}
			}
		}

		return lCancela;
	}

	public boolean inserir(Cancela cancela) throws SQLException {
		String sql = "INSERT INTO CANCELA (CODIGO, NOME, STATUS) VALUES (SEQ_CANCELA.nextval, ?, ?)";

		PreparedStatement statement = con.prepareStatement(sql);
		statement.setString(1, cancela.getNome());
		statement.setBoolean(2, cancela.isAberta());

		return statement.executeUpdate() > 0;
	}

	public boolean abrir(Integer codigo) throws SQLException {
		String sql = "UPDATE CANCELA SET  STATUS = 1 WHERE CODIGO = ?";

		PreparedStatement statement = con.prepareStatement(sql);
		statement.setInt(1, codigo);

		return statement.executeUpdate() > 0;
	}

	public boolean fechar(Integer codigo) throws SQLException {
		String sql = "UPDATE CANCELA SET  STATUS = 0 WHERE CODIGO = ?";

		PreparedStatement statement = con.prepareStatement(sql);
		statement.setInt(1, codigo);

		return statement.executeUpdate() > 0;
	}
	
	public boolean excluir(int id) throws SQLException{
		String sql = "DELETE CANCELA WHERE CODIGO = ?";
		 
		PreparedStatement statement = con.prepareStatement(sql);
		statement.setInt(1, id);
		 
		return statement.executeUpdate() > 0;
	}
} 
