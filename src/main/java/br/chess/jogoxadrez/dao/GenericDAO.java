package br.chess.jogoxadrez.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.chess.jogoxadrez.util.HibernateUtil;

public class GenericDAO<Entidade> {

	public void salvar(Entidade entidade) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();//here begin
			sessao.save(entidade);
			transacao.commit();//end
		} catch (RuntimeException erro) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw erro;
		} finally {
			sessao.close();
		}
	}
}
