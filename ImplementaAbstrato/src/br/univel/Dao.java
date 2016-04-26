package br.univel;

import java.awt.List;

public interface Dao<T, K>{
	
		public void salvar(T t);
		public T buscar(K k);
		public void atualizar(T t);
		public void excluir(K k);
		public List listarTodos();
		void salvar1(T t);
		void excluir1(K k);
		
}
