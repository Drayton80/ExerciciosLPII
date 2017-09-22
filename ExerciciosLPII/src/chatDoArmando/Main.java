/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author arman
 */

import java.io.IOException;
import java.net.UnknownHostException;

public class Main {
	public static void main(String[] args) 
			throws UnknownHostException,	IOException {
		new Clientes("177.180.228.197", 12345).executa();
	}
}