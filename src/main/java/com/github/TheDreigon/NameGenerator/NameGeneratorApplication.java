package com.github.TheDreigon.NameGenerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

import static java.lang.System.*;

@SpringBootApplication
public class NameGeneratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(NameGeneratorApplication.class, args);

		NameListRepository nameListRepository = new NameListRepository();
		ArrayList<String> boyNameList = new ArrayList<>();
		ArrayList<String> girlNameList = new ArrayList<>();

		nameListRepository.populateBoyNameList(boyNameList);
		nameListRepository.populateGirlNameList(girlNameList);

		String userName;
		Scanner scanner = new Scanner(in);

		out.println("Hello, I am a bot. What is your name?");
		userName = scanner.nextLine();
		out.println("Pleased to meet you, " + userName + "!");
		out.println("I can choose a random male or female name for you. Would you like me to do it? \n y/n");

		while(true) {

			switch (scanner.nextLine()) {

				case "y":
					out.println("You picked 'y'. Would you like a male or a female name? m/f");
					switch (scanner.nextLine()) {

						case "m":
							out.println("you picked 'm' Your random name is... \n " + boyNameList.get((int) (Math.random() * 1000)));
							break;
						case "f":
							out.println("you picked 'f' Your random name is... \n " + girlNameList.get((int) (Math.random() * 1000)));
							break;
					}
					out.println("I can choose another random name for you. Would you like me to do it again? \n y/n");
					break;

				case "n":
					out.println("You picked the option 'n'. \n The app will now close.");
					scanner.close();
					exit(0);
					break;

				default:
					out.println("Please pick a valid option... \n Waiting... \n y/n?");
					break;
			}
		}
	}
}
