package com.example.cg.pattern.builder.first;

import androidx.annotation.NonNull;

/**
 * 产品（房子）
 *
 * 完整的房子需要（1）地基（2）钢筋工程（3）铺电线（4）粉刷
 */
public class Product {

    private String buildA;
    private String buildB;
    private String buildC;
    private String buildD;

    public String getBuildA() {
        return buildA;
    }

    public void setBuildA(String buildA) {
        this.buildA = buildA;
    }

    public String getBuildB() {
        return buildB;
    }

    public void setBuildB(String buildB) {
        this.buildB = buildB;
    }

    public String getBuildC() {
        return buildC;
    }

    public void setBuildC(String buildC) {
        this.buildC = buildC;
    }

    public String getBuildD() {
        return buildD;
    }

    public void setBuildD(String buildD) {
        this.buildD = buildD;
    }

    @NonNull
    @Override
    public String toString() {
        return buildA+"\n"+buildB+"\n"+buildC+"\n"+buildD+"\n"+"房子验收完成";
    }
}
