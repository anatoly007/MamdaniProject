package com.spitsin.mamdani;

import com.spitsin.mamdani.exceptions.HasNoThatTermException;
import com.spitsin.mamdani.exceptions.HasNoThatVariableException;

import java.util.Map;

public class Statement {
    private static Map<String, LingVariable> variables;
    private LingVariable lingVariable;
    private Term term;

    public static void setLingVariables(Map<String, LingVariable> variables) {
        Statement.variables = variables;
    }

    public Statement(String variableName, String termName) {
        if (!variables.containsKey(variableName)) {
            throw new HasNoThatVariableException();
        }
        if (!variables.get(variableName).hasTerm(termName)) {
            throw new HasNoThatTermException(variableName + ":" + termName);
        }
        this.lingVariable = variables.get(variableName);
        this.term = variables.get(variableName).getTerm(termName);
    }

    public int getVariableId() {
        return lingVariable.getId();
    }

    public LingVariable getLingVariable() {
        return lingVariable;
    }

    public Term getTerm() {
        return term;
    }
}
