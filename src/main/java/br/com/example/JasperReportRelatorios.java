package br.com.example;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.example.entity.Cliente;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;


public class JasperReportRelatorios {

	public static void main(String[] args) throws JRException, SQLException {

		System.out.println("Gerando relatorio...");
		// lista com os nossos clientes.
		List<Cliente> lista = new ArrayList<Cliente>();
		
		Cliente c1 = new Cliente();
		c1.setNome("Alexandre Macedo");
		c1.setEmail("alexbmac@gmail.com");
		
		Cliente c2 = new Cliente();
		c2.setNome("Rafael Cosentino");
		c2.setEmail("cosen@gmail.com");
		
		Cliente c3 = new Cliente();
		c3.setNome("Daniel Machado");
		c3.setEmail("daniel@gmail.com");
		
		lista.add(c1);
		lista.add(c2);
		lista.add(c3);

		// * Opcional
		// Map<String, Object> com os nossos parametros.
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("codigo", 123545);
		parametros.put("nome", "abcdef");

		
		// compilacao do JRXML
		JasperReport report = JasperCompileManager.compileReport("src/main/resources/JasperReportRelatorioClientes.jrxml");
		
		// Preenchimento do relatorio, note que o metodo recebe 3 parametros: 
		// 1 - O relatorio 
		// 
		// 2 - Um Map, com parametros que sao passados ao relatorio no momento do preenchimento.
		//     No nosso caso eh 'parametros' mas pode-se passar NULL.
		// 
		// 3 - O data source. Note que nao devemos passar a lista diretamente, 
		// e sim "transformar" em um data source utilizando a classe JRBeanCollectionDataSource
		JasperPrint print = JasperFillManager.fillReport(report, parametros, new JRBeanCollectionDataSource(lista));
		
		// Exportacao do relatorio para outro formato, no caso PDF.
		JasperExportManager.exportReportToPdfFile(print, "src/main/resources/JasperReportRelatorioClientes.pdf");
		
		System.out.println("Relatorio gerado.");
		
		// * Opcional
		// Usado para abrir o 'JasperPrint'.
		JasperViewer viewer = new JasperViewer(print);     
        viewer.setVisible(true);   
	}

}
