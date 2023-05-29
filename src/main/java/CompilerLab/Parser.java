package CompilerLab;

import java.util.ArrayList;
import java.util.Objects;

public class Parser {
    ArrayList<String> boxList = new ArrayList<>();
    ArrayList<String> methodList = new ArrayList<>();
    ArrayList<String> diamondList = new ArrayList<>();

    private void error() {
        System.out.println("There was an Error in your code please check the input");
    }

    public boolean parserMethodForTesting(ArrayList<Token> lexedInput) {
        if (!lexedInput.isEmpty()) {
            if (lexedInput.get(0).getType().equals("k-type")) {
                if (lexedInput.get(1).getType().equals("id")) {
                    if (lexedInput.get(2).getType().equals("(")) {
                        if (lexedInput.get(3).getType().equals(")")) {
                            if (lexedInput.get(4).getType().equals("{")) {
                                System.out.println("Start point is created here");
                                System.out.println("Here body is called");
                                if (lexedInput.get(lexedInput.size() - 1).getType().equals("}")) {
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


    public void parserMethod(ArrayList<Token> lexedInput) {
        if (!lexedInput.isEmpty()) {
            if (lexedInput.get(0).getType().equals("k-type")) {
                if (lexedInput.get(1).getType().equals("id")) {
                    if (lexedInput.get(2).getType().equals("(")) {
                        if (lexedInput.get(3).getType().equals(")")) {
                            if (lexedInput.get(4).getType().equals("{")) {
                                System.out.println("Start point is created here");
                                System.out.println("Here body is called");
                                parserBody((ArrayList<Token>) lexedInput.subList(5, lexedInput.size()));
                                //ToDo: Add method call to Body here!
                                if (lexedInput.get(lexedInput.size() - 1).getType().equals("}")) {
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

    public void parserCallMethod(ArrayList<Token> lexedInput) {
        if (!lexedInput.isEmpty()) {
            if (lexedInput.get(0).getType().equals("id")) {
                if (lexedInput.get(1).getType().equals("(")) {
                    if (lexedInput.get(2).getType().equals(")")) {
                        if (lexedInput.get(3).getType().equals(";")) {
                            String output = lexedInput.get(0) + " - call method";
                            boxList.add(output);
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

    public void parserBody(ArrayList<Token> lexedInput) {
        int currentIndex = 0;
        while (currentIndex < lexedInput.size()) {
            switch (lexedInput.get(currentIndex).getType()) {
                case "k-type":
                    int start = currentIndex;
                    while (!lexedInput.get(start).getType().equals(";")) {
                        currentIndex++;
                    }
                    //parserVar((ArrayList<Token>)lexedInput.subList(start,currentIndex + 1));
                    currentIndex++;
                    break;
                case "id":
                    int start2 = currentIndex;
                    while (!lexedInput.get(start2).getType().equals(";")) {
                        currentIndex++;
                    }
                    //parserId((ArrayList<Token>)lexedInput.subList(start2,currentIndex + 1));
                    currentIndex++;
                    break;
                case "for":
                    int start3 = currentIndex;
                    while (!lexedInput.get(start3).getType().equals("}")) {
                        currentIndex++;
                    }
                    parserFor((ArrayList<Token>) lexedInput.subList(start3, currentIndex + 1));
                    currentIndex++;
                    break;
                case "if":
                    int start4 = currentIndex;
                    while (!lexedInput.get(start4).getType().equals("}")) {
                        currentIndex++;
                    }
                    parserIf((ArrayList<Token>) lexedInput.subList(start4, currentIndex + 1));
                    currentIndex++;
                    break;
            }
        }
    }

    public void parserIf(ArrayList<Token> lexedInput)
    {
        if(Objects.equals(lexedInput.get(0).getWords(), "if"))
        {
            if(Objects.equals(lexedInput.get(1).getWords(), "("))
            {
                parserInstruction((ArrayList<Token>) lexedInput.subList(2, 5));
                if(Objects.equals(lexedInput.get(6).getWords(), ")"))
                {
                    if(Objects.equals(lexedInput.get(7).getWords(), "{"))
                    {
                        parserBody((ArrayList<Token>) lexedInput.subList(8, lexedInput.size()-2));
                        if(Objects.equals(lexedInput.get(lexedInput.size()-1).getWords(), "}"))
                        {
                            diamondList.add("If Condition");
                        }else{
                            error();
                        }
                    }else{
                        error();
                    }
                }else{
                    error();
                }
            }else{
                error();
            }
        }else{
            error();
        }
    }

    public void parserInstruction (ArrayList < Token > lexedInput) {
        if (!lexedInput.isEmpty()) {
            if (lexedInput.get(0).getType().equals("id")) {
                if (lexedInput.get(1).getType().equals("operator")) {
                    if (lexedInput.get(lexedInput.size() - 1).getType().equals(";")) {
                        String output = lexedInput.get(0) + " - instruction";
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

    public void parserFor (ArrayList < Token > lexedInput)
    {
        if (Objects.equals(lexedInput.get(0).getWords(), "for")) {
            if (Objects.equals(lexedInput.get(1).getWords(), "(")) {
                //parserVar(lexedInput, 2, 5);
                parserInstruction((ArrayList<Token>) lexedInput.subList(6, 9));
                parserInstruction((ArrayList<Token>) lexedInput.subList(10, 13));
                if (Objects.equals(lexedInput.get(14).getWords(), ")")) {
                    if (Objects.equals(lexedInput.get(15).getWords(), "{")) {
                        parserBody((ArrayList<Token>) lexedInput.subList(16, lexedInput.size() - 2));
                        if (Objects.equals(lexedInput.get(lexedInput.size() - 1).getWords(), "}")) {
                            diamondList.add("For Condition");
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
}
