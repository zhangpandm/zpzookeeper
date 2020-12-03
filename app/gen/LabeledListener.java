// Generated from D:/learnWork/zpzookeeper/app/src/main/resources\Labeled.g4 by ANTLR 4.8
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LabeledParser}.
 */
public interface LabeledListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LabeledParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(LabeledParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link LabeledParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(LabeledParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by the {@code sigleExpr}
	 * labeled alternative in {@link LabeledParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterSigleExpr(LabeledParser.SigleExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code sigleExpr}
	 * labeled alternative in {@link LabeledParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitSigleExpr(LabeledParser.SigleExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assign}
	 * labeled alternative in {@link LabeledParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterAssign(LabeledParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assign}
	 * labeled alternative in {@link LabeledParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitAssign(LabeledParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parens}
	 * labeled alternative in {@link LabeledParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParens(LabeledParser.ParensContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parens}
	 * labeled alternative in {@link LabeledParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParens(LabeledParser.ParensContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multiFilter}
	 * labeled alternative in {@link LabeledParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMultiFilter(LabeledParser.MultiFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multiFilter}
	 * labeled alternative in {@link LabeledParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMultiFilter(LabeledParser.MultiFilterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addSub}
	 * labeled alternative in {@link LabeledParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAddSub(LabeledParser.AddSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addSub}
	 * labeled alternative in {@link LabeledParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAddSub(LabeledParser.AddSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ID}
	 * labeled alternative in {@link LabeledParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterID(LabeledParser.IDContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ID}
	 * labeled alternative in {@link LabeledParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitID(LabeledParser.IDContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mulDiv}
	 * labeled alternative in {@link LabeledParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMulDiv(LabeledParser.MulDivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mulDiv}
	 * labeled alternative in {@link LabeledParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMulDiv(LabeledParser.MulDivContext ctx);
}