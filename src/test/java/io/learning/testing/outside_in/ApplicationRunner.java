package io.learning.testing.outside_in;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class ApplicationRunner {

    public String run(final String inputFile){

        ByteArrayOutputStream dummyOutput = new ByteArrayOutputStream();
        SalesReportRunner app = new SalesReportRunner(new PrintStream(dummyOutput));
        app.run(inputFile);

        try{

            return dummyOutput.toString("UTF-8");
        }
        catch(UnsupportedEncodingException e){

            throw new RuntimeException(e);

        }
    }



}
