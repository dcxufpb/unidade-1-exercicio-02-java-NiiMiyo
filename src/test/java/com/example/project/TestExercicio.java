package com.example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.io.*;

public class TestExercicio {

	private static String BREAK = System.lineSeparator();

	@Test
	public void exercicio01() {
		rodarTestarOutput("Arcos Dourados Com. de Alimentos LTDA" + BREAK + 
				"Av. Projetada Leste, 500 EUC F32/33/34" + BREAK + 
				"Br. Sta Genebra - Campinas - SP" + BREAK + 
				"CEP:13080-395 Tel (19) 3756-7408" + BREAK + 
				"Loja 1317 (PDP)" + BREAK + 
				"CNPJ: 42.591.651/0797-34" + BREAK + 
				"IE: 244.898.500.113" + BREAK);
	}
	
	@Test
	public void exercicio02_tudoVazio() {
		CupomFiscal.NOME_LOJA = "";
		CupomFiscal.LOGRADOURO = "";
		CupomFiscal.NUMERO = 0;
		CupomFiscal.COMPLEMENTO = "";
		CupomFiscal.BAIRRO = "";
		CupomFiscal.MUNICIPIO = "";
		CupomFiscal.ESTADO = "";
		CupomFiscal.CEP = "";
		CupomFiscal.TELEFONE = "";
		CupomFiscal.OBSERVACAO = "";
		CupomFiscal.CNPJ = "";
		CupomFiscal.INSCRICAO_ESTADUAL = "";
		
		rodarTestarOutput("" + BREAK + 
				", 0 " + BREAK + 
				" -  - " + BREAK + 
				"CEP: Tel " + BREAK + 
				"" + BREAK + 
				"CNPJ: " + BREAK + 
				"IE: " + BREAK);
	}

	@Test
	public void exercicio02_Customizado() {
		//Defina seus próprios valores para as variáveis a seguir 
		CupomFiscal.NOME_LOJA = "Top 10 nomes de lojas";
		CupomFiscal.LOGRADOURO = "Rua Tchurusbango Tchurusmago";
		CupomFiscal.NUMERO = 13;
		CupomFiscal.COMPLEMENTO = "Do lado da casa vizinha";
		CupomFiscal.BAIRRO = "Bairro do Limoeiro";
		CupomFiscal.MUNICIPIO = "São Paulo";
		CupomFiscal.ESTADO = "SP";
		CupomFiscal.CEP = "08090-284";
		CupomFiscal.TELEFONE = "(11) 4002-8922";
		CupomFiscal.OBSERVACAO = "Entre o Campinho e a Lua de Baixo";
		CupomFiscal.CNPJ = "43.745.249/0001-39";
		CupomFiscal.INSCRICAO_ESTADUAL = "564.213.199.866";

		String expected = "Top 10 nomes de lojas" + BREAK;
		expected += "Rua Tchurusbango Tchurusmago, 13 Do lado da casa vizinha" + BREAK;
		expected += "Bairro do Limoeiro - São Paulo - SP" + BREAK;
		expected += "CEP:08090-284 Tel (11) 4002-8922" + BREAK;
		expected += "Entre o Campinho e a Lua de Baixo" + BREAK;
		expected += "CNPJ: 43.745.249/0001-39" + BREAK;
		expected += "IE: 564.213.199.866";
		
		//E atualize o texto esperado abaixo
		rodarTestarOutput(expected + BREAK);
	}

	private void rodarTestarOutput(String expected) {
		PrintStream originalOut = System.out;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(bos));

		// action
		CupomFiscal.main(null);

		// assertion
		assertEquals(expected, bos.toString());

		// undo the binding in System
		System.setOut(originalOut);
	}
}
