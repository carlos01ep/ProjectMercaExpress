package com.test;

import java.util.LinkedList;

import com.merca.Controller;
import com.model.Categorias;


public class TestController {

	public static void main(String[] args) {
		
		System.out.println("Inicio de TestController");
		LinkedList<Categorias> listaCategorias = Controller.getCategorias();
		System.out.println("Total de jugadores= " + listaCategorias.toString());
		
	}

}
