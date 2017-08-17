package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jdbc.ConnectionPoolOracle;
import model.*;
import dao.CancelaDao;

public class CancelaService {

	public void inserir(Cancela cancela) throws SQLException{
		try (Connection con = new ConnectionPoolOracle().getConnection()) {
			new CancelaDao(con).inserir(cancela);
		}
	}
	
	public void abrir(Integer codigo) throws SQLException{
		try (Connection con = new ConnectionPoolOracle().getConnection()) {
			new CancelaDao(con).abrir(codigo);
		}
	}
	
	public void fechar(Integer codigo) throws SQLException{
		try (Connection con = new ConnectionPoolOracle().getConnection()) {
			new CancelaDao(con).fechar(codigo);
		}
	}
	
	public void excluir(Integer codigo) throws SQLException{
		try (Connection con = new ConnectionPoolOracle().getConnection()) {
			new CancelaDao(con).excluir(codigo);
		}
	}

	public List<Cancela> lista() throws SQLException{
		try (Connection con = new ConnectionPoolOracle().getConnection()) {
            return new CancelaDao(con).lista();
		}
	}
}
