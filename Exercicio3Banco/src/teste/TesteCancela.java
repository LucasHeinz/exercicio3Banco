package teste;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import service.CancelaService;
import jdbc.ConnectionPoolOracle;
import model.Cancela;

public class TesteCancela {

	public static void main(String[] args) throws SQLException {
		
		try(Connection con = new ConnectionPoolOracle().getConnection()) {
			CancelaService cancelaService = new CancelaService();
			Cancela cancela = new Cancela(false, "Meio");
			cancelaService.inserir(cancela);
			
			cancelaService.abrir(4);
			cancelaService.fechar(4);
			
			List<Cancela> lCancela = cancelaService.lista(); 
			for (Cancela can : lCancela) {
				System.out.println(can.toString());
			}
			
			cancelaService.excluir(2);
		}
	}
}
