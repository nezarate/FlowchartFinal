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

    public void parserMethod(ArrayList<Token> lexedInput){
        if (!lexedInput.isEmpty()) {
            if (lexedInput.get(0).getType().equals("k-type")) {
                if (lexedInput.get(1).getType().equals("id")) {
                    if (lexedInput.get(2).getType().equals("(")) {
                        if (lexedInput.get(3).getType().equals(")")) {
                            if (lexedInput.get(4).getType().equals("{")) {
                                System.out.println("Start point is created here");
                                System.out.println("Here body is called");
                                parserBody((ArrayList<Token>)lexedInput.subList(5,lexedInput.size()));
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

    public void parserBody(ArrayList<Token> lexedInput){
        int currentIndex = 0;
        while(currentIndex < lexedInput.size()){
            switch(lexedInput.get(currentIndex).getType()){
                case "k-type":
                    int start = currentIndex;
                    while(!lexedInput.get(start).getType().equals(";")){
                        currentIndex ++;
                    }
                    parserVar((ArrayList<Token>)lexedInput.subList(start,currentIndex + 1));
                    currentIndex ++;
                    break;
                case "id":
                    int start2 = currentIndex;
                    while(!lexedInput.get(start2).getType().equals(";")){
                        currentIndex ++;
                    }
                    parserId((ArrayList<Token>)lexedInput.subList(start2,currentIndex + 1));
                    currentIndex ++;
                    break;
                case "for":
                    int start3 = currentIndex;
                    while(!lexedInput.get(start3).getType().equals("}")){
                        currentIndex ++;
                    }
                    parserFor((ArrayList<Token>)lexedInput.subList(start3,currentIndex + 1));
                    currentIndex ++;
                    break;
                case "if":
                    int start4 = currentIndex;
                    while(!lexedInput.get(start4).getType().equals("}")){
                        currentIndex ++;
                    }
                    parserIf((ArrayList<Token>)lexedInput.subList(start4,currentIndex + 1));
                    currentIndex ++;
                    break;
            }
        }
    }

    private void error(){
        System.out.println("There was an Error in your code please check the input");
    }
}
