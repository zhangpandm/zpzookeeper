// Generated from D:/learnWork/zpzookeeper/app/src/main/resources\Labeled.g4 by ANTLR 4.8
package com.zp.lr.label;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LabeledParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface LabeledVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link LabeledParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(LabeledParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sigleExpr}
	 * labeled alternative in {@link LabeledParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSigleExpr(LabeledParser.SigleExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assign}
	 * labeled alternative in {@link LabeledParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(LabeledParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parens}
	 * labeled alternative in {@link LabeledParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParens(LabeledParser.ParensContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multiFilter}
	 * labeled alternative in {@link LabeledParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiFilter(LabeledParser.MultiFilterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TAND}
	 * labeled alternative in {@link LabeledParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTAND(LabeledParser.TANDContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NUM}
	 * labeled alternative in {@link LabeledParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNUM(LabeledParser.NUMContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addSub}
	 * labeled alternative in {@link LabeledParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSub(LabeledParser.AddSubContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ID}
	 * labeled alternative in {@link LabeledParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitID(LabeledParser.IDContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mulDiv}
	 * labeled alternative in {@link LabeledParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulDiv(LabeledParser.MulDivContext ctx);
}