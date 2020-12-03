package com.zp.lr.test;

import com.zp.lr.antlr.DslBaseListener;
import com.zp.lr.antlr.DslLexer;
import com.zp.lr.antlr.DslParser;
import com.zp.lr.label.LabeledBaseListener;
import com.zp.lr.label.LabeledLexer;
import com.zp.lr.label.LabeledParser;
import com.zp.lr.label.SimpleExpresVisitor;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * @Auther: zhangpanm
 * @Date: 2020/7/22
 * @Description:
 */
public class AntlrTest {

    @Test
    public void anTlrTest1(){
        String sql= "select 'abc' as a, `hahah` as c  From a as pub_user;";
        ANTLRInputStream input = new ANTLRInputStream(sql);  //将输入转成antlr的input流
        DslLexer lexer = new DslLexer(input);  //词法分析

        CommonTokenStream tokens = new CommonTokenStream(lexer);  //转成token流
        DslParser parser = new DslParser(tokens); // 语法分析
        //parser.addParseListener(new DslBaseListener());
        DslParser.StaContext tree = parser.sta();  //获取某一个规则树，这里获取的是最外层的规则，也可以通过sql()获取sql规则树......
        System.out.println(tree.toStringTree(parser)); //打印规则数
        ParseTreeWalker.DEFAULT.walk(new DslBaseListener(),tree);
    }
    @Test
    public void lableTest1(){
          String exp="A.1001#C2.N = A.1002#C2.C2_Z+A.1003#C2.N";
        //String exp="A.1001 = A.1003 # c2.33";
       // String exp="A.1001 = 6*9/2+3";
        ANTLRInputStream input = new ANTLRInputStream(exp);  //将输入转成antlr的input流
        LabeledLexer lexer  = new LabeledLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);  //转成token流
        LabeledParser parser = new LabeledParser(tokens);
        LabeledParser.ProgContext tree = parser.prog();
        System.out.println(tree.toStringTree(parser)); //打印规则数
       // ParseTreeWalker.DEFAULT.walk(new LabeledBaseListener(),tree);
        SimpleExpresVisitor visitor = new SimpleExpresVisitor();
        Object  result = visitor.visitProg(tree);
       System.out.println("res:"+result);
    }
    @Test
    public void aVoid(){
        BeanFactoryPostProcessor bfpp = new BeanFactoryPostProcessor() {
            @Override
            public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
                configurableListableBeanFactory.getBeanDefinition("ddd");

            }
        };
    }
}
