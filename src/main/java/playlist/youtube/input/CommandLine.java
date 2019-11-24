package playlist.youtube.input;

import java.util.List;
import java.util.Scanner;

import playlist.youtube.finder.PlayListURLFinder;

public class CommandLine {

	private static final String WHICH_PLAYLIST_QUESTION = "Quelle liste??\nhttps://www.youtube.com/watch?v=QZS_G5RjP3c&list=PL5XT9W6RnqISELICaEGDUjzWo4iiM0-iN";
	private static final String CONFIRM_PALYLIST_QUESTION = "Confirmez la liste (NO pour corriger): \n";
	private static String urlPlaylist;
	private static boolean validatedList = false;
	private static Scanner inputSystem = new Scanner(System.in);
	private static List<String> list;

	/**
	 * Asks for the playlist and returns the URLs of all videos
	 * 
	 * @return all the URLs of the playlist
	 */
	public static List<String> run() {
		do {
			// Demander l URL de la playlist
			askURL();
			// Verifier que c'est la bonne
			confirmURL();
		} while (!validatedList);

		// Recuperer les liens de chaque video
		getAllVideoURLs();

		// Demander Audio, Video et Qualite

		inputSystem.close();

		return list;
	}

	private static void getAllVideoURLs() {
		System.out.println("On va récupérer les URL de chaque vidéo. Patiantez svp");
		list = PlayListURLFinder.getURLList(urlPlaylist);
		for (String video : list) {
			System.out.println("Video: " + video);
		}
	}

	private static void confirmURL() {
		String answer = askForSomething(CONFIRM_PALYLIST_QUESTION + urlPlaylist);
		if (!answer.equalsIgnoreCase("no")) {
			validatedList = true;
		}

	}

	private static void askURL() {
		urlPlaylist = askForSomething(WHICH_PLAYLIST_QUESTION);

	}

	private static String askForSomething(String question) {
		// Create a Scanner object
		System.out.println(question);
		String answer = inputSystem.nextLine();
		return answer;
	}
}
