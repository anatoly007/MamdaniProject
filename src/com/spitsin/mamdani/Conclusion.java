package com.spitsin.mamdani;

import java.sql.*;


public class Conclusion extends Statement {
    public Conclusion(String name, String termName) {
        super(name, termName);
    }

    public Term getTerm() {
        return super.getTerm();
    }
}
