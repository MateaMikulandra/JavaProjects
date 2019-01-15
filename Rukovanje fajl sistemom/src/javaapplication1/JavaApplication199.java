package javaapplication199;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class JavaApplication199 {

    public static void main(String[] args) throws IOException {
        System.out.println("Enter one of the commands: LIST,INFO,CREATE_DIR,RENAME,COPY,MOVE,DELETE");
        Scanner s = new Scanner(System.in);
        String opcija = s.nextLine();
        switch (opcija.toLowerCase()) {
            case "list": {
                System.out.println("Please enter a path: ");
                File f2 = new File(s.nextLine());
                if (f2.exists() && f2.isDirectory()) {
                    File[] files = f2.listFiles();
                    for (int i = 0; i < files.length; i++) {
                        System.out.println(files[i].getName());
                    }
                }
                break;
            }
            case "info": {
                System.out.println("Please enter a path: ");
                File f1 = new File(s.nextLine());
                if (f1.exists()) {
                    System.out.println("Name = " + f1.getName());
                    System.out.println("path = " + f1.getPath());
                    System.out.println("Lenght = " + f1.length());
                    if (f1.isDirectory()) {
                        System.out.println("Type is directory");
                    } else {
                        System.out.println("Type is file");
                    }
                    Path file = f1.toPath();
                    BasicFileAttributes attr = Files.readAttributes(file, BasicFileAttributes.class);
                    LocalDateTime dateTimeCreation = LocalDateTime.ofInstant(attr.creationTime().toInstant(), ZoneId.systemDefault());
                    LocalDateTime dateTimeModified = LocalDateTime.ofInstant(attr.lastModifiedTime().toInstant(), ZoneId.systemDefault());
                    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd. MMMM yyyy. HH:mm:ss");
                    System.out.println("Creation Time: " + dateTimeCreation.format(dateTimeFormatter));
                    System.out.println("Last Modified: " + dateTimeModified.format(dateTimeFormatter));
                } else {
                    System.out.println("The path is bad");
                }
                break;
            }
            case "create_dir": {
                System.out.println("Please enter a path: ");
                File f3 = new File(s.nextLine());
                try {
                    if (!f3.exists()) {
                        f3.mkdir();
                        System.out.println("Created a directory called " + f3.getName());
                    } else {
                        System.out.println("Directory called " + f3.getName() + " already exists.");
                    }
                } catch (Exception e) {
                    System.out.println("Couldn't create a directory called " + f3.getName());
                }
                break;
            }
            case "rename": {
                System.out.println("Enter the path to the file that you would like to change the: ");
                File old = new File(s.nextLine());
                System.out.println("Enter a new name for the file");
                String ime = s.nextLine();
                File newfile = new File(old.getParent() + File.separator + ime);
                if (!old.exists()) {
                    System.out.println("File doesn't exists!");
                    return;
                }
                if (newfile.exists()) {
                    System.out.println("File with desired name already exists!");
                    return;
                }
                if (old.renameTo(newfile)) {
                    System.out.println("Rename succesful");
                } else {
                    System.out.println("Rename failed");
                }
                break;
            }
            case "copy": {
                System.out.println("Enter the path to the file that you want to copy: ");
                File f5 = new File(s.nextLine());
                System.out.println("Enter the path for the copied file: ");
                File cp = new File(s.nextLine());
                if (!f5.exists()) {
                    System.out.println("File/Folder does not exist");
                    return;
                }
                if (!cp.getParentFile().exists()) {
                    System.out.println("Location does not exist");
                    return;
                }
                File fh = new File(cp.getPath() + File.separator + f5.getName());
                if (fh.exists()) {
                    System.out.println("File already exists");
                    return;
                } else {
                    Files.copy(f5.toPath(), fh.toPath());
                }
                break;
            }
            case "move": {

                System.out.println("Enter the path to the file that you want to move: ");
                File f5 = new File(s.nextLine());
                System.out.println("Please enter a path offset file: ");
                File cp = new File(s.nextLine());
                if (!f5.exists()) {
                    System.out.println("File/Folder does not exist");
                    return;
                }
                if (!cp.getParentFile().exists()) {
                    System.out.println("Location does not exist");
                    return;
                }
                File fh = new File(cp.getPath() + File.separator + f5.getName());
                if (fh.exists()) {
                    System.out.println("File already exists");
                    return;
                } else {
                    Files.copy(f5.toPath(), fh.toPath());
                    Files.deleteIfExists(f5.toPath());
                }
                break;
            }
            case "delete": {
                System.out.println("Enter the path of the file to delete: ");
                File fileToDelete = new File(s.nextLine());
                JavaApplication199.checkFolder(fileToDelete);
                Files.deleteIfExists(fileToDelete.toPath());
                break;
            }
            default: {
                System.out.println("You have entered an unknown command");
            }
        }
    }

    public static void checkFolder(File f) {
        if (f.isDirectory()) {
            File[] files = f.listFiles();
            for (int i = 0; i < files.length; i++) {
                if (files[i].isFile()) {
                    files[i].delete();
                } else {
                    checkFolder(files[i]);
                }
            }

        }
    }
}
