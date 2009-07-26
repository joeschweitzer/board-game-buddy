package com.boardgamebuddy.core.table;

public interface TableManager {

	public enum TableType { TICTACTOE };
	
	void addNewTable(Table table);
}
