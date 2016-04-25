package com.spitsin.mamdani;

public class LingVariable {
    private String name;
    private UniversalSet uSet;
    private TermSet termSet;
    private static int count = 0;
    private int id;

    LingVariable(String name, TermSet termSet, UniversalSet uSet) {
        this.name = name;
        this.termSet = termSet;
        this.uSet = uSet;
        this.id = LingVariable.count++;
    }

    public LingVariable(String name, TermSet termSet) {
        this(name, termSet, new UniversalSet() {
        });
    }

    public boolean hasTerm(String term) {
        if (termSet.containsTerm(term)) {
            return true;
        } else {
            return false;
        }
    }

    public Term getTerm(String termName) {
        return termSet.getTerm(termName);
    }

    public int getId() {
        return id;
    }

    public double getValueForTerm(Term term, double x) {
        return termSet.getFuncForTerm(term).getValue(x);
    }

    public String getName() {
        return name;
    }
}
