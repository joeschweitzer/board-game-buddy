package com.google.code.bgb.tictactoe.board;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SquareBoard {

	private int size;
	private List<Space> spaces;
	private Map<Integer, Collection<Space>> rows;
	private Map<Integer, Collection<Space>> columns;
	private Map<Integer, Collection<Space>> diagonals;
	
	public SquareBoard(int size) {
		this.size = size;
		spaces = new ArrayList<Space>();
		rows = new HashMap<Integer, Collection<Space>>();
		columns = new HashMap<Integer, Collection<Space>>();
		diagonals = new HashMap<Integer, Collection<Space>>();
		
		init();
	}
	
	public void init() {
		for(int index = 0; index < (size * size); index++) {
			spaces.add(new Space(String.valueOf(index)));
		}
		
		for(int row = 0; row < size; row++) {
			rows.put(new Integer(row), 
					spaces.subList(row * size, (row * size) + size));
		}
		
		for(int column = 0; column < size; column++) {
			Collection<Space> columnSpaces = new ArrayList<Space>();
			
			for(int row = 0; row < size; row++) {
				Space[] rowSpaces = new Space[size];
				rowSpaces = rows.get(new Integer(row)).toArray(rowSpaces);
				columnSpaces.add(rowSpaces[column]);
			}
			
			columns.put(new Integer(column), columnSpaces);
		}
		
		for(int row = 0; row < size; row++) {
			Collection<Space> ascSpaces = new ArrayList<Space>();
			
			for(int element = 0; element <= row; element++) {
				Space[] elementSpaces = new Space[size];
				elementSpaces = 
					columns.get(new Integer(element)).toArray(elementSpaces);
				Space space = elementSpaces[row - element];
				ascSpaces.add(space);
			}
			
			diagonals.put(new Integer(row), ascSpaces);
		}
		
		int diagonalNum = size - 1;
		
		for(int row = 0; row < size; row++) {
			Collection<Space> ascSpaces = new ArrayList<Space>();
			
			for(int element = 0; element < size - row; element++) {
				Space[] elementSpaces = new Space[size];
				elementSpaces = 
					columns.get(new Integer(size - element - 1)).toArray(elementSpaces);
				ascSpaces.add(elementSpaces[row + element]);
			}
			
			diagonals.put(new Integer(diagonalNum), ascSpaces);
			diagonalNum++;
		}
		
		for(int row = 0; row < size; row++) {
			Collection<Space> ascSpaces = new ArrayList<Space>();
			
			for(int element = 0; element <= row; element++) {
				Space[] elementSpaces = new Space[size];
				elementSpaces = 
					columns.get(new Integer(size - element - 1)).toArray(elementSpaces);
				ascSpaces.add(elementSpaces[row - element]);
			}
			
			diagonals.put(new Integer(diagonalNum), ascSpaces);
			diagonalNum++;
		}
		
		diagonalNum--;
		
		for(int row = 0; row < size; row++) {
			Collection<Space> ascSpaces = new ArrayList<Space>();
			
			for(int element = 0; element < size - row; element++) {
				Space[] elementSpaces = new Space[size];
				elementSpaces = 
					columns.get(new Integer(element)).toArray(elementSpaces);
				ascSpaces.add(elementSpaces[row + element]);
			}
			
			diagonals.put(new Integer(diagonalNum), ascSpaces);
			diagonalNum++;
		}
		
	}
	

	public void printBoard() {
		String allSpaces = "";
		
		for(Space space : spaces) {
			allSpaces += space.getValue() + " ";
		}
		System.out.println(allSpaces);
		
		System.out.println();
		
		for(int row = 0; row < rows.size(); row++) {
			String rowPrint = "";
			for(Space space : rows.get(new Integer(row))) {
				rowPrint += space.getValue() + " ";
			}
			System.out.println(rowPrint);
		}
		
		System.out.println();
		
		for(int column = 0; column < columns.size(); column++) {
			String columnPrint = "";
			for(Space space : columns.get(new Integer(column))) {
				columnPrint += space.getValue() + " ";
			}
			System.out.println(columnPrint);
		}
		
		System.out.println();
		
		for(int diagonal = 0; diagonal < diagonals.size(); diagonal++) {
			String diagonalPrint = "";
			for(Space space : diagonals.get(new Integer(diagonal))) {
				diagonalPrint += space.getValue() + " ";
			}
			System.out.println(diagonalPrint);
		}
	}
}
