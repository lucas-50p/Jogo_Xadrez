package br.chess.jogoxadrez.main;

import org.hibernate.Session;

import br.chess.jogoxadrez.util.HibernateUtil;

public class HibernateUtilTest {

	public static void main(String[] args) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		sessao.close();
		HibernateUtil.getFabricaDeSessoes().close();
	}
}
