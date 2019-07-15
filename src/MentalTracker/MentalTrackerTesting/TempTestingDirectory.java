package MentalTracker.MentalTrackerTesting;

import com.codename1.io.FileSystemStorage;

import java.util.List;
import java.util.Vector;

public class TempTestingDirectory {

    private final FileSystemStorage _StorageInstance = FileSystemStorage.getInstance();
    private final String _AppPath;
    private final String _TempFolder = "TestingFolder";
    private final String _TempDirectory;

    private List<String> _CreatedFiles = new Vector<>();

    public TempTestingDirectory()
    {
        _AppPath = FileSystemStorage.getInstance().getAppHomePath();
        _TempDirectory = _AppPath + _TempFolder + _StorageInstance.getFileSystemSeparator();
        _StorageInstance.mkdir(_AppPath + _TempFolder);
    }

    public String CreateFilePath (String fileName)
    {
        _CreatedFiles.add(fileName);
        return _TempDirectory + fileName;
    }

    public void DeleteTempFiles()
    {
        for (String fileName : _CreatedFiles) {
            if (_StorageInstance.exists(_TempDirectory + fileName))
            {
                _StorageInstance.delete(_TempDirectory + fileName);
            }
        }
        _StorageInstance.delete(_TempDirectory);
    }
}
