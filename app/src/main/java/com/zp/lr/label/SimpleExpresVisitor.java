package com.zp.lr.label;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.List;

/**
 * @Auther: zhangpanm
 * @Date: 2020/7/23
 * @Description:
 */
public class SimpleExpresVisitor<T> extends LabeledBaseVisitor {
    @Override
    public T visitProg(LabeledParser.ProgContext ctx) {
        System.out.println("slev:"+ctx.getText());
        return (T) visitChildren(ctx);

    }

    /**
     * 访问维度变量：A.1002
     * @param ctx
     * @return
     */
    @Override
    public String visitID(LabeledParser.IDContext ctx) {
        System.out.println("slev-ID:"+ctx.getText());
        return ctx.getText();
    }

    /**
     * 访问赋值表达式
     * @param ctx
     * @return
     */
    public T  visitAssign(LabeledParser.AssignContext ctx) {
        System.out.println("slev-Assign:"+ctx.getText());
        LabeledParser.ExprContext leftExp = ctx.expr(0);
        LabeledParser.ExprContext rightExp = ctx.expr(1);
        if(leftExp instanceof LabeledParser.IDContext){
            visitID((LabeledParser.IDContext)leftExp);
        }
        List<ParseTree> childs = rightExp.children;
        return (T) visit(rightExp);
    }

    /**
     * 访问乘除表达式
     * @param ctx
     * @return
     */
    @Override
    public T visitMulDiv(LabeledParser.MulDivContext ctx) {
       int type = ctx.op.getType();
       LabeledParser.ExprContext leftExp = ctx.expr(0);
       LabeledParser.ExprContext rightExp = ctx.expr(1);

      /* if(leftExp instanceof LabeledParser.NUMContext){
           leftExp.getText();
       }else {
           //TODO 计算left表达式结果
           left=(T)visit(leftExp);
       }*/
        visit(leftExp);

            //TODO 计算right表达式结果
        return (T) visit(rightExp);


    }

    /**
     * 访问加减表达式
     * @param ctx
     * @return
     */
    @Override
    public T visitAddSub(LabeledParser.AddSubContext ctx) {
        int type = ctx.op.getType();
        LabeledParser.ExprContext leftExp = ctx.expr(0);
        LabeledParser.ExprContext rightExp = ctx.expr(1);
        /*float left =0F;
        float right = 0F;
        if(leftExp instanceof LabeledParser.NUMContext){
            left =Float.valueOf(leftExp.getText());
        }else {
            //TODO 计算left表达式结果
            left=(float)visit(leftExp);
        }

        if(rightExp instanceof LabeledParser.NUMContext){
            right =Float.valueOf(rightExp.getText());
        }else {
            //TODO 计算right表达式结果
            right=(float)visit(rightExp);
        }
        switch (type){
            case LabeledParser.ADD:
                return left+right;
            case LabeledParser.SUB:
                return left-right;
        }
        throw new RuntimeException("visitMulDiv can not excute mul or div");*/
        System.out.println(visit(leftExp)+"+"+visit(rightExp));
        return (T) visit(leftExp);
    }

    /**
     * 访问表达式
     * @param ctx
     * @return
     */
    @Override
    public T visitSigleExpr(LabeledParser.SigleExprContext ctx) {
        System.out.println("slev-visitSigleExpr:"+ctx.getText());
        List<ParseTree> childs = ctx.children;
        return (T) visit(ctx);
    }

}
