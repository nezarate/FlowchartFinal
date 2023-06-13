package Handlers;

import Database.DB;
import Panels.CodeMetricsCodePanel;
import org.jooq.Record9;
import org.jooq.Result;

import javax.swing.*;

public class CodeMetricHandler{
    private static CodeMetricHandler codeMetricHandler = null;
    private static CodeMetricsCodePanel codePanel;
    private static int loc;
    private static int eloc;
    private static int lloc;
    private static int cc;
    private int problemNum;
    private CodeMetricHandler(){
        this.problemNum = 1;
    }
    public static CodeMetricHandler getInstance(){
        if(codeMetricHandler == null){
            codeMetricHandler = new CodeMetricHandler();
        }
        return codeMetricHandler;
    }

    public String getCurrProblem(){
        try{
            Result<Record9<Long, String, String, String, String, Integer, Integer, Integer, Integer>> result = DB.getCodeProblemByID(problemNum);
            String codeProblem = (String) result.get(0).value3();
            System.out.println(codeProblem);
            return codeProblem;
        } catch(Error e){
            System.out.println(e);
        }
        return "could not load problem from database";
    }

    public static void submitUserAnswers(int givenloc, int giveneloc, int givenlloc, int givencc){
        loc = givenloc;
        eloc = giveneloc;
        lloc = givenlloc;
        cc = givencc;
    }

    public void submit(){
        try{
            Result<Record9<Long, String, String, String, String, Integer, Integer, Integer, Integer>> result = DB.getCodeProblemByID(problemNum);
            int correctloc = result.get(0).value6();
            int correcteloc = result.get(0).value7();
            int correctlloc = result.get(0).value8();
            int correctcc = result.get(0).value9();
            if(loc == correctloc && eloc == correcteloc && lloc == correctlloc && cc == correctcc){
                JOptionPane.showMessageDialog(null, "Correct Answer!");
                this.problemNum += 1;
                codePanel.update();
            }
            else{
                JOptionPane.showMessageDialog(null, "Wrong Answer!");
            }
        } catch(Error e){
            System.out.println(e.getMessage());
        }
    }

    public static void addObserver(CodeMetricsCodePanel givenCodePanel){
        codePanel = givenCodePanel;
    }


}
