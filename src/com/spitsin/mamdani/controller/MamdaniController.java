package com.spitsin.mamdani.controller;

import com.spitsin.mamdani.*;
import com.spitsin.mamdani.exceptions.ArgumentOutOfBoundsException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MamdaniController {
    private Map<String, LingVariable> variables;
    private ArrayList<Rule> rules;
    UnionOfTermSet unionOfTerms;

    public static void main(String[] args) {
        MamdaniController controller = new MamdaniController();
        controller.loadVariables();
        controller.loadRules();
//        double b[] = controller.fuzzification(new double[]{0.7, 0.83});
        double b[] = controller.fuzzification(new double[]{0.8, 0.68});

//        double b[] = controller.fuzzification(new double[]{0.12, 0.5, 0.75, 0.95});
        double c[] = controller.aggregation(b);
        System.out.println();
        System.out.println();
        controller.unionOfTerms = controller.composition(c);

        for (double x = 0.0; x <= 1.0; x += 0.01) {
            System.out.println(x + " : " + controller.unionOfTerms.getMaxValue(x) + " ");
        }
        System.out.println("Result");
        System.out.println(controller.defuzzification(controller.unionOfTerms));
    }


    private void loadVariables() {
        variables = new HashMap<String, LingVariable>();

        TermSet ts1 = new TermSet();
        ts1.setTerm("низкий", new TrapFunc(0, 0, 0.3, 0.4));
        ts1.setTerm("средний", new TrapFunc(0.3, 0.4, 0.6, 0.7));
        ts1.setTerm("высокий", new TrapFunc(0.6, 0.7, 1, 1));
        LingVariable x1 = new LingVariable("input1", ts1);
        variables.put("X1", x1);

        TermSet ts2 = new TermSet();
        ts2.setTerm("неуд.", new TrapFunc(0, 0, 0.4, 0.5));
        ts2.setTerm("уд.", new TrianFunc(0.4, 0.6, 0.7));
        ts2.setTerm("хор.", new TrianFunc(0.6, 0.8, 0.9));
        ts2.setTerm("отл.", new TrianFunc(0.8, 1, 1));
        LingVariable x2 = new LingVariable("input2", ts2);
        variables.put("X2", x2);

        TermSet ts3 = new TermSet();
        ts3.setTerm("ноль", new TrapFunc(0, 0, 0.2, 0.3));
        ts3.setTerm("низкий", new TrapFunc(0.2, 0.3, 0.4, 0.5));
        ts3.setTerm("средний", new TrapFunc(0.4, 0.5, 0.6, 0.7));
        ts3.setTerm("высокий", new TrapFunc(0.6, 0.7, 0.8, 0.9));
        ts3.setTerm("полный", new TrapFunc(0.8, 0.9, 1, 1));
        LingVariable y = new LingVariable("output", ts3);
        variables.put("Y", y);

//        TermSet ts1 = new TermSet();
//        ts1.setTerm("достоверно", new TrapFunc(0.6, 0.8, 1, 1));
//        ts1.setTerm("недостоверно", new TrapFunc(0, 0, 0.6, 0.8));
//        LingVariable x1 = new LingVariable("Достоверность информации о работодателе", ts1);
//        variables.put("X1", x1);
//
//        TermSet ts2 = new TermSet();
//        ts2.setTerm("надежно", new TrapFunc(0.6, 0.8, 1, 1));
//        ts2.setTerm("ненадежно", new TrapFunc(0, 0, 0.6, 0.8));
//        LingVariable x2 = new LingVariable("Надежность партнерства с работодателем", ts2);
//        variables.put("X2", x2);
//
//        TermSet ts3 = new TermSet();
//        ts3.setTerm("отсутствует", new TrapFunc(0, 0, 0.1, 0.3));
//        ts3.setTerm("частичное", new TrapFunc(0.1, 0.3, 0.7, 0.8));
//        ts3.setTerm("полное", new TrapFunc(0.7, 0.8, 1, 1));
//        LingVariable x3 = new LingVariable("Описание вакансии", ts3);
//        variables.put("X3", x3);
//
//        TermSet ts4 = new TermSet();
//        ts4.setTerm("не обосновано", new TrapFunc(0, 0, 0.5, 0.7));
//        ts4.setTerm("обосновано", new TrapFunc(0.5, 0.7, 1, 1));
//        LingVariable x4 = new LingVariable("Обоснованность количественной потребности", ts4);
//        variables.put("X4", x4);
//
//        TermSet ts5 = new TermSet();
//        ts5.setTerm("недостоверно", new TrapFunc(0, 0, 0.6, 0.8));
//        ts5.setTerm("достоверно", new TrapFunc(0.6, 0.8, 1, 1));
//        LingVariable y = new LingVariable("Показатель достоверности информации", ts5);
//        variables.put("Y", y);
    }

    private void loadRules() {
        Statement.setLingVariables(variables);
        rules = new ArrayList<Rule>();


//        Rule r1 = new Rule();
//        r1.setConditions(new Condition("X1", "недостоверно"));
//        r1.setConclusion(new Conclusion("Y", "недостоверно"));
//        rules.add(r1);
//
//        Rule r2 = new Rule();
//        r2.setConditions(new Condition("X2", "ненадежно"));
//        r2.setConclusion(new Conclusion("Y", "недостоверно"));
//        rules.add(r2);
//
//        Rule r3 = new Rule();
//        r3.setConditions(new Condition("X3", "отсутствует"));
//        r3.setConclusion(new Conclusion("Y", "недостоверно"));
//        rules.add(r3);
//
//        Rule r4 = new Rule();
//        r4.setConditions(new Condition("X4", "обосновано"), new Condition("X3", "частичное"));
//        r4.setConclusion(new Conclusion("Y", "достоверно"));
//        rules.add(r4);
//
//        Rule r5 = new Rule();
//        r5.setConditions(new Condition("X4", "обосновано"), new Condition("X3", "полное"));
//        r5.setConclusion(new Conclusion("Y", "достоверно"));
//        rules.add(r5);
//
//        Rule r6 = new Rule();
//        r6.setConditions(new Condition("X4", "не обосновано"), new Condition("X3", "частичное"));
//        r6.setConclusion(new Conclusion("Y", "недостоверно"));
//        rules.add(r6);
//
//        Rule r7 = new Rule();
//        r7.setConditions(new Condition("X4", "не обосновано"), new Condition("X3", "полное"));
//        r7.setConclusion(new Conclusion("Y", "достоверно"));
//        rules.add(r7);

        Rule r1 = new Rule();
        r1.setConditions(new Condition("X1", "высокий"), new Condition("X2", "отл."));
        r1.setConclusion(new Conclusion("Y", "полный"));
        rules.add(r1);

        Rule r2 = new Rule();
        r2.setConditions(new Condition("X1", "высокий"), new Condition("X2", "хор."));
        r2.setConclusion(new Conclusion("Y", "высокий"));
        rules.add(r2);

        Rule r3 = new Rule();
        r3.setConditions(new Condition("X1", "высокий"), new Condition("X2", "уд."));
        r3.setConclusion(new Conclusion("Y", "средний"));
        rules.add(r3);

        Rule r4 = new Rule();
        r4.setConditions(new Condition("X1", "высокий"), new Condition("X2", "неуд."));
        r4.setConclusion(new Conclusion("Y", "низкий"));
        rules.add(r4);

        Rule r5 = new Rule();
        r5.setConditions(new Condition("X1", "средний"), new Condition("X2", "отл."));
        r5.setConclusion(new Conclusion("Y", "высокий"));
        rules.add(r5);

        Rule r6 = new Rule();
        r6.setConditions(new Condition("X1", "средний"), new Condition("X2", "хор."));
        r6.setConclusion(new Conclusion("Y", "средний"));
        rules.add(r6);

        Rule r7 = new Rule();
        r7.setConditions(new Condition("X1", "средний"), new Condition("X2", "уд."));
        r7.setConclusion(new Conclusion("Y", "низкий"));
        rules.add(r7);

        Rule r8 = new Rule();
        r8.setConditions(new Condition("X1", "средний"), new Condition("X2", "неуд."));
        r8.setConclusion(new Conclusion("Y", "ноль"));
        rules.add(r8);

        Rule r9 = new Rule();
        r9.setConditions(new Condition("X1", "низкий"), new Condition("X2", "отл."));
        r9.setConclusion(new Conclusion("Y", "средний"));
        rules.add(r9);

        Rule r10 = new Rule();
        r10.setConditions(new Condition("X1", "низкий"), new Condition("X2", "хор."));
        r10.setConclusion(new Conclusion("Y", "низкий"));
        rules.add(r10);

        Rule r11 = new Rule();
        r11.setConditions(new Condition("X1", "низкий"), new Condition("X2", "уд."));
        r11.setConclusion(new Conclusion("Y", "ноль"));
        rules.add(r11);

        Rule r12 = new Rule();
        r12.setConditions(new Condition("X1", "низкий"), new Condition("X2", "неуд."));
        r12.setConclusion(new Conclusion("Y", "ноль"));
        rules.add(r12);

    }

    public double[] fuzzification(double[] inputData) {
        if (inputData.length != variables.size() - 1) {
            throw new ArgumentOutOfBoundsException();
        }

        int i = 0;
        double[] b = new double[Rule.getNumberOfConditions()];
        for (Rule rule : rules) {
            for (Statement condition : rule.getConditions()) {
                int id = condition.getVariableId();
                LingVariable variable = condition.getLingVariable();
                b[i] = variable.getValueForTerm(condition.getTerm(), inputData[id]);
                System.out.print(variable.getName() + " : " + b[i] + " ");
                i++;
            }
            System.out.println();
        }
        return b;
    }

    private double[] aggregation(double[] b) {
        int i = 0;
        int j = 0;
        double[] c = new double[Rule.getNumberOfConclusions()];
        for (Rule rule : rules) {
            double truthOfConditions = 1.0;
            for (Statement condition : rule.getConditions()) {
                truthOfConditions = Math.min(truthOfConditions, b[i]);
                i++;
            }
            c[j] = truthOfConditions;
            System.out.println(c[j]);
            j++;
        }
        return c;
    }


    private UnionOfTermSet composition(double c[]) {
        UnionOfTermSet unionOfTerms = new UnionOfTermSet(Rule.getNumberOfConclusions());
        int i = 0;
        for (Rule rule : rules) {
            Term term = rule.getConclusion().getTerm().copyTerm();
            term.setActivatedValue(c[i]);
            unionOfTerms.add(term);
            i++;
        }
        return unionOfTerms;
    }

    private double defuzzification(UnionOfTermSet unionOfTerms) {
        double x, y1 = 0.0, y2 = 0.0, step = 0.01;
        for (x = 0.0; x <= 1.0; x += step) {
            y1 += x * unionOfTerms.getMaxValue(x);
        }
        for (x = 0.0; x <= 1.0; x += step) {
            y2 += unionOfTerms.getMaxValue(x);
        }
        return y1/y2;
    }

}
