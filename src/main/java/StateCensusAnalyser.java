import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class StateCensusAnalyser {

    private int count;

    public int loadCensusData(String path) throws CensusAnalyserException {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(path));
            CsvToBean<CSVStateCensus> csvToBean = new CsvToBeanBuilder(reader).withType(CSVStateCensus.class).withIgnoreLeadingWhiteSpace(true).build();
            Iterator<CSVStateCensus> csvUserIterator = csvToBean.iterator();
            while (csvUserIterator.hasNext()) {
                count++;
                csvUserIterator.next();
            }
        } catch (RuntimeException exception) {
            throw new CensusAnalyserException(CensusAnalyserException.exceptionType.WRONG_FILE,
                    "delimiter or header is improper");
        } catch (NoSuchFileException exception) {
            throw new CensusAnalyserException(CensusAnalyserException.exceptionType.FILE_NOT_FOUND,
                    "file not found");
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return count;
    }

    public int loadStateCodeData(String path) throws CensusAnalyserException {
        List<IndianStateCode> csvUserList;
        try {
            Reader reader = Files.newBufferedReader(Paths.get(path));
            CsvBuilderInterface csvBuilder = CSVBuilderFactory.getCSVBuilder();
            csvUserList = csvBuilder.getCSVFileList(reader, IndianStateCode.class);

        } catch (IOException exception) {
            throw new CensusAnalyserException(CensusAnalyserException.exceptionType.FILE_NOT_FOUND,
                    "file not found");
        } catch (CSVBuilderException exception) {
            throw new CensusAnalyserException(exception.getMessage(), exception.type.name());
        } catch (RuntimeException exception) {
            throw new CensusAnalyserException(CensusAnalyserException.exceptionType.WRONG_FILE,
                    "delimiter or header is improper");
        }
        return csvUserList.size();
    }
}

