package com.zp.lr.antlr;
 
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link DslParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface DslVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link DslParser#sta}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSta(DslParser.StaContext ctx);
	/**
	 * Visit a parse tree produced by {@link DslParser#ender}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnder(DslParser.EnderContext ctx);
	/**
	 * Visit a parse tree produced by {@link DslParser#sql}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSql(DslParser.SqlContext ctx);
	/**
	 * Visit a parse tree produced by {@link DslParser#as}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAs(DslParser.AsContext ctx);
	/**
	 * Visit a parse tree produced by {@link DslParser#tableName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableName(DslParser.TableNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link DslParser#format}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormat(DslParser.FormatContext ctx);
	/**
	 * Visit a parse tree produced by {@link DslParser#path}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPath(DslParser.PathContext ctx);
	/**
	 * Visit a parse tree produced by {@link DslParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(DslParser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link DslParser#quotedIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuotedIdentifier(DslParser.QuotedIdentifierContext ctx);
}