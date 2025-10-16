package org.example.fileorganizer;


import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

public class FileOrganizerController {

    @FXML private TextField txtFolderPath;
    @FXML private RadioButton rbtnType;
    @FXML private RadioButton rbtnExtension;
    @FXML private TextArea txtLog;
    @FXML private Button btnChooseFolder;
    @FXML private ToggleGroup modeToggleGroup;

    private File selectedFolder;

    @FXML
    private void chooseFolder() {
        DirectoryChooser chooser = new DirectoryChooser();
        chooser.setTitle("Select Folder");
        File folder = chooser.showDialog(new Stage());
        if (folder != null) {
            selectedFolder = folder;
            txtFolderPath.setText(folder.getAbsolutePath());
        }
    }

    @FXML
    private void organizeFiles() {
        if (selectedFolder == null) {
            txtLog.appendText("Please select a folder first.\n");
            return;
        }

        boolean byType = rbtnType.isSelected();
        try (Stream<Path> files = Files.list(selectedFolder.toPath())) {
            files.filter(Files::isRegularFile).forEach(file -> {
                try {
                    String folderName = byType ? Files.probeContentType(file) : getExtension(file);
                    if (folderName == null) folderName = "Unknown";
                    folderName = folderName.replace("/", "_");

                    Path targetDir = selectedFolder.toPath().resolve(folderName);
                    Files.createDirectories(targetDir);
                    Files.move(file, targetDir.resolve(file.getFileName()), StandardCopyOption.REPLACE_EXISTING);

                    txtLog.appendText("Moved: " + file.getFileName() + " → " + folderName + "\n");
                } catch (IOException e) {
                    txtLog.appendText("Error moving file: " + file.getFileName() + "\n");
                }
            });
        } catch (IOException e) {
            txtLog.appendText("Failed to read directory.\n");
        }
    }

    private String getExtension(Path file) {
        String name = file.getFileName().toString();
        int index = name.lastIndexOf(".");
        return (index > 0) ? name.substring(index + 1).toUpperCase() : "NoExtension";
    }
}

