import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StateCensusAnalyserTest {

    public final String CSV_FILE_PATH = "C:\\Users\\ADMIN\\census\\censusanalyser\\src\\main\\resources\\StateCensusData.csv";
    public final String WRONG_CSV_FILE_PATH ="C:\\Users\\ADMIN\\census\\censusanalyser\\src\\main\\resources\\StateCensusD.csv";
    public final String WRONG_TYPE_FILE_PATH = "C:\\Users\\ADMIN\\census\\censusanalyser\\src\\main\\resources\\StateCensusData.txt";
    public final String CSV_FILE_PATH_WRONG_DELIMITER = "C:\\Users\\ADMIN\\census\\censusanalyser\\src\\main\\resources\\IndiaStateCensusDataWrongDelimiter.csv";
    public final String CSV_FILE_PATH_WRONG_HEADER = "C:\\Users\\ADMIN\\census\\censusanalyser\\src\\main\\resources\\IndiaStateCensusDataWrongHeader.csv";

    public final String STATE_CODE_FILE_PATH = "C:\\Users\\ADMIN\\census\\censusanalyser\\src\\main\\resources\\IndiaStateCode.csv";
    public final String WRONG_TYPE_STATE_CODE_FILE_PATH = "C:\\Users\\ADMIN\\census\\censusanalyser\\src\\main\\resources\\IndiaStateCode.txt";

    private static StateCensusAnalyser censusAnalyser;

    // TC-1.1
    @Test
    public void givenStateCsvFile_CheckNumberOfRecords_ShouldReturnNumber() {
        try {
            StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
            int numberOfStates = censusAnalyser.loadCensusData(CSV_FILE_PATH);
            Assertions.assertEquals(29, numberOfStates);
        } catch (Exception exception) {
            exception.getMessage();
        }
    }

    // TC-1.2
    @Test
    public void givenWrongStateCsvFile_CheckPresentOrNot_ShouldReturnException() {
        try {
            StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
            censusAnalyser.loadCensusData(WRONG_CSV_FILE_PATH);
        } catch (CensusAnalyserException exception) {
            Assertions.assertEquals("file not found", exception.getMessage());
        }
    }

    // TC-1.3
    @Test
    public void givenWrongTypeFile_CheckCsvOrNot_ShouldReturnCustomException() {
        try {
            StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
            censusAnalyser.loadCensusData(WRONG_TYPE_FILE_PATH);
        } catch (CensusAnalyserException exception) {
            Assertions.assertEquals("file not found", exception.getMessage());
        }
    }

    // TC-1.4
    @Test
    public void givenDelimiterErrorStateCsvFile_CheckPresentOrNot_ShouldReturnCustomException() {
        try {
            StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
            censusAnalyser.loadCensusData(CSV_FILE_PATH_WRONG_DELIMITER);
        } catch (CensusAnalyserException exception) {
            Assertions.assertEquals("delimiter or header is improper", exception.getMessage());
        }
    }

    // TC-1.5
    @Test
    public void givenIndianCensusDataProper_WithImproperHeader_ShouldReturnCustomException() {
        try {
            StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
            censusAnalyser.loadCensusData(CSV_FILE_PATH_WRONG_HEADER);
        } catch (CensusAnalyserException exception) {
            Assertions.assertEquals("delimiter or header is improper", exception.getMessage());
        }
    }

    // TC-2.1
    @Test
    public void givenStateCodeCsvFile_CheckNumberOfRecords_ShouldReturnNumber() {
        try {
            StateCensusAnalyser stateDataLoader = new StateCensusAnalyser();
            int numberOfStates = stateDataLoader.loadStateCodeData(STATE_CODE_FILE_PATH);
            Assertions.assertEquals(37, numberOfStates);
        } catch (Exception exception) {
            exception.getMessage();
        }
    }

    // TC-2.2
    @Test
    public void givenWrongStateCodeCsvFile_CheckPresentOrNot_ShouldReturnException() {
        try {
            StateCensusAnalyser stateDataLoader = new StateCensusAnalyser();
            stateDataLoader.loadStateCodeData(WRONG_CSV_FILE_PATH);
        } catch (CensusAnalyserException exception) {
            Assertions.assertEquals("file not found", exception.getMessage());
        }
    }

    // TC-2.3
    @Test
    public void givenWrongTypeStateCodeCsvFile_CheckCsvOrNot_ShouldReturnException() {
        try {
            StateCensusAnalyser stateDataLoader = new StateCensusAnalyser();
            stateDataLoader.loadStateCodeData(WRONG_TYPE_STATE_CODE_FILE_PATH);
        } catch (CensusAnalyserException exception) {
            Assertions.assertEquals("file not found", exception.getMessage());
        }
    }

    // TC-2.4
    @Test
    public void givenDelimiterErrorStateCodeFile_CheckPresentOrNot_ShouldReturnCustomException() {
        try {
            StateCensusAnalyser stateDataLoader = new StateCensusAnalyser();
            stateDataLoader.loadStateCodeData(STATE_CODE_FILE_PATH);
        } catch (CensusAnalyserException exception) {
            Assertions.assertEquals("delimiter or header is improper", exception.getMessage());
        }
    }

    // TC-2.5
    @Test
    public void givenHeaderErrorStateCodeFile_CheckPresentOrNot_ShouldReturnCustomException() {
        try {
            StateCensusAnalyser stateDataLoader = new StateCensusAnalyser();
            stateDataLoader.loadStateCodeData(STATE_CODE_FILE_PATH);
        } catch (CensusAnalyserException exception) {
            Assertions.assertEquals("delimiter or header is improper", exception.getMessage());
        }
    }
}
