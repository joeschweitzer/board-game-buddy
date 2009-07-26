package com.google.code.bgb.basic.table;

import java.util.HashMap;
import java.util.Map;

import com.google.code.bgb.core.table.Table;
import com.google.code.bgb.core.table.TableManager;

public class BasicTableManager implements TableManager {

	private Map<String, Table> tableMap = new HashMap<String, Table>();
	
	public BasicTableManager() {
		
	}

	public void addNewTable(Table table) {
		tableMap.put("table1", table);
	}
}
