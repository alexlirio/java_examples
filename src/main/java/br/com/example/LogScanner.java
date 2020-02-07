package br.com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class LogScanner {
	
	String fileName = "myFile.txt";
	Path path = FileSystems.getDefault().getPath(System.getProperty("user.home"), "Desktop");
	Path logFile = path.resolve(fileName);
    private int lines = 0;
    private int characters = 0;

	public static void main(String[] args) {
		new LogScanner().run();
	}

	public void run() {
        try {
            WatchService watcher = FileSystems.getDefault().newWatchService();
            try (BufferedReader in = new BufferedReader(new FileReader(logFile.toFile()))) {
                String line;
                while ((line = in.readLine()) != null) {
                    lines++;
                    characters += line.length() + System.lineSeparator().length();
                }
            }

            logFile.toAbsolutePath().getParent().register(watcher, StandardWatchEventKinds.ENTRY_MODIFY);

            do {
                WatchKey key = watcher.take();
                System.out.println("Waiting...");
                for (WatchEvent<?> event : key.pollEvents()) {
                    WatchEvent<Path> pathEvent = (WatchEvent<Path>) event;
                    Path dir = (Path)key.watchable();
                    Path path = dir.resolve(pathEvent.context());
                    if (path.equals(logFile)) {
//                        try (BufferedReader in = new BufferedReader(new FileReader(pathEvent.context().toFile()))) {
                        try (BufferedReader in = new BufferedReader(new FileReader(path.toFile()))) {
                        	String line;
                            Pattern p = Pattern.compile("WARN|ERROR");
                            in.skip(characters);
                            while ((line = in.readLine()) != null) {
                                lines++;
                                characters += line.length() + System.lineSeparator().length();
                                if (p.matcher(line).find()) {
                                    // Do something
                                    System.out.println(line);
                                }
                            }
                        }
                    }
                }
                key.reset();
            } while (true);
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(LogScanner.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
    }
}


//public class LogScanner {
//	
//	final static Path path = FileSystems.getDefault().getPath(System.getProperty("user.home"), "Desktop");
//	
//	public static void main(String[] args) {
//		System.out.println(path);
//		
//		try (final WatchService watchService = FileSystems.getDefault().newWatchService()) {
//		    final WatchKey watchKey = path.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY);
//		    while (true) {
//		        final WatchKey wk = watchService.take();
//		        for (WatchEvent<?> event : wk.pollEvents()) {
//		            //we only register "ENTRY_MODIFY" so the context is always a Path.
//		            final Path changed = (Path) event.context();
//		            System.out.println(changed);
//		            if (changed.endsWith("myFile.txt")) {
//		                System.out.println("My file has changed");
//		            }
//		        }
//		        // reset the key
//		        boolean valid = wk.reset();
//		        if (!valid) {
//		            System.out.println("Key has been unregisterede");
//		        }
//		    }
//		} catch (IOException | InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//}
