package com.boardgamebuddy.basic.table;

import java.util.HashMap;
import java.util.Map;

import com.boardgamebuddy.core.table.Table;
import com.boardgamebuddy.core.table.TableManager;

public class BasicTableManager implements TableManager {

	private Map<String, Table> tableMap = new HashMap<String, Table>();
	
	public BasicTableManager() {
		
	}

	public void addNewTable(Table table) {
		tableMap.put("table1", table);
	}
}
