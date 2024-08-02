package com.cp.compiler.executions.languages;

import com.cp.compiler.executions.Execution;
import com.cp.compiler.executions.ExecutionFactory;
import com.cp.compiler.models.testcases.TransformedTestCase;
import com.cp.compiler.contract.Language;
import lombok.val;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * The type Go execution.
 *
 * @author Zakaria Maaraki
 */
public class GoExecution extends Execution {
    
    /**
     * Instantiates a new Go execution.
     *
     * @param sourceCodeFile the source code file
     * @param testCases      the test cases
     * @param timeLimit      the time limit
     * @param memoryLimit    the memory limit
     */
    public GoExecution(MultipartFile sourceCodeFile,
                       List<TransformedTestCase> testCases,
                       int timeLimit,
                       int memoryLimit) {
        super(sourceCodeFile, testCases, timeLimit, memoryLimit, ExecutionFactory.getExecutionType(Language.GO));
    }
    
    @Override
    public Map<String, String> getParameters(String inputFileName) {
        val commandPrefix = "./exec";
        val executionCommand = inputFileName == null
                ? commandPrefix + "\n"
                : commandPrefix + " < " + inputFileName + "\n";
    
        return Map.of(
                "timeLimit", String.valueOf(getTimeLimit()),
                "memoryLimit", String.valueOf(getMemoryLimit()),
                "executionCommand", executionCommand);
    }
    
    @Override
    protected void copyLanguageSpecificFilesToExecutionDirectory() throws IOException {
        // Empty
    }
    
    @Override
    public Language getLanguage() {
        return Language.GO;
    }
}
