package main;

import java.util.List;

import playlist.downloader.y2mate.Y2Mate;
import playlist.youtube.input.CommandLine;

public class Main {

	public static void main(String[] args) {
		// DOWNLOADER
//		PlayListDownloader d = new PlayListDownloader();
//		d.run();
		// URL FINDER
//		PlayListURLFinder finder = new PlayListURLFinder();
//		finder.run();
		// BATEAU SYLLABUS
//		PermisBateauVideoDowloader.run();

		List<String> list = CommandLine.run();
//		for (String URL : list) {
//			Y2Mate.download(URL);
//		}
		Y2Mate.download(list.get(0));
	}

}
