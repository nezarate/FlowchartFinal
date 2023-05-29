package CompilerLab;

import java.util.ArrayList;

public class Parser {
    public boolean parserMethodForTesting(ArrayList<Token> lexedInput) {
        if (!lexedInput.isEmpty()) {
            if (lexedInput.get(0).getType().equals("k-type")) {
                if (lexedInput.get(1).getType().equals("id")) {
                    if (lexedInput.get(2).getType().equals("(")) {
                        if (lexedInput.get(3).getType().equals(")")) {
                            if (lexedInput.get(4).getType().equals("{")) {
                                System.out.println("Start point is created here");
                                System.out.println("Here body is called");
                                if (lexedInput.get(lexedInput.size()-1).getType().equals("}")) {
                                    System.out.println("End point is created here");
                                    return true;
                                } else {
                                    return false;
                                }
                            } else {
                                return false;
                            }
                        } else {
                            return false;
                        }
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    //


    public void parserMethod(ArrayList<Token> lexedInput){
        if (!lexedInput.isEmpty()) {
            if (lexedInput.get(0).getType().equals("k-type")) {
                if (lexedInput.get(1).getType().equals("id")) {
                    if (lexedInput.get(2).getType().equals("(")) {
                        if (lexedInput.get(3).getType().equals(")")) {
                            if (lexedInput.get(4).getType().equals("{")) {
                                System.out.println("Start point is created here");
                                System.out.println("Here body is called");
                                //ToDo: Add method call to Body here!
                                if (lexedInput.get(lexedInput.size()-1).getType().equals("}")) {
                                    System.out.println("End point is created here");
                                } else {
                                    error();
                                }
                            } else {
                                error();
                            }
                        } else {
                            error();
                        }
                    } else {
                        error();
                    }
                } else {
                    error();
                }
            } else {
                error();
            }
        } else {
            error();
        }
    }

    private void error(){
        System.out.println("There was an Error in your code please check the input");
    }
}
