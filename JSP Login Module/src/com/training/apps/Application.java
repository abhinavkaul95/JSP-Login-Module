package com.training.apps;

import java.util.Scanner;

import com.training.model.ValidateBean;

public class Application {

	public static void main(String[] args) {
		Scanner sac = new Scanner(System.in);
		String username = sac.nextLine();
		String password = sac.nextLine();
		ValidateBean bean = new ValidateBean();
		System.out.println(bean.validate(username, password));
		sac.close();

	}

}
